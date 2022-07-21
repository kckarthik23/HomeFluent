package com.HomeFluent.Homeaccount.Security.AuthFilter;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.log.LogMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import com.HomeFluent.Homeaccount.Security.SecurityConstants.SecurityConstants;
import io.jsonwebtoken.Jwts;

public class AuthorizationFilter extends BasicAuthenticationFilter {

    private AuthenticationManager authmanager;

    public AuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        this.authmanager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub

        String header = request.getHeader(SecurityConstants.HEADER_STRING);
        if (header == null || (!header.startsWith(SecurityConstants.TOKEN_PREFIX))) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authRequest = this.getAuthenticationRequest(request);
        if (authRequest == null) {
            this.logger.trace("Did not process authentication request since failed to find "
                    + "username and password in Basic Authorization header");
            chain.doFilter(request, response);
            return;
        }
        String username = authRequest.getName();
        this.logger.trace(LogMessage.format("Found username '%s' in Basic Authorization header", username));

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authRequest);
        SecurityContextHolder.setContext(context);

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationRequest(HttpServletRequest request) {
        String token = request.getHeader(SecurityConstants.HEADER_STRING);
        UsernamePasswordAuthenticationToken ust = null;
        if (token != null) {
            token = token.replace(SecurityConstants.TOKEN_PREFIX, "");
            String userName = Jwts.parser().setSigningKey(SecurityConstants.TOKEN_SECREAT).parseClaimsJws(token)
                    .getBody().getSubject();
            ust = new UsernamePasswordAuthenticationToken(userName, null, new ArrayList<>());
        }
        return ust;
    }

}

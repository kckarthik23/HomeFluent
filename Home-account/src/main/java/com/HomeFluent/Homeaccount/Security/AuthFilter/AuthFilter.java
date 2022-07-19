package com.HomeFluent.Homeaccount.Security.AuthFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.HomeFluent.Homeaccount.Security.SecurityConstants.SecurityConstants;
import com.HomeFluent.Homeaccount.models.UserRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.HomeFluent.Homeaccount.Security.UserDetail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AuthFilter extends UsernamePasswordAuthenticationFilter {
    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);
    private AuthenticationManager authmanager;

    public AuthFilter(AuthenticationManager authmanager) {
        this.authmanager = authmanager;
    }

   

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            UserRequest creds = new ObjectMapper().
            readValue(request.getInputStream(), UserRequest.class);
            return authmanager.authenticate(
                    new UsernamePasswordAuthenticationToken
                    (creds.getName(), creds.getPassword(),
                     new ArrayList<>()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        // TODO Auto-generated method stub
        int  userId=((UserDetail)authResult.getPrincipal()).getUserId();
        String token=Jwts.builder().setSubject("UserID"+userId).
        setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
        .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN).compact();
        response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+token);
        response.addHeader("userId",Integer.toString(userId));
        logger.info("response headers "+response.getHeader("Authoriation"));
        response.setStatus(200);
        //response.setHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+token);
    response.getWriter().write(token+"Authorized User"+userId);
    logger.info(response.toString());
    
    }
@Override
protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException failed) throws IOException, ServletException {
    // TODO Auto-generated method stub
    String body=response.SC_BAD_REQUEST+" invalid password ";
    response.getWriter().write(body);
    response.getWriter().flush();
    //throw new IOException(failed.getMessage(), failed.getCause());
        }
}

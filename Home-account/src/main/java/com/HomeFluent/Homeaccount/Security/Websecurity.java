package com.HomeFluent.Homeaccount.Security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.cors.CorsConfiguration;

import com.HomeFluent.Homeaccount.Security.AuthFilter.AuthFilter;
import com.HomeFluent.Homeaccount.Security.AuthFilter.AuthorizationFilter;
import com.HomeFluent.Homeaccount.Security.SecurityConstants.SecurityConstants;
import com.HomeFluent.Homeaccount.Security.UserDetails.DetailService;

@EnableWebSecurity
public class Websecurity extends WebSecurityConfigurerAdapter {

    final DetailService UserServiceImpl;
    //@Autowired
    //WebConfig config;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public Websecurity(UserDetailsService userdetailService) {
        this.UserServiceImpl = (DetailService) userdetailService;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
        // super.configure(auth);
        auth.userDetailsService(UserServiceImpl).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:8000","http://localhost:8080"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT","OPTIONS","PATCH", "DELETE"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setExposedHeaders(List.of("Authorization","userId"));
        http.csrf().disable().cors()
        .configurationSource(r->corsConfiguration)
                .and()
                .headers()
                .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "http://localhost:8000"))
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/homeFluent/users/createUser/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(getAuthFilter())
                .addFilter(new AuthorizationFilter(authenticationManager()))
                .exceptionHandling()
                .authenticationEntryPoint((request, response, exception) -> {
                    response.setStatus(401);
                }) 
                .and()
                .httpBasic()
                .and()
                .formLogin();

    }

    public AuthFilter getAuthFilter() throws Exception {
        final AuthFilter filter = new AuthFilter(authenticationManager());
        filter.setFilterProcessesUrl(SecurityConstants.SIGNUP_URL);
        return filter;
    }
}

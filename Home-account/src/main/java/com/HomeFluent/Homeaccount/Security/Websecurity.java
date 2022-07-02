package com.HomeFluent.Homeaccount.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@EnableWebSecurity
public class Websecurity extends WebSecurityConfigurerAdapter{

    
    final UserDetailsService userdetailService;
    
    final BCryptPasswordEncoder encoder;
    
    public Websecurity(UserDetailsService userdetailService, BCryptPasswordEncoder encoder) {
    this.userdetailService = userdetailService;
    this.encoder = encoder;
}

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
       // super.configure(auth);
        auth.userDetailsService(userdetailService).passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
       http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST,"/createUser")
       .permitAll().anyRequest().authenticated();
    }
    
}

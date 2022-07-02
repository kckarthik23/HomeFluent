package com.HomeFluent.Homeaccount.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.HomeFluent.Homeaccount.Security.UserDetails.DetailService;
@EnableWebSecurity
public class Websecurity extends WebSecurityConfigurerAdapter{

    
    final DetailService detailService;
    
    @Bean
public PasswordEncoder passwordEncoder()
{
    return new BCryptPasswordEncoder();
}
    
    public Websecurity(UserDetailsService userdetailService) {
    this.detailService = (DetailService) userdetailService;
    
}

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
       // super.configure(auth);
        auth.userDetailsService(detailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
       http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST,"/")
       .permitAll();
    }
    
}

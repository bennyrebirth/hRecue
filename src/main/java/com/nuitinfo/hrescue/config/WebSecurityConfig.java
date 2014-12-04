/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nuitinfo.hrescue.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Jerry Philippe RAKOTOBE <jerry.rakotobe@gmail.com>
 */
@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private DataSource dataSource;
    
    private static final String USERS_BY_USERNAME_QUERY = "SELECT u.username, u.password, true FROM USER u WHERE u.username = ?" ;
    private static final String AUTHORITIES_BY_USERNAME_QUERY = "SELECT u.username, r.role_spring as role FROM USER u, ROLE r WHERE u.username = ?" ;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth
            .jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery(USERS_BY_USERNAME_QUERY)
            .authoritiesByUsernameQuery(AUTHORITIES_BY_USERNAME_QUERY)
            .passwordEncoder(passwordEncoder)
            ;
    }

    
    
    
    
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers("/signup","/forgot-password").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout()
            .permitAll()
        .and()
            .csrf()
                .disable() ;
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web
      .ignoring()
         .antMatchers("/resources/**");
  }
  
  
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
       return super.authenticationManagerBean();
  }
}

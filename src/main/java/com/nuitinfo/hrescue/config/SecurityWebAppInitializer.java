package com.nuitinfo.hrescue.config;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 *
 * @author Jerry Philippe RAKOTOBE <jerry.rakotobe@gmail.com>
 */
@Order(1)
public class SecurityWebAppInitializer extends  AbstractSecurityWebApplicationInitializer{
    
}

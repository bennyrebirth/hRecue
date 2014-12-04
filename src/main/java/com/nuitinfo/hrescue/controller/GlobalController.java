/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuitinfo.hrescue.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jerry Philippe RAKOTOBE
 */
@Controller
public class GlobalController {
    
    private static final Logger LOG = LoggerFactory.getLogger(GlobalController.class);
    
    @RequestMapping({"/"})
    public String mainPage(HttpServletRequest request) {
        return "/index" ;
    }
    
}

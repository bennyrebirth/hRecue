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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jerry Philippe RAKOTOBE
 */
@Controller
public class GlobalController {
    
    private static final Logger LOG = LoggerFactory.getLogger(GlobalController.class);
    
    @RequestMapping({"/"})
    public String mainPage(HttpServletRequest request, Model model) {
        model.addAttribute("menu", "home") ;
        return "/index" ;
    }
    
    @RequestMapping({"/Informations"})
    public String informationsPage(HttpServletRequest request,Model model) {
        model.addAttribute("menu", "info") ;
        return "/informations" ;
    }
    
    @RequestMapping({"/Location"})
    public String locationPage(HttpServletRequest request,Model model) {
        model.addAttribute("menu", "location") ;
        return "/location" ;
    }

    @RequestMapping({"/AddInformation"})
    public String addInformationPage(HttpServletRequest request,Model model) {
        model.addAttribute("menu", "addinfo") ;
        return "/add_information" ;
    }
    
    @RequestMapping({"/ManageInformations"})
    public String manageInformationsPage(HttpServletRequest request,Model model) {
        model.addAttribute("menu", "manageinfos") ;
        return "/manage_informations" ;
    }
    
    @RequestMapping({"/ManageUsers"})
    public String manageUsersPage(HttpServletRequest request,Model model) {
        model.addAttribute("menu", "manageusers") ;
        return "/manage_users" ;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuitinfo.hrescue.controller;

import com.nuitinfo.hrescue.service.IAppMobileService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jerry Philippe RAKOTOBE
 */
@Controller
public class AppMobileController {
    
    @Autowired
    IAppMobileService appMobileService ;
    
    @RequestMapping(value="/LatitudeAndLongitude.action", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getLatitudeLongitudeUser( @RequestParam("username") String username,
                                            @RequestParam("latitude") String latitude,
                                            @RequestParam("longitude") String longitude,
                                            HttpServletRequest request, Model model ){
        Map<String, Object> result = new HashMap() ;
        result.put("success", true) ;
        appMobileService.saveCoordinate(username, latitude, longitude);
        return result ;
   }
    
}

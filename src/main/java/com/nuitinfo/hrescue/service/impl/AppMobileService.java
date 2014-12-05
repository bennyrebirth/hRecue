/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuitinfo.hrescue.service.impl;

import com.nuitinfo.hrescue.dao.IUserDAO;
import com.nuitinfo.hrescue.domain.User;
import com.nuitinfo.hrescue.service.IAppMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jerry Philippe RAKOTOBE
 */
@Service
@Transactional
public class AppMobileService implements IAppMobileService {

    @Autowired
    IUserDAO userDAO ;
    
    @Override
    @Transactional
    public void saveCoordinate(String username,String latitude, String longitude) {
        User u = userDAO.findByUsername(username) ;
        u.setLastLatitude(latitude);
        u.setLastLongitude(longitude);
        userDAO.save(u) ;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuitinfo.hrescue.dao;

import com.nuitinfo.hrescue.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jerry Philippe RAKOTOBE
 */
public interface IUserDAO extends CrudRepository<User, Integer>{
    
    public User findByUsername(String username);
    
}

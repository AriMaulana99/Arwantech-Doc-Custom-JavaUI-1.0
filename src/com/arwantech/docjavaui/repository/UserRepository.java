/*
 * Copyright (c) 2017 ARWANTECH CREATIVE TEAM
 *
 * Anda diperkenankan mengedit isi dari source code ini
 * asalkan tetap menyertakan copyright ini.
 *
 * File ini dibuat menggunakan :
 * Editor     : NetBeans IDE 8.0.2
 * NoteBook   : ASUS Notebook K42F
 * OS         : Windows 10 Pro 64bit
 * Compiler   : JDK 8 update 18
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 *      http://www.apache.org/licenses/LICENSE-2.0
 */
package com.arwantech.docjavaui.repository;

import com.arwantech.docjavaui.domain.User;
import com.arwantech.docjavaui.utils.Utility;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AriMaulana99
 */
public class UserRepository {
    
    public List<User> readAll() throws SQLException {
        List<User> listUser = new ArrayList<>();
        listUser.add(0, new User(1, "ARIANSYAH MAULANA", "ari", "nAlrx9PxStLRwb1G32v30Q==", "info.ariansyahmaulana@gmai.com"));
        listUser.add(1, new User(2, "MUHAMAD RIDWAN", "ridwan", "nAlrx9PxStLRwb1G32v30Q==", "ridwan.info@gmai.com"));
        listUser.add(2, new User(3, "DIMAS R ISMAIL", "dimas", "nAlrx9PxStLRwb1G32v30Q==", "dimasrismail@gmai.com"));
        return listUser;
    }
    
    public List<User> getById(String id) throws SQLException  {
        List<User> list = readAll();
        List<User> userById = new ArrayList<>();
        for (User user1 : list) {
            User user = new User();  
            user.setId(user1.getId());
            user.setName(user1.getName());
            user.setUsername(user1.getUsername());
            user.setPassword(user1.getPassword());
            user.setEmail(user1.getEmail());
            if(String.valueOf(user1.getId()).equals(id)) {
                userById.add(user);
            }
        }
        return userById;
    }
    
    public User getByUsernameAndPassword(String username, String password) throws SQLException  {
        try {
            List<User> list = readAll();
            User user = null;
            for (User user1 : list) {               
                if(user1.getUsername().equals(username) && Utility.decrypData(user1.getPassword()).equals(password)) {
                    user = new User();
                    user.setId(user1.getId());
                    user.setName(user1.getName());
                    user.setUsername(user1.getUsername());
                    user.setPassword(user1.getPassword());
                    user.setEmail(user1.getEmail());
                } 
            }
            return user;
        } catch (Exception e) {
            return null;
        }
        
    }
}

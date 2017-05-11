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
package com.arwantech.docjavaui.utils;

import com.arwantech.docjavaui.enums.Constant;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 *
 * @author AriMaulana99
 */
public class Utility {
    
    public static Image getImage(final String pathAndFileName) {
        final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
        return Toolkit.getDefaultToolkit().getImage(url);
    }
    
    public static String encrypData(String data) {
        try {
            TripleDES tdes = new TripleDES(Constant.SECRET_KEY);
            String vData = tdes.encrypt(data);
            return vData;
        } catch (Exception e) {
            return null;
        }
    }
    
    public static String decrypData(String data) {
        try {
            TripleDES tdes = new TripleDES(Constant.SECRET_KEY);
            String vData = tdes.decrypt(data);
            return vData;
        } catch (Exception e) {
            return null;
        }
    }
    
}

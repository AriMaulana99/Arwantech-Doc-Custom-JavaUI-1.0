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
package com.arwantech.docjavaui.generatejasper;

import com.arwantech.docjavaui.domain.User;
import com.arwantech.docjavaui.enums.Constant;
import com.arwantech.javaui.loading.Loading10;
import com.arwantech.javaui.loading.Loading2;
import com.arwantech.docjavaui.repository.UserRepository;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author AriMaulana99
 */
public class ReportUser {
    

    public ReportUser() {
        
    }

    public void userAll(Loading2 loading) {
        try {
            UserRepository userRepository = new UserRepository();
            List<User> userAll = userRepository.readAll();

            //siapkan datasource
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(userAll);
            
            //compile JRXML menjadi jasper 
            Map<String, Object> param = new HashMap<>();
            param.put("author", "Arwantech Creative Team");
            JasperDesign jasperDesign = JRXmlLoader.load(new File("").getAbsolutePath()+ Constant.USER_REPORT);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            
            //fill report dengan datasource
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource);
           
            loading.stop();
            
            JasperViewer.viewReport(jasperPrint, false);
            System.out.println("Report Generate Successfull . . .");
        } catch (JRException | SQLException jre) {
            loading.stop();
            System.out.println("ERROR : " + jre);
        }
    }
    
    public void userById(String id, Loading10 loading) {
        try {
            UserRepository userRepository = new UserRepository();
            List<User> userById = userRepository.getById(id);

            //siapkan datasource
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(userById);
            
            //compile JRXML menjadi jasper 
            Map<String, Object> param = new HashMap<>();
            param.put("author", "Arwantech Creative Team");
            JasperDesign jasperDesign = JRXmlLoader.load(new File("").getAbsolutePath()+ Constant.USER_REPORT);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            
            //fill report dengan datasource
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource);
            
            loading.stop();
            
            JasperViewer.viewReport(jasperPrint, false);
            System.out.println("Report Generate Successfull . . .");
        } catch (JRException | SQLException jre) {
            loading.stop();
            System.out.println("ERROR : " + jre);
        }
    }
    
    
}

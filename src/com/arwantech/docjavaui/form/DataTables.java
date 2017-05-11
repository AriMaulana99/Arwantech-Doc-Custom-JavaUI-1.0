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
package com.arwantech.docjavaui.form;

import com.arwantech.docjavaui.domain.Person;
import com.arwantech.javaui.efek.TransitionTextfield;
import com.arwantech.docjavaui.enums.Images;
import com.arwantech.docjavaui.repository.PersonRepository;
import com.arwantech.docjavaui.tablemodel.PersonTableModel;
import com.arwantech.javaui.utils.Utility;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author AriMaulana99
 */
public class DataTables extends javax.swing.JPanel {
    
    private PersonTableModel tblModel;
    private PersonRepository personRepository;
    private List<Person> dataUserAll;
    private List<Person> dataTable;
    
    private boolean append = false;
    private int counterList = 0;
    
    Integer nomorHalaman = 1;
    Integer jumlahBarisPerhalaman = 5;
    Integer totalHalaman = 1;
    Integer totalData = 0;
    
    /**
     * Creates new form DataTable
     */
    public DataTables() {
        try {
            initComponents();
            personRepository = new PersonRepository();
            dataUserAll = personRepository.readAll();
            initPagination();
            initUI();
        } catch (Exception e) {
        }
    }
    
    private void initUI() {
        int sizeIcon = 20;
        btnFirst.setIcon(new ImageIcon(Images.ICON_FIRST.getScaledInstance(sizeIcon, sizeIcon, sizeIcon)));
        btnPrev.setIcon(new ImageIcon(Images.ICON_PREV.getScaledInstance(sizeIcon, sizeIcon, sizeIcon)));
        btnNext.setIcon(new ImageIcon(Images.ICON_NEXT.getScaledInstance(sizeIcon, sizeIcon, sizeIcon)));
        btnLast.setIcon(new ImageIcon(Images.ICON_LAST.getScaledInstance(sizeIcon, sizeIcon, sizeIcon)));
        
        TransitionTextfield tt = new TransitionTextfield(tfCari);
        tt.setColorType(3);
        tt.setSpeed(50);
        tt.initTransitionMaterialUI();
        Utility.setInputUI(tfCari, lblCari);
    }
    
    private void initPagination(){
        dataTable = dataUserAll;   
        totalData = dataTable.size();
        
        sorting(); 
        
        jumlahBarisPerhalaman = Integer.valueOf(cbxLimitData.getSelectedItem().toString());
        Double totalHalamanD = Math.ceil(totalData.doubleValue()/jumlahBarisPerhalaman.doubleValue());
        totalHalaman = totalHalamanD.intValue();
        
        loadDataTableLimit(dataTable);
        
        lblDisplayData.setText("Showing   1   of   " + counterList + "   of   " + totalData + "   entries"); 
        
        switchButton();
    }
    
    private void loadDataTableLimit(List<Person> dataFilter) {
        List<Person> dataLImit = new ArrayList<>();
        
        if (nomorHalaman > totalHalaman){
            nomorHalaman = 1;
        }
        counterList = jumlahBarisPerhalaman * (nomorHalaman-1);
        for (int i = 1; i <= jumlahBarisPerhalaman; i++) {
            try {
                dataFilter.get(counterList);
            } catch (Exception e) {
                break;
            } 
            dataLImit.add(dataFilter.get(counterList));
            counterList++;
        }
        tblModel = new PersonTableModel(dataLImit);
        tblPerson.setModel(tblModel);
    }
    
    private List<Person> sorting() {
        dataTable = new ArrayList<>();
        String key = tfCari.getText();
        if (tfCari.getText().isEmpty()) {
            dataTable = dataUserAll;
        } else {
            for(Person d : dataUserAll){
                Person person = new Person();
                person.setId(d.getId());
                person.setName(d.getName());
                person.setAge(d.getAge());
                person.setAddress(d.getAddress());
                if (append == false) {
                    if(d.getName().toLowerCase().contains(key) || 
                        d.getName().toUpperCase().contains(key) || 
                        d.getName().contains(key) || 
                        String.valueOf(d.getId()).toLowerCase().contains(key) ||
                        String.valueOf(d.getId()).toUpperCase().contains(key) ||
                        String.valueOf(d.getId()).contains(key) ||
                        String.valueOf(d.getAge()).toLowerCase().contains(key) ||
                        String.valueOf(d.getAge()).toUpperCase().contains(key) ||
                        String.valueOf(d.getAge()).contains(key) ||
                        d.getAddress().toLowerCase().contains(key) ||
                        d.getAddress().toUpperCase().contains(key) ||
                        d.getAddress().contains(key)) 
                    {
                        dataTable.add(person);
                    }
                } else {
                    if(String.valueOf(d.getId()).toLowerCase().matches(key)) {
                        dataTable.add(person);
                    }
                }
            }  
        }
        
        if (tfCari.getText().isEmpty()) {
            totalData = dataUserAll.size();
        } else {
            totalData = dataTable.size();
        }
        return dataTable;
    }
    
    private void switchButton() {
        if(nomorHalaman.equals(1) || totalHalaman.equals(0)){
            btnFirst.setEnabled(false);
            btnPrev.setEnabled(false);
        }else{
            btnFirst.setEnabled(true);
            btnPrev.setEnabled(true);
        }

        if(nomorHalaman.equals(totalHalaman) || totalHalaman.equals(0)){
            btnLast.setEnabled(false);
            btnNext.setEnabled(false);
        }else{
            btnLast.setEnabled(true);
            btnNext.setEnabled(true);
        }
    }
    
    private void next() {
        if(nomorHalaman < totalHalaman){
            nomorHalaman++;
            initPagination();
        }
    }
    
    private void prev() {
        if(nomorHalaman > 1){
            nomorHalaman--;
            initPagination();
        }
    }
    
    private void last() {
        nomorHalaman = totalHalaman;
        initPagination();
    }
    
    private void first() {
        nomorHalaman = 1;
        initPagination();
    }
    
    private void selectById() {
        append = cbcById.isSelected();
        initPagination();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPerson = new javax.swing.JTable();
        lblDisplayData = new javax.swing.JLabel();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        cbxLimitData = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        lblCari = new javax.swing.JLabel();
        tfCari = new javax.swing.JTextField();
        cbcById = new javax.swing.JCheckBox();

        setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(191, 191, 191), 1, true));

        jPanel12.setBackground(new java.awt.Color(56, 59, 68));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Data Tables");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        tblPerson.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblPerson.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPerson.setRowHeight(25);
        jScrollPane1.setViewportView(tblPerson);

        lblDisplayData.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblDisplayData.setForeground(new java.awt.Color(51, 51, 51));
        lblDisplayData.setText("Showing  1  of  3  of  1000  entries");
        lblDisplayData.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnFirst.setBackground(new java.awt.Color(0, 102, 204));
        btnFirst.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setText("First");
        btnFirst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFirst.setPreferredSize(new java.awt.Dimension(77, 35));
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(0, 102, 204));
        btnPrev.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnPrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev.setText("Prev");
        btnPrev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrev.setPreferredSize(new java.awt.Dimension(77, 35));
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(0, 102, 204));
        btnNext.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText("Next");
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.setPreferredSize(new java.awt.Dimension(77, 35));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(0, 102, 204));
        btnLast.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setText("Last");
        btnLast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLast.setPreferredSize(new java.awt.Dimension(77, 35));
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(lblDisplayData, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                        .addGap(49, 49, 49)
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDisplayData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        cbxLimitData.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "15" }));
        cbxLimitData.setOpaque(false);
        cbxLimitData.setPreferredSize(new java.awt.Dimension(65, 30));
        cbxLimitData.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLimitDataItemStateChanged(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCari.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblCari.setForeground(new java.awt.Color(153, 153, 153));
        lblCari.setText("Masukan Input Pencarian");
        lblCari.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(lblCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 150, 40));

        tfCari.setBackground(new java.awt.Color(255, 255, 255));
        tfCari.setForeground(new java.awt.Color(102, 102, 102));
        tfCari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(191, 191, 191)));
        tfCari.setMinimumSize(new java.awt.Dimension(2, 30));
        tfCari.setOpaque(false);
        tfCari.setPreferredSize(new java.awt.Dimension(80, 30));
        tfCari.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfCariCaretUpdate(evt);
            }
        });
        jPanel2.add(tfCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 40));

        cbcById.setBackground(new java.awt.Color(255, 255, 255));
        cbcById.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cbcById.setForeground(new java.awt.Color(51, 51, 51));
        cbcById.setText("Search By ID");
        cbcById.setBorder(null);
        cbcById.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbcById.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbcByIdStateChanged(evt);
            }
        });
        jPanel2.add(cbcById, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, 40));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(cbxLimitData, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cbxLimitData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel11, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxLimitDataItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLimitDataItemStateChanged
        initPagination();
    }//GEN-LAST:event_cbxLimitDataItemStateChanged

    private void tfCariCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfCariCaretUpdate
        initPagination();
    }//GEN-LAST:event_tfCariCaretUpdate

    private void cbcByIdStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbcByIdStateChanged
        selectById();
    }//GEN-LAST:event_cbcByIdStateChanged

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        last();
    }//GEN-LAST:event_btnLastActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JCheckBox cbcById;
    private javax.swing.JComboBox cbxLimitData;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblDisplayData;
    private javax.swing.JTable tblPerson;
    private javax.swing.JTextField tfCari;
    // End of variables declaration//GEN-END:variables
}

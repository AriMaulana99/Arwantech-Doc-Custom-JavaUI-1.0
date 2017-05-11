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

import com.arwantech.javaui.efek.TransitionForm;
import javax.swing.JButton;

/**
 *
 * @author AriMaulana99
 */
public class FormTransition extends javax.swing.JFrame {
    private int type;
    /**
     * Creates new form FormTransition
     */
    public FormTransition() {
        initComponents();
        
    }

    public FormTransition(JButton button, int type) {
        this.setUndecorated(true);
        initComponents();
        this.type = type;
        switch (this.type) {
            case 0 :
                TransitionForm transitionFrame1 = new TransitionForm(this, 10);
                transitionFrame1.setOpacityFirst(0.0f);
                transitionFrame1.setOpacityLast( 1.0f);
                transitionFrame1.setButton(button);
                transitionFrame1.initFrameTransitionOpen();
                break;
            case 1 :
                TransitionForm transitionFrame2 = new TransitionForm(this, 20);
                transitionFrame2.setOpacityFirst(0.0f);
                transitionFrame2.setOpacityLast( 1.0f);
                transitionFrame2.setButton(button);
                transitionFrame2.initFrameTransitionOpen();
                break;
            case 2 :
                TransitionForm transitionFrame3 = new TransitionForm(this, 35);
                transitionFrame3.setOpacityFirst(0.0f);
                transitionFrame3.setOpacityLast( 1.0f);
                transitionFrame3.setButton(button);
                transitionFrame3.initFrameTransitionOpen();
                break;
            case 3 :
                TransitionForm transitionFrame4 = new TransitionForm(this, 15);
                transitionFrame4.setOpacityFirst(0.0f);
                transitionFrame4.setOpacityLast( 1.0f);
                transitionFrame4.setButton(button);
                transitionFrame4.setTiming(1);
                transitionFrame4.initFrameTransitionOpenClose();
                break;
        }
        
        
        
//        SlidingForm slidingForm = new SlidingForm(this);
//        slidingForm.setButton(button);
//        slidingForm.setWidth(this.getWidth());
//        slidingForm.setHeight(this.getHeight());
//        slidingForm.setX(200);
//        slidingForm.setyFirst(10);
//        slidingForm.setyRectangle(300);
//        slidingForm.initSlidingTopToBootom();
        
//        SlidingForm slidingForm = new SlidingForm(this);
//        slidingForm.setButton(button);
//        slidingForm.setWidth(this.getWidth());
//        slidingForm.setHeight(this.getHeight());
//        slidingForm.setX(200);
//        slidingForm.setyFirst(300);
//        slidingForm.setyRectangle(10);
//        slidingForm.setSpeed(5);
//        slidingForm.initSlidingBootomToTop();
        
//        SlidingForm slidingForm = new SlidingForm(this);
//        slidingForm.setButton(button);
//        slidingForm.setWidth(this.getWidth());
//        slidingForm.setHeight(this.getHeight());
//        slidingForm.setY(10);
//        slidingForm.setxFirst(600);
//        slidingForm.setxRectangle(10);
//        slidingForm.setSpeed(2);
//        slidingForm.initSlidingRightToLeft();
        
//        SlidingForm slidingForm = new SlidingForm(this);
//        slidingForm.setButton(button);
//        slidingForm.setWidth(this.getWidth());
//        slidingForm.setHeight(this.getHeight());
//        slidingForm.setY(10);
//        slidingForm.setxFirst(10);
//        slidingForm.setxRectangle(500);
//        slidingForm.setSpeed(2);
//        slidingForm.initSlidingLeftToRight();
//        
        
    }
    
    private void close() {
        switch (this.type) {
            case 0 :
                TransitionForm transitionFrame1 = new TransitionForm(this, 10);
                transitionFrame1.setOpacityFirst(1.00f);
                transitionFrame1.setOpacityLast(0.01f);
                transitionFrame1.setButton(jLabel1);
                transitionFrame1.initFrameTransitionClose();
                break;
            case 1 :
                TransitionForm transitionFrame2 = new TransitionForm(this, 20);
                transitionFrame2.setOpacityFirst(1.00f);
                transitionFrame2.setOpacityLast(0.01f);
                transitionFrame2.setButton(jLabel1);
                transitionFrame2.initFrameTransitionClose();
                break;
            case 2 :
                TransitionForm transitionFrame3 = new TransitionForm(this, 35);
                transitionFrame3.setOpacityFirst(1.00f);
                transitionFrame3.setOpacityLast(0.01f);
                transitionFrame3.setButton(jLabel1);
                transitionFrame3.initFrameTransitionClose();
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(191, 191, 191), 5, true));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("x");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Transition form with speed custom");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Form Transisi");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Test Form Transisi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(234, 234, 234))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        close();
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTransition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTransition().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

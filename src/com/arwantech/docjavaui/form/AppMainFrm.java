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

import com.arwantech.docjavaui.domain.User;
import com.arwantech.javaui.efek.ChangeTwoColor;
import com.arwantech.javaui.efek.SlidingPanel;
import com.arwantech.docjavaui.enums.Colors;
import com.arwantech.docjavaui.enums.Images;
import com.arwantech.javaui.utils.Utility;
import java.awt.Font;
import java.awt.Image;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author AriMaulana99
 */
public class AppMainFrm extends javax.swing.JFrame {
    
    private User user = null;
    private final int timing = 1;
    private int counterTiming = 0;
    
    /**
     * Creates new form AppMainFrm1
     */
    public AppMainFrm() {
        initComponents();
        initUI();
    }
    
    public AppMainFrm(User user) {
        initComponents();
        this.user = user;
        initUI();
        
    }

    private void initUI() {
        this.setExtendedState(MAXIMIZED_BOTH);
        lblUser.setText(user.getName());
        lblLogo.setIcon(new ImageIcon(Images.ICON_LOGO_ARWANTECH.getScaledInstance(200, 40, 45)));
        lblLogout.setIcon(new ImageIcon(Images.ICON_LOGOUT.getScaledInstance(25, 25, 25)));
        lblAvatar.setIcon(new ImageIcon(checkUser().getScaledInstance(90, 90, 70)));
        
        int sizeIcon = 20;
        lblDtTables.setIcon(new ImageIcon(Images.ICON_DATA_TABLES.getScaledInstance(sizeIcon, sizeIcon, sizeIcon)));
        lblFinput.setIcon(new ImageIcon(Images.ICON_FORM_INPUT.getScaledInstance(sizeIcon, sizeIcon, sizeIcon)));
        lblFValidasi.setIcon(new ImageIcon(Images.ICON_FORM_VALIDASI.getScaledInstance(sizeIcon, sizeIcon, sizeIcon)));
        lblFTransisi.setIcon(new ImageIcon(Images.ICON_FORM_TRANSISI.getScaledInstance(sizeIcon, sizeIcon, sizeIcon)));
        lblFSliding.setIcon(new ImageIcon(Images.ICON_FORM_SLIDING.getScaledInstance(sizeIcon, sizeIcon, sizeIcon)));
        lblPSliding.setIcon(new ImageIcon(Images.ICON_PANEL_SLIDING.getScaledInstance(sizeIcon, sizeIcon, sizeIcon)));
        lblFDialog.setIcon(new ImageIcon(Images.ICON_FORM_DIALOG.getScaledInstance(sizeIcon, sizeIcon, sizeIcon)));
        lblNotif.setIcon(new ImageIcon(Images.ICON_NOTIFIKASI.getScaledInstance(sizeIcon, sizeIcon, sizeIcon)));
        lblLoading.setIcon(new ImageIcon(Images.ICON_LOADING.getScaledInstance(sizeIcon, sizeIcon, sizeIcon)));
        lblJasperArray.setIcon(new ImageIcon(Images.ICON_JASPER.getScaledInstance(sizeIcon, sizeIcon, sizeIcon)));
        
        
        ChangeTwoColor twoColor1 = new ChangeTwoColor(lblDtTables, lblFDialog, lblFSliding, 
                lblFTransisi, lblFValidasi, lblFinput, lblJasperArray, lblLoading, 
                lblNotif, lblPSliding);
        twoColor1.setBgEntered(Colors.BLUE);
        twoColor1.setFontEntered(new Font("SansSerif", Font.BOLD, 12)); 
        twoColor1.changeTwoColorLabel();
        Utility.setMarginLeftInput(20, lblDtTables, lblFDialog, lblFSliding, lblFTransisi, 
                lblFValidasi, lblFinput, lblJasperArray, lblLoading, lblNotif, lblPSliding);
        loadBanner();
    }
    
    private void switchPanel(JComponent component) {
        pnActivity.removeAll();
        pnActivity.add(component);
        this.setVisible(rootPaneCheckingEnabled);
    }
    
    private Image checkUser() {
        int id = user.getId();
        Image avatar = null;
        switch (id) {
            case 1 : 
                avatar = Images.FOTO_PROFIL;
                break;
            case 2 : 
                avatar = Images.FOTO_PROFIL;
                break;
            case 3 : 
                avatar = Images.FOTO_PROFIL;
                break;
        }
        return avatar;
    }
    
    private void logout() {
        this.dispose();
        new LoginFrm().setVisible(true);
    }
    
    @SuppressWarnings("empty-statement")
    private void loadBanner() {
        counterTiming = 0;
        final Timer thread = new Timer();;
        final TimerTask task;
        
        try { 
            /* Thread */
            task = new TimerTask() {
                @Override
                public void run() { 
                    System.out.println("PROSES TRANSAKSI");
                    if (counterTiming == timing) {
                        thread.cancel();
                        FormBanner panel = new FormBanner();
                        slidingPanel(panel, 6);
                    }
                    counterTiming++;
                }
                };     
            Date startDate = new Date();
            thread.schedule(task, startDate, 1000);   
        } catch (Exception ex) {
            thread.cancel();
            System.out.println("Method daftar() ERROR : " + ex);
        } 
        lblBanner.setIcon(new ImageIcon(Images.ANIMASI_LOADING1));
    }
    
    @SuppressWarnings("empty-statement")
    private void loadDataTables() {
        counterTiming = 0;
        final Timer thread = new Timer();;
        final TimerTask task;
        
        try { 
            /* Thread */
            task = new TimerTask() {
                @Override
                public void run() { 
                    System.out.println("PROSES TRANSAKSI");
                    if (counterTiming == timing) {
                        switchPanel(new DataTables());
                        thread.cancel(); 
                    }
                    counterTiming++;
                    
                }
                };     
            Date startDate = new Date();
            thread.schedule(task, startDate, 1000);   
        } catch (Exception ex) {
            thread.cancel();
            System.out.println("Method daftar() ERROR : " + ex);
        } 
        switchPanel(lblBanner);
        lblBanner.setText("     Please Wait....");
        lblBanner.setIcon(new ImageIcon(Images.ANIMASI_LOADING2));
    }
    
    private void slidingPanel(JPanel panel, int speed) {
        SlidingPanel slidingPanel = new SlidingPanel(this, panel, pnActivity);
        slidingPanel.setWidth(this.getWidth());
        slidingPanel.setHeight(this.getHeight());
        slidingPanel.setyFirst(-500);
        slidingPanel.setSpeed(speed);
        slidingPanel.initSlidingTopToBootom();
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
        pnMenu = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        lblDtTables = new javax.swing.JLabel();
        lblFinput = new javax.swing.JLabel();
        lblFValidasi = new javax.swing.JLabel();
        lblFTransisi = new javax.swing.JLabel();
        lblFSliding = new javax.swing.JLabel();
        lblFDialog = new javax.swing.JLabel();
        lblNotif = new javax.swing.JLabel();
        lblJasperArray = new javax.swing.JLabel();
        lblPSliding = new javax.swing.JLabel();
        lblLoading = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblAvatar = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pnActivity = new javax.swing.JPanel();
        lblBanner = new javax.swing.JLabel();
        pnFooter = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnHeader = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        pnMenu.setBackground(new java.awt.Color(39, 41, 48));
        pnMenu.setPreferredSize(new java.awt.Dimension(270, 300));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel7.setBackground(new java.awt.Color(39, 41, 48));

        lblDtTables.setBackground(new java.awt.Color(39, 41, 48));
        lblDtTables.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblDtTables.setForeground(new java.awt.Color(206, 206, 206));
        lblDtTables.setText("  Data Tables");
        lblDtTables.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDtTables.setOpaque(true);
        lblDtTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDtTablesMouseClicked(evt);
            }
        });

        lblFinput.setBackground(new java.awt.Color(39, 41, 48));
        lblFinput.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblFinput.setForeground(new java.awt.Color(206, 206, 206));
        lblFinput.setText("  Form Input");
        lblFinput.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFinput.setOpaque(true);
        lblFinput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFinputMouseClicked(evt);
            }
        });

        lblFValidasi.setBackground(new java.awt.Color(39, 41, 48));
        lblFValidasi.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblFValidasi.setForeground(new java.awt.Color(206, 206, 206));
        lblFValidasi.setText("  Form Validasi");
        lblFValidasi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFValidasi.setOpaque(true);
        lblFValidasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFValidasiMouseClicked(evt);
            }
        });

        lblFTransisi.setBackground(new java.awt.Color(39, 41, 48));
        lblFTransisi.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblFTransisi.setForeground(new java.awt.Color(206, 206, 206));
        lblFTransisi.setText("  Form Transisi");
        lblFTransisi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFTransisi.setOpaque(true);
        lblFTransisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFTransisiMouseClicked(evt);
            }
        });

        lblFSliding.setBackground(new java.awt.Color(39, 41, 48));
        lblFSliding.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblFSliding.setForeground(new java.awt.Color(206, 206, 206));
        lblFSliding.setText("  Form Sliding");
        lblFSliding.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFSliding.setOpaque(true);
        lblFSliding.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFSlidingMouseClicked(evt);
            }
        });

        lblFDialog.setBackground(new java.awt.Color(39, 41, 48));
        lblFDialog.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblFDialog.setForeground(new java.awt.Color(206, 206, 206));
        lblFDialog.setText("  Form Dialog");
        lblFDialog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFDialog.setOpaque(true);
        lblFDialog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFDialogMouseClicked(evt);
            }
        });

        lblNotif.setBackground(new java.awt.Color(39, 41, 48));
        lblNotif.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblNotif.setForeground(new java.awt.Color(206, 206, 206));
        lblNotif.setText("  Notifikasi");
        lblNotif.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNotif.setOpaque(true);
        lblNotif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNotifMouseClicked(evt);
            }
        });

        lblJasperArray.setBackground(new java.awt.Color(39, 41, 48));
        lblJasperArray.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblJasperArray.setForeground(new java.awt.Color(206, 206, 206));
        lblJasperArray.setText("  Jasper ArrayList");
        lblJasperArray.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblJasperArray.setOpaque(true);
        lblJasperArray.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblJasperArrayMouseClicked(evt);
            }
        });

        lblPSliding.setBackground(new java.awt.Color(39, 41, 48));
        lblPSliding.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblPSliding.setForeground(new java.awt.Color(206, 206, 206));
        lblPSliding.setText("  Panel Sliding");
        lblPSliding.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPSliding.setOpaque(true);
        lblPSliding.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPSlidingMouseClicked(evt);
            }
        });

        lblLoading.setBackground(new java.awt.Color(39, 41, 48));
        lblLoading.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblLoading.setForeground(new java.awt.Color(206, 206, 206));
        lblLoading.setText("  Loading");
        lblLoading.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLoading.setOpaque(true);
        lblLoading.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoadingMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDtTables, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblFinput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblFValidasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblFTransisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblFSliding, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblFDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblNotif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblJasperArray, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
            .addComponent(lblPSliding, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblLoading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lblDtTables, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblFinput, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblFValidasi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblFTransisi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblFSliding, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPSliding, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblJasperArray, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jScrollPane2.setViewportView(jPanel7);

        jPanel6.setBackground(new java.awt.Color(23, 25, 29));

        lblUser.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblUser.setForeground(new java.awt.Color(204, 204, 204));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("ARIANSYAH");

        lblAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblRole.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblRole.setForeground(new java.awt.Color(204, 204, 204));
        lblRole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRole.setText("administrator");

        jLabel22.setBackground(new java.awt.Color(56, 59, 68));
        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(179, 179, 179));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("MENU NAVIGASI");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel22.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAvatar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
        );

        jPanel1.add(pnMenu, java.awt.BorderLayout.LINE_START);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(800, 551));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("    Main Activity");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(191, 191, 191)));

        pnActivity.setBackground(new java.awt.Color(255, 255, 255));
        pnActivity.setLayout(new java.awt.BorderLayout());

        lblBanner.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblBanner.setForeground(new java.awt.Color(51, 51, 51));
        lblBanner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnActivity.add(lblBanner, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
                    .addComponent(pnActivity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnActivity, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pnFooter.setBackground(new java.awt.Color(27, 172, 145));
        pnFooter.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 0, 0, 0, new java.awt.Color(204, 204, 204)));
        pnFooter.setPreferredSize(new java.awt.Dimension(1288, 30));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Copyright (c) 2017 ARWANTECH CREATIVE TEAM");

        javax.swing.GroupLayout pnFooterLayout = new javax.swing.GroupLayout(pnFooter);
        pnFooter.setLayout(pnFooterLayout);
        pnFooterLayout.setHorizontalGroup(
            pnFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFooterLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addContainerGap(990, Short.MAX_VALUE))
        );
        pnFooterLayout.setVerticalGroup(
            pnFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        getContentPane().add(pnFooter, java.awt.BorderLayout.PAGE_END);

        pnHeader.setBackground(new java.awt.Color(27, 172, 145));
        pnHeader.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(204, 204, 204)));
        pnHeader.setPreferredSize(new java.awt.Dimension(1288, 60));

        lblLogo.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));

        lblLogout.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 255, 255));
        lblLogout.setText("Logout");
        lblLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 875, Short.MAX_VALUE)
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnHeader, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblDtTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDtTablesMouseClicked
        loadDataTables();
    }//GEN-LAST:event_lblDtTablesMouseClicked

    private void lblFinputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFinputMouseClicked
        FormInput input = new FormInput();
        input.setMain(this);
        switchPanel(input);
    }//GEN-LAST:event_lblFinputMouseClicked

    private void lblFValidasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFValidasiMouseClicked
        FormValidasi input = new FormValidasi();
        input.setMain(this);
        switchPanel(input);
    }//GEN-LAST:event_lblFValidasiMouseClicked

    private void lblFTransisiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFTransisiMouseClicked
        switchPanel(new FormTransisi());
    }//GEN-LAST:event_lblFTransisiMouseClicked

    private void lblFSlidingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFSlidingMouseClicked
        switchPanel(new FormSlide());
    }//GEN-LAST:event_lblFSlidingMouseClicked

    private void lblPSlidingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPSlidingMouseClicked
        PanelSliding panel = new PanelSliding(this, pnActivity);
        slidingPanel(panel, 3);
    }//GEN-LAST:event_lblPSlidingMouseClicked

    private void lblFDialogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFDialogMouseClicked
        switchPanel(new FormDialogPanel(this));
    }//GEN-LAST:event_lblFDialogMouseClicked

    private void lblNotifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNotifMouseClicked
        switchPanel(new Notifikasi(this));
    }//GEN-LAST:event_lblNotifMouseClicked

    private void lblLoadingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoadingMouseClicked
        switchPanel(new FormLoading(this));
    }//GEN-LAST:event_lblLoadingMouseClicked

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        logout();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblJasperArrayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJasperArrayMouseClicked
        switchPanel(new FormJasperArrayList(this));
    }//GEN-LAST:event_lblJasperArrayMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        boolean tanya = Utility.confirmDialog(this, null, "Apakah yakin akan keluar dari aplikasi ?");
        if (tanya) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(AppMainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppMainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppMainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppMainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppMainFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblBanner;
    private javax.swing.JLabel lblDtTables;
    private javax.swing.JLabel lblFDialog;
    private javax.swing.JLabel lblFSliding;
    private javax.swing.JLabel lblFTransisi;
    private javax.swing.JLabel lblFValidasi;
    private javax.swing.JLabel lblFinput;
    private javax.swing.JLabel lblJasperArray;
    private javax.swing.JLabel lblLoading;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblNotif;
    private javax.swing.JLabel lblPSliding;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnActivity;
    private javax.swing.JPanel pnFooter;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnMenu;
    // End of variables declaration//GEN-END:variables
}

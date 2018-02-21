/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adr.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author yaroslav
 */
public class PanelGPO extends javax.swing.JPanel {

    final private AlcorAdrApp theApp;
    final public Timer tRefreshStates;
    final public Timer tRefreshValues;
    final public Timer tPolling;
    
    /**
     * Creates new form PanelGPI
     */
    public PanelGPO( AlcorAdrApp app) {
        initComponents();
        theApp = app;
        tRefreshStates = new Timer( 100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean bEnable = theApp.GetDevGPI().isInitialized();
                
                btnConfigure.setEnabled(  bEnable);
                
                chkTU01.setEnabled( bEnable);
                btnTU01_СVal0.setEnabled( bEnable); btnTU01_СVal1.setEnabled( bEnable);
                btnTU01_SVal0.setEnabled( bEnable); btnTU01_SVal1.setEnabled( bEnable);
                
                chkTU02.setEnabled( bEnable);
                btnTU02_CVal0.setEnabled( bEnable); btnTU02_CVal1.setEnabled( bEnable);
                btnTU02_SVal0.setEnabled( bEnable); btnTU02_SVal1.setEnabled( bEnable);
                
                chkTU03.setEnabled( bEnable);
                btnTU03_CVal0.setEnabled( bEnable); btnTU03_CVal1.setEnabled( bEnable);
                btnTU03_SVal0.setEnabled( bEnable); btnTU03_SVal1.setEnabled( bEnable);
                
                chkTU04.setEnabled( bEnable);
                btnTU04_CVal0.setEnabled( bEnable); btnTU04_CVal1.setEnabled( bEnable);
                btnTU04_SVal0.setEnabled( bEnable); btnTU04_SVal1.setEnabled( bEnable);
                
                chkTU05.setEnabled( bEnable);
                btnTU05_CVal0.setEnabled( bEnable); btnTU05_CVal1.setEnabled( bEnable);
                btnTU05_SVal0.setEnabled( bEnable); btnTU05_SVal1.setEnabled( bEnable);
                
                chkTU06.setEnabled( bEnable);
                btnTU06_CVal0.setEnabled( bEnable); btnTU06_CVal1.setEnabled( bEnable);
                btnTU06_SVal0.setEnabled( bEnable); btnTU06_SVal1.setEnabled( bEnable);
                
                chkTU07.setEnabled( bEnable);
                btnTU07_СVal0.setEnabled( bEnable); btnTU07_CVal1.setEnabled( bEnable);
                btnTU07_SVal0.setEnabled( bEnable); btnTU07_SVal1.setEnabled( bEnable);
                
                chkTU08.setEnabled( bEnable);
                btnTU08_CVal0.setEnabled( bEnable); btnTU08_CVal1.setEnabled( bEnable);
                btnTU08_SVal0.setEnabled( bEnable); btnTU08_SVal1.setEnabled( bEnable);
                
                chkTU09.setEnabled( bEnable);
                btnTU09_CVal0.setEnabled( bEnable); btnTU09_CVal1.setEnabled( bEnable);
                btnTU09_SVal0.setEnabled( bEnable); btnTU09_SVal1.setEnabled( bEnable);
                
                chkTU10.setEnabled( bEnable);
                btnTU10_CVal0.setEnabled( bEnable); btnTU10_CVal1.setEnabled( bEnable);
                btnTU10_SVal0.setEnabled( bEnable); btnTU10_SVal1.setEnabled( bEnable);
                
                chkTU11.setEnabled( bEnable);
                btnTU11_CVal0.setEnabled( bEnable); btnTU11_CVal1.setEnabled( bEnable);
                btnTU11_SVal0.setEnabled( bEnable); btnTU11_SVal1.setEnabled( bEnable);
                
                chkTU12.setEnabled( bEnable);
                btnTU12_CVal0.setEnabled( bEnable); btnTU12_CVal1.setEnabled( bEnable);
                btnTU12_SVal0.setEnabled( bEnable); btnTU12_SVal1.setEnabled( bEnable);
                
                chkTU13.setEnabled( bEnable);
                btnTU13_CVal0.setEnabled( bEnable); btnTU13_CVal1.setEnabled( bEnable);
                btnTU13_SVal0.setEnabled( bEnable); btnTU13_SVal1.setEnabled( bEnable);
                
                chkTU14.setEnabled( bEnable);
                btnTU14_CVal0.setEnabled( bEnable); btnTU14_CVal1.setEnabled( bEnable);
                btnTU14_SVal0.setEnabled( bEnable); btnTU14_SVal1.setEnabled( bEnable);
                
                chkTU15.setEnabled( bEnable);
                btnTU15_CVal0.setEnabled( bEnable); btnTU15_CVal1.setEnabled( bEnable);
                btnTU15_SVal0.setEnabled( bEnable); btnTU15_SVal1.setEnabled( bEnable);
                
                chkTU16.setEnabled( bEnable);
                btnTU16_CVal0.setEnabled( bEnable); btnTU16_CVal1.setEnabled( bEnable);
                btnTU16_SVal0.setEnabled( bEnable); btnTU16_SVal1.setEnabled( bEnable);
                
                chkTU17.setEnabled( bEnable);
                btnTU17_CVal0.setEnabled( bEnable); btnTU17_CVal1.setEnabled( bEnable);
                btnTU17_SVal0.setEnabled( bEnable); btnTU17_SVal1.setEnabled( bEnable);
                
                chkTU18.setEnabled( bEnable);
                btnTU18_CVal0.setEnabled( bEnable); btnTU18_CVal1.setEnabled( bEnable);
                btnTU18_SVal0.setEnabled( bEnable); btnTU18_SVal1.setEnabled( bEnable);
                
                chkTU19.setEnabled( bEnable);
                btnTU19_CVal0.setEnabled( bEnable); btnTU19_CVal1.setEnabled( bEnable);
                btnTU19_SVal0.setEnabled( bEnable); btnTU19_SVal1.setEnabled( bEnable);
                
                chkTU20.setEnabled( bEnable);
                btnTU20_CVal0.setEnabled( bEnable); btnTU20_CVal1.setEnabled( bEnable);
                btnTU20_SVal0.setEnabled( bEnable); btnTU20_SVal1.setEnabled( bEnable);
                
                
                btnRefreshCurrentValues.setEnabled(   bEnable);
                btnRefreshStartupValues.setEnabled(   bEnable);
                
                btnAll_all.setEnabled( bEnable);
                btnAll_none.setEnabled( bEnable);
                btnAll_CVal0.setEnabled( bEnable);
                btnAll_CVal1.setEnabled( bEnable);
                btnAll_SVal0.setEnabled( bEnable);
                btnAll_SVal1.setEnabled( bEnable);
                
                chkLoopCycle.setEnabled( bEnable);
            }
        });
        
        tRefreshStates.start();
        
        tRefreshValues = new Timer( 100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if( !edtGPOAddressValue.isEnabled())
                    if( theApp.GetDevGPO().GetAddress() != null)
                        edtGPOAddressValue.setText( "0x00" + theApp.GetDevGPO().GetAddress());
                    else
                        edtGPOAddressValue.setText( "NULL");
                
                String cBits = theApp.GetDevGPO().GetCBits();
                
                JLabel cLabels[] = { lblTU01_СValue, lblTU02_CValue, lblTU03_CValue, lblTU04_CValue, lblTU05_CValue,
                                    lblTU06_CValue, lblTU07_CValue, lblTU08_CValue, lblTU09_CValue, lblTU10_CValue,
                                    lblTU11_CValue, lblTU12_CValue, lblTU13_CValue, lblTU14_CValue, lblTU15_CValue,
                                    lblTU16_CValue, lblTU17_CValue, lblTU18_CValue, lblTU19_CValue, lblTU20_CValue };
                
                if( cBits != null && cBits.length() == 20) {
                    
                    for( int i=0; i<20; i++) {

                        if(      cBits.charAt( i) == '0')
                            cLabels[i].setIcon( theApp.GetResources().getIconBigRed());
                        else if( cBits.charAt( i) == '1')
                            cLabels[i].setIcon( theApp.GetResources().getIconBigGreen());
                        else
                            cLabels[i].setIcon( theApp.GetResources().getIconBigBlack());
                    }
                }
                else {
                    for( int i=0; i<20; cLabels[i++].setIcon( theApp.GetResources().getIconBigBlack()));
                }
                
                String sBits = theApp.GetDevGPO().GetSBits();
                
                JLabel sLabels[] = { lblTU01_SValue, lblTU02_SValue, lblTU03_SValue, lblTU04_SValue, lblTU05_SValue,
                                    lblTU06_SValue, lblTU07_SValue, lblTU08_SValue, lblTU09_SValue, lblTU10_SValue,
                                    lblTU11_SValue, lblTU12_SValue, lblTU13_SValue, lblTU14_SValue, lblTU15_SValue,
                                    lblTU16_SValue, lblTU17_SValue, lblTU18_SValue, lblTU19_SValue, lblTU20_SValue };
                
                if( sBits != null && sBits.length() == 20) {
                    
                    for( int i=0; i<20; i++) {

                        if(      sBits.charAt( i) == '0')
                            sLabels[i].setIcon( theApp.GetResources().getIconBigRed());
                        else if( sBits.charAt( i) == '1')
                            sLabels[i].setIcon( theApp.GetResources().getIconBigGreen());
                        else
                            sLabels[i].setIcon( theApp.GetResources().getIconBigBlack());
                    }
                }
                else {
                    for( int i=0; i<20; sLabels[i++].setIcon( theApp.GetResources().getIconBigBlack()));
                }
            }
        });
        
        tRefreshValues.start();
        
        tPolling = new Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if( theApp.GetConnectionState() == AlcorAdrConstants.CONNECT_CONNECTED)
                    theApp.GetRxTx().AddCommandToQueue( theApp.GetDevGPO().cmdGetCurrentValues(), theApp.GetDevGPO());
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblGPOAddrTitle = new javax.swing.JLabel();
        edtGPOAddressValue = new javax.swing.JTextField();
        lblCSTitle = new javax.swing.JLabel();
        chkCSvalue = new javax.swing.JCheckBox();
        btnConfigure = new javax.swing.JButton();
        chkTU01 = new javax.swing.JCheckBox();
        lblTU01_СValue = new javax.swing.JLabel();
        btnTU01_СVal0 = new javax.swing.JButton();
        btnTU01_СVal1 = new javax.swing.JButton();
        lblTU01_SValue = new javax.swing.JLabel();
        btnTU01_SVal0 = new javax.swing.JButton();
        btnTU01_SVal1 = new javax.swing.JButton();
        chkTU02 = new javax.swing.JCheckBox();
        lblTU02_CValue = new javax.swing.JLabel();
        btnTU02_CVal0 = new javax.swing.JButton();
        btnTU02_CVal1 = new javax.swing.JButton();
        lblTU02_SValue = new javax.swing.JLabel();
        btnTU02_SVal0 = new javax.swing.JButton();
        btnTU02_SVal1 = new javax.swing.JButton();
        chkTU03 = new javax.swing.JCheckBox();
        lblTU03_CValue = new javax.swing.JLabel();
        btnTU03_CVal0 = new javax.swing.JButton();
        btnTU03_CVal1 = new javax.swing.JButton();
        lblTU03_SValue = new javax.swing.JLabel();
        btnTU03_SVal0 = new javax.swing.JButton();
        btnTU03_SVal1 = new javax.swing.JButton();
        chkTU04 = new javax.swing.JCheckBox();
        lblTU04_CValue = new javax.swing.JLabel();
        btnTU04_CVal0 = new javax.swing.JButton();
        btnTU04_CVal1 = new javax.swing.JButton();
        lblTU04_SValue = new javax.swing.JLabel();
        btnTU04_SVal0 = new javax.swing.JButton();
        btnTU04_SVal1 = new javax.swing.JButton();
        chkTU05 = new javax.swing.JCheckBox();
        lblTU05_CValue = new javax.swing.JLabel();
        btnTU05_CVal0 = new javax.swing.JButton();
        btnTU05_CVal1 = new javax.swing.JButton();
        lblTU05_SValue = new javax.swing.JLabel();
        btnTU05_SVal0 = new javax.swing.JButton();
        btnTU05_SVal1 = new javax.swing.JButton();
        chkTU06 = new javax.swing.JCheckBox();
        lblTU06_CValue = new javax.swing.JLabel();
        btnTU06_CVal0 = new javax.swing.JButton();
        btnTU06_CVal1 = new javax.swing.JButton();
        lblTU06_SValue = new javax.swing.JLabel();
        btnTU06_SVal0 = new javax.swing.JButton();
        btnTU06_SVal1 = new javax.swing.JButton();
        chkTU07 = new javax.swing.JCheckBox();
        lblTU07_CValue = new javax.swing.JLabel();
        btnTU07_СVal0 = new javax.swing.JButton();
        btnTU07_CVal1 = new javax.swing.JButton();
        lblTU07_SValue = new javax.swing.JLabel();
        btnTU07_SVal0 = new javax.swing.JButton();
        btnTU07_SVal1 = new javax.swing.JButton();
        chkTU08 = new javax.swing.JCheckBox();
        lblTU08_CValue = new javax.swing.JLabel();
        btnTU08_CVal0 = new javax.swing.JButton();
        btnTU08_CVal1 = new javax.swing.JButton();
        lblTU08_SValue = new javax.swing.JLabel();
        btnTU08_SVal0 = new javax.swing.JButton();
        btnTU08_SVal1 = new javax.swing.JButton();
        chkTU09 = new javax.swing.JCheckBox();
        lblTU09_CValue = new javax.swing.JLabel();
        btnTU09_CVal0 = new javax.swing.JButton();
        btnTU09_CVal1 = new javax.swing.JButton();
        lblTU09_SValue = new javax.swing.JLabel();
        btnTU09_SVal0 = new javax.swing.JButton();
        btnTU09_SVal1 = new javax.swing.JButton();
        chkTU10 = new javax.swing.JCheckBox();
        lblTU10_CValue = new javax.swing.JLabel();
        btnTU10_CVal0 = new javax.swing.JButton();
        btnTU10_CVal1 = new javax.swing.JButton();
        lblTU10_SValue = new javax.swing.JLabel();
        btnTU10_SVal0 = new javax.swing.JButton();
        btnTU10_SVal1 = new javax.swing.JButton();
        chkTU11 = new javax.swing.JCheckBox();
        lblTU11_CValue = new javax.swing.JLabel();
        btnTU11_CVal0 = new javax.swing.JButton();
        btnTU11_CVal1 = new javax.swing.JButton();
        lblTU11_SValue = new javax.swing.JLabel();
        btnTU11_SVal0 = new javax.swing.JButton();
        btnTU11_SVal1 = new javax.swing.JButton();
        chkTU12 = new javax.swing.JCheckBox();
        lblTU12_CValue = new javax.swing.JLabel();
        btnTU12_CVal0 = new javax.swing.JButton();
        btnTU12_CVal1 = new javax.swing.JButton();
        lblTU12_SValue = new javax.swing.JLabel();
        btnTU12_SVal0 = new javax.swing.JButton();
        btnTU12_SVal1 = new javax.swing.JButton();
        chkTU13 = new javax.swing.JCheckBox();
        lblTU13_CValue = new javax.swing.JLabel();
        btnTU13_CVal0 = new javax.swing.JButton();
        btnTU13_CVal1 = new javax.swing.JButton();
        lblTU13_SValue = new javax.swing.JLabel();
        btnTU13_SVal0 = new javax.swing.JButton();
        btnTU13_SVal1 = new javax.swing.JButton();
        chkTU14 = new javax.swing.JCheckBox();
        lblTU14_CValue = new javax.swing.JLabel();
        btnTU14_CVal0 = new javax.swing.JButton();
        btnTU14_CVal1 = new javax.swing.JButton();
        lblTU14_SValue = new javax.swing.JLabel();
        btnTU14_SVal0 = new javax.swing.JButton();
        btnTU14_SVal1 = new javax.swing.JButton();
        chkTU15 = new javax.swing.JCheckBox();
        lblTU15_CValue = new javax.swing.JLabel();
        btnTU15_CVal0 = new javax.swing.JButton();
        btnTU15_CVal1 = new javax.swing.JButton();
        lblTU15_SValue = new javax.swing.JLabel();
        btnTU15_SVal0 = new javax.swing.JButton();
        btnTU15_SVal1 = new javax.swing.JButton();
        chkTU16 = new javax.swing.JCheckBox();
        lblTU16_CValue = new javax.swing.JLabel();
        btnTU16_CVal0 = new javax.swing.JButton();
        btnTU16_CVal1 = new javax.swing.JButton();
        lblTU16_SValue = new javax.swing.JLabel();
        btnTU16_SVal0 = new javax.swing.JButton();
        btnTU16_SVal1 = new javax.swing.JButton();
        chkTU17 = new javax.swing.JCheckBox();
        lblTU17_CValue = new javax.swing.JLabel();
        btnTU17_CVal0 = new javax.swing.JButton();
        btnTU17_CVal1 = new javax.swing.JButton();
        lblTU17_SValue = new javax.swing.JLabel();
        btnTU17_SVal0 = new javax.swing.JButton();
        btnTU17_SVal1 = new javax.swing.JButton();
        chkTU18 = new javax.swing.JCheckBox();
        lblTU18_CValue = new javax.swing.JLabel();
        btnTU18_CVal0 = new javax.swing.JButton();
        btnTU18_CVal1 = new javax.swing.JButton();
        lblTU18_SValue = new javax.swing.JLabel();
        btnTU18_SVal0 = new javax.swing.JButton();
        btnTU18_SVal1 = new javax.swing.JButton();
        chkTU19 = new javax.swing.JCheckBox();
        lblTU19_CValue = new javax.swing.JLabel();
        btnTU19_CVal0 = new javax.swing.JButton();
        btnTU19_CVal1 = new javax.swing.JButton();
        lblTU19_SValue = new javax.swing.JLabel();
        btnTU19_SVal0 = new javax.swing.JButton();
        btnTU19_SVal1 = new javax.swing.JButton();
        chkTU20 = new javax.swing.JCheckBox();
        lblTU20_CValue = new javax.swing.JLabel();
        btnTU20_CVal0 = new javax.swing.JButton();
        btnTU20_CVal1 = new javax.swing.JButton();
        lblTU20_SValue = new javax.swing.JLabel();
        btnTU20_SVal0 = new javax.swing.JButton();
        btnTU20_SVal1 = new javax.swing.JButton();
        btnRefreshCurrentValues = new javax.swing.JButton();
        btnRefreshStartupValues = new javax.swing.JButton();
        btnAll_all = new javax.swing.JButton();
        btnAll_none = new javax.swing.JButton();
        btnAll_CVal0 = new javax.swing.JButton();
        btnAll_CVal1 = new javax.swing.JButton();
        btnAll_SVal0 = new javax.swing.JButton();
        btnAll_SVal1 = new javax.swing.JButton();
        chkLoopCycle = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 220)));
        setMaximumSize(new java.awt.Dimension(310, 870));
        setMinimumSize(new java.awt.Dimension(310, 870));
        setPreferredSize(new java.awt.Dimension(310, 870));
        setLayout(null);

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("GPO - Цифровые выходы");
        add(lblTitle);
        lblTitle.setBounds(0, 0, 310, 20);

        lblGPOAddrTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGPOAddrTitle.setText("Адрес");
        add(lblGPOAddrTitle);
        lblGPOAddrTitle.setBounds(30, 30, 60, 30);

        edtGPOAddressValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtGPOAddressValue.setText("-");
        edtGPOAddressValue.setEnabled(false);
        add(edtGPOAddressValue);
        edtGPOAddressValue.setBounds(90, 30, 80, 30);

        lblCSTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCSTitle.setText("CS");
        add(lblCSTitle);
        lblCSTitle.setBounds(200, 30, 50, 30);

        chkCSvalue.setEnabled(false);
        add(chkCSvalue);
        chkCSvalue.setBounds(250, 30, 30, 30);

        btnConfigure.setText("Настроить");
        btnConfigure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigureActionPerformed(evt);
            }
        });
        add(btnConfigure);
        btnConfigure.setBounds(20, 60, 280, 40);

        chkTU01.setText("TU01");
        chkTU01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU01);
        chkTU01.setBounds(10, 130, 70, 25);

        lblTU01_СValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU01_СValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU01_СValue);
        lblTU01_СValue.setBounds(80, 130, 30, 25);

        btnTU01_СVal0.setText("0");
        btnTU01_СVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU01_СVal0ActionPerformed(evt);
            }
        });
        add(btnTU01_СVal0);
        btnTU01_СVal0.setBounds(110, 130, 40, 25);

        btnTU01_СVal1.setText("1");
        btnTU01_СVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU01_СVal1ActionPerformed(evt);
            }
        });
        add(btnTU01_СVal1);
        btnTU01_СVal1.setBounds(150, 130, 40, 25);

        lblTU01_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU01_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU01_SValue);
        lblTU01_SValue.setBounds(190, 130, 30, 25);

        btnTU01_SVal0.setText("0");
        btnTU01_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU01_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU01_SVal0);
        btnTU01_SVal0.setBounds(220, 130, 40, 25);

        btnTU01_SVal1.setText("1");
        btnTU01_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU01_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU01_SVal1);
        btnTU01_SVal1.setBounds(260, 130, 40, 25);

        chkTU02.setText("TU02");
        chkTU02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU02);
        chkTU02.setBounds(10, 160, 70, 25);

        lblTU02_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU02_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU02_CValue);
        lblTU02_CValue.setBounds(80, 160, 30, 25);

        btnTU02_CVal0.setText("0");
        btnTU02_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU02_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU02_CVal0);
        btnTU02_CVal0.setBounds(110, 160, 40, 25);

        btnTU02_CVal1.setText("1");
        btnTU02_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU02_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU02_CVal1);
        btnTU02_CVal1.setBounds(150, 160, 40, 25);

        lblTU02_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU02_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU02_SValue);
        lblTU02_SValue.setBounds(190, 160, 30, 25);

        btnTU02_SVal0.setText("0");
        btnTU02_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU02_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU02_SVal0);
        btnTU02_SVal0.setBounds(220, 160, 40, 25);

        btnTU02_SVal1.setText("1");
        btnTU02_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU02_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU02_SVal1);
        btnTU02_SVal1.setBounds(260, 160, 40, 25);

        chkTU03.setText("TU03");
        chkTU03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU03);
        chkTU03.setBounds(10, 190, 70, 25);

        lblTU03_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU03_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU03_CValue);
        lblTU03_CValue.setBounds(80, 190, 30, 25);

        btnTU03_CVal0.setText("0");
        btnTU03_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU03_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU03_CVal0);
        btnTU03_CVal0.setBounds(110, 190, 40, 25);

        btnTU03_CVal1.setText("1");
        btnTU03_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU03_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU03_CVal1);
        btnTU03_CVal1.setBounds(150, 190, 40, 25);

        lblTU03_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU03_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU03_SValue);
        lblTU03_SValue.setBounds(190, 190, 30, 25);

        btnTU03_SVal0.setText("0");
        btnTU03_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU03_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU03_SVal0);
        btnTU03_SVal0.setBounds(220, 190, 40, 25);

        btnTU03_SVal1.setText("1");
        btnTU03_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU03_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU03_SVal1);
        btnTU03_SVal1.setBounds(260, 190, 40, 25);

        chkTU04.setText("TU04");
        chkTU04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU04);
        chkTU04.setBounds(10, 220, 70, 25);

        lblTU04_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU04_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU04_CValue);
        lblTU04_CValue.setBounds(80, 220, 30, 25);

        btnTU04_CVal0.setText("0");
        btnTU04_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU04_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU04_CVal0);
        btnTU04_CVal0.setBounds(110, 220, 40, 25);

        btnTU04_CVal1.setText("1");
        btnTU04_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU04_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU04_CVal1);
        btnTU04_CVal1.setBounds(150, 220, 40, 25);

        lblTU04_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU04_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU04_SValue);
        lblTU04_SValue.setBounds(190, 220, 30, 25);

        btnTU04_SVal0.setText("0");
        btnTU04_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU04_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU04_SVal0);
        btnTU04_SVal0.setBounds(220, 220, 40, 25);

        btnTU04_SVal1.setText("1");
        btnTU04_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU04_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU04_SVal1);
        btnTU04_SVal1.setBounds(260, 220, 40, 25);

        chkTU05.setText("TU05");
        chkTU05.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU05);
        chkTU05.setBounds(10, 250, 70, 25);

        lblTU05_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU05_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU05_CValue);
        lblTU05_CValue.setBounds(80, 250, 30, 25);

        btnTU05_CVal0.setText("0");
        btnTU05_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU05_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU05_CVal0);
        btnTU05_CVal0.setBounds(110, 250, 40, 25);

        btnTU05_CVal1.setText("1");
        btnTU05_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU05_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU05_CVal1);
        btnTU05_CVal1.setBounds(150, 250, 40, 25);

        lblTU05_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU05_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU05_SValue);
        lblTU05_SValue.setBounds(190, 250, 30, 25);

        btnTU05_SVal0.setText("0");
        btnTU05_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU05_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU05_SVal0);
        btnTU05_SVal0.setBounds(220, 250, 40, 25);

        btnTU05_SVal1.setText("1");
        btnTU05_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU05_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU05_SVal1);
        btnTU05_SVal1.setBounds(260, 250, 40, 25);

        chkTU06.setText("TU06");
        chkTU06.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU06);
        chkTU06.setBounds(10, 280, 70, 25);

        lblTU06_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU06_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU06_CValue);
        lblTU06_CValue.setBounds(80, 280, 30, 25);

        btnTU06_CVal0.setText("0");
        btnTU06_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU06_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU06_CVal0);
        btnTU06_CVal0.setBounds(110, 280, 40, 25);

        btnTU06_CVal1.setText("1");
        btnTU06_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU06_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU06_CVal1);
        btnTU06_CVal1.setBounds(150, 280, 40, 25);

        lblTU06_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU06_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU06_SValue);
        lblTU06_SValue.setBounds(190, 280, 30, 25);

        btnTU06_SVal0.setText("0");
        btnTU06_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU06_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU06_SVal0);
        btnTU06_SVal0.setBounds(220, 280, 40, 25);

        btnTU06_SVal1.setText("1");
        btnTU06_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU06_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU06_SVal1);
        btnTU06_SVal1.setBounds(260, 280, 40, 25);

        chkTU07.setText("TU07");
        chkTU07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU07);
        chkTU07.setBounds(10, 310, 70, 25);

        lblTU07_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU07_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU07_CValue);
        lblTU07_CValue.setBounds(80, 310, 30, 25);

        btnTU07_СVal0.setText("0");
        btnTU07_СVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU07_СVal0ActionPerformed(evt);
            }
        });
        add(btnTU07_СVal0);
        btnTU07_СVal0.setBounds(110, 310, 40, 25);

        btnTU07_CVal1.setText("1");
        btnTU07_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU07_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU07_CVal1);
        btnTU07_CVal1.setBounds(150, 310, 40, 25);

        lblTU07_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU07_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU07_SValue);
        lblTU07_SValue.setBounds(190, 310, 30, 25);

        btnTU07_SVal0.setText("0");
        btnTU07_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU07_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU07_SVal0);
        btnTU07_SVal0.setBounds(220, 310, 40, 25);

        btnTU07_SVal1.setText("1");
        btnTU07_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU07_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU07_SVal1);
        btnTU07_SVal1.setBounds(260, 310, 40, 25);

        chkTU08.setText("TU08");
        chkTU08.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU08);
        chkTU08.setBounds(10, 340, 70, 25);

        lblTU08_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU08_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU08_CValue);
        lblTU08_CValue.setBounds(80, 340, 30, 25);

        btnTU08_CVal0.setText("0");
        btnTU08_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU08_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU08_CVal0);
        btnTU08_CVal0.setBounds(110, 340, 40, 25);

        btnTU08_CVal1.setText("1");
        btnTU08_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU08_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU08_CVal1);
        btnTU08_CVal1.setBounds(150, 340, 40, 25);

        lblTU08_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU08_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU08_SValue);
        lblTU08_SValue.setBounds(190, 340, 30, 25);

        btnTU08_SVal0.setText("0");
        btnTU08_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU08_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU08_SVal0);
        btnTU08_SVal0.setBounds(220, 340, 40, 25);

        btnTU08_SVal1.setText("1");
        btnTU08_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU08_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU08_SVal1);
        btnTU08_SVal1.setBounds(260, 340, 40, 25);

        chkTU09.setText("TU09");
        chkTU09.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU09);
        chkTU09.setBounds(10, 370, 70, 25);

        lblTU09_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU09_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU09_CValue);
        lblTU09_CValue.setBounds(80, 370, 30, 25);

        btnTU09_CVal0.setText("0");
        btnTU09_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU09_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU09_CVal0);
        btnTU09_CVal0.setBounds(110, 370, 40, 25);

        btnTU09_CVal1.setText("1");
        btnTU09_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU09_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU09_CVal1);
        btnTU09_CVal1.setBounds(150, 370, 40, 25);

        lblTU09_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU09_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU09_SValue);
        lblTU09_SValue.setBounds(190, 370, 30, 25);

        btnTU09_SVal0.setText("0");
        btnTU09_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU09_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU09_SVal0);
        btnTU09_SVal0.setBounds(220, 370, 40, 25);

        btnTU09_SVal1.setText("1");
        btnTU09_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU09_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU09_SVal1);
        btnTU09_SVal1.setBounds(260, 370, 40, 25);

        chkTU10.setText("TU10");
        chkTU10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU10);
        chkTU10.setBounds(10, 400, 70, 25);

        lblTU10_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU10_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU10_CValue);
        lblTU10_CValue.setBounds(80, 400, 30, 25);

        btnTU10_CVal0.setText("0");
        btnTU10_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU10_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU10_CVal0);
        btnTU10_CVal0.setBounds(110, 400, 40, 25);

        btnTU10_CVal1.setText("1");
        btnTU10_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU10_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU10_CVal1);
        btnTU10_CVal1.setBounds(150, 400, 40, 25);

        lblTU10_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU10_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU10_SValue);
        lblTU10_SValue.setBounds(190, 400, 30, 25);

        btnTU10_SVal0.setText("0");
        btnTU10_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU10_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU10_SVal0);
        btnTU10_SVal0.setBounds(220, 400, 40, 25);

        btnTU10_SVal1.setText("1");
        btnTU10_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU10_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU10_SVal1);
        btnTU10_SVal1.setBounds(260, 400, 40, 25);

        chkTU11.setText("TU11");
        chkTU11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU11);
        chkTU11.setBounds(10, 430, 70, 25);

        lblTU11_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU11_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU11_CValue);
        lblTU11_CValue.setBounds(80, 430, 30, 25);

        btnTU11_CVal0.setText("0");
        btnTU11_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU11_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU11_CVal0);
        btnTU11_CVal0.setBounds(110, 430, 40, 25);

        btnTU11_CVal1.setText("1");
        btnTU11_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU11_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU11_CVal1);
        btnTU11_CVal1.setBounds(150, 430, 40, 25);

        lblTU11_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU11_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU11_SValue);
        lblTU11_SValue.setBounds(190, 430, 30, 25);

        btnTU11_SVal0.setText("0");
        btnTU11_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU11_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU11_SVal0);
        btnTU11_SVal0.setBounds(220, 430, 40, 25);

        btnTU11_SVal1.setText("1");
        btnTU11_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU11_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU11_SVal1);
        btnTU11_SVal1.setBounds(260, 430, 40, 25);

        chkTU12.setText("TU12");
        chkTU12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU12);
        chkTU12.setBounds(10, 460, 70, 25);

        lblTU12_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU12_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU12_CValue);
        lblTU12_CValue.setBounds(80, 460, 30, 25);

        btnTU12_CVal0.setText("0");
        btnTU12_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU12_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU12_CVal0);
        btnTU12_CVal0.setBounds(110, 460, 40, 25);

        btnTU12_CVal1.setText("1");
        btnTU12_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU12_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU12_CVal1);
        btnTU12_CVal1.setBounds(150, 460, 40, 25);

        lblTU12_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU12_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU12_SValue);
        lblTU12_SValue.setBounds(190, 460, 30, 25);

        btnTU12_SVal0.setText("0");
        btnTU12_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU12_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU12_SVal0);
        btnTU12_SVal0.setBounds(220, 460, 40, 25);

        btnTU12_SVal1.setText("1");
        btnTU12_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU12_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU12_SVal1);
        btnTU12_SVal1.setBounds(260, 460, 40, 25);

        chkTU13.setText("TU13");
        chkTU13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU13);
        chkTU13.setBounds(10, 490, 70, 25);

        lblTU13_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU13_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU13_CValue);
        lblTU13_CValue.setBounds(80, 490, 30, 25);

        btnTU13_CVal0.setText("0");
        btnTU13_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU13_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU13_CVal0);
        btnTU13_CVal0.setBounds(110, 490, 40, 25);

        btnTU13_CVal1.setText("1");
        btnTU13_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU13_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU13_CVal1);
        btnTU13_CVal1.setBounds(150, 490, 40, 25);

        lblTU13_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU13_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU13_SValue);
        lblTU13_SValue.setBounds(190, 490, 30, 25);

        btnTU13_SVal0.setText("0");
        btnTU13_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU13_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU13_SVal0);
        btnTU13_SVal0.setBounds(220, 490, 40, 25);

        btnTU13_SVal1.setText("1");
        btnTU13_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU13_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU13_SVal1);
        btnTU13_SVal1.setBounds(260, 490, 40, 25);

        chkTU14.setText("TU14");
        chkTU14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU14);
        chkTU14.setBounds(10, 520, 70, 25);

        lblTU14_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU14_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU14_CValue);
        lblTU14_CValue.setBounds(80, 520, 30, 25);

        btnTU14_CVal0.setText("0");
        btnTU14_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU14_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU14_CVal0);
        btnTU14_CVal0.setBounds(110, 520, 40, 25);

        btnTU14_CVal1.setText("1");
        btnTU14_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU14_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU14_CVal1);
        btnTU14_CVal1.setBounds(150, 520, 40, 25);

        lblTU14_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU14_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU14_SValue);
        lblTU14_SValue.setBounds(190, 520, 30, 25);

        btnTU14_SVal0.setText("0");
        btnTU14_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU14_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU14_SVal0);
        btnTU14_SVal0.setBounds(220, 520, 40, 25);

        btnTU14_SVal1.setText("1");
        btnTU14_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU14_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU14_SVal1);
        btnTU14_SVal1.setBounds(260, 520, 40, 25);

        chkTU15.setText("TU15");
        chkTU15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU15);
        chkTU15.setBounds(10, 550, 70, 25);

        lblTU15_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU15_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU15_CValue);
        lblTU15_CValue.setBounds(80, 550, 30, 25);

        btnTU15_CVal0.setText("0");
        btnTU15_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU15_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU15_CVal0);
        btnTU15_CVal0.setBounds(110, 550, 40, 25);

        btnTU15_CVal1.setText("1");
        btnTU15_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU15_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU15_CVal1);
        btnTU15_CVal1.setBounds(150, 550, 40, 25);

        lblTU15_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU15_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU15_SValue);
        lblTU15_SValue.setBounds(190, 550, 30, 25);

        btnTU15_SVal0.setText("0");
        btnTU15_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU15_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU15_SVal0);
        btnTU15_SVal0.setBounds(220, 550, 40, 25);

        btnTU15_SVal1.setText("1");
        btnTU15_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU15_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU15_SVal1);
        btnTU15_SVal1.setBounds(260, 550, 40, 25);

        chkTU16.setText("TU16");
        chkTU16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU16);
        chkTU16.setBounds(10, 580, 70, 25);

        lblTU16_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU16_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU16_CValue);
        lblTU16_CValue.setBounds(80, 580, 30, 25);

        btnTU16_CVal0.setText("0");
        btnTU16_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU16_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU16_CVal0);
        btnTU16_CVal0.setBounds(110, 580, 40, 25);

        btnTU16_CVal1.setText("1");
        btnTU16_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU16_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU16_CVal1);
        btnTU16_CVal1.setBounds(150, 580, 40, 25);

        lblTU16_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU16_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU16_SValue);
        lblTU16_SValue.setBounds(190, 580, 30, 25);

        btnTU16_SVal0.setText("0");
        btnTU16_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU16_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU16_SVal0);
        btnTU16_SVal0.setBounds(220, 580, 40, 25);

        btnTU16_SVal1.setText("1");
        btnTU16_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU16_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU16_SVal1);
        btnTU16_SVal1.setBounds(260, 580, 40, 25);

        chkTU17.setText("TU17");
        chkTU17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU17);
        chkTU17.setBounds(10, 610, 70, 25);

        lblTU17_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU17_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU17_CValue);
        lblTU17_CValue.setBounds(80, 610, 30, 25);

        btnTU17_CVal0.setText("0");
        btnTU17_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU17_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU17_CVal0);
        btnTU17_CVal0.setBounds(110, 610, 40, 25);

        btnTU17_CVal1.setText("1");
        btnTU17_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU17_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU17_CVal1);
        btnTU17_CVal1.setBounds(150, 610, 40, 25);

        lblTU17_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU17_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU17_SValue);
        lblTU17_SValue.setBounds(190, 610, 30, 25);

        btnTU17_SVal0.setText("0");
        btnTU17_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU17_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU17_SVal0);
        btnTU17_SVal0.setBounds(220, 610, 40, 25);

        btnTU17_SVal1.setText("1");
        btnTU17_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU17_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU17_SVal1);
        btnTU17_SVal1.setBounds(260, 610, 40, 25);

        chkTU18.setText("TU18");
        chkTU18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU18);
        chkTU18.setBounds(10, 640, 70, 25);

        lblTU18_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU18_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU18_CValue);
        lblTU18_CValue.setBounds(80, 640, 30, 25);

        btnTU18_CVal0.setText("0");
        btnTU18_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU18_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU18_CVal0);
        btnTU18_CVal0.setBounds(110, 640, 40, 25);

        btnTU18_CVal1.setText("1");
        btnTU18_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU18_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU18_CVal1);
        btnTU18_CVal1.setBounds(150, 640, 40, 25);

        lblTU18_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU18_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU18_SValue);
        lblTU18_SValue.setBounds(190, 640, 30, 25);

        btnTU18_SVal0.setText("0");
        btnTU18_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU18_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU18_SVal0);
        btnTU18_SVal0.setBounds(220, 640, 40, 25);

        btnTU18_SVal1.setText("1");
        btnTU18_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU18_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU18_SVal1);
        btnTU18_SVal1.setBounds(260, 640, 40, 25);

        chkTU19.setText("TU19");
        chkTU19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU19);
        chkTU19.setBounds(10, 670, 70, 25);

        lblTU19_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU19_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU19_CValue);
        lblTU19_CValue.setBounds(80, 670, 30, 25);

        btnTU19_CVal0.setText("0");
        btnTU19_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU19_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU19_CVal0);
        btnTU19_CVal0.setBounds(110, 670, 40, 25);

        btnTU19_CVal1.setText("1");
        btnTU19_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU19_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU19_CVal1);
        btnTU19_CVal1.setBounds(150, 670, 40, 25);

        lblTU19_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU19_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU19_SValue);
        lblTU19_SValue.setBounds(190, 670, 30, 25);

        btnTU19_SVal0.setText("0");
        btnTU19_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU19_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU19_SVal0);
        btnTU19_SVal0.setBounds(220, 670, 40, 25);

        btnTU19_SVal1.setText("1");
        btnTU19_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU19_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU19_SVal1);
        btnTU19_SVal1.setBounds(260, 670, 40, 25);

        chkTU20.setText("TU20");
        chkTU20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(chkTU20);
        chkTU20.setBounds(10, 700, 70, 25);

        lblTU20_CValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU20_CValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU20_CValue);
        lblTU20_CValue.setBounds(80, 700, 30, 25);

        btnTU20_CVal0.setText("0");
        btnTU20_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU20_CVal0ActionPerformed(evt);
            }
        });
        add(btnTU20_CVal0);
        btnTU20_CVal0.setBounds(110, 700, 40, 25);

        btnTU20_CVal1.setText("1");
        btnTU20_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU20_CVal1ActionPerformed(evt);
            }
        });
        add(btnTU20_CVal1);
        btnTU20_CVal1.setBounds(150, 700, 40, 25);

        lblTU20_SValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTU20_SValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        add(lblTU20_SValue);
        lblTU20_SValue.setBounds(190, 700, 30, 25);

        btnTU20_SVal0.setText("0");
        btnTU20_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU20_SVal0ActionPerformed(evt);
            }
        });
        add(btnTU20_SVal0);
        btnTU20_SVal0.setBounds(220, 700, 40, 25);

        btnTU20_SVal1.setText("1");
        btnTU20_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTU20_SVal1ActionPerformed(evt);
            }
        });
        add(btnTU20_SVal1);
        btnTU20_SVal1.setBounds(260, 700, 40, 25);

        btnRefreshCurrentValues.setText("Обновить");
        btnRefreshCurrentValues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshCurrentValuesActionPerformed(evt);
            }
        });
        add(btnRefreshCurrentValues);
        btnRefreshCurrentValues.setBounds(80, 730, 110, 30);

        btnRefreshStartupValues.setText("Обновить");
        btnRefreshStartupValues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshStartupValuesActionPerformed(evt);
            }
        });
        add(btnRefreshStartupValues);
        btnRefreshStartupValues.setBounds(190, 730, 110, 30);

        btnAll_all.setText("ВСЕ");
        btnAll_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAll_allActionPerformed(evt);
            }
        });
        add(btnAll_all);
        btnAll_all.setBounds(10, 760, 90, 30);

        btnAll_none.setText("НИКОГО");
        btnAll_none.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAll_noneActionPerformed(evt);
            }
        });
        add(btnAll_none);
        btnAll_none.setBounds(10, 790, 90, 30);

        btnAll_CVal0.setText("0");
        btnAll_CVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAll_CVal0ActionPerformed(evt);
            }
        });
        add(btnAll_CVal0);
        btnAll_CVal0.setBounds(110, 780, 40, 25);

        btnAll_CVal1.setText("1");
        btnAll_CVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAll_CVal1ActionPerformed(evt);
            }
        });
        add(btnAll_CVal1);
        btnAll_CVal1.setBounds(150, 780, 40, 25);

        btnAll_SVal0.setText("0");
        btnAll_SVal0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAll_SVal0ActionPerformed(evt);
            }
        });
        add(btnAll_SVal0);
        btnAll_SVal0.setBounds(220, 780, 40, 25);

        btnAll_SVal1.setText("1");
        btnAll_SVal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAll_SVal1ActionPerformed(evt);
            }
        });
        add(btnAll_SVal1);
        btnAll_SVal1.setBounds(260, 780, 40, 25);

        chkLoopCycle.setText("<html>Опрашивать текущие значения<br>периодически</html>");
        chkLoopCycle.setEnabled(false);
        chkLoopCycle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chkLoopCycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLoopCycleActionPerformed(evt);
            }
        });
        add(chkLoopCycle);
        chkLoopCycle.setBounds(10, 816, 290, 50);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><u>Стартовые</u></html>");
        add(jLabel1);
        jLabel1.setBounds(190, 100, 110, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html><u>Текущие</u></html>");
        add(jLabel2);
        jLabel2.setBounds(80, 100, 110, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAll_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAll_allActionPerformed
        chkTU01.setSelected( true);
        chkTU02.setSelected( true);
        chkTU03.setSelected( true);
        chkTU04.setSelected( true);
        chkTU05.setSelected( true);
        
        chkTU06.setSelected( true);
        chkTU07.setSelected( true);
        chkTU08.setSelected( true);
        chkTU09.setSelected( true);
        chkTU10.setSelected( true);
        
        chkTU11.setSelected( true);
        chkTU12.setSelected( true);
        chkTU13.setSelected( true);
        chkTU14.setSelected( true);
        chkTU15.setSelected( true);
        
        chkTU16.setSelected( true);
        chkTU17.setSelected( true);
        chkTU18.setSelected( true);
        chkTU19.setSelected( true);
        chkTU20.setSelected( true);
        
    }//GEN-LAST:event_btnAll_allActionPerformed

    private void btnAll_noneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAll_noneActionPerformed
        chkTU01.setSelected( false);
        chkTU02.setSelected( false);
        chkTU03.setSelected( false);
        chkTU04.setSelected( false);
        chkTU05.setSelected( false);
        
        chkTU06.setSelected( false);
        chkTU07.setSelected( false);
        chkTU08.setSelected( false);
        chkTU09.setSelected( false);
        chkTU10.setSelected( false);
        
        chkTU11.setSelected( false);
        chkTU12.setSelected( false);
        chkTU13.setSelected( false);
        chkTU14.setSelected( false);
        chkTU15.setSelected( false);
        
        chkTU16.setSelected( false);
        chkTU17.setSelected( false);
        chkTU18.setSelected( false);
        chkTU19.setSelected( false);
        chkTU20.setSelected( false);
    }//GEN-LAST:event_btnAll_noneActionPerformed

    private void btnConfigureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigureActionPerformed
        if( edtGPOAddressValue.isEnabled()) {
            //мы отредактировали - надо сохранить и закрыть контролы
            edtGPOAddressValue.setEnabled( false);
            chkCSvalue.setEnabled( false);
        }
        else {
            //мы хотим отредактировать - надо открыть контролы
            edtGPOAddressValue.setEnabled( true);
            chkCSvalue.setEnabled( true);
        }
    }//GEN-LAST:event_btnConfigureActionPerformed

    private void btnRefreshStartupValuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshStartupValuesActionPerformed
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevGPO().cmdGetStartUpValues(), theApp.GetDevGPO());
    }//GEN-LAST:event_btnRefreshStartupValuesActionPerformed

    private void chkLoopCycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLoopCycleActionPerformed
        if( chkLoopCycle.isSelected())
            tPolling.start();
        else
            tPolling.stop();
    }//GEN-LAST:event_chkLoopCycleActionPerformed

    private void btnAll_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAll_CVal0ActionPerformed
        JCheckBox chks[] = { chkTU01, chkTU02, chkTU03, chkTU04, chkTU05,
                             chkTU06, chkTU07, chkTU08, chkTU09, chkTU10,
                             chkTU11, chkTU12, chkTU13, chkTU14, chkTU15,
                             chkTU16, chkTU17, chkTU18, chkTU19, chkTU20 };
        
        int nMask = 0;
        for( int i=0; i<20; i++) {
            if( chks[i].isSelected())
                nMask += 1 << i;
        }
        
        theApp.GetRxTx().AddCommandToQueue(
                theApp.GetDevGPO().cmdSetCurrentValue( nMask, 0),
                                            theApp.GetDevGPO());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevGPO().cmdGetCurrentValues(), theApp.GetDevGPO());
    }//GEN-LAST:event_btnAll_CVal0ActionPerformed

    private void btnAll_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAll_SVal0ActionPerformed
        JCheckBox chks[] = { chkTU01, chkTU02, chkTU03, chkTU04, chkTU05,
                             chkTU06, chkTU07, chkTU08, chkTU09, chkTU10,
                             chkTU11, chkTU12, chkTU13, chkTU14, chkTU15,
                             chkTU16, chkTU17, chkTU18, chkTU19, chkTU20 };
        
        int nMask = 0;
        for( int i=0; i<20; i++) {
            if( chks[i].isSelected())
                nMask += 1 << i;
        }
        
        theApp.GetRxTx().AddCommandToQueue(
                theApp.GetDevGPO().cmdSetStartUpValue( nMask, 0),
                                            theApp.GetDevGPO());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevGPO().cmdGetStartUpValues(), theApp.GetDevGPO());
    }//GEN-LAST:event_btnAll_SVal0ActionPerformed

    private void btnRefreshCurrentValuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshCurrentValuesActionPerformed
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevGPO().cmdGetCurrentValues(), theApp.GetDevGPO());
    }//GEN-LAST:event_btnRefreshCurrentValuesActionPerformed

    private void SetCBit( int nBit) {
        theApp.GetRxTx().AddCommandToQueue(
                theApp.GetDevGPO().cmdSetCurrentValue_chan( nBit, 1),
                                            theApp.GetDevGPO());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevGPO().cmdGetCurrentValues(), theApp.GetDevGPO());
    }
    
    private void ClearCBit( int nBit) {
        theApp.GetRxTx().AddCommandToQueue(
                theApp.GetDevGPO().cmdSetCurrentValue_chan( nBit, 0),
                                            theApp.GetDevGPO());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevGPO().cmdGetCurrentValues(), theApp.GetDevGPO());
    }
    
    private void btnTU01_СVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU01_СVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU01);
    }//GEN-LAST:event_btnTU01_СVal0ActionPerformed

    private void btnTU01_СVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU01_СVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU01);
    }//GEN-LAST:event_btnTU01_СVal1ActionPerformed

    private void btnTU02_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU02_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU02);
    }//GEN-LAST:event_btnTU02_CVal0ActionPerformed

    private void btnTU02_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU02_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU02);
    }//GEN-LAST:event_btnTU02_CVal1ActionPerformed

    private void btnTU03_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU03_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU03);
    }//GEN-LAST:event_btnTU03_CVal0ActionPerformed

    private void btnTU03_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU03_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU03);
    }//GEN-LAST:event_btnTU03_CVal1ActionPerformed

    private void btnTU04_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU04_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU04);
    }//GEN-LAST:event_btnTU04_CVal0ActionPerformed

    private void btnTU04_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU04_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU04);
    }//GEN-LAST:event_btnTU04_CVal1ActionPerformed

    private void btnTU05_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU05_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU05);
    }//GEN-LAST:event_btnTU05_CVal0ActionPerformed

    private void btnTU05_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU05_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU05);
    }//GEN-LAST:event_btnTU05_CVal1ActionPerformed

    private void btnTU06_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU06_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU06);
    }//GEN-LAST:event_btnTU06_CVal0ActionPerformed

    private void btnTU06_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU06_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU06);
    }//GEN-LAST:event_btnTU06_CVal1ActionPerformed

    private void btnTU07_СVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU07_СVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU07);
    }//GEN-LAST:event_btnTU07_СVal0ActionPerformed

    private void btnTU07_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU07_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU07);
    }//GEN-LAST:event_btnTU07_CVal1ActionPerformed

    private void btnTU08_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU08_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU08);
    }//GEN-LAST:event_btnTU08_CVal0ActionPerformed

    private void btnTU08_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU08_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU08);
    }//GEN-LAST:event_btnTU08_CVal1ActionPerformed

    private void btnTU09_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU09_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU09);
    }//GEN-LAST:event_btnTU09_CVal0ActionPerformed

    private void btnTU09_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU09_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU09);
    }//GEN-LAST:event_btnTU09_CVal1ActionPerformed

    private void btnTU10_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU10_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU10);
    }//GEN-LAST:event_btnTU10_CVal0ActionPerformed

    private void btnTU10_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU10_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU10);
    }//GEN-LAST:event_btnTU10_CVal1ActionPerformed

    private void btnTU11_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU11_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU11);
    }//GEN-LAST:event_btnTU11_CVal0ActionPerformed

    private void btnTU11_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU11_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU11);
    }//GEN-LAST:event_btnTU11_CVal1ActionPerformed

    private void btnTU12_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU12_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU12);
    }//GEN-LAST:event_btnTU12_CVal0ActionPerformed

    private void btnTU12_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU12_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU12);
    }//GEN-LAST:event_btnTU12_CVal1ActionPerformed

    private void btnTU13_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU13_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU13);
    }//GEN-LAST:event_btnTU13_CVal0ActionPerformed

    private void btnTU13_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU13_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU13);
    }//GEN-LAST:event_btnTU13_CVal1ActionPerformed

    private void btnTU14_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU14_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU14);
    }//GEN-LAST:event_btnTU14_CVal0ActionPerformed

    private void btnTU14_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU14_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU14);
    }//GEN-LAST:event_btnTU14_CVal1ActionPerformed

    private void btnTU15_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU15_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU15);
    }//GEN-LAST:event_btnTU15_CVal0ActionPerformed

    private void btnTU15_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU15_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU15);
    }//GEN-LAST:event_btnTU15_CVal1ActionPerformed

    private void btnTU16_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU16_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU16);
    }//GEN-LAST:event_btnTU16_CVal0ActionPerformed

    private void btnTU16_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU16_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU16);
    }//GEN-LAST:event_btnTU16_CVal1ActionPerformed

    private void btnTU17_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU17_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU17);
    }//GEN-LAST:event_btnTU17_CVal0ActionPerformed

    private void btnTU17_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU17_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU17);
    }//GEN-LAST:event_btnTU17_CVal1ActionPerformed

    private void btnTU18_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU18_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU18);
    }//GEN-LAST:event_btnTU18_CVal0ActionPerformed

    private void btnTU18_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU18_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU18);
    }//GEN-LAST:event_btnTU18_CVal1ActionPerformed

    private void btnTU19_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU19_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU19);
    }//GEN-LAST:event_btnTU19_CVal0ActionPerformed

    private void btnTU19_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU19_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU19);
    }//GEN-LAST:event_btnTU19_CVal1ActionPerformed

    private void btnTU20_CVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU20_CVal0ActionPerformed
        ClearCBit( AlcorAdrConstants.CHANNEL_TU20);
    }//GEN-LAST:event_btnTU20_CVal0ActionPerformed

    private void btnTU20_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU20_CVal1ActionPerformed
        SetCBit( AlcorAdrConstants.CHANNEL_TU20);
    }//GEN-LAST:event_btnTU20_CVal1ActionPerformed

    private void btnAll_CVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAll_CVal1ActionPerformed
        JCheckBox chks[] = { chkTU01, chkTU02, chkTU03, chkTU04, chkTU05,
                             chkTU06, chkTU07, chkTU08, chkTU09, chkTU10,
                             chkTU11, chkTU12, chkTU13, chkTU14, chkTU15,
                             chkTU16, chkTU17, chkTU18, chkTU19, chkTU20 };
        
        int nMask = 0;
        for( int i=0; i<20; i++) {
            if( chks[i].isSelected())
                nMask += 1 << i;
        }
        
        theApp.GetRxTx().AddCommandToQueue(
                theApp.GetDevGPO().cmdSetCurrentValue( nMask, 1),
                                            theApp.GetDevGPO());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevGPO().cmdGetCurrentValues(), theApp.GetDevGPO());
    }//GEN-LAST:event_btnAll_CVal1ActionPerformed

    private void SetSBit( int nBit) {
        theApp.GetRxTx().AddCommandToQueue(
                theApp.GetDevGPO().cmdSetStartUpValue_chan( nBit, 1),
                                            theApp.GetDevGPO());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevGPO().cmdGetCurrentValues(), theApp.GetDevGPO());
    }
    
    private void ClearSBit( int nBit) {
        theApp.GetRxTx().AddCommandToQueue(
                theApp.GetDevGPO().cmdSetStartUpValue_chan( nBit, 0),
                                            theApp.GetDevGPO());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevGPO().cmdGetCurrentValues(), theApp.GetDevGPO());
    }
    
    private void btnTU01_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU01_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU01);
    }//GEN-LAST:event_btnTU01_SVal0ActionPerformed

    private void btnTU01_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU01_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU01);
    }//GEN-LAST:event_btnTU01_SVal1ActionPerformed

    private void btnTU02_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU02_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU02);
    }//GEN-LAST:event_btnTU02_SVal0ActionPerformed

    private void btnTU02_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU02_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU02);
    }//GEN-LAST:event_btnTU02_SVal1ActionPerformed

    private void btnTU03_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU03_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU03);
    }//GEN-LAST:event_btnTU03_SVal0ActionPerformed

    private void btnTU03_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU03_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU03);
    }//GEN-LAST:event_btnTU03_SVal1ActionPerformed

    private void btnTU04_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU04_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU04);
    }//GEN-LAST:event_btnTU04_SVal0ActionPerformed

    private void btnTU04_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU04_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU04);
    }//GEN-LAST:event_btnTU04_SVal1ActionPerformed

    private void btnTU05_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU05_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU05);
    }//GEN-LAST:event_btnTU05_SVal0ActionPerformed

    private void btnTU05_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU05_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU05);
    }//GEN-LAST:event_btnTU05_SVal1ActionPerformed

    private void btnTU06_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU06_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU06);
    }//GEN-LAST:event_btnTU06_SVal0ActionPerformed

    private void btnTU06_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU06_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU06);
    }//GEN-LAST:event_btnTU06_SVal1ActionPerformed

    private void btnTU07_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU07_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU07);
    }//GEN-LAST:event_btnTU07_SVal0ActionPerformed

    private void btnTU07_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU07_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU07);
    }//GEN-LAST:event_btnTU07_SVal1ActionPerformed

    private void btnTU08_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU08_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU08);
    }//GEN-LAST:event_btnTU08_SVal0ActionPerformed

    private void btnTU08_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU08_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU08);
    }//GEN-LAST:event_btnTU08_SVal1ActionPerformed

    private void btnTU09_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU09_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU09);
    }//GEN-LAST:event_btnTU09_SVal0ActionPerformed

    private void btnTU09_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU09_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU09);
    }//GEN-LAST:event_btnTU09_SVal1ActionPerformed

    private void btnTU10_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU10_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU10);
    }//GEN-LAST:event_btnTU10_SVal0ActionPerformed

    private void btnTU10_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU10_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU10);
    }//GEN-LAST:event_btnTU10_SVal1ActionPerformed

    private void btnTU11_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU11_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU11);
    }//GEN-LAST:event_btnTU11_SVal0ActionPerformed

    private void btnTU11_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU11_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU11);
    }//GEN-LAST:event_btnTU11_SVal1ActionPerformed

    private void btnTU12_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU12_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU12);
    }//GEN-LAST:event_btnTU12_SVal0ActionPerformed

    private void btnTU12_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU12_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU12);
    }//GEN-LAST:event_btnTU12_SVal1ActionPerformed

    private void btnTU13_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU13_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU13);
    }//GEN-LAST:event_btnTU13_SVal0ActionPerformed

    private void btnTU13_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU13_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU13);
    }//GEN-LAST:event_btnTU13_SVal1ActionPerformed

    private void btnTU14_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU14_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU14);
    }//GEN-LAST:event_btnTU14_SVal0ActionPerformed

    private void btnTU14_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU14_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU14);
    }//GEN-LAST:event_btnTU14_SVal1ActionPerformed

    private void btnTU15_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU15_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU15);
    }//GEN-LAST:event_btnTU15_SVal0ActionPerformed

    private void btnTU15_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU15_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU15);
    }//GEN-LAST:event_btnTU15_SVal1ActionPerformed

    private void btnTU16_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU16_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU16);
    }//GEN-LAST:event_btnTU16_SVal0ActionPerformed

    private void btnTU16_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU16_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU16);
    }//GEN-LAST:event_btnTU16_SVal1ActionPerformed

    private void btnTU17_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU17_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU17);
    }//GEN-LAST:event_btnTU17_SVal0ActionPerformed

    private void btnTU17_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU17_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU17);
    }//GEN-LAST:event_btnTU17_SVal1ActionPerformed

    private void btnTU18_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU18_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU18);
    }//GEN-LAST:event_btnTU18_SVal0ActionPerformed

    private void btnTU18_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU18_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU18);
    }//GEN-LAST:event_btnTU18_SVal1ActionPerformed

    private void btnTU19_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU19_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU19);
    }//GEN-LAST:event_btnTU19_SVal0ActionPerformed

    private void btnTU19_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU19_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU19);
    }//GEN-LAST:event_btnTU19_SVal1ActionPerformed

    private void btnTU20_SVal0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU20_SVal0ActionPerformed
        ClearSBit( AlcorAdrConstants.CHANNEL_TU20);
    }//GEN-LAST:event_btnTU20_SVal0ActionPerformed

    private void btnTU20_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTU20_SVal1ActionPerformed
        SetSBit( AlcorAdrConstants.CHANNEL_TU20);
    }//GEN-LAST:event_btnTU20_SVal1ActionPerformed

    private void btnAll_SVal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAll_SVal1ActionPerformed
        JCheckBox chks[] = { chkTU01, chkTU02, chkTU03, chkTU04, chkTU05,
                             chkTU06, chkTU07, chkTU08, chkTU09, chkTU10,
                             chkTU11, chkTU12, chkTU13, chkTU14, chkTU15,
                             chkTU16, chkTU17, chkTU18, chkTU19, chkTU20 };
        
        int nMask = 0;
        for( int i=0; i<20; i++) {
            if( chks[i].isSelected())
                nMask += 1 << i;
        }
        
        theApp.GetRxTx().AddCommandToQueue(
                theApp.GetDevGPO().cmdSetStartUpValue( nMask, 1),
                                            theApp.GetDevGPO());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevGPO().cmdGetStartUpValues(), theApp.GetDevGPO());
    }//GEN-LAST:event_btnAll_SVal1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAll_CVal0;
    private javax.swing.JButton btnAll_CVal1;
    private javax.swing.JButton btnAll_SVal0;
    private javax.swing.JButton btnAll_SVal1;
    private javax.swing.JButton btnAll_all;
    private javax.swing.JButton btnAll_none;
    private javax.swing.JButton btnConfigure;
    private javax.swing.JButton btnRefreshCurrentValues;
    private javax.swing.JButton btnRefreshStartupValues;
    private javax.swing.JButton btnTU01_SVal0;
    private javax.swing.JButton btnTU01_SVal1;
    private javax.swing.JButton btnTU01_СVal0;
    private javax.swing.JButton btnTU01_СVal1;
    private javax.swing.JButton btnTU02_CVal0;
    private javax.swing.JButton btnTU02_CVal1;
    private javax.swing.JButton btnTU02_SVal0;
    private javax.swing.JButton btnTU02_SVal1;
    private javax.swing.JButton btnTU03_CVal0;
    private javax.swing.JButton btnTU03_CVal1;
    private javax.swing.JButton btnTU03_SVal0;
    private javax.swing.JButton btnTU03_SVal1;
    private javax.swing.JButton btnTU04_CVal0;
    private javax.swing.JButton btnTU04_CVal1;
    private javax.swing.JButton btnTU04_SVal0;
    private javax.swing.JButton btnTU04_SVal1;
    private javax.swing.JButton btnTU05_CVal0;
    private javax.swing.JButton btnTU05_CVal1;
    private javax.swing.JButton btnTU05_SVal0;
    private javax.swing.JButton btnTU05_SVal1;
    private javax.swing.JButton btnTU06_CVal0;
    private javax.swing.JButton btnTU06_CVal1;
    private javax.swing.JButton btnTU06_SVal0;
    private javax.swing.JButton btnTU06_SVal1;
    private javax.swing.JButton btnTU07_CVal1;
    private javax.swing.JButton btnTU07_SVal0;
    private javax.swing.JButton btnTU07_SVal1;
    private javax.swing.JButton btnTU07_СVal0;
    private javax.swing.JButton btnTU08_CVal0;
    private javax.swing.JButton btnTU08_CVal1;
    private javax.swing.JButton btnTU08_SVal0;
    private javax.swing.JButton btnTU08_SVal1;
    private javax.swing.JButton btnTU09_CVal0;
    private javax.swing.JButton btnTU09_CVal1;
    private javax.swing.JButton btnTU09_SVal0;
    private javax.swing.JButton btnTU09_SVal1;
    private javax.swing.JButton btnTU10_CVal0;
    private javax.swing.JButton btnTU10_CVal1;
    private javax.swing.JButton btnTU10_SVal0;
    private javax.swing.JButton btnTU10_SVal1;
    private javax.swing.JButton btnTU11_CVal0;
    private javax.swing.JButton btnTU11_CVal1;
    private javax.swing.JButton btnTU11_SVal0;
    private javax.swing.JButton btnTU11_SVal1;
    private javax.swing.JButton btnTU12_CVal0;
    private javax.swing.JButton btnTU12_CVal1;
    private javax.swing.JButton btnTU12_SVal0;
    private javax.swing.JButton btnTU12_SVal1;
    private javax.swing.JButton btnTU13_CVal0;
    private javax.swing.JButton btnTU13_CVal1;
    private javax.swing.JButton btnTU13_SVal0;
    private javax.swing.JButton btnTU13_SVal1;
    private javax.swing.JButton btnTU14_CVal0;
    private javax.swing.JButton btnTU14_CVal1;
    private javax.swing.JButton btnTU14_SVal0;
    private javax.swing.JButton btnTU14_SVal1;
    private javax.swing.JButton btnTU15_CVal0;
    private javax.swing.JButton btnTU15_CVal1;
    private javax.swing.JButton btnTU15_SVal0;
    private javax.swing.JButton btnTU15_SVal1;
    private javax.swing.JButton btnTU16_CVal0;
    private javax.swing.JButton btnTU16_CVal1;
    private javax.swing.JButton btnTU16_SVal0;
    private javax.swing.JButton btnTU16_SVal1;
    private javax.swing.JButton btnTU17_CVal0;
    private javax.swing.JButton btnTU17_CVal1;
    private javax.swing.JButton btnTU17_SVal0;
    private javax.swing.JButton btnTU17_SVal1;
    private javax.swing.JButton btnTU18_CVal0;
    private javax.swing.JButton btnTU18_CVal1;
    private javax.swing.JButton btnTU18_SVal0;
    private javax.swing.JButton btnTU18_SVal1;
    private javax.swing.JButton btnTU19_CVal0;
    private javax.swing.JButton btnTU19_CVal1;
    private javax.swing.JButton btnTU19_SVal0;
    private javax.swing.JButton btnTU19_SVal1;
    private javax.swing.JButton btnTU20_CVal0;
    private javax.swing.JButton btnTU20_CVal1;
    private javax.swing.JButton btnTU20_SVal0;
    private javax.swing.JButton btnTU20_SVal1;
    private javax.swing.JCheckBox chkCSvalue;
    private javax.swing.JCheckBox chkLoopCycle;
    private javax.swing.JCheckBox chkTU01;
    private javax.swing.JCheckBox chkTU02;
    private javax.swing.JCheckBox chkTU03;
    private javax.swing.JCheckBox chkTU04;
    private javax.swing.JCheckBox chkTU05;
    private javax.swing.JCheckBox chkTU06;
    private javax.swing.JCheckBox chkTU07;
    private javax.swing.JCheckBox chkTU08;
    private javax.swing.JCheckBox chkTU09;
    private javax.swing.JCheckBox chkTU10;
    private javax.swing.JCheckBox chkTU11;
    private javax.swing.JCheckBox chkTU12;
    private javax.swing.JCheckBox chkTU13;
    private javax.swing.JCheckBox chkTU14;
    private javax.swing.JCheckBox chkTU15;
    private javax.swing.JCheckBox chkTU16;
    private javax.swing.JCheckBox chkTU17;
    private javax.swing.JCheckBox chkTU18;
    private javax.swing.JCheckBox chkTU19;
    private javax.swing.JCheckBox chkTU20;
    private javax.swing.JTextField edtGPOAddressValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCSTitle;
    private javax.swing.JLabel lblGPOAddrTitle;
    private javax.swing.JLabel lblTU01_SValue;
    private javax.swing.JLabel lblTU01_СValue;
    private javax.swing.JLabel lblTU02_CValue;
    private javax.swing.JLabel lblTU02_SValue;
    private javax.swing.JLabel lblTU03_CValue;
    private javax.swing.JLabel lblTU03_SValue;
    private javax.swing.JLabel lblTU04_CValue;
    private javax.swing.JLabel lblTU04_SValue;
    private javax.swing.JLabel lblTU05_CValue;
    private javax.swing.JLabel lblTU05_SValue;
    private javax.swing.JLabel lblTU06_CValue;
    private javax.swing.JLabel lblTU06_SValue;
    private javax.swing.JLabel lblTU07_CValue;
    private javax.swing.JLabel lblTU07_SValue;
    private javax.swing.JLabel lblTU08_CValue;
    private javax.swing.JLabel lblTU08_SValue;
    private javax.swing.JLabel lblTU09_CValue;
    private javax.swing.JLabel lblTU09_SValue;
    private javax.swing.JLabel lblTU10_CValue;
    private javax.swing.JLabel lblTU10_SValue;
    private javax.swing.JLabel lblTU11_CValue;
    private javax.swing.JLabel lblTU11_SValue;
    private javax.swing.JLabel lblTU12_CValue;
    private javax.swing.JLabel lblTU12_SValue;
    private javax.swing.JLabel lblTU13_CValue;
    private javax.swing.JLabel lblTU13_SValue;
    private javax.swing.JLabel lblTU14_CValue;
    private javax.swing.JLabel lblTU14_SValue;
    private javax.swing.JLabel lblTU15_CValue;
    private javax.swing.JLabel lblTU15_SValue;
    private javax.swing.JLabel lblTU16_CValue;
    private javax.swing.JLabel lblTU16_SValue;
    private javax.swing.JLabel lblTU17_CValue;
    private javax.swing.JLabel lblTU17_SValue;
    private javax.swing.JLabel lblTU18_CValue;
    private javax.swing.JLabel lblTU18_SValue;
    private javax.swing.JLabel lblTU19_CValue;
    private javax.swing.JLabel lblTU19_SValue;
    private javax.swing.JLabel lblTU20_CValue;
    private javax.swing.JLabel lblTU20_SValue;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}

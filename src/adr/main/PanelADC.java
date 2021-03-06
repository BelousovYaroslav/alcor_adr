/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adr.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class PanelADC extends javax.swing.JPanel {

    static Logger logger = Logger.getLogger( PanelADC.class);
    
    final private AlcorAdrApp theApp;
    final public Timer tRefreshStates;
    final public Timer tRefreshValues;
    final public Timer tPolling;
    
    private Double m_dblCoefficient;
    
    /**
     * Creates new form PanelGPI
     */
    public PanelADC( AlcorAdrApp app) {
        initComponents();
        theApp = app;
        
        m_dblCoefficient = 1.0;
                
        tRefreshStates = new Timer( 100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnRefresh.setEnabled(   theApp.GetDevADC().isInitialized());
                btnConfigure.setEnabled( theApp.GetDevADC().isInitialized());
                chkLoopCycle.setEnabled( theApp.GetDevADC().isInitialized());
            }
        });
        
        tRefreshStates.start();
        
        tRefreshValues = new Timer( 100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if( !edtADCAddressValue.isEnabled())
                    if( theApp.GetDevADC().GetAddress() != null)
                        edtADCAddressValue.setText( "0x00" + theApp.GetDevADC().GetAddress());
                    else
                        edtADCAddressValue.setText( "NULL");
                
                lblValueTI01.setText( String.format( "%.03f", theApp.GetDevADC().getValue( AlcorAdrConstants.CHANNEL_AI01)));
                lblValueTI02.setText( String.format( "%.03f", theApp.GetDevADC().getValue( AlcorAdrConstants.CHANNEL_AI02)));
                lblValueTI03.setText( String.format( "%.03f", theApp.GetDevADC().getValue( AlcorAdrConstants.CHANNEL_AI03)));
                lblValueTI04.setText( String.format( "%.03f", theApp.GetDevADC().getValue( AlcorAdrConstants.CHANNEL_AI04)));
                lblValueTI05.setText( String.format( "%.03f", theApp.GetDevADC().getValue( AlcorAdrConstants.CHANNEL_AI05)));
                lblValueTI06.setText( String.format( "%.03f", theApp.GetDevADC().getValue( AlcorAdrConstants.CHANNEL_AI06)));
                lblValueTI07.setText( String.format( "%.03f", theApp.GetDevADC().getValue( AlcorAdrConstants.CHANNEL_AI07)));
                lblValueTI08.setText( String.format( "%.03f", theApp.GetDevADC().getValue( AlcorAdrConstants.CHANNEL_AI08)));
                lblValueTI09.setText( String.format( "%.03f", theApp.GetDevADC().getValue( AlcorAdrConstants.CHANNEL_AI09)));
                lblValueTI10.setText( String.format( "%.03f", theApp.GetDevADC().getValue( AlcorAdrConstants.CHANNEL_AI10)));
                lblValueTI11.setText( String.format( "%.03f", theApp.GetDevADC().getValue( AlcorAdrConstants.CHANNEL_AI11)));
                lblValueTI12.setText( String.format( "%.03f", theApp.GetDevADC().getValue( AlcorAdrConstants.CHANNEL_AI12)));
                
                lblCoeff.setText( String.format( "%.03f", m_dblCoefficient));
            }
        });
        
        tRefreshValues.start();
        
        tPolling = new Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if( theApp.GetConnectionState() == AlcorAdrConstants.CONNECT_CONNECTED)
                    theApp.GetRxTx().AddCommandToQueue( theApp.GetDevADC().cmdGetAllChannelsValues(), theApp.GetDevADC());
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
        lblADCAddrTitle = new javax.swing.JLabel();
        edtADCAddressValue = new javax.swing.JTextField();
        lblCStitle = new javax.swing.JLabel();
        chkCSvalue = new javax.swing.JCheckBox();
        btnConfigure = new javax.swing.JButton();
        lblTitle_TI_01 = new javax.swing.JLabel();
        lblValueTI01 = new javax.swing.JLabel();
        lblTitle_TI_02 = new javax.swing.JLabel();
        lblValueTI02 = new javax.swing.JLabel();
        lblTitle_TI_03 = new javax.swing.JLabel();
        lblValueTI03 = new javax.swing.JLabel();
        lblTitle_TI_04 = new javax.swing.JLabel();
        lblValueTI04 = new javax.swing.JLabel();
        lblTitle_TI_05 = new javax.swing.JLabel();
        lblValueTI05 = new javax.swing.JLabel();
        lblTitle_TI_06 = new javax.swing.JLabel();
        lblValueTI06 = new javax.swing.JLabel();
        lblTitle_TI_07 = new javax.swing.JLabel();
        lblValueTI07 = new javax.swing.JLabel();
        lblTitle_TI_08 = new javax.swing.JLabel();
        lblValueTI08 = new javax.swing.JLabel();
        lblTitle_TI_09 = new javax.swing.JLabel();
        lblValueTI09 = new javax.swing.JLabel();
        lblTitle_TI_10 = new javax.swing.JLabel();
        lblValueTI10 = new javax.swing.JLabel();
        lblTitle_TI_11 = new javax.swing.JLabel();
        lblValueTI11 = new javax.swing.JLabel();
        lblTitle_TI_12 = new javax.swing.JLabel();
        lblValueTI12 = new javax.swing.JLabel();
        chkLoopCycle = new javax.swing.JCheckBox();
        btnRefresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        edtCoeff = new javax.swing.JTextField();
        lblCoeff = new javax.swing.JLabel();
        btnSetCoeff = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 220)));
        setMaximumSize(new java.awt.Dimension(250, 870));
        setMinimumSize(new java.awt.Dimension(250, 870));
        setPreferredSize(new java.awt.Dimension(250, 870));
        setLayout(null);

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("ADC - Аналоговые входы");
        add(lblTitle);
        lblTitle.setBounds(0, 0, 250, 20);

        lblADCAddrTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblADCAddrTitle.setText("Адрес");
        add(lblADCAddrTitle);
        lblADCAddrTitle.setBounds(10, 30, 60, 30);

        edtADCAddressValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtADCAddressValue.setText("-");
        edtADCAddressValue.setEnabled(false);
        add(edtADCAddressValue);
        edtADCAddressValue.setBounds(70, 30, 80, 30);

        lblCStitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCStitle.setText("CS");
        add(lblCStitle);
        lblCStitle.setBounds(150, 30, 50, 30);

        chkCSvalue.setEnabled(false);
        add(chkCSvalue);
        chkCSvalue.setBounds(200, 30, 30, 30);

        btnConfigure.setText("Настроить");
        btnConfigure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigureActionPerformed(evt);
            }
        });
        add(btnConfigure);
        btnConfigure.setBounds(20, 60, 210, 40);

        lblTitle_TI_01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle_TI_01.setText("TI01");
        add(lblTitle_TI_01);
        lblTitle_TI_01.setBounds(50, 110, 50, 25);

        lblValueTI01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueTI01.setText("-");
        lblValueTI01.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblValueTI01);
        lblValueTI01.setBounds(110, 110, 80, 25);

        lblTitle_TI_02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle_TI_02.setText("TI02");
        add(lblTitle_TI_02);
        lblTitle_TI_02.setBounds(50, 140, 50, 25);

        lblValueTI02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueTI02.setText("-");
        lblValueTI02.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblValueTI02);
        lblValueTI02.setBounds(110, 140, 80, 25);

        lblTitle_TI_03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle_TI_03.setText("TI03");
        add(lblTitle_TI_03);
        lblTitle_TI_03.setBounds(50, 170, 50, 25);

        lblValueTI03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueTI03.setText("-");
        lblValueTI03.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblValueTI03);
        lblValueTI03.setBounds(110, 170, 80, 25);

        lblTitle_TI_04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle_TI_04.setText("TI04");
        add(lblTitle_TI_04);
        lblTitle_TI_04.setBounds(50, 200, 50, 25);

        lblValueTI04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueTI04.setText("-");
        lblValueTI04.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblValueTI04);
        lblValueTI04.setBounds(110, 200, 80, 25);

        lblTitle_TI_05.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle_TI_05.setText("TI05");
        add(lblTitle_TI_05);
        lblTitle_TI_05.setBounds(50, 230, 50, 25);

        lblValueTI05.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueTI05.setText("-");
        lblValueTI05.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblValueTI05);
        lblValueTI05.setBounds(110, 230, 80, 25);

        lblTitle_TI_06.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle_TI_06.setText("TI06");
        add(lblTitle_TI_06);
        lblTitle_TI_06.setBounds(50, 260, 50, 25);

        lblValueTI06.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueTI06.setText("-");
        lblValueTI06.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblValueTI06);
        lblValueTI06.setBounds(110, 260, 80, 25);

        lblTitle_TI_07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle_TI_07.setText("TI07");
        add(lblTitle_TI_07);
        lblTitle_TI_07.setBounds(50, 290, 50, 25);

        lblValueTI07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueTI07.setText("-");
        lblValueTI07.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblValueTI07);
        lblValueTI07.setBounds(110, 290, 80, 25);

        lblTitle_TI_08.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle_TI_08.setText("TI08");
        add(lblTitle_TI_08);
        lblTitle_TI_08.setBounds(50, 320, 50, 25);

        lblValueTI08.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueTI08.setText("-");
        lblValueTI08.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblValueTI08);
        lblValueTI08.setBounds(110, 320, 80, 25);

        lblTitle_TI_09.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle_TI_09.setText("TI09");
        add(lblTitle_TI_09);
        lblTitle_TI_09.setBounds(50, 350, 50, 25);

        lblValueTI09.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueTI09.setText("-");
        lblValueTI09.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblValueTI09);
        lblValueTI09.setBounds(110, 350, 80, 25);

        lblTitle_TI_10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle_TI_10.setText("TI10");
        add(lblTitle_TI_10);
        lblTitle_TI_10.setBounds(50, 380, 50, 25);

        lblValueTI10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueTI10.setText("-");
        lblValueTI10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblValueTI10);
        lblValueTI10.setBounds(110, 380, 80, 25);

        lblTitle_TI_11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle_TI_11.setText("TI11");
        add(lblTitle_TI_11);
        lblTitle_TI_11.setBounds(50, 410, 50, 25);

        lblValueTI11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueTI11.setText("-");
        lblValueTI11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblValueTI11);
        lblValueTI11.setBounds(110, 410, 80, 25);

        lblTitle_TI_12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle_TI_12.setText("TI12");
        add(lblTitle_TI_12);
        lblTitle_TI_12.setBounds(50, 440, 50, 25);

        lblValueTI12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueTI12.setText("-");
        lblValueTI12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblValueTI12);
        lblValueTI12.setBounds(110, 440, 80, 25);

        chkLoopCycle.setText("Опрашивать периодически");
        chkLoopCycle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chkLoopCycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLoopCycleActionPerformed(evt);
            }
        });
        add(chkLoopCycle);
        chkLoopCycle.setBounds(20, 790, 210, 30);

        btnRefresh.setText("Обновить");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh);
        btnRefresh.setBounds(20, 820, 210, 40);

        jLabel1.setText("Коэффициент:");
        add(jLabel1);
        jLabel1.setBounds(10, 730, 230, 20);

        edtCoeff.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtCoeff.setText("1.0");
        add(edtCoeff);
        edtCoeff.setBounds(100, 760, 70, 30);

        lblCoeff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCoeff.setText("-");
        add(lblCoeff);
        lblCoeff.setBounds(10, 760, 90, 30);

        btnSetCoeff.setText("SET");
        btnSetCoeff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetCoeffActionPerformed(evt);
            }
        });
        add(btnSetCoeff);
        btnSetCoeff.setBounds(180, 760, 60, 28);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfigureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigureActionPerformed
        if( edtADCAddressValue.isEnabled()) {
            //мы отредактировали - надо сохранить и закрыть контролы
            edtADCAddressValue.setEnabled( false);
            chkCSvalue.setEnabled( false);
        }
        else {
            //мы хотим отредактировать - надо открыть контролы
            edtADCAddressValue.setEnabled( true);
            chkCSvalue.setEnabled( true);
        }
    }//GEN-LAST:event_btnConfigureActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevADC().cmdGetAllChannelsValues(), theApp.GetDevADC());
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void chkLoopCycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLoopCycleActionPerformed
        if( chkLoopCycle.isSelected())
            tPolling.start();
        else
            tPolling.stop();
    }//GEN-LAST:event_chkLoopCycleActionPerformed

    private void btnSetCoeffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetCoeffActionPerformed
        try {
            String strValue = edtCoeff.getText();
            strValue = strValue.replace( ',', '.');
            m_dblCoefficient = Double.parseDouble( strValue);
            edtCoeff.setBackground( null);
            theApp.GetRxTx().AddCommandToQueue( theApp.GetDevADC().cmdSetCalibA( m_dblCoefficient), theApp.GetDevADC());
        } catch( Exception ex) {
            logger.error( "On entering ADC-coefficient exception caught", ex);
            edtCoeff.setBackground(Color.red);
        }
    }//GEN-LAST:event_btnSetCoeffActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfigure;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSetCoeff;
    private javax.swing.JCheckBox chkCSvalue;
    private javax.swing.JCheckBox chkLoopCycle;
    private javax.swing.JTextField edtADCAddressValue;
    private javax.swing.JTextField edtCoeff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblADCAddrTitle;
    private javax.swing.JLabel lblCStitle;
    private javax.swing.JLabel lblCoeff;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle_TI_01;
    private javax.swing.JLabel lblTitle_TI_02;
    private javax.swing.JLabel lblTitle_TI_03;
    private javax.swing.JLabel lblTitle_TI_04;
    private javax.swing.JLabel lblTitle_TI_05;
    private javax.swing.JLabel lblTitle_TI_06;
    private javax.swing.JLabel lblTitle_TI_07;
    private javax.swing.JLabel lblTitle_TI_08;
    private javax.swing.JLabel lblTitle_TI_09;
    private javax.swing.JLabel lblTitle_TI_10;
    private javax.swing.JLabel lblTitle_TI_11;
    private javax.swing.JLabel lblTitle_TI_12;
    private javax.swing.JLabel lblValueTI01;
    private javax.swing.JLabel lblValueTI02;
    private javax.swing.JLabel lblValueTI03;
    private javax.swing.JLabel lblValueTI04;
    private javax.swing.JLabel lblValueTI05;
    private javax.swing.JLabel lblValueTI06;
    private javax.swing.JLabel lblValueTI07;
    private javax.swing.JLabel lblValueTI08;
    private javax.swing.JLabel lblValueTI09;
    private javax.swing.JLabel lblValueTI10;
    private javax.swing.JLabel lblValueTI11;
    private javax.swing.JLabel lblValueTI12;
    // End of variables declaration//GEN-END:variables
}

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
public class PanelDAC extends javax.swing.JPanel {

    final private AlcorAdrApp theApp;
    static Logger logger = Logger.getLogger( PanelDAC.class);
    
    final public Timer tRefreshStates;
    final public Timer tRefreshValues;
    final public Timer tPolling;
    private int m_nPollingChanel;
    
    Double m_dblCoefficientA, m_dblCoefficientB;
            
    /**
     * Creates new form PanelGPI
     */
    public PanelDAC( AlcorAdrApp app) {
        initComponents();
        theApp = app;
        
        m_dblCoefficientA = 1.;
        m_dblCoefficientB = 1.;
        
        m_nPollingChanel = AlcorAdrConstants.CHANNEL_DAC00;
        
        tRefreshStates = new Timer( 100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnRefresh.setEnabled(   theApp.GetDevDAC().isInitialized());
                btnConfigure.setEnabled( theApp.GetDevDAC().isInitialized());
                chkLoopCycle.setEnabled( theApp.GetDevDAC().isInitialized());
                
                btnCGet_AO01.setEnabled( theApp.GetDevDAC().isInitialized());
                btnCSet_AO01.setEnabled( theApp.GetDevDAC().isInitialized());
                btnCGet_AO02.setEnabled( theApp.GetDevDAC().isInitialized());
                btnCSet_AO02.setEnabled( theApp.GetDevDAC().isInitialized());
                btnCGet_AO03.setEnabled( theApp.GetDevDAC().isInitialized());
                btnCSet_AO03.setEnabled( theApp.GetDevDAC().isInitialized());
                btnCGet_AO04.setEnabled( theApp.GetDevDAC().isInitialized());
                btnCSet_AO04.setEnabled( theApp.GetDevDAC().isInitialized());
                
                btnSGet_AO01.setEnabled( theApp.GetDevDAC().isInitialized());
                btnSSet_AO01.setEnabled( theApp.GetDevDAC().isInitialized());
                btnSGet_AO02.setEnabled( theApp.GetDevDAC().isInitialized());
                btnSSet_AO02.setEnabled( theApp.GetDevDAC().isInitialized());
                btnSGet_AO03.setEnabled( theApp.GetDevDAC().isInitialized());
                btnSSet_AO03.setEnabled( theApp.GetDevDAC().isInitialized());
                btnSGet_AO04.setEnabled( theApp.GetDevDAC().isInitialized());
                btnSSet_AO04.setEnabled( theApp.GetDevDAC().isInitialized());
                
                edtCValue_AO01.setEnabled( theApp.GetDevDAC().isInitialized());
                edtCValue_AO02.setEnabled( theApp.GetDevDAC().isInitialized());
                edtCValue_AO03.setEnabled( theApp.GetDevDAC().isInitialized());
                edtCValue_AO04.setEnabled( theApp.GetDevDAC().isInitialized());
                
                edtSValue_AO01.setEnabled( theApp.GetDevDAC().isInitialized());
                edtSValue_AO02.setEnabled( theApp.GetDevDAC().isInitialized());
                edtSValue_AO03.setEnabled( theApp.GetDevDAC().isInitialized());
                edtSValue_AO04.setEnabled( theApp.GetDevDAC().isInitialized());
            }
        });
        
        tRefreshStates.start();
        
        tRefreshValues = new Timer( 100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if( !edtDACAddressValue.isEnabled())
                    if( theApp.GetDevDAC().GetAddress() != null)
                        edtDACAddressValue.setText( "0x00" + theApp.GetDevDAC().GetAddress());
                    else
                        edtDACAddressValue.setText( "NULL");
                
                if( !theApp.GetDevDAC().GetCDac0().isNaN())
                    lblCValueAO01.setText( String.format( "%.03f", theApp.GetDevDAC().GetCDac0()));
                else
                    lblCValueAO01.setText( "-");
                
                if( !theApp.GetDevDAC().GetCDac1().isNaN())
                    lblCValueAO02.setText( String.format( "%.03f", theApp.GetDevDAC().GetCDac1()));
                else
                    lblCValueAO02.setText( "-");
                
                if( !theApp.GetDevDAC().GetCDac2().isNaN())
                    lblCValueAO03.setText( String.format( "%.03f", theApp.GetDevDAC().GetCDac2()));
                else
                    lblCValueAO03.setText( "-");
                
                if( !theApp.GetDevDAC().GetCDac3().isNaN())
                    lblCValueAO04.setText( String.format( "%.03f", theApp.GetDevDAC().GetCDac3()));
                else
                    lblCValueAO04.setText( "-");
                
                if( !theApp.GetDevDAC().GetSDac0().isNaN())
                    lblSValueAO01.setText( String.format( "%.03f", theApp.GetDevDAC().GetSDac0()));
                else
                    lblSValueAO01.setText( "-");
                
                if( !theApp.GetDevDAC().GetSDac1().isNaN())
                    lblSValueAO02.setText( String.format( "%.03f", theApp.GetDevDAC().GetSDac1()));
                else
                    lblSValueAO02.setText( "-");
                
                if( !theApp.GetDevDAC().GetSDac2().isNaN())
                    lblSValueAO03.setText( String.format( "%.03f", theApp.GetDevDAC().GetSDac2()));
                else
                    lblSValueAO03.setText( "-");
                
                if( !theApp.GetDevDAC().GetSDac3().isNaN())
                    lblSValueAO04.setText( String.format( "%.03f", theApp.GetDevDAC().GetSDac3()));
                else
                    lblSValueAO04.setText( "-");
                
                lblCoeffATitle.setText( String.format( "%.03f", m_dblCoefficientA));
                lblCoeffBTitle.setText( String.format( "%.03f", m_dblCoefficientB));
            }
        });
        
        tRefreshValues.start();
        
        
        tPolling = new Timer( 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if( theApp.GetConnectionState() == AlcorAdrConstants.CONNECT_CONNECTED)
                    theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetCurrentValueForChannel( m_nPollingChanel), theApp.GetDevDAC());
                
                m_nPollingChanel++;
                if( m_nPollingChanel > AlcorAdrConstants.CHANNEL_DAC03)
                    m_nPollingChanel = AlcorAdrConstants.CHANNEL_DAC00;
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
        lblDACAddrTitle = new javax.swing.JLabel();
        edtDACAddressValue = new javax.swing.JTextField();
        lblCStitle = new javax.swing.JLabel();
        chkCSvalue = new javax.swing.JCheckBox();
        btnConfigure = new javax.swing.JButton();
        lblTitleCurrent = new javax.swing.JLabel();
        lblCTitle_AO01 = new javax.swing.JLabel();
        btnCGet_AO01 = new javax.swing.JButton();
        lblCValueAO01 = new javax.swing.JLabel();
        edtCValue_AO01 = new javax.swing.JTextField();
        btnCSet_AO01 = new javax.swing.JButton();
        lblCTitle_AO02 = new javax.swing.JLabel();
        btnCGet_AO02 = new javax.swing.JButton();
        lblCValueAO02 = new javax.swing.JLabel();
        edtCValue_AO02 = new javax.swing.JTextField();
        btnCSet_AO02 = new javax.swing.JButton();
        lblCTitle_AO03 = new javax.swing.JLabel();
        btnCGet_AO03 = new javax.swing.JButton();
        lblCValueAO03 = new javax.swing.JLabel();
        edtCValue_AO03 = new javax.swing.JTextField();
        btnCSet_AO03 = new javax.swing.JButton();
        lblCTitle_AO04 = new javax.swing.JLabel();
        btnCGet_AO04 = new javax.swing.JButton();
        lblCValueAO04 = new javax.swing.JLabel();
        edtCValue_AO04 = new javax.swing.JTextField();
        btnCSet_AO04 = new javax.swing.JButton();
        lblTitleStartup = new javax.swing.JLabel();
        lblSTitle_AO01 = new javax.swing.JLabel();
        btnSGet_AO01 = new javax.swing.JButton();
        lblSValueAO01 = new javax.swing.JLabel();
        edtSValue_AO01 = new javax.swing.JTextField();
        btnSSet_AO01 = new javax.swing.JButton();
        lblSTitle_AO02 = new javax.swing.JLabel();
        btnSGet_AO02 = new javax.swing.JButton();
        lblSValueAO02 = new javax.swing.JLabel();
        edtSValue_AO02 = new javax.swing.JTextField();
        btnSSet_AO02 = new javax.swing.JButton();
        lblSTitle_AO03 = new javax.swing.JLabel();
        btnSGet_AO03 = new javax.swing.JButton();
        lblSValueAO03 = new javax.swing.JLabel();
        edtSValue_AO03 = new javax.swing.JTextField();
        btnSSet_AO03 = new javax.swing.JButton();
        lblSTitle_AO04 = new javax.swing.JLabel();
        btnSGet_AO04 = new javax.swing.JButton();
        lblSValueAO04 = new javax.swing.JLabel();
        edtSValue_AO04 = new javax.swing.JTextField();
        btnSSet_AO04 = new javax.swing.JButton();
        lblCoeffATitle = new javax.swing.JLabel();
        lblCoeffAValue = new javax.swing.JLabel();
        edtCoeffAValue = new javax.swing.JTextField();
        btnSetCoeffA = new javax.swing.JButton();
        lblCoeffBTitle = new javax.swing.JLabel();
        lblCoeffBValue = new javax.swing.JLabel();
        edtCoeffBValue = new javax.swing.JTextField();
        btnSetCoeffB = new javax.swing.JButton();
        chkLoopCycle = new javax.swing.JCheckBox();
        btnRefresh = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 220)));
        setMaximumSize(new java.awt.Dimension(280, 870));
        setMinimumSize(new java.awt.Dimension(280, 870));
        setPreferredSize(new java.awt.Dimension(280, 870));
        setLayout(null);

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("DAC - Аналоговые выходы");
        add(lblTitle);
        lblTitle.setBounds(0, 0, 250, 20);

        lblDACAddrTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDACAddrTitle.setText("Адрес");
        add(lblDACAddrTitle);
        lblDACAddrTitle.setBounds(10, 30, 60, 30);

        edtDACAddressValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtDACAddressValue.setText("-");
        edtDACAddressValue.setEnabled(false);
        add(edtDACAddressValue);
        edtDACAddressValue.setBounds(70, 30, 80, 30);

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
        btnConfigure.setBounds(20, 60, 240, 40);

        lblTitleCurrent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleCurrent.setText("<html><u>Текущие значения</u></html>");
        add(lblTitleCurrent);
        lblTitleCurrent.setBounds(0, 110, 280, 20);

        lblCTitle_AO01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCTitle_AO01.setText("AO01");
        add(lblCTitle_AO01);
        lblCTitle_AO01.setBounds(0, 130, 280, 25);

        btnCGet_AO01.setText("GET");
        btnCGet_AO01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCGet_AO01ActionPerformed(evt);
            }
        });
        add(btnCGet_AO01);
        btnCGet_AO01.setBounds(10, 160, 60, 25);

        lblCValueAO01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCValueAO01.setText("-");
        lblCValueAO01.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblCValueAO01);
        lblCValueAO01.setBounds(70, 160, 60, 25);

        edtCValue_AO01.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtCValue_AO01.setEnabled(false);
        add(edtCValue_AO01);
        edtCValue_AO01.setBounds(140, 160, 70, 25);

        btnCSet_AO01.setText("SET");
        btnCSet_AO01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCSet_AO01ActionPerformed(evt);
            }
        });
        add(btnCSet_AO01);
        btnCSet_AO01.setBounds(210, 160, 60, 25);

        lblCTitle_AO02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCTitle_AO02.setText("AO02");
        add(lblCTitle_AO02);
        lblCTitle_AO02.setBounds(0, 190, 280, 25);

        btnCGet_AO02.setText("GET");
        btnCGet_AO02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCGet_AO02ActionPerformed(evt);
            }
        });
        add(btnCGet_AO02);
        btnCGet_AO02.setBounds(10, 220, 60, 25);

        lblCValueAO02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCValueAO02.setText("-");
        lblCValueAO02.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblCValueAO02);
        lblCValueAO02.setBounds(70, 220, 60, 25);

        edtCValue_AO02.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtCValue_AO02.setEnabled(false);
        add(edtCValue_AO02);
        edtCValue_AO02.setBounds(140, 220, 70, 25);

        btnCSet_AO02.setText("SET");
        btnCSet_AO02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCSet_AO02ActionPerformed(evt);
            }
        });
        add(btnCSet_AO02);
        btnCSet_AO02.setBounds(210, 220, 60, 25);

        lblCTitle_AO03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCTitle_AO03.setText("AO03");
        add(lblCTitle_AO03);
        lblCTitle_AO03.setBounds(0, 250, 280, 25);

        btnCGet_AO03.setText("GET");
        btnCGet_AO03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCGet_AO03ActionPerformed(evt);
            }
        });
        add(btnCGet_AO03);
        btnCGet_AO03.setBounds(10, 280, 60, 25);

        lblCValueAO03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCValueAO03.setText("-");
        lblCValueAO03.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblCValueAO03);
        lblCValueAO03.setBounds(70, 280, 60, 25);

        edtCValue_AO03.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtCValue_AO03.setEnabled(false);
        add(edtCValue_AO03);
        edtCValue_AO03.setBounds(140, 280, 70, 25);

        btnCSet_AO03.setText("SET");
        btnCSet_AO03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCSet_AO03ActionPerformed(evt);
            }
        });
        add(btnCSet_AO03);
        btnCSet_AO03.setBounds(210, 280, 60, 25);

        lblCTitle_AO04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCTitle_AO04.setText("AO04");
        add(lblCTitle_AO04);
        lblCTitle_AO04.setBounds(0, 310, 280, 25);

        btnCGet_AO04.setText("GET");
        btnCGet_AO04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCGet_AO04ActionPerformed(evt);
            }
        });
        add(btnCGet_AO04);
        btnCGet_AO04.setBounds(10, 340, 60, 25);

        lblCValueAO04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCValueAO04.setText("-");
        lblCValueAO04.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblCValueAO04);
        lblCValueAO04.setBounds(70, 340, 60, 25);

        edtCValue_AO04.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtCValue_AO04.setEnabled(false);
        add(edtCValue_AO04);
        edtCValue_AO04.setBounds(140, 340, 70, 25);

        btnCSet_AO04.setText("SET");
        btnCSet_AO04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCSet_AO04ActionPerformed(evt);
            }
        });
        add(btnCSet_AO04);
        btnCSet_AO04.setBounds(210, 340, 60, 25);

        lblTitleStartup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleStartup.setText("<html><u>Стартовые значения</u></html>");
        add(lblTitleStartup);
        lblTitleStartup.setBounds(0, 390, 280, 20);

        lblSTitle_AO01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSTitle_AO01.setText("AO01");
        add(lblSTitle_AO01);
        lblSTitle_AO01.setBounds(0, 410, 280, 25);

        btnSGet_AO01.setText("GET");
        btnSGet_AO01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSGet_AO01ActionPerformed(evt);
            }
        });
        add(btnSGet_AO01);
        btnSGet_AO01.setBounds(10, 440, 60, 25);

        lblSValueAO01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSValueAO01.setText("-");
        lblSValueAO01.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblSValueAO01);
        lblSValueAO01.setBounds(70, 440, 60, 25);

        edtSValue_AO01.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtSValue_AO01.setEnabled(false);
        add(edtSValue_AO01);
        edtSValue_AO01.setBounds(140, 440, 70, 25);

        btnSSet_AO01.setText("SET");
        btnSSet_AO01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSSet_AO01ActionPerformed(evt);
            }
        });
        add(btnSSet_AO01);
        btnSSet_AO01.setBounds(210, 440, 60, 25);

        lblSTitle_AO02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSTitle_AO02.setText("AO02");
        add(lblSTitle_AO02);
        lblSTitle_AO02.setBounds(10, 470, 260, 25);

        btnSGet_AO02.setText("GET");
        btnSGet_AO02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSGet_AO02ActionPerformed(evt);
            }
        });
        add(btnSGet_AO02);
        btnSGet_AO02.setBounds(10, 500, 60, 25);

        lblSValueAO02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSValueAO02.setText("-");
        lblSValueAO02.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblSValueAO02);
        lblSValueAO02.setBounds(70, 500, 60, 25);

        edtSValue_AO02.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtSValue_AO02.setEnabled(false);
        add(edtSValue_AO02);
        edtSValue_AO02.setBounds(140, 500, 70, 25);

        btnSSet_AO02.setText("SET");
        btnSSet_AO02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSSet_AO02ActionPerformed(evt);
            }
        });
        add(btnSSet_AO02);
        btnSSet_AO02.setBounds(210, 500, 60, 25);

        lblSTitle_AO03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSTitle_AO03.setText("AO03");
        add(lblSTitle_AO03);
        lblSTitle_AO03.setBounds(10, 530, 260, 25);

        btnSGet_AO03.setText("GET");
        btnSGet_AO03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSGet_AO03ActionPerformed(evt);
            }
        });
        add(btnSGet_AO03);
        btnSGet_AO03.setBounds(10, 560, 60, 25);

        lblSValueAO03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSValueAO03.setText("-");
        lblSValueAO03.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblSValueAO03);
        lblSValueAO03.setBounds(70, 560, 60, 25);

        edtSValue_AO03.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtSValue_AO03.setEnabled(false);
        add(edtSValue_AO03);
        edtSValue_AO03.setBounds(140, 560, 70, 25);

        btnSSet_AO03.setText("SET");
        btnSSet_AO03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSSet_AO03ActionPerformed(evt);
            }
        });
        add(btnSSet_AO03);
        btnSSet_AO03.setBounds(210, 560, 60, 25);

        lblSTitle_AO04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSTitle_AO04.setText("AO04");
        add(lblSTitle_AO04);
        lblSTitle_AO04.setBounds(10, 590, 260, 25);

        btnSGet_AO04.setText("GET");
        btnSGet_AO04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSGet_AO04ActionPerformed(evt);
            }
        });
        add(btnSGet_AO04);
        btnSGet_AO04.setBounds(10, 620, 60, 25);

        lblSValueAO04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSValueAO04.setText("-");
        lblSValueAO04.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        add(lblSValueAO04);
        lblSValueAO04.setBounds(70, 620, 60, 25);

        edtSValue_AO04.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtSValue_AO04.setEnabled(false);
        add(edtSValue_AO04);
        edtSValue_AO04.setBounds(140, 620, 70, 25);

        btnSSet_AO04.setText("SET");
        btnSSet_AO04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSSet_AO04ActionPerformed(evt);
            }
        });
        add(btnSSet_AO04);
        btnSSet_AO04.setBounds(210, 620, 60, 25);

        lblCoeffATitle.setText("Коэффициент A:");
        add(lblCoeffATitle);
        lblCoeffATitle.setBounds(30, 670, 230, 20);

        lblCoeffAValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCoeffAValue.setText("-");
        add(lblCoeffAValue);
        lblCoeffAValue.setBounds(30, 690, 90, 30);

        edtCoeffAValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtCoeffAValue.setText("1.0");
        add(edtCoeffAValue);
        edtCoeffAValue.setBounds(120, 690, 70, 30);

        btnSetCoeffA.setText("SET");
        btnSetCoeffA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetCoeffAActionPerformed(evt);
            }
        });
        add(btnSetCoeffA);
        btnSetCoeffA.setBounds(200, 690, 60, 28);

        lblCoeffBTitle.setText("Коэффициент B:");
        add(lblCoeffBTitle);
        lblCoeffBTitle.setBounds(30, 730, 230, 20);

        lblCoeffBValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCoeffBValue.setText("-");
        add(lblCoeffBValue);
        lblCoeffBValue.setBounds(30, 750, 90, 30);

        edtCoeffBValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtCoeffBValue.setText("1.0");
        add(edtCoeffBValue);
        edtCoeffBValue.setBounds(120, 750, 70, 30);

        btnSetCoeffB.setText("SET");
        btnSetCoeffB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetCoeffBActionPerformed(evt);
            }
        });
        add(btnSetCoeffB);
        btnSetCoeffB.setBounds(200, 750, 60, 28);

        chkLoopCycle.setText("Опрашивать периодически");
        chkLoopCycle.setEnabled(false);
        chkLoopCycle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chkLoopCycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLoopCycleActionPerformed(evt);
            }
        });
        add(chkLoopCycle);
        chkLoopCycle.setBounds(20, 790, 240, 30);

        btnRefresh.setText("Обновить");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh);
        btnRefresh.setBounds(20, 820, 240, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCSet_AO01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCSet_AO01ActionPerformed
        String strValueToSet = edtCValue_AO01.getText();
        strValueToSet = strValueToSet.replace( ',', '.');
        Double dblValueToSet;
        try {
            dblValueToSet = Double.parseDouble( strValueToSet);
        } catch( Exception ex) {
            edtCValue_AO01.setBackground( Color.red);
            logger.error( "При разборе введённого значения для выставки на канал DAC00 (текущее), произошёл Exception", ex);
            return;
        }
        
        edtCValue_AO01.setBackground( null);
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdSetCurrentValueForChannel( AlcorAdrConstants.CHANNEL_DAC00, dblValueToSet),
                theApp.GetDevDAC());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetCurrentValueForChannel( AlcorAdrConstants.CHANNEL_DAC00),
                theApp.GetDevDAC());
    }//GEN-LAST:event_btnCSet_AO01ActionPerformed

    private void btnConfigureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigureActionPerformed
        if( edtDACAddressValue.isEnabled()) {
            //мы отредактировали - надо сохранить и закрыть контролы
            edtDACAddressValue.setEnabled( false);
            chkCSvalue.setEnabled( false);
        }
        else {
            //мы хотим отредактировать - надо открыть контролы
            edtDACAddressValue.setEnabled( true);
            chkCSvalue.setEnabled( true);
        }
    }//GEN-LAST:event_btnConfigureActionPerformed

    private void btnCSet_AO02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCSet_AO02ActionPerformed
        String strValueToSet = edtCValue_AO02.getText();
        strValueToSet = strValueToSet.replace( ',', '.');
        Double dblValueToSet;
        try {
            dblValueToSet = Double.parseDouble( strValueToSet);
        } catch( Exception ex) {
            edtCValue_AO02.setBackground( Color.red);
            logger.error( "При разборе введённого значения для выставки на канал DAC01 (текущее), произошёл Exception", ex);
            return;
        }
        
        edtCValue_AO02.setBackground( null);
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdSetCurrentValueForChannel( AlcorAdrConstants.CHANNEL_DAC01, dblValueToSet),
                theApp.GetDevDAC());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetCurrentValueForChannel( AlcorAdrConstants.CHANNEL_DAC01),
                theApp.GetDevDAC());
    }//GEN-LAST:event_btnCSet_AO02ActionPerformed

    private void btnCSet_AO03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCSet_AO03ActionPerformed
        String strValueToSet = edtCValue_AO03.getText();
        strValueToSet = strValueToSet.replace( ',', '.');
        Double dblValueToSet;
        try {
            dblValueToSet = Double.parseDouble( strValueToSet);
        } catch( Exception ex) {
            edtCValue_AO03.setBackground( Color.red);
            logger.error( "При разборе введённого значения для выставки на канал DAC02 (текущее), произошёл Exception", ex);
            return;
        }
        
        edtCValue_AO03.setBackground( null);
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdSetCurrentValueForChannel( AlcorAdrConstants.CHANNEL_DAC02, dblValueToSet),
                theApp.GetDevDAC());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetCurrentValueForChannel( AlcorAdrConstants.CHANNEL_DAC02),
                theApp.GetDevDAC());
    }//GEN-LAST:event_btnCSet_AO03ActionPerformed

    private void btnCSet_AO04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCSet_AO04ActionPerformed
        String strValueToSet = edtCValue_AO04.getText();
        strValueToSet = strValueToSet.replace( ',', '.');
        Double dblValueToSet;
        try {
            dblValueToSet = Double.parseDouble( strValueToSet);
        } catch( Exception ex) {
            edtCValue_AO04.setBackground( Color.red);
            logger.error( "При разборе введённого значения для выставки на канал DAC03 (текущее), произошёл Exception", ex);
            return;
        }
        
        edtCValue_AO04.setBackground( null);
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdSetCurrentValueForChannel( AlcorAdrConstants.CHANNEL_DAC03, dblValueToSet),
                theApp.GetDevDAC());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetCurrentValueForChannel( AlcorAdrConstants.CHANNEL_DAC03),
                theApp.GetDevDAC());
    }//GEN-LAST:event_btnCSet_AO04ActionPerformed

    private void btnSSet_AO01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSSet_AO01ActionPerformed
        String strValueToSet = edtSValue_AO01.getText();
        strValueToSet = strValueToSet.replace( ',', '.');
        Double dblValueToSet;
        try {
            dblValueToSet = Double.parseDouble( strValueToSet);
        } catch( Exception ex) {
            edtSValue_AO01.setBackground( Color.red);
            logger.error( "При разборе введённого значения для выставки на канал DAC00 (стартовое), произошёл Exception", ex);
            return;
        }
        
        edtSValue_AO01.setBackground( null);
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdSetStartupValueForChannel( AlcorAdrConstants.CHANNEL_DAC00, dblValueToSet),
                theApp.GetDevDAC());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetStartupValueForChannel( AlcorAdrConstants.CHANNEL_DAC00),
                theApp.GetDevDAC());
    }//GEN-LAST:event_btnSSet_AO01ActionPerformed

    private void btnSSet_AO02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSSet_AO02ActionPerformed
        String strValueToSet = edtSValue_AO02.getText();
        strValueToSet = strValueToSet.replace( ',', '.');
        Double dblValueToSet;
        try {
            dblValueToSet = Double.parseDouble( strValueToSet);
        } catch( Exception ex) {
            edtSValue_AO02.setBackground( Color.red);
            logger.error( "При разборе введённого значения для выставки на канал DAC01 (стартовое), произошёл Exception", ex);
            return;
        }
        
        edtSValue_AO02.setBackground( null);
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdSetStartupValueForChannel( AlcorAdrConstants.CHANNEL_DAC01, dblValueToSet),
                theApp.GetDevDAC());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetStartupValueForChannel( AlcorAdrConstants.CHANNEL_DAC01),
                theApp.GetDevDAC());
    }//GEN-LAST:event_btnSSet_AO02ActionPerformed

    private void btnSSet_AO03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSSet_AO03ActionPerformed
        String strValueToSet = edtSValue_AO03.getText();
        strValueToSet = strValueToSet.replace( ',', '.');
        Double dblValueToSet;
        try {
            dblValueToSet = Double.parseDouble( strValueToSet);
        } catch( Exception ex) {
            edtSValue_AO03.setBackground( Color.red);
            logger.error( "При разборе введённого значения для выставки на канал DAC02 (стартовое), произошёл Exception", ex);
            return;
        }
        
        edtSValue_AO03.setBackground( null);
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdSetStartupValueForChannel( AlcorAdrConstants.CHANNEL_DAC02, dblValueToSet),
                theApp.GetDevDAC());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetStartupValueForChannel( AlcorAdrConstants.CHANNEL_DAC02),
                theApp.GetDevDAC());
    }//GEN-LAST:event_btnSSet_AO03ActionPerformed

    private void btnSSet_AO04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSSet_AO04ActionPerformed
        String strValueToSet = edtSValue_AO04.getText();
        strValueToSet = strValueToSet.replace( ',', '.');
        Double dblValueToSet;
        try {
            dblValueToSet = Double.parseDouble( strValueToSet);
        } catch( Exception ex) {
            edtSValue_AO04.setBackground( Color.red);
            logger.error( "При разборе введённого значения для выставки на канал DAC03 (стартовое), произошёл Exception", ex);
            return;
        }
        
        edtSValue_AO04.setBackground( null);
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdSetStartupValueForChannel( AlcorAdrConstants.CHANNEL_DAC03, dblValueToSet),
                theApp.GetDevDAC());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetStartupValueForChannel( AlcorAdrConstants.CHANNEL_DAC03),
                theApp.GetDevDAC());
    }//GEN-LAST:event_btnSSet_AO04ActionPerformed

    private void btnCGet_AO01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCGet_AO01ActionPerformed
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetCurrentValueForChannel( AlcorAdrConstants.CHANNEL_DAC00),
                theApp.GetDevDAC());
    }//GEN-LAST:event_btnCGet_AO01ActionPerformed

    private void btnCGet_AO02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCGet_AO02ActionPerformed
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetCurrentValueForChannel( AlcorAdrConstants.CHANNEL_DAC01),
                theApp.GetDevDAC());
    }//GEN-LAST:event_btnCGet_AO02ActionPerformed

    private void btnCGet_AO03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCGet_AO03ActionPerformed
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetCurrentValueForChannel( AlcorAdrConstants.CHANNEL_DAC02),
                theApp.GetDevDAC());
    }//GEN-LAST:event_btnCGet_AO03ActionPerformed

    private void btnCGet_AO04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCGet_AO04ActionPerformed
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetCurrentValueForChannel( AlcorAdrConstants.CHANNEL_DAC03),
                theApp.GetDevDAC());
    }//GEN-LAST:event_btnCGet_AO04ActionPerformed

    private void btnSGet_AO01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSGet_AO01ActionPerformed
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetStartupValueForChannel( AlcorAdrConstants.CHANNEL_DAC00),
                theApp.GetDevDAC());
    }//GEN-LAST:event_btnSGet_AO01ActionPerformed

    private void btnSGet_AO02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSGet_AO02ActionPerformed
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetStartupValueForChannel( AlcorAdrConstants.CHANNEL_DAC01),
                theApp.GetDevDAC());
    }//GEN-LAST:event_btnSGet_AO02ActionPerformed

    private void btnSGet_AO03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSGet_AO03ActionPerformed
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetStartupValueForChannel( AlcorAdrConstants.CHANNEL_DAC02),
                theApp.GetDevDAC());
    }//GEN-LAST:event_btnSGet_AO03ActionPerformed

    private void btnSGet_AO04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSGet_AO04ActionPerformed
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetStartupValueForChannel( AlcorAdrConstants.CHANNEL_DAC03),
                theApp.GetDevDAC());
    }//GEN-LAST:event_btnSGet_AO04ActionPerformed

    private void chkLoopCycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLoopCycleActionPerformed
        if( chkLoopCycle.isSelected())
            tPolling.start();
        else
            tPolling.stop();
    }//GEN-LAST:event_chkLoopCycleActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetCurrentValueForChannel( AlcorAdrConstants.CHANNEL_DAC00), theApp.GetDevDAC());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetCurrentValueForChannel( AlcorAdrConstants.CHANNEL_DAC01), theApp.GetDevDAC());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetCurrentValueForChannel( AlcorAdrConstants.CHANNEL_DAC02), theApp.GetDevDAC());
        theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdGetCurrentValueForChannel( AlcorAdrConstants.CHANNEL_DAC03), theApp.GetDevDAC());
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSetCoeffAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetCoeffAActionPerformed
        try {
            String strValue = edtCoeffAValue.getText();
            strValue = strValue.replace( ',', '.');
            m_dblCoefficientA = Double.parseDouble( strValue);
            edtCoeffAValue.setBackground( null);
            theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdSetCalibA( m_dblCoefficientA), theApp.GetDevDAC());
        } catch( Exception ex) {
            logger.error( "On entering DAC-coefficient-A exception caught", ex);
            edtCoeffAValue.setBackground(Color.red);
        }
    }//GEN-LAST:event_btnSetCoeffAActionPerformed

    private void btnSetCoeffBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetCoeffBActionPerformed
        try {
            String strValue = edtCoeffBValue.getText();
            strValue = strValue.replace( ',', '.');
            m_dblCoefficientB = Double.parseDouble( strValue);
            edtCoeffBValue.setBackground( null);
            theApp.GetRxTx().AddCommandToQueue( theApp.GetDevDAC().cmdSetCalibB( m_dblCoefficientB), theApp.GetDevDAC());
        } catch( Exception ex) {
            logger.error( "On entering DAC-coefficient-B exception caught", ex);
            edtCoeffBValue.setBackground(Color.red);
        }
    }//GEN-LAST:event_btnSetCoeffBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCGet_AO01;
    private javax.swing.JButton btnCGet_AO02;
    private javax.swing.JButton btnCGet_AO03;
    private javax.swing.JButton btnCGet_AO04;
    private javax.swing.JButton btnCSet_AO01;
    private javax.swing.JButton btnCSet_AO02;
    private javax.swing.JButton btnCSet_AO03;
    private javax.swing.JButton btnCSet_AO04;
    private javax.swing.JButton btnConfigure;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSGet_AO01;
    private javax.swing.JButton btnSGet_AO02;
    private javax.swing.JButton btnSGet_AO03;
    private javax.swing.JButton btnSGet_AO04;
    private javax.swing.JButton btnSSet_AO01;
    private javax.swing.JButton btnSSet_AO02;
    private javax.swing.JButton btnSSet_AO03;
    private javax.swing.JButton btnSSet_AO04;
    private javax.swing.JButton btnSetCoeffA;
    private javax.swing.JButton btnSetCoeffB;
    private javax.swing.JCheckBox chkCSvalue;
    private javax.swing.JCheckBox chkLoopCycle;
    private javax.swing.JTextField edtCValue_AO01;
    private javax.swing.JTextField edtCValue_AO02;
    private javax.swing.JTextField edtCValue_AO03;
    private javax.swing.JTextField edtCValue_AO04;
    private javax.swing.JTextField edtCoeffAValue;
    private javax.swing.JTextField edtCoeffBValue;
    private javax.swing.JTextField edtDACAddressValue;
    private javax.swing.JTextField edtSValue_AO01;
    private javax.swing.JTextField edtSValue_AO02;
    private javax.swing.JTextField edtSValue_AO03;
    private javax.swing.JTextField edtSValue_AO04;
    private javax.swing.JLabel lblCStitle;
    private javax.swing.JLabel lblCTitle_AO01;
    private javax.swing.JLabel lblCTitle_AO02;
    private javax.swing.JLabel lblCTitle_AO03;
    private javax.swing.JLabel lblCTitle_AO04;
    private javax.swing.JLabel lblCValueAO01;
    private javax.swing.JLabel lblCValueAO02;
    private javax.swing.JLabel lblCValueAO03;
    private javax.swing.JLabel lblCValueAO04;
    private javax.swing.JLabel lblCoeffATitle;
    private javax.swing.JLabel lblCoeffAValue;
    private javax.swing.JLabel lblCoeffBTitle;
    private javax.swing.JLabel lblCoeffBValue;
    private javax.swing.JLabel lblDACAddrTitle;
    private javax.swing.JLabel lblSTitle_AO01;
    private javax.swing.JLabel lblSTitle_AO02;
    private javax.swing.JLabel lblSTitle_AO03;
    private javax.swing.JLabel lblSTitle_AO04;
    private javax.swing.JLabel lblSValueAO01;
    private javax.swing.JLabel lblSValueAO02;
    private javax.swing.JLabel lblSValueAO03;
    private javax.swing.JLabel lblSValueAO04;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleCurrent;
    private javax.swing.JLabel lblTitleStartup;
    // End of variables declaration//GEN-END:variables
}

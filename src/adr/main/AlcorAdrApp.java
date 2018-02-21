/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adr.main;

import adr.devices.*;
import adr.serial.COMPortSettings;
import adr.serial.TwoWaySerialComm;
import javax.swing.JOptionPane;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class AlcorAdrApp {

    static Logger logger = Logger.getLogger( AlcorAdrDlg.class);
    
    private DevCommon m_common;
    public DevCommon GetDevCommon() { return m_common;}
    
    final private DevADC m_adc;
    public DevADC GetDevADC() { return m_adc;}
    
    final private DevDAC m_dac;
    public DevDAC GetDevDAC() { return m_dac;}
    
    final private DevGPI m_gpi;
    public DevGPI GetDevGPI() { return m_gpi;}
    
    final private DevGPO m_gpo;
    public DevGPO GetDevGPO() { return m_gpo;}
    
    public AlcorAdrDlg m_pMainWnd;
    
    final private AlcorAdrResources m_pResources;
    public AlcorAdrResources GetResources() { return m_pResources;}
    
    final private AlcorAdrSettings m_pSettings;
    public AlcorAdrSettings GetSettings() { return m_pSettings;}
    
    private TwoWaySerialComm m_rxtx;
    public TwoWaySerialComm GetRxTx() { return m_rxtx; }
    
    private int m_nConnectionState;
    public int  GetConnectionState() { return m_nConnectionState;}
    public void SetConnectionState( int nState) { m_nConnectionState = nState;}
    
    public AlcorAdrApp() {
        m_common = new DevCommon( this);    m_common.Init();
        m_adc = new DevADC( this);  m_adc.Init();
        m_dac = new DevDAC( this);  m_dac.Init();
        m_gpi = new DevGPI( this);  m_gpi.Init();
        m_gpo = new DevGPO( this);  m_gpo.Init();
        
        m_pResources = new AlcorAdrResources();
        m_pSettings = new AlcorAdrSettings( this);
        m_pSettings.LoadSettings();
        
        m_nConnectionState = AlcorAdrConstants.CONNECT_DISCONNECTED;
    }
    
     public void openPort() {
        try {
            if( m_rxtx != null) {
                closePort();
                m_rxtx = null;
            }
            m_rxtx = new TwoWaySerialComm( this);
            
            //m_rxtx.connect( port);//"/dev/ttyUSB0");
            String strComPort = ( String) m_pMainWnd.cmbComPortName.getSelectedItem();
            logger.info( "Открываем порт " + strComPort);
            COMPortSettings sett = m_pSettings.GetCOMPortSettings();
            sett.SetPort( strComPort);
            m_rxtx.connect( sett);
        } catch( Exception ex) {
            logger.error( "Exception on open COM port device", ex);
            MessageBoxError( "При открытии COM-порта произошла исключительная ситуация.\nПроверьте параметры в настройках.", "Ошибка");
        }
        
        m_nConnectionState = AlcorAdrConstants.CONNECT_ADDRESSES;
        m_rxtx.AddCommandToQueue( m_common.cmdGetAddresses(), m_common);
    }
    
    public void closePort() {
        try {
            m_rxtx.disconnect( m_pSettings.GetCOMPortSettings());
            m_rxtx = null;
        } catch( Exception ex) {
            logger.error( "Exception on open COM port device", ex);
            MessageBoxError( "При закрытии COM-порта произошла исключительная ситуация.", "Ошибка");
        }
        
        m_nConnectionState = AlcorAdrConstants.CONNECT_DISCONNECTED;
    }
     
    public void start() {
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
            java.util.logging.Logger.getLogger( AlcorAdrDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger( AlcorAdrDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger( AlcorAdrDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger( AlcorAdrDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        m_pMainWnd = new AlcorAdrDlg( null, true, this);
        java.awt.EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                m_pMainWnd.setVisible( true);                
                //String str =  Thread.currentThread().getContextClassLoader().getResource();
            }
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BasicConfigurator.configure();
        org.apache.log4j.Logger.getRootLogger().setLevel( org.apache.log4j.Level.ALL);
        
        /*
        //главная переменная окружения
        String strAMSrootEnvVar = System.getenv( "AMS_ROOT");
        if( strAMSrootEnvVar == null) {
            MessageBoxError( "Не задана переменная окружения AMS_ROOT!", "Ошибка");
            return;
        }
        
        //настройка логгера
        String strlog4jPropertiesFile = strAMSrootEnvVar + "/etc/log4j.ams.properties";
        File file = new File( strlog4jPropertiesFile);
        if(!file.exists())
            System.out.println("It is not possible to load the given log4j properties file :"+file.getAbsolutePath());
        else
            PropertyConfigurator.configure( file.getAbsolutePath());
        //logger.setLevel( LOG_LEVEL);
        */
        
        //ЗАПУСК ПРОГРАММЫ
        //Тут вызывается конструктор AMSApp (т.е. в момент конструктора 
        //потом вызвается его метод start, где создается окно,  потом инициализируются устройства
        try {
            AlcorAdrApp appInstance = new AlcorAdrApp();
            appInstance.start();
        }
        catch( Exception ex) {
            logger.error( "Exception caught while constructing theApp", ex);
            MessageBoxError( "Произошёл сбой при запуске приложения. Подробная информация в журнале.", "Ошибка");
            return;
        }
    }
    
    /**
     * Функция для сообщения пользователю информационного сообщения
     * @param strMessage сообщение
     * @param strTitleBar заголовок
     */
    public static void MessageBoxInfo( String strMessage, String strTitleBar)
    {
        JOptionPane.showMessageDialog( null, strMessage, strTitleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Функция для сообщения пользователю сообщения об ошибке
     * @param strMessage сообщение
     * @param strTitleBar заголовок
     */
    public static void MessageBoxError( String strMessage, String strTitleBar)
    {
        JOptionPane.showMessageDialog( null, strMessage, strTitleBar, JOptionPane.ERROR_MESSAGE);
    }
}

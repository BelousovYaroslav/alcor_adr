/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adr.main;

import adr.serial.COMPortSettings;
import gnu.io.SerialPort;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 *
 * @author yaroslav
 */
public class AlcorAdrSettings {
    //MEMBERS
    private final COMPortSettings m_pCOMPortSettings;
    
    //GETTERS
    public COMPortSettings GetCOMPortSettings() { return m_pCOMPortSettings; }    
    
    //REST
    private final AlcorAdrApp theApp;
    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger( AlcorAdrSettings.class);
    
    public AlcorAdrSettings( AlcorAdrApp app) {
        m_pCOMPortSettings = new COMPortSettings();
        theApp = app;
    }
    
    /**
     * Функция сохранения настроек в .xml файл
     */
    public void SaveSettings() {
        try {
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement( "Settings" );
            
            
            root.addElement( "COM_Port"     ).addText( m_pCOMPortSettings.GetPort());
            
            root.addElement( "COM_Baudrate" ).addText( Integer.toString( m_pCOMPortSettings.GetBaudRate()));
            
            if( m_pCOMPortSettings.GetDataBits() == SerialPort.DATABITS_5)
                root.addElement( "COM_DataBits" ).addText( "5");
            else if( m_pCOMPortSettings.GetDataBits() == SerialPort.DATABITS_6)
                root.addElement( "COM_DataBits" ).addText( "6");
            else if( m_pCOMPortSettings.GetDataBits() == SerialPort.DATABITS_7)
                root.addElement( "COM_DataBits" ).addText( "7");
            else if( m_pCOMPortSettings.GetDataBits() == SerialPort.DATABITS_8)
                root.addElement( "COM_DataBits" ).addText( "8");
            else {
                logger.warn( "Unknown COM_DataBits value '" + m_pCOMPortSettings.GetDataBits() + "'! Saving default!");
                root.addElement( "COM_DataBits" ).addText( "8");
            }
            
            switch( m_pCOMPortSettings.GetParity()) {
                case SerialPort.PARITY_NONE:    root.addElement( "COM_Parity" ).addText( "None");   break;
                case SerialPort.PARITY_ODD:     root.addElement( "COM_Parity" ).addText( "Odd");    break;
                case SerialPort.PARITY_EVEN:    root.addElement( "COM_Parity" ).addText( "Even");   break;
                case SerialPort.PARITY_MARK:    root.addElement( "COM_Parity" ).addText( "Mark");   break;
                case SerialPort.PARITY_SPACE:   root.addElement( "COM_Parity" ).addText( "Space");  break;
                default:
                    logger.warn( "Unknown COM_Parity value '" + m_pCOMPortSettings.GetParity() + "'! Saving default!");
                    root.addElement( "COM_Parity" ).addText( "None");
                break;
            }

            switch( m_pCOMPortSettings.GetStopBits()) {
                case SerialPort.STOPBITS_1: root.addElement( "COM_StopBits" ).addText( "1"); break;
                case SerialPort.STOPBITS_2: root.addElement( "COM_StopBits" ).addText( "2"); break;
                default: 
                    logger.warn( "Unknown COM_StopBits value '" + m_pCOMPortSettings.GetStopBits() + "'! Saving default!");
                    root.addElement( "COM_StopBits" ).addText( "1");
                break;
            }
            
            
            OutputFormat format = OutputFormat.createPrettyPrint();
            
            //TODO
            String strSettingsXmlFile = "alcor.adr.settings.xml";//System.getenv( "AMS_ROOT") + "/etc/settings.ams.xml";
                    
            XMLWriter writer = new XMLWriter( new FileWriter( strSettingsXmlFile), format);
            
            writer.write( document );
            writer.close();
        } catch (IOException ex) {
            logger.error( "IOException caught while saving settings!", ex);
        }
    }
    
    /**
     * Функция загрузки настроек из .xml файла
     * @return 
     * true  - загрузка прошла успешно
     * false - загрузка прошла с ошибками
     */
    public boolean LoadSettings() {
        boolean bResOk = true;
        try {
            SAXReader reader = new SAXReader();
            
            String strSettingsFilePathName = "alcor.adr.settings.xml";//System.getenv( "AMS_ROOT") + "/etc/settings.ams.xml";
            URL url = ( new java.io.File( strSettingsFilePathName)).toURI().toURL();
            
            Document document = reader.read( url);
            
            Element root = document.getRootElement();

            // iterate through child elements of root
            for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                String name = element.getName();
                String value = element.getText();
                
                //logger.debug( "Pairs: [" + name + " : " + value + "]");
                
                if( "COM_Port".equals( name)) m_pCOMPortSettings.SetPort( value);
                
                if( "COM_Baudrate".equals( name)) m_pCOMPortSettings.SetBaudRate( Integer.parseInt( value));
                
                if( "COM_DataBits".equals( name)) {
                    switch (value) {
                        case "5":   m_pCOMPortSettings.SetDataBits( SerialPort.DATABITS_5); break;
                        case "6":   m_pCOMPortSettings.SetDataBits( SerialPort.DATABITS_6); break;
                        case "7":   m_pCOMPortSettings.SetDataBits( SerialPort.DATABITS_7); break;
                        case "8":   m_pCOMPortSettings.SetDataBits( SerialPort.DATABITS_8); break;
                        default:    logger.warn( "Unknown COM_DataBits value '" + value + "' in settings.xml! Using default!"); bResOk = false; break;
                    }
                }
                        
                if( "COM_Parity".equals( name)) {
                    switch (value) {
                        case "None":    m_pCOMPortSettings.SetParity( SerialPort.PARITY_NONE);  break;
                        case "Odd":     m_pCOMPortSettings.SetParity( SerialPort.PARITY_ODD);   break;
                        case "Even":    m_pCOMPortSettings.SetParity( SerialPort.PARITY_EVEN);  break;
                        case "Mark":    m_pCOMPortSettings.SetParity( SerialPort.PARITY_MARK);  break;
                        case "Space":   m_pCOMPortSettings.SetParity( SerialPort.PARITY_SPACE); break;
                        default:        logger.warn( "Unknown COM_Parity value '" + value + "' in settings.xml! Using default!"); bResOk = false; break;
                    }
                }
                
                if( "COM_StopBits".equals( name)) {
                    switch (value) {
                        case "1":   m_pCOMPortSettings.SetStopBits( SerialPort.STOPBITS_1); break;
                        case "2":   m_pCOMPortSettings.SetParity( SerialPort.STOPBITS_2);   break;
                        default:    logger.warn( "Unknown COM_StopBits value '" + value + "' in settings.xml! Using default!"); bResOk = false; break;
                    }
                }
            }
            
        } catch( MalformedURLException ex) {
            logger.error( "MalformedURLException caught while loading settings!", ex);
            bResOk = false;
        } catch( DocumentException ex) {
            logger.error( "DocumentException caught while loading settings!", ex);
            bResOk = false;
        }
        
        return bResOk;
    }
    
    /*
    public static void main( String args[]) {
        BasicConfigurator.configure();
        logger.setLevel( Level.TRACE);
        AlcorAdrSettings ams = new AlcorAdrSettings( null);
        ams.SaveSettings();
        ams.LoadSettings();
    }
    */
}

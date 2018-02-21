/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adr.devices;

import adr.main.AlcorAdrApp;
import adr.main.AlcorAdrConstants;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class DevCommon extends DevAbstract {
    final private AlcorAdrApp theApp;
    static Logger logger = Logger.getLogger( DevCommon.class);
    
    public DevCommon( AlcorAdrApp app) {
        theApp = app;        
    }
    
    public String cmdGetAddresses() {
        return "@A";
    }
    
    public String cmdGetCheckSumms() {
        return "@CS";
    }
    
    public String cmdGetFirmware() {
        return "@F";
    }
    
    public String cmdTurnOffLogging() {
        return "@LOG0";
    }
    
    public String cmdConfigureModule( int nOldAddr, int nNewAddr, boolean bCSusage) {
        if( nOldAddr < 0 && nOldAddr > 254) return null;
        if( nNewAddr < 0 && nNewAddr > 254) return null;
        return String.format( "%%%02x%02x0000", nOldAddr, nNewAddr, bCSusage?"40":"00");
    }
    
    
    @Override
    public void ProcessResponse(String strCmd, String strResponse) {
        if( strCmd.equals( cmdGetAddresses())) {
            String strAddrAI = strResponse.substring(  6,  8);
            String strAddrAO = strResponse.substring( 14, 16);
            String strAddrDI = strResponse.substring( 22, 24);
            String strAddrDO = strResponse.substring( 30, 32);
            
            logger.debug( "AD AI: 0x" + strAddrAI);
            logger.debug( "AD AO: 0x" + strAddrAO);
            logger.debug( "AD DI: 0x" + strAddrDI);
            logger.debug( "AD DI: 0x" + strAddrDO);
            
            theApp.GetDevADC().SetAddress( Integer.parseInt( strAddrAI, 16));
            theApp.GetDevDAC().SetAddress( Integer.parseInt( strAddrAO, 16));
            theApp.GetDevGPI().SetAddress( Integer.parseInt( strAddrDI, 16));
            theApp.GetDevGPO().SetAddress( Integer.parseInt( strAddrDO, 16));
            
            theApp.SetConnectionState( AlcorAdrConstants.CONNECT_CHECKSUMMS);
            theApp.GetRxTx().AddCommandToQueue(cmdGetCheckSumms(), theApp.GetDevCommon());
        }
        
        if( strCmd.equals( cmdGetCheckSumms())) {
            String strCsAI = strResponse.substring(  4,  5);
            String strCsAO = strResponse.substring(  9, 10);
            String strCsDI = strResponse.substring( 14, 15);
            String strCsDO = strResponse.substring( 19, 20);
            
            logger.debug( "CS AI:" + strCsAI);
            logger.debug( "CS AO:" + strCsAO);
            logger.debug( "CS DI:" + strCsDI);
            logger.debug( "CS DI:" + strCsDO);
            
            if( strCsAI.equals( "0")) theApp.GetDevADC().SetCSUsage( AlcorAdrConstants.CHECKSUMM_NO);
            if( strCsAI.equals( "1")) theApp.GetDevADC().SetCSUsage( AlcorAdrConstants.CHECKSUMM_YES);
            
            if( strCsAO.equals( "0")) theApp.GetDevDAC().SetCSUsage( AlcorAdrConstants.CHECKSUMM_NO);
            if( strCsAO.equals( "1")) theApp.GetDevDAC().SetCSUsage( AlcorAdrConstants.CHECKSUMM_YES);
            
            if( strCsDI.equals( "0")) theApp.GetDevGPI().SetCSUsage( AlcorAdrConstants.CHECKSUMM_NO);
            if( strCsDI.equals( "1")) theApp.GetDevGPI().SetCSUsage( AlcorAdrConstants.CHECKSUMM_YES);
            
            if( strCsDO.equals( "0")) theApp.GetDevGPO().SetCSUsage( AlcorAdrConstants.CHECKSUMM_NO);
            if( strCsDO.equals( "1")) theApp.GetDevGPO().SetCSUsage( AlcorAdrConstants.CHECKSUMM_YES);
            
            theApp.SetConnectionState( AlcorAdrConstants.CONNECT_CONNECTED);
            //theApp.GetRxTx().AddCommandToQueue( ReqCheckSumms(), theApp.GetDevCommon());
        }
        
        if( strCmd.equals( cmdGetFirmware())) {
            String strVerMajor = strResponse.substring( 1, 3);
            String strVerMiddle = strResponse.substring( 3, 5);
            String strVerMinor = strResponse.substring( 5, 7);
            
            theApp.m_pMainWnd.lblFWvalue.setText( strVerMajor + "." + strVerMiddle + "." + strVerMinor);
        }
        
        if( strCmd.equals( cmdTurnOffLogging())) {
            logger.debug( "Processing respond for TurnOffLogging command");
            if( strResponse.equals( "!LOG0")) {
                logger.debug( "Logging successfully turned off");
            }
            else {
                logger.error( "Logging off command failed.");
            }
        }
    }

    @Override
    public void ProcessTimeOut(String strCmd) {
        if( strCmd.charAt( 1) == 'A') {
            if( theApp.GetConnectionState() == AlcorAdrConstants.CONNECT_ADDRESSES) {
                theApp.GetRxTx().AddCommandToQueue( "@A\r", this);
            }
        }
    }

    @Override
    public void Init() {
        SetAddress( null);
        SetCSUsage( AlcorAdrConstants.CHECKSUMM_UNKNOWN);
    }
}

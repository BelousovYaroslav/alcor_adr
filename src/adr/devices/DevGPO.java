/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adr.devices;

import adr.main.AlcorAdrApp;
import adr.main.AlcorAdrConstants;
import adr.serial.CheckSumm;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class DevGPO extends DevAbstract {
    static Logger logger = Logger.getLogger( DevGPO.class);
    private AlcorAdrApp theApp;
    
    public String m_strCBits;
    public String GetCBits() { return m_strCBits; }
    
    public String m_strSBits;
    public String GetSBits() { return m_strSBits; }
    
    public DevGPO( AlcorAdrApp app) {
        theApp = app;
    }
    
    public String cmdGetCurrentValues() {
        String strResult;
        
        if( GetAddress() == null) return null;
        strResult = String.format( "$%02X6", GetAddress());
        
        if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES) {
            String strCS = CheckSumm.calcCheckSumm( strResult);
            strResult += strCS;
        }
        
        strResult += "\r";
        strResult = strResult.toUpperCase();
        
        return strResult;
    }
    
    public String cmdSetCurrentValue( int nMask, int nVal) {
        String strResult;
        strResult = String.format( "#%02X%06X%d", GetAddress(), nMask, nVal);
        
        if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES) {
            String strCS = CheckSumm.calcCheckSumm( strResult);
            strResult += strCS;
        }
        
        strResult += "\r";
        strResult = strResult.toUpperCase();
        
        return strResult;
    }
    
    public String cmdSetCurrentValue_chan( int nChan, int nVal) {
        String strResult;
        
        if( GetAddress() == null) return null;
        if( nChan < 0 || nChan > 20) return null;
        if( nVal < 0 || nVal > 1) return null;
        
        int nChanMask = 1 << nChan;
        
        strResult = String.format( "#%02X%06X%d", GetAddress(), nChanMask, nVal);
        
        if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES) {
            String strCS = CheckSumm.calcCheckSumm( strResult);
            strResult += strCS;
        }
        
        strResult += "\r";
        strResult = strResult.toUpperCase();
        
        return strResult;
    }
    
     public String cmdGetStartUpValues() {
        String strResult;
        
        if( GetAddress() == null) return null;
        strResult = String.format( "$%02XS6", GetAddress());
        
        if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES) {
            String strCS = CheckSumm.calcCheckSumm( strResult);
            strResult += strCS;
        }
        
        strResult += "\r";
        strResult = strResult.toUpperCase();
        
        return strResult;
    }
    
    public String cmdSetStartUpValue( int nMask, int nVal) {
        String strResult;
        strResult = String.format( "#%02XS%06X%d", GetAddress(), nMask, nVal);
        
        if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES) {
            String strCS = CheckSumm.calcCheckSumm( strResult);
            strResult += strCS;
        }
        
        strResult += "\r";
        strResult = strResult.toUpperCase();
        
        return strResult;
    }
    
    public String cmdSetStartUpValue_chan( int nChan, int nVal) {
        String strResult;
        
        if( GetAddress() == null) return null;
        if( nChan < 0 || nChan > 20) return null;
        if( nVal < 0 || nVal > 1) return null;
        
        int nChanMask = 1 << nChan;
        
        strResult = String.format( "#%02XS%06X%d", GetAddress(), nChanMask, nVal);
        
        if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES) {
            String strCS = CheckSumm.calcCheckSumm( strResult);
            strResult += strCS;
        }
        
        strResult += "\r";
        strResult = strResult.toUpperCase();
        
        return strResult;
    }
    
    public void Init() {
        SetAddress( null);
        SetCSUsage( AlcorAdrConstants.CHECKSUMM_UNKNOWN);
        m_strCBits = "????????????";
        m_strSBits = "????????????";
    }
    
    @Override
    public void ProcessResponse(String strCmd, String strResponse) {
        if( strCmd.startsWith( "#")) {
            if( (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && strCmd.length() == 13) ||
                (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_NO && strCmd.length() == 11)  ) {
                //#AA(mask)d
                
            }
            else
            if( (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && strCmd.length() == 14) ||
                (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_NO  && strCmd.length() == 12)  ) {
                //#AAS(mask)d
                
            }
            else
            {
                //UNKNOWN #-COMMAND
            }
        }
        else
        if( strCmd.startsWith( "$")) {
            if( strCmd.charAt( 3) == '6') {
                if( (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && strCmd.length() == 7) ||
                    (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_NO  && strCmd.length() == 5)  ) {
                    
                    //$AA6
                    if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && CheckSumm.CheckCheckSumm( strCmd)) {
                        logger.warn( "Response: '" + strResponse + "'. CheckSumm fails!");
                        return;
                    }

                    String strValue = strResponse.substring( 1, 7);
                    int nValue = Integer.parseInt( strValue, 16);

                    m_strCBits = "";
                    int nBase = 1;

                    for( int i=0; i<20; i++) {
                        m_strCBits += ( ( nValue & nBase) > 0) ? "1" : "0";
                        nBase = nBase << 1;
                    }
                    
                }
                else
                {
                    //WRONG FORMATTED $AA6 COMMAND
                }
            }
            else
            if( strCmd.charAt( 3) == 'M') {
                if( (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && strCmd.length() == 7) ||
                    (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_NO  && strCmd.length() == 5)  ) {
                    //$AAM
                    
                }
                else
                {
                    //WRONG FORMATTED $AAM COMMAND
                }
            }
            else
            if( strCmd.charAt( 3) == 'S') {
                if( (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && strCmd.length() == 8) ||
                    (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_NO  && strCmd.length() == 6)  ) {
                    
                    //$AAS6
                    if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && CheckSumm.CheckCheckSumm( strCmd)) {
                        logger.warn( "Response: '" + strResponse + "'. CheckSumm fails!");
                        return;
                    }

                    String strValue = strResponse.substring( 1, 7);
                    int nValue = Integer.parseInt( strValue, 16);

                    m_strSBits = "";
                    int nBase = 1;

                    for( int i=0; i<20; i++) {
                        m_strSBits += ( ( nValue & nBase) > 0) ? "1" : "0";
                        nBase = nBase << 1;
                    }
                }
                else
                {
                    //WRONG FORMATTED $AAS6 COMMAND
                }
            }
            else
            {
                //UNKNOWN $-COMMAND
            }
        }
        else
        {
            //UNKNOWN COMMAND NEITHER # NOR $
        }
    }

    @Override
    public void ProcessTimeOut(String strCmd) {
        logger.warn( "Timeout on command '" + strCmd + "'");
    }
    
}

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
public class DevGPI extends DevAbstract {
    static Logger logger = Logger.getLogger( DevGPI.class);
    private AlcorAdrApp theApp;
    
    public String m_strBits;
    public String GetBits() { return m_strBits; }
    
    public DevGPI( AlcorAdrApp app) {
        theApp = app;
    }
    
    public void Init() {
        SetAddress( null);
        SetCSUsage( AlcorAdrConstants.CHECKSUMM_UNKNOWN);
        m_strBits = "????????????";
    }
    
    public String cmdGetValues() {
        String strResult;
        
        if( GetAddress() == null) return null;
        strResult = String.format( "$%02x6", GetAddress());
        
        if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES) {
            String strCS = CheckSumm.calcCheckSumm( strResult);
            strResult += strCS;
        }
        
        strResult += "\r";
        strResult = strResult.toUpperCase();
        
        return strResult;
    }
    
    @Override
    public void ProcessResponse(String strCmd, String strResponse) {
        if( strCmd.startsWith( "$")) {
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
            if( strCmd.charAt( 3) == '6') {
                if( (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && strCmd.length() == 7) ||
                    (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_NO  && strCmd.length() == 5)  ) {
                    //$AA6
                    
                    if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && CheckSumm.CheckCheckSumm( strCmd)) {
                        logger.warn( "Response: '" + strResponse + "'. CheckSumm fails!");
                        return;
                    }

                    String strValue = strResponse.substring( 1, 5);
                    int nValue = Integer.parseInt( strValue, 16);

                    m_strBits = "";
                    int nBase = 1;

                    for( int i=0; i<12; i++) {
                        m_strBits += ( ( nValue & nBase) > 0) ? "1" : "0";
                        nBase = nBase << 1;
                    }
                }
                else
                {
                    //WRONG FORMATTED $AA6 COMMAND
                }
            }
            else
            {
                //UNKNOWN $-COMMAND
            }
        }
        else
        {
            //UNKNOWN COMMAND
        }
    }

    @Override
    public void ProcessTimeOut(String strCmd) {
        logger.warn( "Timeout on command '" + strCmd + "'");
    }
    
}

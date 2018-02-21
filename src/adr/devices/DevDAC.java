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
public class DevDAC extends DevAbstract {

    private AlcorAdrApp theApp;
    
    static Logger logger = Logger.getLogger( DevDAC.class);
    
    private Double m_dblCDac0;
    private Double m_dblCDac1;
    private Double m_dblCDac2;
    private Double m_dblCDac3;
    public Double GetCDac0() { return m_dblCDac0; }
    public Double GetCDac1() { return m_dblCDac1; }
    public Double GetCDac2() { return m_dblCDac2; }
    public Double GetCDac3() { return m_dblCDac3; }
    public Double GetCDacN( int nChannel) {
        Double dblResult = null;
        switch( nChannel) {
            case AlcorAdrConstants.CHANNEL_DAC00: dblResult = m_dblCDac0; break;
            case AlcorAdrConstants.CHANNEL_DAC01: dblResult = m_dblCDac0; break;
            case AlcorAdrConstants.CHANNEL_DAC02: dblResult = m_dblCDac0; break;
            case AlcorAdrConstants.CHANNEL_DAC03: dblResult = m_dblCDac0; break;
        }
        return dblResult;
    }
    
    private Double m_dblSDac0;
    private Double m_dblSDac1;
    private Double m_dblSDac2;
    private Double m_dblSDac3;
    public Double GetSDac0() { return m_dblSDac0; }
    public Double GetSDac1() { return m_dblSDac1; }
    public Double GetSDac2() { return m_dblSDac2; }
    public Double GetSDac3() { return m_dblSDac3; }
    public Double GetSDacN( int nChannel) {
        Double dblResult = null;
        switch( nChannel) {
            case AlcorAdrConstants.CHANNEL_DAC00: dblResult = m_dblSDac0; break;
            case AlcorAdrConstants.CHANNEL_DAC01: dblResult = m_dblSDac0; break;
            case AlcorAdrConstants.CHANNEL_DAC02: dblResult = m_dblSDac0; break;
            case AlcorAdrConstants.CHANNEL_DAC03: dblResult = m_dblSDac0; break;
        }
        return dblResult;
    }
    
    public DevDAC( AlcorAdrApp app) {
        theApp = app;
        m_dblCDac0 = Double.NaN;
        m_dblCDac1 = Double.NaN;
        m_dblCDac2 = Double.NaN;
        m_dblCDac3 = Double.NaN;
        
        m_dblSDac0 = Double.NaN;
        m_dblSDac1 = Double.NaN;
        m_dblSDac2 = Double.NaN;
        m_dblSDac3 = Double.NaN;
    }
    
    @Override
    public void ProcessResponse(String strCmd, String strResponse) {
        if( strCmd.startsWith( "#")) {
            if( strCmd.charAt( 3) == 'C') {
                if( (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && strCmd.length() == 14) ||
                    (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_NO  && strCmd.length() == 12)  ) {
                    //#AACn(data)
                }
                else
                {
                    //WRONG FORMATTED #AACn(data) COMMAND
                }
            }
            else
            if( strCmd.charAt( 3) == 'S') {
                if( (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && strCmd.length() == 15) ||
                    (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_NO  && strCmd.length() == 13)  ) {
                    //#AASCn(data)
                }
                else
                {
                    //WRONG FORMATTED #AASCn(data) COMMAND
                }
            }
            else
            {
                //UNKNOWN #-COMMAND
            }
        }
        else
        if( strCmd.startsWith( "$")) {
            if( strCmd.charAt( 3) == '6' && strCmd.charAt( 4) == 'C') {
                if( (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && strCmd.length() == 9) ||
                    (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_NO  && strCmd.length() == 7)  ) {
                    //$AA6Cn
                    String strValue = strResponse.substring( 3, 9);
                    Double dblValue = Double.parseDouble( strValue);
                    switch( strCmd.charAt( 5)) {
                        case '0': m_dblCDac0 = dblValue; break;
                        case '1': m_dblCDac1 = dblValue; break;
                        case '2': m_dblCDac2 = dblValue; break;
                        case '3': m_dblCDac3 = dblValue; break;
                        default:
                            logger.error( "Request for unexisting channel '" + strCmd.charAt( 5) + "'");
                    }
                }
                else
                {
                    //WRONG FORMATTED $AA6Cn COMMAND
                }
            }
            else
            if( strCmd.charAt( 3) == 'A') {
                if( (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && strCmd.length() == 12) ||
                    (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_NO  && strCmd.length() == 10)  ) {
                    //$AAA1.000
                }
                else
                {
                    //WRONG FORMATTED $AAA1.000 COMMAND
                }
            }
            else
            if( strCmd.charAt( 3) == 'B') {
                if( (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && strCmd.length() == 12) ||
                    (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_NO  && strCmd.length() == 10)  ) {
                    //$AAB1.000
                }
                else
                {
                    //WRONG FORMATTED $AAB1.000 COMMAND
                }
            }
            else
            if( strCmd.charAt( 3) == 'D' && strCmd.charAt( 4) == 'C') {
                if( (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && strResponse.length() == 9) ||
                    (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_NO  && strResponse.length() == 7)  ) {
                    //$AADCn
                    String strValue = strResponse.substring( 3, 9);
                    Double dblValue = Double.parseDouble( strValue);
                    switch( strCmd.charAt( 5)) {
                        case '0': m_dblSDac0 = dblValue; break;
                        case '1': m_dblSDac1 = dblValue; break;
                        case '2': m_dblSDac2 = dblValue; break;
                        case '3': m_dblSDac3 = dblValue; break;
                        default:
                            logger.error( "Request for unexisting channel '" + strCmd.charAt( 5) + "'");
                    }
                }
                else
                {
                    //WRONG FORMATTED $AADCn COMMAND
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

    @Override
    public void Init() {
        SetAddress( null);
        SetCSUsage( AlcorAdrConstants.CHECKSUMM_UNKNOWN);
    }
    
    public String cmdGetCurrentValueForChannel( int nChannel) {
        String strResult;
        
        if( GetAddress() == null) return null;
        
        switch( nChannel ) {
            case AlcorAdrConstants.CHANNEL_DAC00:
                strResult = String.format( "$%02x6C0", GetAddress()); break;
            case AlcorAdrConstants.CHANNEL_DAC01:
                strResult = String.format( "$%02x6C1", GetAddress()); break;
            case AlcorAdrConstants.CHANNEL_DAC02:
                strResult = String.format( "$%02x6C2", GetAddress()); break;
            case AlcorAdrConstants.CHANNEL_DAC03:
                strResult = String.format( "$%02x6C3", GetAddress()); break;
            default:
                return null;
        }
        
        if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES) {
            String strCS = CheckSumm.calcCheckSumm( strResult);
            strResult += strCS;
        }
        
        strResult += "\r";
        strResult = strResult.toUpperCase();
        
        return strResult;
    }
    
    public String cmdSetCurrentValueForChannel( int nChannel, Double dblValue) {
        String strResult;
        
        if( GetAddress() == null)
            return null;
        
        if( dblValue < 0. || dblValue > 3.0)
            return null;
        
        switch( nChannel ) {
            case AlcorAdrConstants.CHANNEL_DAC00:
                strResult = String.format( "#%02xC0+%01.3f", GetAddress(), dblValue); break;
            case AlcorAdrConstants.CHANNEL_DAC01:
                strResult = String.format( "#%02xC1+%01.3f", GetAddress(), dblValue); break;
            case AlcorAdrConstants.CHANNEL_DAC02:
                strResult = String.format( "#%02xC2+%01.3f", GetAddress(), dblValue); break;
            case AlcorAdrConstants.CHANNEL_DAC03:
                strResult = String.format( "#%02xC3+%01.3f", GetAddress(), dblValue); break;
            default:
                return null;
        }
        
        strResult = strResult.replace( ',', '.');
        if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES) {
            String strCS = CheckSumm.calcCheckSumm( strResult);
            strResult += strCS;
        }
        
        strResult += "\r";
        strResult = strResult.toUpperCase();
        
        return strResult;
    }
    
    public String cmdGetStartupValueForChannel( int nChannel) {
        String strResult;
        
        if( GetAddress() == null) return null;
        
        switch( nChannel ) {
            case AlcorAdrConstants.CHANNEL_DAC00:
                strResult = String.format( "$%02xDC0", GetAddress()); break;
            case AlcorAdrConstants.CHANNEL_DAC01:
                strResult = String.format( "$%02xDC1", GetAddress()); break;
            case AlcorAdrConstants.CHANNEL_DAC02:
                strResult = String.format( "$%02xDC2", GetAddress()); break;
            case AlcorAdrConstants.CHANNEL_DAC03:
                strResult = String.format( "$%02xDC3", GetAddress()); break;
            default:
                return null;
        }
        
        if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES) {
            String strCS = CheckSumm.calcCheckSumm( strResult);
            strResult += strCS;
        }
        
        strResult += "\r";
        strResult = strResult.toUpperCase();
        
        return strResult;
    }
    
    public String cmdSetStartupValueForChannel( int nChannel, Double dblValue) {
        String strResult;
        
        if( GetAddress() == null)
            return null;
        
        if( dblValue < 0. || dblValue > 3.0)
            return null;
        
        switch( nChannel ) {
            case AlcorAdrConstants.CHANNEL_DAC00:
                strResult = String.format( "#%02xSC0%01.3f", GetAddress(), dblValue); break;
            case AlcorAdrConstants.CHANNEL_DAC01:
                strResult = String.format( "#%02xSC1%01.3f", GetAddress(), dblValue); break;
            case AlcorAdrConstants.CHANNEL_DAC02:
                strResult = String.format( "#%02xSC2%01.3f", GetAddress(), dblValue); break;
            case AlcorAdrConstants.CHANNEL_DAC03:
                strResult = String.format( "#%02xSC3%01.3f", GetAddress(), dblValue); break;
            default:
                return null;
        }
        
        if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES) {
            String strCS = CheckSumm.calcCheckSumm( strResult);
            strResult += strCS;
        }
        
        strResult += "\r";
        strResult = strResult.toUpperCase();
        
        return strResult;
    }
    
    public String cmdSetCalibA( double dblValue) {
        String strResult;
        
        if( GetAddress() == null) return null;
        
        strResult = String.format( "$%02XA%.03f", GetAddress(), dblValue);
        
        if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES) {
            String strCS = CheckSumm.calcCheckSumm( strResult);
            strResult += strCS;
        }
        
        //0x0D
        strResult += "\r";
        
        return strResult;
    }
    
    public String cmdSetCalibB( double dblValue) {
        String strResult;
        
        if( GetAddress() == null) return null;
        
        strResult = String.format( "$%02XB%.03f", GetAddress(), dblValue);
        
        if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES) {
            String strCS = CheckSumm.calcCheckSumm( strResult);
            strResult += strCS;
        }
        
        //0x0D
        strResult += "\r";
        
        return strResult;
    }
}

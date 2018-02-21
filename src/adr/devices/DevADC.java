/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adr.devices;

import adr.main.AlcorAdrApp;
import adr.main.AlcorAdrConstants;
import adr.serial.CheckSumm;
import java.util.HashMap;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class DevADC extends DevAbstract {

    static Logger logger = Logger.getLogger( DevADC.class);
    
    private final AlcorAdrApp theApp;
    private final HashMap m_mapValues;
    
    public Double getValue( int nIndex) {
        Double dblResult = Double.NaN;
        if( m_mapValues.containsKey( nIndex)) {
            dblResult = ( Double) m_mapValues.get( nIndex);
        }
        return dblResult;
    }
    
    public DevADC( AlcorAdrApp app) {
        theApp = app;
        m_mapValues = new HashMap( 12);
    }
    
    public String cmdGetAllChannelsValues() {
        String strResult;
        
        if( GetAddress() == null) return null;
        
        strResult = String.format( "#%02X", GetAddress());
        
        if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES) {
            String strCS = CheckSumm.calcCheckSumm( strResult);
            strResult += strCS;
        }
        
        //0x0D
        strResult += "\r";
        
        return strResult;
    }
    
    public String cmdGetSpecifiedChannelValues( int nChannel) {
        String strResult;
        
        if( GetAddress() == null) return null;
        
        if( nChannel < AlcorAdrConstants.CHANNEL_ADC00 && nChannel > AlcorAdrConstants.CHANNEL_ADC11) {
            logger.error( "Попытка прочитать несуществующий канал! Каналы лежат в диапазоне [0-11], а запрошен " + nChannel);
            return null;
        }
        
        strResult = String.format( "#%02X%X", GetAddress(), nChannel);
        
        if( GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES) {
            String strCS = CheckSumm.calcCheckSumm( strResult);
            strResult += strCS;
        }
        
        //0x0D
        strResult += "\r";
        
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
    
    @Override
    public void ProcessResponse(String strCmd, String strResponse) {
        if( strCmd.startsWith( "#")) {
            if( (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && strCmd.length() == 6) ||
                (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_NO  && strCmd.length() == 4)  ) {
                //#AA
                for( int i=0; i<12; i++) {
                    String strVal = strResponse.substring( 1 + i * 6, 7 + i * 6);
                    Double dblVal = Double.parseDouble( strVal);
                    
                    logger.trace( "ADC:Reposnd:Channel" + i + "=" + strVal);
                    switch( i) {
                        case  0: m_mapValues.put( AlcorAdrConstants.CHANNEL_ADC00, dblVal); break;
                        case  1: m_mapValues.put( AlcorAdrConstants.CHANNEL_ADC01, dblVal); break;
                        case  2: m_mapValues.put( AlcorAdrConstants.CHANNEL_ADC02, dblVal); break;
                        case  3: m_mapValues.put( AlcorAdrConstants.CHANNEL_ADC03, dblVal); break;
                        case  4: m_mapValues.put( AlcorAdrConstants.CHANNEL_ADC04, dblVal); break;
                        case  5: m_mapValues.put( AlcorAdrConstants.CHANNEL_ADC05, dblVal); break;
                        case  6: m_mapValues.put( AlcorAdrConstants.CHANNEL_ADC06, dblVal); break;
                        case  7: m_mapValues.put( AlcorAdrConstants.CHANNEL_ADC07, dblVal); break;
                        case  8: m_mapValues.put( AlcorAdrConstants.CHANNEL_ADC08, dblVal); break;
                        case  9: m_mapValues.put( AlcorAdrConstants.CHANNEL_ADC09, dblVal); break;
                        case 10: m_mapValues.put( AlcorAdrConstants.CHANNEL_ADC10, dblVal); break;
                        case 11: m_mapValues.put( AlcorAdrConstants.CHANNEL_ADC11, dblVal); break;
                    }
                }
            }
            else
            if( (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && strCmd.length() == 7) ||
                (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_NO  && strCmd.length() == 5)  ) {
                //#AAN
                String strVal = strResponse.substring( 1, 7);
                Double dblVal = Double.parseDouble( strVal);
                    
                logger.trace( "ADC:Respond: value=" + strVal);
                /*switch( ) {
                    case 0: m_mapValues.put( AlcorAdrConstants.CHANNEL_ADC00, dblVal); break;
                    case 1: m_mapValues.put( AlcorAdrConstants.CHANNEL_ADC01, dblVal); break;
                    case 2: m_mapValues.put( AlcorAdrConstants.CHANNEL_ADC02, dblVal); break;
                    case 3: m_mapValues.put( AlcorAdrConstants.CHANNEL_ADC03, dblVal); break;
                }*/
            }    
            else
            {
                //UNKNOWN #-COMMAND
            }    
        }
        else 
        if( strCmd.startsWith( "$")) {
            if( strCmd.charAt( 3) == '2') {
                if( (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && strCmd.length() == 7) ||
                    (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_NO  && strCmd.length() == 5)  ) {
                    //$AA2
                }
                else
                {
                    //WRONG FORMATTED $AA2 COMMAND
                }
            }
            else
            if( strCmd.charAt( 3) == '8') {    
                if( (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_YES && strCmd.length() == 9) ||
                    (  GetCSUsage() == AlcorAdrConstants.CHECKSUMM_NO  && strCmd.length() == 7)  ) {
                    //$AA8Ci
                }
                else
                {
                    //WRONG FORMATTED $AA8Ci COMMAND
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
                    //WRONG FORMATTED $AA COMMAND
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
        m_mapValues.put( AlcorAdrConstants.CHANNEL_AI01, Double.NaN);
        m_mapValues.put( AlcorAdrConstants.CHANNEL_AI02, Double.NaN);
        m_mapValues.put( AlcorAdrConstants.CHANNEL_AI03, Double.NaN);
        m_mapValues.put( AlcorAdrConstants.CHANNEL_AI04, Double.NaN);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adr.devices;

import adr.main.AlcorAdrConstants;

/**
 *
 * @author yaroslav
 */
public abstract class DevAbstract {
    private Integer m_nAddress;
    public Integer GetAddress() { return m_nAddress; }
    public void SetAddress( Integer nAddress) { m_nAddress = nAddress; }
    
    private int m_nCheckSummUsage;
    public int GetCSUsage() { return m_nCheckSummUsage;}
    public void SetCSUsage( int nUsage) { m_nCheckSummUsage = nUsage;}
    
    public abstract void ProcessResponse( String strCmd, String strResponse);
    
    public abstract void ProcessTimeOut( String strCmd);
    
    public abstract void Init();
    
    public boolean isInitialized() {
        if( m_nAddress == null) return false;
        
        
        if( m_nCheckSummUsage != AlcorAdrConstants.CHECKSUMM_YES &&
            m_nCheckSummUsage != AlcorAdrConstants.CHECKSUMM_NO)
            
            return false;
            
        return true;
    }
}

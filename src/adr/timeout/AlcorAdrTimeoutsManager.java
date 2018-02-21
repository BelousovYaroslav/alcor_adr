/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adr.timeout;

import java.util.concurrent.ConcurrentHashMap;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class AlcorAdrTimeoutsManager {
    static Logger logger = Logger.getLogger(AlcorAdrTimeoutsManager.class);
    
    private final long ID_CIRCLE_LENGTH = 1024;
    
    private final ConcurrentHashMap m_map;
    public int GetMapSize() {
        return m_map.size();
    }
    
    private static AlcorAdrTimeoutsManager singletonManager = null;
    private long m_lIndex;
    
    public static AlcorAdrTimeoutsManager getInstance() {
        if( singletonManager == null) {
            singletonManager = new AlcorAdrTimeoutsManager();
            return singletonManager;
        }
        else
            return singletonManager;
    }
    
    /**
     * Start note the time 
     * @param nMilliSeconds - timeout duration in milliseconds
     * @return 
     *   id of timeout object
     */
    public long StartTimeout( int nMilliSeconds) {
        
        if( m_map.size() >= ID_CIRCLE_LENGTH) {
            logger.fatal( "Кончилось место в карте ID таймаутов");
            return -1;
        }
        
        //long lDeadloopCheck = m_lIndex;
        while( m_map.containsKey( m_lIndex)) {
            m_lIndex = ( 1 + ( m_lIndex) % ( ID_CIRCLE_LENGTH - 1));
            /*
            if( lDeadloopCheck == m_lIndex) {
                logger.fatal( "Кончилось место в карте ID таймаутов");
                return -1;
            }
            */
        }
        
        long lId = m_lIndex++;
        m_map.put( lId, System.currentTimeMillis() + nMilliSeconds);
        
        logger.trace( "Started timer with iD=" + lId);
        return lId;
    }
    
    /**
     * Check if timeout defined by parameter 'id' has happened
     * @param lId
     * timeout id, returned by <b>StartTimeout</b>
     * 
     * @return 
     *  TRUE - timeout has happened<br>
     *  FALSE - timeout is still in countdown
     */
    public boolean CheckTimeout( long lId) {
        if( m_map.containsKey(lId)) {
            return ( System.currentTimeMillis() >= ( long) m_map.get(lId));
        }
        else {
            logger.warn( "Unknown id=" + lId);
            return true;
        }
    }
    
    /**
     * Stop note the time defined by parameter 'id'
     * @param lId
     * timeout id, returned by <b>StartTimeout</b>
     * 
     */
    public void RemoveId( long lId) {
        logger.trace( "Freed timer with iD=" + lId);
        m_map.remove( lId);
    }
    
    public AlcorAdrTimeoutsManager() {
        m_map = new ConcurrentHashMap( ( int) ID_CIRCLE_LENGTH);
        m_lIndex = 1;
    }
}

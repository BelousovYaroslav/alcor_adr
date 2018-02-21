/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adr.main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.SECONDS;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public class LedsRefresh {
    
    static final Logger logger = Logger.getLogger( LedsRefresh.class);

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final AlcorAdrApp theApp;

    ScheduledFuture <?> lighterHandle;
    
    public LedsRefresh( AlcorAdrApp app) {
        theApp = app;
        
    }

    public void lightLedsStart() {
     
        final Runnable lighter;
        lighter = new Runnable() {
            public void run() {
                //logger.debug( "1");
                
                if( theApp.m_pMainWnd != null)
                    if( theApp.m_pMainWnd.lblRx != null) {
                        
                        if( theApp.GetRxTx() != null && theApp.GetRxTx().isOpen()) {
                            if( theApp.GetRxTx().isReading())
                                theApp.m_pMainWnd.lblRx.setIcon( theApp.GetResources().getIconLittleBrightGreen());
                            else
                                theApp.m_pMainWnd.lblRx.setIcon( theApp.GetResources().getIconLittleBrightRed());
                            
                            if( theApp.GetRxTx().isWriting())
                                theApp.m_pMainWnd.lblTx.setIcon( theApp.GetResources().getIconLittleBrightGreen());
                            else
                                theApp.m_pMainWnd.lblTx.setIcon( theApp.GetResources().getIconLittleBrightRed());
                        }
                        else {
                            theApp.m_pMainWnd.lblRx.setIcon( theApp.GetResources().getIconLittleGrey());
                            theApp.m_pMainWnd.lblTx.setIcon( theApp.GetResources().getIconLittleGrey());
                        }
                    }
                
                //logger.debug( "2");
            }
        };
                
        lighterHandle = scheduler.scheduleAtFixedRate( lighter, 100, 100, TimeUnit.MILLISECONDS);
    }
    
    public void lightLedsStop() {
        logger.debug( "lightLedsStop");
        lighterHandle.cancel(true);
        scheduler.shutdown();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adr.main;

import java.io.File;
import javax.swing.ImageIcon;
import org.apache.log4j.Logger;

/**
 *
 * @author yaroslav
 */
public final class AlcorAdrResources {
    
    static Logger logger = Logger.getLogger(AlcorAdrResources.class);
    
    private final ImageIcon m_icoBigRed;
    public ImageIcon getIconBigRed() { return m_icoBigRed;}
    
    private final ImageIcon m_icoBigGreen;
    public ImageIcon getIconBigGreen() { return m_icoBigGreen;}
    
    private final ImageIcon m_icoBigBlue;
    public ImageIcon getIconBigBlue() { return m_icoBigBlue;}
    
    private final ImageIcon m_icoBigYellow;
    public ImageIcon getIconBigYellow() { return m_icoBigYellow;}
    
    private final ImageIcon m_icoBigBlack;
    public ImageIcon getIconBigBlack() { return m_icoBigBlack;}
    
    private final ImageIcon m_icoLittleBrightRed;
    public ImageIcon getIconLittleBrightRed() { return m_icoLittleBrightRed;}
    
    private final ImageIcon m_icoLittleBrightGreen;
    public ImageIcon getIconLittleBrightGreen() { return m_icoLittleBrightGreen;}
    
    private final ImageIcon m_icoLittleBrightBlue;
    public ImageIcon getIconLittleBrightBlue() { return m_icoLittleBrightBlue;}
    
    private final ImageIcon m_icoLittleGrey;
    public ImageIcon getIconLittleGrey() { return m_icoLittleGrey;}
    
            
    private ImageIcon LoadIconShortCut( String strFilePathName) {
        File f = new File( strFilePathName);
        if(f.exists() && !f.isDirectory()) {
            return new ImageIcon( strFilePathName);
        }
        else {
            logger.warn( "File not found: " + strFilePathName);
            return null;
        }
    }
    
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected ImageIcon createImageIcon(String path,
                                               String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public AlcorAdrResources() {
        
        m_icoBigRed    = createImageIcon( "/adr/res/redLED.gif", "");
        m_icoBigGreen  = createImageIcon( "/adr/res/greenLED.gif", "");
        m_icoBigBlack  = createImageIcon( "/adr/res/blackLED.gif", "");
        m_icoBigBlue   = createImageIcon( "/adr/res/blueLED.gif", "");
        m_icoBigYellow = createImageIcon( "/adr/res/yellowLED.gif", "");
        
        m_icoLittleBrightRed   = createImageIcon( "/adr/res/red_little_bright.gif", "");
        m_icoLittleBrightGreen = createImageIcon( "/adr/res/green_little_bright.gif", "");
        m_icoLittleBrightBlue  = createImageIcon( "/adr/res/blue_little_bright.gif", "");
        m_icoLittleGrey  =       createImageIcon( "/adr/res/grey_little.gif", "");
    }
}

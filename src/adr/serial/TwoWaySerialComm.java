package adr.serial;


import adr.main.AlcorAdrApp;
import adr.devices.DevAbstract;
import adr.timeout.AlcorAdrTimeoutsManager;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.swing.JLabel;
import javax.swing.Timer;

import org.apache.log4j.Logger;

public class TwoWaySerialComm
{
    final AlcorAdrApp theApp;
    static Logger logger = Logger.getLogger( TwoWaySerialComm.class);
    
    private Thread thrInput;
    private Thread thrOutput;
    
    private SerialReader sin;
    private SerialWriter sout;
    
    public boolean IsActive() {
        boolean bIn = IsInputThreadAlive();
        boolean bOut = IsOutputThreadAlive();
        return  ( bIn & bOut);
    }
    
    public boolean IsInputThreadAlive() {
        if( thrInput == null) return false;
        return thrInput.isAlive();
    };
    public boolean IsOutputThreadAlive() {
        if( thrOutput == null) return false;
        return thrOutput.isAlive();
    };
    
    CommPort commPort;
    public boolean isOpen() { return ( commPort != null);}
    
    private boolean m_bWriting;
    public boolean isWriting() { return m_bWriting; }
    public void setWriting() {
        m_bWriting = true;
        new Timer( 100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Timer t = ( Timer) e.getSource();
                t.stop();
                m_bWriting = false;
            }
        }).start();
    }
    
    private boolean m_bReading;
    public boolean isReading() { return m_bReading; }
    public void setReading() {
        m_bReading = true;
        new Timer( 100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Timer t = ( Timer) e.getSource();
                t.stop();
                m_bReading = false;
            }
        }).start();
    }
    
    /*
    private CmdRespondTimeoutThread pTimeoutThread;
    public CmdRespondTimeoutThread GetTimeoutThread() { return pTimeoutThread;}
    public void CreateNewTimeoutThread() {
        if( pTimeoutThread == null) {
            logger.warn( "CreateNewTimeoutThread(): Previous thread object was null! Strange situation.");
        }
        else if( pTimeoutThread.getState() != Thread.State.TERMINATED) {
            logger.warn( "CreateNewTimeoutThread(): Previous thread object state = " + pTimeoutThread.getState());
        }
        pTimeoutThread = new CmdRespondTimeoutThread( this);
    }
    */
    
    volatile public long m_lTimeOutId;
    volatile int m_nTimeOutCounter;
    volatile private CommandItem currentCommandInAction;

    synchronized CommandItem GetCmdInAction() { return currentCommandInAction; }
    synchronized void SetCmdInAction( CommandItem pNewAction) { currentCommandInAction = pNewAction;}
    
    public CircleBuffer crclBuffer;
    
    
    /* ********************************************************** */
    /* *************** COMMAND QUEUE **************************** */
    //private Stack cmdQueue;
    //private final LinkedList cmdQueue;
    private final ConcurrentLinkedQueue cmdQueue;
    
    /*
    public synchronized void AddCommandToQueueEmergent( String strCmd, AbstractDevice clientInstance ) {
        cmdQueue.addFirst( new CommandItem( strCmd, clientInstance));
        logger.trace( "AddCommandToQueueEmergent(" + strCmd + ",...): queue length: " + cmdQueue.size());
    }
    */
    
    public synchronized ConcurrentLinkedQueue GetQueue() { return cmdQueue; }
    
    public synchronized void AddCommandToQueue( String strCmd, DevAbstract clientInstance ) {
        cmdQueue.add( new CommandItem( strCmd, clientInstance));
        String strCmd2 = strCmd.replace('\r', ' ');
        logger.trace( "AddCommandToQueue(" + strCmd2 + ",...): queue length: " + cmdQueue.size());
    }
    
    //public synchronized int GetCommandQueueLen() { return cmdQueue.size(); }
    /* ********************************************************** */
    
    
    public TwoWaySerialComm( AlcorAdrApp app)
    {
        cmdQueue = new ConcurrentLinkedQueue();
        crclBuffer = new CircleBuffer();
        
        //pTimeoutThread = new CmdRespondTimeoutThread( this);
        m_lTimeOutId = 0;
        m_nTimeOutCounter = 0;
        
        //logger.setLevel( AMSApp.LOG_LEVEL);
        
        commPort = null;
        thrInput = null;
        thrOutput = null;
        
        m_bWriting = false;
        m_bReading = false;
        
        theApp = app;
    }
    
    public void connect( COMPortSettings pSettings) throws Exception
    {
        CommPortIdentifier portIdentifier;
        try {
            portIdentifier = CommPortIdentifier.getPortIdentifier( pSettings.GetPort());
        }
        catch( Exception e) {
            logger.fatal( "Exception при попытке получить информацию о текущем порт-соединении");
            AlcorAdrApp.MessageBoxError( "Произошла ошибка при попытке получить информацию о текущем порт-соединении.\nПроверьте COM-подсоединение и его настройки.", "Ошибка");
            return;
        }
        
        if ( portIdentifier.isCurrentlyOwned()) {
            logger.fatal( "Error: Port is currently in use");
        }
        else {
            
            commPort = portIdentifier.open( this.getClass().getName(), 2000);
            
            if ( commPort instanceof SerialPort ) {
                
                SerialPort serialPort = ( SerialPort) commPort;
                //serialPort.setSerialPortParams( 115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                serialPort.setSerialPortParams( pSettings.GetBaudRate(), pSettings.GetDataBits(), pSettings.GetStopBits(), pSettings.GetParity());
                
                InputStream in = serialPort.getInputStream();
                OutputStream out = serialPort.getOutputStream();
                
                sin = new SerialReader( in, this);
                thrOutput = new Thread( sin);
                thrOutput.start();
                
                sout = new SerialWriter( out, this);
                thrInput = new Thread( sout);
                thrInput.start();

            }
            else
            {
                System.out.println("Error: Only serial ports are handled.");
                commPort = null;
            }
        }     
    }
    
    public void disconnect( COMPortSettings pSettings) throws Exception {
        /*
        if( pTimeoutThread != null)
            pTimeoutThread.interrupt();
        */
        
        sin.StopThread();
        thrOutput.join();
        
        sout.StopThread();
        thrInput.join();
        
        if( m_lTimeOutId != 0) {
            AlcorAdrTimeoutsManager.getInstance().RemoveId( m_lTimeOutId);
            m_lTimeOutId = 0;
        }
        
        if( commPort != null) {
            commPort.close();
            commPort = null;
        }
    }

    
    
    
    /*
    public static void main ( String[] args )
    {
        //String strCmd = "что-нибудь русское\n";
        //byte [] bytes = strCmd.getBytes();
        //System.out.println( new String( bytes));
        
                    
        try
        {
            (new TwoWaySerialComm()).connect("/dev/ttyS0");
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    */
}
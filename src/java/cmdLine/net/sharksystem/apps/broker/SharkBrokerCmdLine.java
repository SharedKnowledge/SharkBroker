package net.sharksystem.apps.broker;

import java.io.IOException;
import net.sharkfw.kep.SharkProtocolNotSupportedException;
import net.sharkfw.kp.BrokerKP;
import net.sharkfw.peer.J2SEAndroidSharkEngine;
import net.sharkfw.peer.SharkEngine;

/**
 *
 * @author thsc
 */
public class SharkBrokerCmdLine {
    public static final int ONE_HOUR = 60 * 60 * 1000;
    public static final int PORT = 9090;
    
    public static void main(String[] args) throws SharkProtocolNotSupportedException, IOException, InterruptedException {
        SharkEngine se = new J2SEAndroidSharkEngine();
        BrokerKP hub = new BrokerKP(se, ONE_HOUR);
        
        se.startTCP(PORT);
        
        System.out.println("hub is up an running..");
        
        // let it runs 5 seconds to test that thing
        Thread.sleep(1000*5);
        
        se.stop();
        
        System.out.println("hub shutted down");
    }
}

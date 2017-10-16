package fr.lille1.ios;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import fr.lille1.ios.comanche.naked.WebServer;

public class Activator implements BundleActivator {
	
	private ServiceRegistration sAck;

    public void start(BundleContext context) throws Exception {
        // TODO add activation code here
    	System.out.println("Web-Server starts...");
    	
    	WebServer rr = new WebServer();
		rr.run();
    	sAck = context.registerService(WebServer.class.getName(), rr, null);
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    	sAck.unregister();
    	System.out.println("Web-Server stops...");
    }

}

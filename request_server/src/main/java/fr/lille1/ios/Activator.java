package fr.lille1.ios;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import fr.lille1.ios.server.WebServer;

public class Activator implements BundleActivator {

	private ServiceTracker serviceTracker;
	private WebServer server;
	
    public void start(BundleContext context) throws Exception {
        // TODO add activation code here
    	System.out.println("Bundle REQUEST_SERVER starts...");
    	
    	server = new WebServer();
    	
    	ServiceTrackerCustomizer handler = new WebServerHandler(context,server);
        serviceTracker = new ServiceTracker(context, "fr.lille1.ios.itf.RequestHandler", handler);
        serviceTracker.open();
        
        server.run();
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    	serviceTracker.close();
    	System.out.println("Bundle REQUEST_SERVER stops...");
    }

}

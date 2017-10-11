package fr.lille1.ios;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import fr.lille1.ios.update.UpdaterToServlet;

public class Activator implements BundleActivator {
	
	private ServiceRegistration sAck;

	//private ServiceTracker serviceTracker;
	
	public void start(BundleContext context) throws Exception {
		// TODO add activation code here
    	System.out.println("Client Starts...");

    	// On met le nom qui nous a servis lors de l'enregistrement coté server
    	
    	//ServiceReference <DisplayService> dsr = context.getServiceReference(DisplayService.class);
    	
    	UpdaterToServlet updater = new UpdaterToServlet();
    	sAck = context.registerService(Runnable.class, updater ,null);
    	
    	//ServiceTrackerCustomizer handler = new DisplayServiceHandler(context,client);
        //serviceTracker = new ServiceTracker(context, "fr.lille1.ios.displaymessage.itf.DisplayService", handler);
        //serviceTracker.open();
    	
    }

    public void stop(BundleContext context) throws Exception {
    	// TODO add deactivation code here
    	sAck.unregister();
    	//serviceTracker.close();
    	System.out.println("Client Stops...");
    }

}

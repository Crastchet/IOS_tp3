package fr.lille1.ios;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import fr.lille1.ios.handler.ServletRequestHandler;
import fr.lille1.ios.itf.RequestHandler;

public class Activator implements BundleActivator {

	private ServiceRegistration sAck;

    public void start(BundleContext context) throws Exception {
    	// TODO add activation code here
    	System.out.println("Bundle PASS_TO_SERVLET_MODE starts...");
    	RequestHandler myRequestHandler = new ServletRequestHandler();
    	sAck = context.registerService(RequestHandler.class.getName(), myRequestHandler, null);
        
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    	sAck.unregister();
    	System.out.println("Bundle PASS_TO_SERVLET_MODE stops...");
    }

}

package fr.lille1.ios;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import fr.lille1.ios.handler.FileRequestHandler;
import fr.lille1.ios.itf.RequestHandler;

public class Activator implements BundleActivator {
	
	//M'enregistrer sur le services disponibles en tant que FileHandler..
	private ServiceRegistration sAck;

    public void start(BundleContext context) throws Exception {
    	// TODO add activation code here
    	System.out.println("Bundle PASS_TO_FILE_MODE starts...");
    	RequestHandler myRequestHandler = new FileRequestHandler();
    	sAck = context.registerService(RequestHandler.class.getName(), myRequestHandler, null);
        
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    	sAck.unregister();
    	System.out.println("Bundle PASS_TO_FILE_MODE stops...");
    }

}

package fr.lille1.ios;

import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import fr.lille1.ios.itf.RequestHandler;
import fr.lille1.ios.server.RequestAnalyzer;
import fr.lille1.ios.server.WebServer;

public class WebServerHandler implements ServiceTrackerCustomizer {

	WebServer myServer;
	BundleContext context;
	
	List list = new Pile !!!
	
	public WebServerHandler(BundleContext c, WebServer s) {
		this.myServer = s;
		this.context = c;
	}
	
	public Object addingService(ServiceReference reference) {
		// TODO Auto-generated method stub
		System.out.println("ON EST DANS LE ADD SERVICE");
		RequestHandler requestHandler = context.getService(reference);
		myServer.getRequestAnalyzer().setRequestHandler(requestHandler);
		return requestHandler;
	}

	public void modifiedService(ServiceReference reference, Object service) {
		// TODO Auto-generated method stub
		System.out.println("ON EST DANS LE MODIFIED SERVICE");
		RequestHandler requestHandler = context.getService(reference);
		myServer.getRequestAnalyzer().setRequestHandler(requestHandler);
	}

	public void removedService(ServiceReference reference, Object service) {
		// TODO Auto-generated method stub
		System.out.println("ON EST DANS LE REMOVE SERVICE");
		
		// DANGER, on a plus rien et le serveur devient DOWN !!!
		//myServer.getRequestAnalyzer().setRequestHandler(null);
	}

}

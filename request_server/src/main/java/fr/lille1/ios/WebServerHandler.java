package fr.lille1.ios;

import java.util.LinkedList;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import fr.lille1.ios.itf.RequestHandler;
import fr.lille1.ios.server.ErrorRequestHandler;
import fr.lille1.ios.server.WebServer;

public class WebServerHandler implements ServiceTrackerCustomizer {

	WebServer myServer;
	BundleContext context;
	
	LinkedList<RequestHandler> list;
	
	public WebServerHandler(BundleContext c, WebServer s) {
		this.myServer = s;
		this.context = c;
		this.list = new LinkedList<RequestHandler>();
		
		this.list.add(new ErrorRequestHandler());
		this.myServer.getRequestAnalyzer().setRequestHandler(this.list.getLast());
	}
	
	public Object addingService(ServiceReference reference) {
		// TODO Auto-generated method stub
		RequestHandler requestHandler = context.getService(reference);
		myServer.getRequestAnalyzer().setRequestHandler(requestHandler);
		
		this.list.add(requestHandler);
		
		return requestHandler;
	}

	public void modifiedService(ServiceReference reference, Object service) {
		// TODO Auto-generated method stub
		RequestHandler requestHandler = context.getService(reference);
		myServer.getRequestAnalyzer().setRequestHandler(requestHandler);
		
		list.remove(service); //est ce toujours un RequestHandler. oui je pense.
		this.list.add(requestHandler);
	}

	public void removedService(ServiceReference reference, Object service) {
		// TODO Auto-generated method stub
		list.remove(service); //est ce toujours un RequestHandler. oui je pense.
		
		//if the list of RequestHandler is not empty (in fact the list should never be empty. But just in case..
		if(!list.isEmpty())
			myServer.getRequestAnalyzer().setRequestHandler(list.getLast());
			
		//if the list was empty somehow. But it is not normal we got here
		else
			myServer.getRequestAnalyzer().setRequestHandler(new ErrorRequestHandler());
	}

}

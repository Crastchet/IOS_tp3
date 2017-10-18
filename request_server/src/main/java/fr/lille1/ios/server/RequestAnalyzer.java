package fr.lille1.ios.server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import fr.lille1.ios.itf.Request;
import fr.lille1.ios.itf.RequestHandler;
import fr.lille1.ios.itf.RequestType;

/**
 * Parses the requested URL to extract parameters, then delegates the call to
 * another request handler (e.g. {@link FileRequestHandler})
 * 
 */
public class RequestAnalyzer {
	/** implicit contract: must not be null */
	private RequestHandler rh = null; //
	//private ServletRequestHandler rh = new ServletRequestHandler();

	/**
	 * implicit contract: may be null protected by if (l != null) below
	 */
	private BasicLogger l = new BasicLogger();

	// The rest of the code does not change
	public void handleRequest(Request r) throws IOException {
		r.in = r.s.getInputStream();
		String rq = new LineNumberReader(new InputStreamReader(r.in)).readLine();
		if (l != null)
			l.log(rq);
		String[] requestParts = rq.split(" ");
		if(requestParts.length <= 0) {
			throw new CanNotCompleteTheRequestException("Invalid request : "+rq);
		}
		RequestType type = RequestType.valueOf(requestParts[0]);
		if (type != null) {
			r.type = type;
			int firstSpace = rq.indexOf(' ', 0);
			if(rq.charAt(firstSpace+1) != '/') {
				throw new CanNotCompleteTheRequestException("Need / to begin request after "+type.name()+" : "+rq);
			}
			int secondSpace = rq.indexOf(' ', firstSpace+1);
			if(secondSpace < 0) {
				throw new CanNotCompleteTheRequestException("Need \" HTTP/1.0\" or \" HTTP/1.1\" at the end of the request : "+rq);
			}
			// Removing TypeRequest, space and the first /
			r.url = rq.substring(firstSpace+2, rq.indexOf(' ', firstSpace+1));
			if(rh != null)
				rh.handleRequest(r);
			else
				throw new IOException("Not any RequestHandler mode has been defined. Notice that it should not happen :/");
		} else {
			throw new CanNotCompleteTheRequestException("Invalid request : "+rq);
		}
	}
	
	public void setRequestHandler(RequestHandler r) {
		this.rh = r;
	}
}

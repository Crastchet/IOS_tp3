package fr.lille1.ios.itf;

import java.io.IOException;

public interface RequestHandler {
	
	public void handleRequest(Request r) throws IOException;
}

package fr.lille1.ios.comanche.naked;

import java.io.IOException;

public interface RequestHandler {

	public void handleRequest(Request r) throws IOException;
}
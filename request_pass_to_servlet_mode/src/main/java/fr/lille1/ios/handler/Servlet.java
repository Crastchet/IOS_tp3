package fr.lille1.ios.handler;

import java.io.IOException;

import fr.lille1.ios.itf.Request;

public interface Servlet {

	public void doGet(Request request) throws IOException;
	
	public void doPost(Request request) throws IOException;
	
}

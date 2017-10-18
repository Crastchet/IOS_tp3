package fr.lille1.ios.handler;

import java.io.IOException;

import fr.lille1.ios.itf.Request;

public class HelloWorldServlet implements Servlet {

	
	public void doGet(Request request) throws IOException {
		request.out.write("HTTP/1.0 200 OK\n".getBytes());
		request.out.write("\n".getBytes());    
		request.out.write("Hello World!".getBytes());    
	}

	public void doPost(Request request) throws IOException {
		doGet(request);
	}

}

package fr.lille1.ios.comanche.naked;

import java.io.IOException;

public class HelloWorldServlet implements Servlet {


	public void doGet(Request r) throws IOException {
		r.out.write("HTTP/1.0 200 OK\n".getBytes());
	    r.out.write("\n".getBytes());    
	    r.out.write("Hello World!".getBytes());    
	}

	
	public void doPost(Request r) throws IOException {
		doGet(r);
	}

}

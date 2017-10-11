package fr.lille1.ios.comanche.naked;

import java.util.HashMap;
import java.util.Map;

public class ServletFactory {

	private static final ServletFactory INSTANCE = new ServletFactory();
	private Map<String,Servlet> servlets;
	
	private ServletFactory() {
		this.servlets = new HashMap<String,Servlet>();
		this.registerServlet("helloworldservlet", new HelloWorldServlet());
	}
	
	public static ServletFactory getInstance() {
		return INSTANCE;
	}
	
	public void registerServlet(String name, Servlet servlet) {
		this.servlets.put(name,servlet);
	}
	
	public Servlet getServletByName(String name) {
		return this.servlets.get(name);
	}
	
}

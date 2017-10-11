package fr.lille1.ios.comanche.naked;


/** Logs a message together with a stack trace to get the execution path */
public class StackTraceLogger  {
	public void log (final String msg) {
		new Exception(msg).printStackTrace();		
	}
}

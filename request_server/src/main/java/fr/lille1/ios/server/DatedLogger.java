package fr.lille1.ios.server;

import java.util.Date;

/** Logs to System.err with a time-stamped message */
public class DatedLogger  {
  public void log (String msg) { System.err.println((new Date())+": "+msg); }
}

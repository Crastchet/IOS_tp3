package fr.lille1.ios.server;

/** Logs to System.err with a prefix given at instantiation time */
public class ConfigurableLogger {
  private String header;
  public String getHeader () {
    return header;
  }
  public void setHeader (String header) {
    this.header = header;
  }
  public void log (String msg) {
    System.err.println(header+msg);
  }
}

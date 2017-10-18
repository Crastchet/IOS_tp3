package fr.lille1.ios.server;
import java.io.IOException;

import fr.lille1.ios.itf.Request;
import fr.lille1.ios.itf.RequestHandler;

/** Sends an HTTP 404 in response to the request */
public class ErrorRequestHandler implements RequestHandler  {
  public void handleRequest (Request r) throws IOException {
    r.out.write("HTTP/1.0 404 Not Found\n\n".getBytes());
    r.out.write("Comanche: document not found.".getBytes());
  }
}

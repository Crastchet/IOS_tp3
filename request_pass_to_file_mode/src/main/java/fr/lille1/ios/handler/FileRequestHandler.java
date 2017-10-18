package fr.lille1.ios.handler;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import fr.lille1.ios.itf.Request;
import fr.lille1.ios.itf.RequestHandler;

/** Sends a the content of a file of the file system if the requested URL matches one. */
public class FileRequestHandler implements RequestHandler {
  public void handleRequest (Request r) throws IOException {
	File f = new File(r.url);
    if (f.exists() && !f.isDirectory()) {
      InputStream is = new FileInputStream(f);
      byte[] data = new byte[is.available()];
      is.read(data);
      is.close();
      r.out.write("HTTP/1.0 200 OK\n\n".getBytes());
      r.out.write(data);
    } else { 
      throw new CanNotCompleteTheRequestException("no such file found : "+f.getAbsolutePath());
    }
  }
}

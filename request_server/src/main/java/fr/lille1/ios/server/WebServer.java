package fr.lille1.ios.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import fr.lille1.ios.itf.Request;

/** Listens to a socket and enters an infinite loop to handle incoming requests. */
public class WebServer implements Runnable {
	private SequentialScheduler s = new SequentialScheduler();
	private RequestAnalyzer rh = new RequestAnalyzer();
	private ServerSocket ss;
	private boolean stillRunning;

	// functional aspect
	public void run() {
		new Thread(new Runnable() {
			public void run() {
				ss = null;
				try {
					ss = new ServerSocket(8081);
					stillRunning = !ss.isClosed();
					System.err.println("Comanche HTTP Server ready on port 8081.");
					while (true && stillRunning) {
						final Socket socket = ss.accept();
						s.schedule(new Runnable() {
							public void run() {
								Request r;
								try {
									r = new Request(socket);
									rh.handleRequest(r);
									socket.close();
								} catch (Exception _e) {
									try {
										socket.close();
									} catch (IOException e) {
										throw new RuntimeException("this should never happen");
									}
									_e.printStackTrace();
									//Nothing else, the server must keep on working
								}
							}
						});
						
					}
				} catch (SocketException e) {
					if(stillRunning)
						throw new RuntimeException(e);
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				} finally {
					try {
						if(ss != null) {
							ss.close();
						}
					} catch (IOException ioe) {
						throw new RuntimeException("this should never happen");
					}
				}
			}
		}).start();
	}
	
	public void stop() {
		try {
			ss.close();
			stillRunning = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public RequestAnalyzer getRequestAnalyzer() {
		return this.rh;
	}
}

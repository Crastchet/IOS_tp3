package comanche.naked;

import java.io.IOException;

public class RequestHandler {
	
	private enum Mode {
		fileMode,
		servletMode
	}
	
	private Mode mode = Mode.fileMode;
	

	public void handleRequest(Request r) throws IOException {
		switch(mode) {
		case fileMode:
			new FileRequestHandler().handleRequest(r);
			break;
		case servletMode:
			new ServletRequestHandler().handleRequest(r);
			break;
		default:
			new FileRequestHandler().handleRequest(r);
		}
	}
	
	public void setServletMode() {
		mode = Mode.servletMode;
	}
	
	public void setFileMode() {
		mode = Mode.fileMode;
	}
}

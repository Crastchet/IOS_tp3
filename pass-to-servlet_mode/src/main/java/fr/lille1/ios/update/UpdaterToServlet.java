package fr.lille1.ios.update;

public class UpdaterToServlet implements Runnable {	// Client

	private UpdateService service; 					// Server
	
	
	public void setService(UpdateService s) {
        this.service = s;
        System.out.println("Web-Server.service = " + this.service);
    }

    public void run() {
    	// TODO Auto-generated method stub
    	if(this.service != null)
    		this.service.update();
    }

    
}

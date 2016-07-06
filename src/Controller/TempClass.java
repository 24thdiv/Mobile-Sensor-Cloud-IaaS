package Controller;

import database.DatabaseAccess;
import invoke.InvokeInstance;

public class TempClass {

	public void createinstance(String user_id, String sensor_name, String lat, String lon) throws InterruptedException
	{
		
		Thread t1 = new Thread(new Runnable() {
		     public void run() {
		          // code goes here.
	
		     
		    	 InvokeInstance i = new InvokeInstance();
		    		try {
						i.createSensor(user_id, sensor_name, lat, lon);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
		    		
		    	 
		    	 
		     }
		});  
		t1.start();
		
	
	
	}

}

package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.UDVO;
import database.UserDAO;
import invoke.InvokeInstance;
import invoke.StopStart;

/**
 * Servlet implementation class StartStop
 */
public class StartStop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartStop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession ses = request.getSession();
		String sensor_id = request.getParameter("sensor_id");
		String action = request.getParameter("action");
		int user_id = (int) ses.getAttribute("user");
		
		
		if(action.equals("start"))
		{
			
			
			
			Thread t1 = new Thread(new Runnable() {
			     public void run() {
			          // code goes here.
		
			     
			    	 StopStart start = new StopStart();
						try {
							start.startSensor(String.valueOf(user_id), sensor_id);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	 
			    	 
			     }
			});  
			t1.start();
			
			
			
			
			
			
			
			
				
		}
		else{
			
			
			

			Thread t1 = new Thread(new Runnable() {
			     public void run() {
			          // code goes here.
		
			    	 invoke.StartStop stop = new invoke.StartStop();
						try {
							stop.stopSensor(String.valueOf(user_id), sensor_id);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	 
			    	 
			     }
			});  
			t1.start();
			
			
			
			
			
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<UDVO> ls = new ArrayList<UDVO>();
		UserDAO u = new UserDAO();
		ls = u.display(user_id);
		System.out.println("servelet \n servlet");
		for(UDVO v : ls){
			System.out.println(v.getSensor_id());
			System.out.println(v.getSensor_tag_value());
			System.out.println(v.getSensor_status());
			System.out.println(v.getTemp());
		}
	
		ses.setAttribute("sensor", ls);
		response.sendRedirect("userDashBoard.jsp");
		
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

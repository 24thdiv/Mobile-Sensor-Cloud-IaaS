package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TempClass;
import VO.UDVO;
import database.UserDAO;
import invoke.InvokeInstance;

/**
 * Servlet implementation class CreateSensor
 */
public class CreateSensor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSensor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		HttpSession ses = request.getSession();
		int user_id = (int) ses.getAttribute("user");
		//int user_id =1;
	   String sensor_name = request.getParameter("sensorname");
	   String lat = request.getParameter("lat");
	   String lon = request.getParameter("lon");
	   System.out.println("tag value"+sensor_name);
	   
//	   String filePath = getServletContext().getRealPath("\\WebContent\\KEYSENSOR.pem");
	   InvokeInstance invok = new InvokeInstance();
	   TempClass temp= new TempClass();
	   try {
		   
		   temp.createinstance(String.valueOf(user_id), sensor_name, lat, lon);
		   //invok.createSensor(String.valueOf(user_id), sensor_name, lat, lon);
	   } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		   e.printStackTrace();
	   }
	   
	System.out.println("Sensor Created");
	
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

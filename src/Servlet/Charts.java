package Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.LocalDate;

import database.DatabaseAccess;

/**
 * Servlet implementation class Charts
 */
public class Charts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Charts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		
		HttpSession ses =request.getSession();
		int id = (int) ses.getAttribute("user");
		
		
		// also get sensor_name
		String q = "SELECT sensor_id FROM sensordb.sensor_master where user_id="+id;
		DatabaseAccess db = new DatabaseAccess();
		ArrayList<String> sensor_ids = db.getSensorID(q);
		
		ArrayList<String> dates = new ArrayList<String>();
		String msg=null;
		LocalDate now = LocalDate.now();
		ArrayList<ArrayList<Double>> data = null;
		ArrayList<String> sensor_names= new ArrayList<String>();
		
		for(int i=0; i <15 ; i++)
		{
			dates.add(now.minusDays(14-i).toString());
			System.out.println(dates.get(i));
		}
		
			
		
		if(sensor_ids!=null)
		{
			try {
				data = getTempDetails(sensor_ids,dates);
				
				for(int i=0;i<sensor_ids.size();i++)
				{
					String sensorname = "SELECT sensor_tag_value FROM sensordb.sensor_master where sensor_id='"+sensor_ids.get(i)+"'";
					String name = db.getSensorNames(sensorname);
					sensor_names.add(name);
					
				}
				
				msg="Sensor";
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			
			 msg = "NoSensor";
		}
		
		
		
		request.setAttribute("data", data);
		request.setAttribute("dates", dates);
		request.setAttribute("msg", msg);
		request.setAttribute("sensornames", sensor_names);
		System.out.println("in charts servlet");

        RequestDispatcher dispatcher = request.getRequestDispatcher("chart.jsp");
        dispatcher.forward(request, response);
       
		
		
		
		
	}

	private ArrayList<ArrayList<Double>> getTempDetails(ArrayList<String> sensor_ids, ArrayList<String> dates) throws ClassNotFoundException, SQLException {
		
		
		
		ArrayList<ArrayList<Double>> data = new ArrayList<ArrayList<Double>>();
		int index = 0;
		ArrayList<Double> data_sensor;
		DatabaseAccess db = new DatabaseAccess();
		
		for(int i=0; i<sensor_ids.size(); i++)
		{
			// add where sensor id == this
			String query = "SELECT time_stamp, AVG(temp) as avgtemp FROM sensordb.temp_data where sensor_id='"+sensor_ids.get(i)+"' group by CAST(time_stamp AS date) order by time_stamp DESC limit 15";
			
			ResultSet rs = db.getAvgTemp(query);
			data_sensor = new ArrayList<Double>();
			for(int k=0;k<15;k++)
				data_sensor.add(0.0);
			
			
			if(rs!=null)
			{
				while(rs.next())
				{	
					Date d = rs.getDate("time_stamp");  
					String temp = rs.getString("avgtemp");
					
					if(dates.contains(d.toString()))
					{
						
						System.out.println("d.tostring "+ d.toString());
						index = dates.indexOf(d.toString());
						System.out.println("dates "+dates.get(index));
						Double t = Double.parseDouble(temp);
						data_sensor.set(index, t);
					}
				
				}
				
			}
		
			data.add(data_sensor);	
			
		}
		
		
		System.out.println("return data");
		return data;
	}

	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

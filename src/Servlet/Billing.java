package Servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.BillingVO;
import database.BillingDAO;
import database.UserDAO;

/**
 * Servlet implementation class Billing
 */
public class Billing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Billing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		NumberFormat formater = new DecimalFormat("#0.00");
		List<BillingVO> ls = new ArrayList<BillingVO>();
		BillingDAO u = new BillingDAO();
		
		HttpSession ses1 = request.getSession();
		
		int user_id = (int) ses1.getAttribute("user");
		ls = u.display(String.valueOf(user_id));
		System.out.println("servelet \n servlet");
		for(BillingVO v : ls){
			System.out.println(v.getSensor_id());
			System.out.println(v.getCost());
			System.out.println(v.getUp_time());
		}
		HttpSession ses = request.getSession();
		ses.setAttribute("billing", ls);
		double total=0.00;
		for(BillingVO vt : ls){
			total += Double.parseDouble(vt.getCost());
		}
		String total1 = formater.format(total);
		ses.setAttribute("total", total1);
		System.out.println("total cost   " + total1);
		response.sendRedirect("billingUser.jsp");
	}

}



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubmitBooking
 */
@WebServlet("/SubmitBooking")
public class SubmitBooking extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("text/html");
		
		//Step 1: Initialize a PrintWriter object to return the html values via the response
		PrintWriter out = response.getWriter();
		
		//Step 2: retrieve the four parameters from the request from the web form
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String cardnumber = request.getParameter("cardnumber");
		String cvv = request.getParameter("cvv");
		String expirydate = request.getParameter("expirydate");
		String quantity = request.getParameter("quantity");
		String date = request.getParameter("date");
		
		doGet(request, response);
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingdetails", "root", "password");
			
			 PreparedStatement ps = con.prepareStatement("INSERT into bookingdetails values(?,?,?,?,?,?,?)");
			
			 ps.setString(1, name);
			 ps.setString(2, email);
			 ps.setString(3, cardnumber);
			 ps.setString(4, cvv);
			 ps.setString(5, expirydate);
			 ps.setString(6, quantity);
			 ps.setString(7, date);
			
			
			 int i = ps.executeUpdate();
			
			 if (i > 0)
			 {
			PrintWriter writer = response.getWriter();
			writer.println("<h1>Hello " + name + " Your Booking Is Successful for  "+ quantity + " Ticket  On "+ date +"</h1>");
			writer.println("<h1>A Confirmation Email Have Been Sent to you" + email + "</h1>");
			writer.close(); 
			System.out.println(name);
			} 
			 
			}
		catch (Exception exception) {
			 System.out.println(exception);
			 System.out.println(name);
			 out.close();
			}
	}

}

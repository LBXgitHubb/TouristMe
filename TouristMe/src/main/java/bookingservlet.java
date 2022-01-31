


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.testing.Booking;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class bookingservlet
 */
@WebServlet("/bookingservlet")
public class bookingservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookingdetails";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	
	
	private static final String SELECT_BOOKING_BY_ID = "select name,email,cardnumber,cvv,expirydate,quantity,date from bookingdetails where name =?";
	private static final String SELECT_ALL_BOOKINGS = "select * from bookingdetails ";
	private static final String DELETE_BOOKINGS_SQL = "delete from bookingdetails where name = ?;";
	private static final String UPDATE_BOOKINGS_SQL = "update bookingdetails set name = ?,email =?,cardnumber =?,cvv =?,expirydate =?,quantity =?,date =? where name = ?;";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
    public bookingservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String action = request.getServletPath();
		 try {
		 switch (action) {
		 case "/bookingservlet/delete":
			 deleteBooking(request, response);
			 break;
			 case "/bookingservlet/edit":
			 showEditForm(request, response);
			 break;
			 case "/bookingservlet/update":
			 updateBooking(request, response);
			 break;
			 case "/bookingservlet/dashboard":
		 listBookings(request, response);
		 break;
		 }
		 } catch (SQLException ex) {
		 throw new ServletException(ex);
		 }
	}
		
	private void listBookings(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Booking> bookings = new ArrayList<>();
		try (Connection connection = getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKINGS);) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String cardnumber = rs.getString("cardnumber");
				String cvv = rs.getString("cvv");
				String expirydate = rs.getString("expirydate");
				String quantity = rs.getString("quantity");
				String date = rs.getString("date");
				bookings.add(new Booking(name, email, cardnumber, cvv, expirydate, quantity, date));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		request.setAttribute("listBookings", bookings);
		request.getRequestDispatcher("/bookingManagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String name = request.getParameter("name");
		Booking existingBooking = new Booking("", "", "", "", "", "", "");
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = 
						connection.prepareStatement(SELECT_BOOKING_BY_ID);) {
						preparedStatement.setString(1, name);
						ResultSet rs = preparedStatement.executeQuery();
						while (rs.next()) {
							name = rs.getString("name");
							String email = rs.getString("email");
							String cardnumber = rs.getString("cardnumber");
							String cvv = rs.getString("cvv");
							String expirydate = rs.getString("expirydate");
							String quantity = rs.getString("quantity");
							String date = rs.getString("date");
							existingBooking = new Booking(name, email, cardnumber, cvv, expirydate, quantity, date);
							}
							} catch (SQLException e) {
							System.out.println(e.getMessage());
							}
		request.setAttribute("booking", existingBooking);
		request.getRequestDispatcher("/bookingEdit.jsp").forward(request, response);
		}
	
	private void updateBooking(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
				String oriName = request.getParameter("oriName");
				 String name = request.getParameter("name");
				 String email = request.getParameter("email");
				 String cardnumber = request.getParameter("cardnumber");
				 String cvv = request.getParameter("cvv");
				 String expirydate = request.getParameter("expirydate");
				 String quantity = request.getParameter("quantity");
				 String date = request.getParameter("date");
				 
				 try (Connection connection = getConnection(); PreparedStatement statement = 
						 connection.prepareStatement(UPDATE_BOOKINGS_SQL);) {
						  statement.setString(1, name);
						  statement.setString(2, email);
						  statement.setString(3, cardnumber);
						  statement.setString(4, cvv);
						  statement.setString(5, expirydate);
						  statement.setString(6, quantity);
						  statement.setString(7, date);
						  statement.setString(8, oriName);
						  int i = statement.executeUpdate();
						  } 
				 response.sendRedirect("http://localhost:8080/TouristMe/bookingservlet/dashboard");
				 }
	
	private void deleteBooking(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
				String name = request.getParameter("name");
				try (Connection connection = getConnection(); PreparedStatement statement = 
						connection.prepareStatement(DELETE_BOOKINGS_SQL);) {
						 statement.setString(1, name);
						 int i = statement.executeUpdate();
						 }
				response.sendRedirect("http://localhost:8080/TouristMe/bookingservlet/dashboard");
				}

}

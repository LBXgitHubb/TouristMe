

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
/**
 * Servlet implementation class HelloIndexServlet
 */
@WebServlet("/HelloIndexServlet")
public class HelloIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String jdbcUR_attractions = "jdbc:mysql://localhost:3306/touristme";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "password";
	 
	
	 private static final String SELECT_allAttractions = "SELECT * FROM attractions" + " (name, region, price, address, type, details, image) VALUES " + " (?, ?, ?, ?, ?, ?, ?);";
	 private static final String SELECT_users = "SELECT status FROM users WHERE status = 1";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		 switch (action) {	
		 default:
			 listAttractions(request, response);
		 break;
		 }
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listAttractions(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		
		List <Listings> attractions = new ArrayList <>();
		try (Connection connection = getConnection();
				 
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_allAttractions);){
			
			ResultSet rs = preparedStatement.executeQuery();
			
		while(rs.next()) {
			String name = rs.getString("name");
			String region = rs.getString("region"); 
			String price = rs.getString("price");
			String address = rs.getString("address"); 
			String type = rs.getString("type");
			String details = rs.getString("details"); 
			String image = rs.getString("image");	
			attractions.add(new Listings(name,region,price,address,type,details,image));
		}
		System.out.println(attractions);
		
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			}
		
			request.setAttribute("listAttractions", attractions);
			request.getRequestDispatcher("/AttractionListings.jsp").forward(request, response);
		}		 
		
	protected Connection getConnection() {
		 Connection connection = null;
		 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 connection = DriverManager.getConnection(jdbcUR_attractions, jdbcUsername, jdbcPassword);
		 } catch (SQLException e) {
		 e.printStackTrace();
		 } catch (ClassNotFoundException e) {
		 e.printStackTrace();
		 }
		 return connection;
		 }
	} 
	
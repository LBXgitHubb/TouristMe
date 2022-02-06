

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class ShowListing
 */
@WebServlet("/ShowListing")
public class ShowListing extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jdbcURL = "jdbc:mysql://localhost:3306/touristme";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "password";
	 private static final String INSERT_LISTINGS_SQL = "INSERT INTO attractions" + " (name, region, price, address, type, details, image) VALUES " +
			  " (?, ?, ?, ?, ?, ?, ?);";
	 
	 private static final String GET_LOGIN_STATUS = "SELECT status FROM users WHERE status = 1";
	 
			  private static final String SELECT_LISTING_BY_ID = "select name,region,price,address,type,details,image from attractions where name =?";
			  private static final String SELECT_ALL_LISTINGS = "select * from attractions ";
			  private static final String DELETE_LISTINGS_SQL = "delete from attractions where name = ?;";
			  private static final String UPDATE_LISTINGS_SQL = "update attractions set name = ?,region= ?,price =?,address =?,type =?,details =?,image =? where name = ?;";
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowListing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		 try {
		 switch (action) {
		 case "/insert":
		 break;
		 case "/delete":
		 break;
		 case "/edit":
		 break;
		 case "/update":
		 break;
		 default:	
			 listListings(request, response);
		 break;
		 }
		 } catch (SQLException ex) {
		 throw new ServletException(ex);
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
	
	
	
	
	private void listListings(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
			{
			List <Listings> listings = new ArrayList <>();
			 try (Connection connection = getConnection();
			 // Step 5.1: Create a statement using connection object
			 PreparedStatement preparedStatement =
			connection.prepareStatement(SELECT_ALL_LISTINGS);) {
			 // Step 5.2: Execute the query or update query
			 ResultSet rs = preparedStatement.executeQuery();
			 // Step 5.3: Process the ResultSet object.
			 while (rs.next()) {
			 String name = rs.getString("name");
			 String region = rs.getString("region");
			 String price = rs.getString("price");
			 String address = rs.getString("address");
			 String type = rs.getString("type");
			 String details = rs.getString("details");
			 String image = rs.getString("image");

			 listings.add(new Listings(name, region, price, address, type, details, image));
			 }
			 } catch (SQLException e) {
			 System.out.println(e.getMessage());
			 }
			// Step 5.4: Set the users list into the listUsers attribute to be pass to the
			request.setAttribute("listListings", listings);
			request.getRequestDispatcher("/AttractionListings.jsp").forward(request, response);
			}

}

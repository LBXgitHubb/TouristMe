

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
 * Servlet implementation class ListingServlet
 */
@WebServlet("/ListingServlet")
public class ListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jdbcURL = "jdbc:mysql://localhost:3306/listingsdetails";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "T0214511H";
	 private static final String INSERT_LISTINGS_SQL = "INSERT INTO ListingsDetails" + " (name, region, price, address, type, details, image) VALUES " +
			  " (?, ?, ?, ?, ?, ?, ?);";
			  private static final String SELECT_LISTING_BY_ID = "select name,region,price,address,type,details,image from ListingsDetails where name =?";
			  private static final String SELECT_ALL_LISTINGS = "select * from ListingsDetails ";
			  private static final String DELETE_LISTINGS_SQL = "delete from ListingsDetails where name = ?;";
			  private static final String UPDATE_LISTINGS_SQL = "update ListingsDetails set name = ?,region= ?,price =?,address =?,type =?,details =?,image =? where name = ?;";
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
    public ListingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
			 switch (action) {
			 case "/ListingServlet/delete":
				 deleteListing(request, response);
			 break;
			 case "/ListingServlet/edit":
				 showEditForm(request, response);
			 break;
			 case "/ListingServlet/update":
				 updateListing(request, response);
			 case "/ListingServlet/dashboard":
			 listListings(request, response);
			 break;
			 }
			 } catch (SQLException ex) {
			 throw new ServletException(ex);
			 }
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
			request.getRequestDispatcher("/listingManagement.jsp").forward(request, response);
			}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String name = request.getParameter("name");
		Listings existingListing = new Listings("", "", "", "","","","");
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement =
						connection.prepareStatement(SELECT_LISTING_BY_ID);) {
						preparedStatement.setString(1, name);
						ResultSet rs = preparedStatement.executeQuery();
						while (rs.next()) {
							name = rs.getString("name");
							String region = rs.getString("region");
							String price = rs.getString("price");
							String address = rs.getString("address");
							String type = rs.getString("type");
							String details = rs.getString("details");
							String image = rs.getString("image");

							existingListing = new Listings(name, region, price, address, type, details, image);
							}
							} catch (SQLException e) {
							System.out.println(e.getMessage());
							}
		request.setAttribute("listing", existingListing);
		request.getRequestDispatcher("/ListingEdit.jsp").forward(request, response);
		}
	private void updateListing(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String oriName = request.getParameter("oriName");
		 String name = request.getParameter("name");
		 String region = request.getParameter("region");
		 String price = request.getParameter("price");
		 String address = request.getParameter("address");
		 String type = request.getParameter("type");
		 String details = request.getParameter("details");
		 String image = request.getParameter("image");

		 try (Connection connection = getConnection(); PreparedStatement statement =
				 connection.prepareStatement(UPDATE_LISTINGS_SQL);) {
				  statement.setString(1, name);
				  statement.setString(2, region);
				  statement.setString(3, price);
				  statement.setString(4, address);
				  statement.setString(5, type);
				  statement.setString(6, details);
				  statement.setString(7, image);
				  statement.setString(8, oriName);
				  int i = statement.executeUpdate();
				  }
		 response.sendRedirect("http://localhost:8090/TouristMe/ListingServlet/dashboard");
	}
	private void deleteListing(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		 String name = request.getParameter("name");
		 try (Connection connection = getConnection(); PreparedStatement statement =
				 connection.prepareStatement(DELETE_LISTINGS_SQL);) {
				  statement.setString(1, name);
				  int i = statement.executeUpdate();
				  }
		 response.sendRedirect("http://localhost:8090/TouristMe/ListingServlet/dashboard");
	}
}

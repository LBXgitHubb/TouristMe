

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
 * Servlet implementation class AdminListingsServlet
 */
@WebServlet("/AdminListingsServlet")
public class AdminListingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminListingsServlet() {
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
		PrintWriter out = response.getWriter();
		String n = request.getParameter("Name");
		String p = request.getParameter("Region");
		String e = request.getParameter("Price");
		String c = request.getParameter("Address");
		String d = request.getParameter("Attraction Type");
		String f = request.getParameter("Image");
		String g = request.getParameter("Details");
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection(
			 "jdbc:mysql://localhost:3306/listingsdetails", "root", "T0214511H");
			 PreparedStatement ps = con.prepareStatement("insert into LISTINGSDETAILS values(?,?,?,?,?,?,?)");
			 ps.setString(1, n);
			 ps.setString(2, p);
			 ps.setString(3, e);
			 ps.setString(4, c);
			 ps.setString(5, d);
			 ps.setString(6, f);
			 ps.setString(7, g);

			 int i = ps.executeUpdate();
			 if (i > 0){
				 PrintWriter writer = response.getWriter();
				 writer.println("<h1>" + "successfully registered an attraction" +
				 "</h1>");
				 writer.close();
				 }
			}
		catch (Exception exception) {
				 System.out.println(exception);

				 	out.close();
				}


		doGet(request, response);
	}

}

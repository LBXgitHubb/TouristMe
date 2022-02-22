

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession(); 
		
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		int status = 1;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/touristme", "root",
					"password");

			// Step 4: implement the sql query using prepared statement
			PreparedStatement ps = con.prepareStatement("SELECT userName, password from users where BINARY userName=? and BINARY password=?;");
			PreparedStatement qs = con.prepareStatement("UPDATE users SET status = ? WHERE userName = ?;");
			
			// Step 5: parse in the data retrieved from the web form request into the
			// prepared statement
			// accordingly

			ps.setString(1, userName);
			ps.setString(2, password);
		
			ResultSet re= ps.executeQuery();
			if(re.next()) {
				
				
			
				
				qs.setInt(1, status);
				qs.setString(2, userName);
				System.out.println(status);
				System.out.println(userName);
				int i = qs.executeUpdate();
				out.println(
						"Success");
				out.close();
				session.setAttribute("status", status);
				session.setAttribute("username",userName);
				//Step 3: redirect back to UserServlet (note: remember to change the url to your project name)
				response.sendRedirect("http://localhost:8090/TouristME/login.jsp");
				
				
			}else {
				out.println(
						"Failure");
				out.close();

			}
			
		} catch (Exception exception) {

			System.out.println(exception);
			out.close();
		}
	}

}

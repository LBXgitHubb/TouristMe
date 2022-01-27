

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts", "root",
					"password");

			// Step 4: implement the sql query using prepared statement
			PreparedStatement ps = con.prepareStatement("SELECT userName, password from users where BINARY userName=? and BINARY password=?;");
			// Step 5: parse in the data retrieved from the web form request into the
			// prepared statement
			// accordingly

			
			ps.setString(1, userName);
			ps.setString(2, password);
		
			ResultSet re= ps.executeQuery();
			if(re.next()) {
				
				
				PrintWriter writer = response.getWriter();
				writer.println(
						"<h1>" + "You have Successfully login!" + "<br>" + userName + "</h1>");
				writer.close();
				
			}else {
				PrintWriter writer = response.getWriter();
				writer.println(
						"<h1>" + "You had enter the wrong username or password" + "<br>" + userName + "</h1>");
				writer.close();
			}
			
		} catch (Exception exception) {

			System.out.println(exception);
			out.close();
		}
	}

}

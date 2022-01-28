
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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// get 4 parameter from web
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("re-password");
		String role = "admin";
		int status=0;

		if (password.equals("5YuVy5*-_z^G3j-5")) {
			if (password.equals(rePassword)) {

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts", "root",
							"password");

					PreparedStatement ps = con.prepareStatement("insert into USERS values(?,?,?,?)");

					ps.setString(1, userName);
					ps.setString(2, password);
					ps.setString(3, role);
					ps.setInt(4, status);

					int i = ps.executeUpdate();
					// Step 7: check if the query had been successfully execute, return “You are
					// successfully
					// registered” via the response,
					if (i > 0) {
						PrintWriter writer = response.getWriter();
						writer.println(
								"<h1>" + "You have successfully registered an account!" + "<br>" + userName + "</h1>");
						writer.close();
					}
				} catch (Exception exception) {

					System.out.println(exception);
					out.close();
				}
			} else {
				PrintWriter writer = response.getWriter();
				writer.println("<h1>" + "password does not match!" + "<br>" + userName + "</h1>");

				writer.close();
			}
		} else {
			PrintWriter writer = response.getWriter();
			writer.println("<h1>" + "You had Keyed in the wrong password!" + "<br>" + userName + "</h1>");

			writer.close();
		}

	}

}

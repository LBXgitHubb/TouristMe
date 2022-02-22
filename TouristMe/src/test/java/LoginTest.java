import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.commons.io.FileUtils;

/**
 * 
 */

/**
 * @author acer
 *
 */
class LoginTest {
	private LoginServlet login = new LoginServlet();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link LoginServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	
	
	
	@Test
	void Success() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getParameter("userName")).thenReturn("tim");
		when(request.getParameter("password")).thenReturn("5YuVy5*-_z^G3j-5");
		
		StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        try {
			when(response.getWriter()).thenReturn(writer);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		 try {
			login.doPost(request, response);
	        assertTrue(stringWriter.toString().contains("Success"));

		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		 

	}
	
	@Test
	void Failure() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getParameter("userName")).thenReturn("ttim");
		when(request.getParameter("password")).thenReturn("5YtuVy5*-_z^G3j-5");
		
		StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        try {
			when(response.getWriter()).thenReturn(writer);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		 try {
			login.doPost(request, response);
	        assertTrue(stringWriter.toString().contains("Failure"));

		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		 

	}

}

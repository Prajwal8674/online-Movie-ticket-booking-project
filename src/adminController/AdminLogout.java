package adminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdminLogout")
public class AdminLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        
			
			Cookie c = new Cookie("mail","");
			c.setMaxAge(0);
			response.addCookie(c);
			 out.print("<!DOCTYPE html>");
		        out.print("<html>");
		        out.print("<head>");
		        out.print("<meta charset='ISO-8859-1'>");
		        out.print("<title>Insert title here</title>");
		        out.print("<style>");
		        out.print("p{");
		        out.print("background-color: green;");
		        out.print("text-align:center;");
		        out.print("color:white;");
		        out.print("width:60%;");
		        out.print("}");
		        out.print("h2{");
		        out.print("color :red;");
		        out.print("text-align:center;");
		        out.print("width:60%;");
		        out.print("display: flex;");
		        out.print("position:relative;");
		        out.print("top : 20px;");
		        out.print("}");
		        out.print("</style>");
		        out.print("</head>");
		        out.print("<body>");
		        out.print("<marquee scrollamount='12'><h2><p> Logout Successful !! Please Login</p></h2></marquee>");
		        out.print("</body>");
		        out.print("</html>");				        
		        request.getRequestDispatcher("admin.html").include(request, response);	
		        out.print("You are successfully logged out!");  
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

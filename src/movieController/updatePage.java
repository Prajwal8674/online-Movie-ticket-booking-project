package movieController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movieModel.MovieDao;
import movieModel.pojo;


@WebServlet("/updatePage")
public class updatePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        int id= Integer.parseInt(request.getParameter("id"));
        pojo p = null;

        try {
			p= new MovieDao().getOneUser(id)  ;
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
        if( p!=null){
        	 out.println("<!DOCTYPE html>");
             out.println("<html>");
             out.println("<head>");
             out.println("<title>Movie Ticket Booking</title>");
             out.println("<style>");
             out.println("body {");
             out.println("    font-family: Arial, sans-serif;");
             out.println("    margin: 0;");
             out.println("    padding: 0;");
             out.println("    background-image: url(\"img/bg.webp\");");
             out.println("    background-size: cover;");
             out.println("    background-repeat: no-repeat;");
             out.println("}");
             out.println("header {");
             out.println("    background-color: #333;");
             out.println("    color: #fff;");
             out.println("    padding: 20px;");
             out.println("    text-align: center;");
             out.println("}");
             out.println("h1 {");
             out.println("    margin: 0;");
             out.println("}");
             out.println(".container {");
             out.println("    max-width: 800px;");
             out.println("    margin: 20px auto;");
             out.println("    padding: 20px;");
             out.println("    border: 1px solid #333;");
             out.println("    background-color: white;");
             out.println("}");
             out.println("label {");
             out.println("    display: block;");
             out.println("    margin-bottom: 10px;");
             out.println("}");
             out.println("input[type=\"text\"], input[type=\"number\"], select {");
             out.println("    width: 98%;");
             out.println("    padding: 8px;");
             out.println("    margin-bottom: 20px;");
             out.println("}");
             out.println("button {");
             out.println("    padding: 10px 20px;");
             out.println("    background-color: #333;");
             out.println("    color: #fff;");
             out.println("    border: none;");
             out.println("    cursor: pointer;");
             out.println("}");
             out.println("button:hover {");
             out.println("    background-color: #555;");
             out.println("}");
             out.println("/* Basic styling for the navigation bar */");
             out.println("ul.navbar {");
             out.println("    list-style-type: none;");
             out.println("    margin: 0;");
             out.println("    padding: 0;");
             out.println("    overflow: hidden;");
             out.println("    background-color: #333;");
             out.println("    box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.3);");
             out.println("}");
             out.println("li.navitem {");
             out.println("    float: left;");
             out.println("}");
             out.println("li.navitem a {");
             out.println("    display: block;");
             out.println("    color: white;");
             out.println("    text-align: center;");
             out.println("    padding: 16px;");
             out.println("    text-decoration: none;");
             out.println("    transition: background-color 0.3s ease;");
             out.println("}");
             out.println("li.navitem a:hover {");
             out.println("    background-color: #111;");
             out.println("}");
             out.println("/* Add some more attractive styles */");
             out.println("li.navitem a.active {");
             out.println("    background-color: #4CAF50;");
             out.println("}");
             out.println("li.navitem:hover {");
             out.println("    background-color: #111;");
             out.println("}");
             out.println("li.navitem:hover a {");
             out.println("    color: #fff;");
             out.println("}");
             out.println("/* Responsive styles */");
             out.println("@media screen and (max-width: 600px) {");
             out.println("    ul.navbar {");
             out.println("        position: relative;");
             out.println("    }");
             out.println("    li.navitem {");
             out.println("        float: none;");
             out.println("        display: inline-block;");
             out.println("    }");
             out.println("    li.navitem a {");
             out.println("        display: block;");
             out.println("        text-align: center;");
             out.println("        width: 100%;");
             out.println("        padding: 10px;");
             out.println("    }");
             out.println("}");
             out.println("</style>");
             out.println("</head>");
             out.println("<body>");
             out.println("<ul class=\"navbar\">");
             out.println("<li class=\"navitem\"><a class=\"\" href=\"HomeAdmin.html\">Home</a></li>");
             out.println("<li class=\"navitem\"><a class=\"active\"href=\"http://localhost:8084/MyWeb/showMoviesForAdmin\">Show Movies</a></li>");
             out.println("<li class=\"navitem\"><a href=\"http://localhost:8084/MyWeb/showUsers\">Show Users</a></li>");
             out.println("<li class=\"navitem\"><a href=\"http://localhost:8084/MyWeb/uploadMovies\">Upload Movies</a></li>");
             out.println("<li class=\"navitem\"><a href=\"http://localhost:8084/MyWeb/AdminLogout\">Log Out</a></li>");
             out.println("</ul>");
             out.println("<div class=\"container\">");
             out.println("<form action=\"updateMovie\" method=\"get\">");
             out.println("<label for=\"movieName\"> id:</label>");
             out.println("<input type=\"text\"  name=\"id\" placeholder=\"Enter Movie Name\"  readonly value="+p.getid()+" >");

             
             out.println("<label for=\"movieName\">Movie Name:</label>");
             out.println("<input type=\"text\"name=\"movieN\" placeholder=\"Enter Movie Name\" value="+p.getMovieN()+">");
             
             out.println("<label for=\"price\">Price:</label>");
             out.println("<input type=\"number\"  name=\"price\" placeholder=\"Enter Price\"value="+p.getPrice()+">");
             
             out.println("<label for=\"actors\">Actors:</label>");
             out.println("<input type=\"text\"  name=\"actor\" placeholder=\"Enter Actors\"value="+p.getActor()+">");
             
             out.println("<label for=\"directors\">Director:</label>");
             out.println("<input type=\"text\" name=\"director\" placeholder=\"Enter Directors\"value="+p.getDirector()+">");
        
             out.println("<button type=\"submit\">UPDATE</button>");
          
             out.println("</form>");
             out.println("</div>");
             out.println("</body>");
             out.println("</html>");
     	
        	
        }
       
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

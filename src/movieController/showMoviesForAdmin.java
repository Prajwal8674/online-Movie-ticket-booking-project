package movieController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movieModel.MovieDao;
import movieModel.pojo;

@WebServlet("/showMoviesForAdmin")
public class showMoviesForAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		/*int pageID = Integer.parseInt(request.getParameter("page"));
		int start = pageID;
		
		
		int total = 5;
		if(start==1){}
		else{
			start-=1;
			start= start*total+1;
		}*/
		
		
		MovieDao md = new MovieDao();

		Cookie c[]=request.getCookies();
		
		
		if(c!=null){
			String email= c[0].getValue();
			if(!email.equals("")||email!=null){
				
				try {
					ArrayList<pojo> p = md.getallMovies();
					 out.println("<!DOCTYPE html>");
				        out.println("<html>");
				        out.println("<head>");
				        out.println("<style>");
				        ///navbar
				        
				        out.println("/* Basic styling for the navigation bar */");
				        out.println("body {");
				        out.println("    font-family: Arial, sans-serif;");
				        out.println("    margin: 0;");
				        out.println("    padding: 0;");
				        out.println("    background-image: url(\"img/bg.webp\");");
				        out.println("    background-size: cover;");
				        out.println("    background-repeat: no-repeat;");
				        out.println("}");
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
				        out.println("li.navitem a.active {");
				        out.println("    background-color: #4CAF50;");
				        out.println("}");
				        out.println("li.navitem:hover {");
				        out.println("    background-color: #111;");
				        out.println("}");
				        out.println("li.navitem:hover a {");
				        out.println("    color: #fff;");
				        out.println("}");
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
				        // css
				        out.println("body {");
				        out.println("    margin: 0;");
				        out.println("    padding: 0;");
				        out.println("    background-image: url('img/bg.webp');");
				        out.println("    background-size: cover;");
				        out.println("    background-repeat: no-repeat;");
				        out.println("}");
				        out.println(".table-container {");
				        out.println("    display: flex;");
				        out.println("    justify-content: center;");
				        out.println("    align-items: flex-start;");
				        out.println("    height: 100vh;");
				        out.println("}");
				        out.println("table {");
				        out.println("    width: 80%;");
				        out.println("    table-layout: fixed; /* Set fixed table layout */");
				        out.println("    border-collapse: collapse;");
				        out.println("}");
				        out.println("th, td {");
				        out.println("    padding: 12px;");
				        out.println("    text-align: left;");
				        out.println("    border-bottom: 1px solid #ddd;");
				        out.println("    font-family: Arial, sans-serif;");
				        out.println("}");
				        out.println("th {");
				        out.println("    background-color: #f2f2f2;");
				        out.println("    color: #333;");
				        out.println("    font-weight: bold;");
				        out.println("}");
				        out.println("td {");
				        out.println("    background-color: #fff;");
				        out.println("    color: #555;");
				        out.println("    vertical-align: middle; /* Align buttons vertically */");
				        out.println("}");
				        out.println("tr:nth-child(even) td {");
				        out.println("    background-color: #f9f9f9;");
				        out.println("}");
				        out.println("tr:hover td {");
				        out.println("    background-color: #ebebeb;");
				        out.println("}");
				        out.println(".button1 {");
				        out.println("    padding: 8px 12px;");
				        out.println("    border: none;");
				        out.println("    background-color: #4CAF50;");
				        out.println("    color: #fff;");
				        out.println("    text-align: center;");
				        out.println("    text-decoration: none;");
				        out.println("    display: inline-block;");
				        out.println("    font-size: 14px;");
				        out.println("    border-radius: 4px;");
				        out.println("    cursor: pointer;");
				        out.println("    transition: transform 0.2s;");
				        out.println("}");
				        out.println(".button1:active {");
				        out.println("    transform: scale(0.95);");
				        out.println("}");
				        out.print(".button-container {");
				        out.print("    display: flex;");
				        out.print("}");
				        out.print(".button-container a {");
				        out.print("    margin-right: 10px;");
				        out.print("}");
				        out.println(".pagination {");
				        out.println("display: flex;");
				        out.println("justify-content: center;");
				        out.println("margin-top: 20px; /* Adjust margin at the top */");
				        out.println("}");

				        out.println(".pagination button {");
				        out.println("margin: 0 5px;");
				        out.println("padding: 5px 10px;");
				        out.println("background-color: #f2f2f2;");
				        out.println("border: none;");
				        out.println("cursor: pointer;");
				        out.println("transition: background-color 0.2s;");
				        out.println("}");

				        out.println(".pagination button:hover {");
				        out.println("background-color: #ddd;");
				        out.println("}");

				        out.println(".pagination button.active {");
				        out.println("background-color: #4CAF50;");
				        out.println("color: #fff;");
				        out.println("}");
				        out.println("</style>");
				        out.println("</head>");
				        out.println("<body>");
				        out.println("<ul class=\"navbar\">");
				        out.println("<li class=\"navitem\"><a  href=\"HomeAdmin.html\">Home</a></li>");
				        out.println("<li class=\"navitem\"><a class=\"active\" href=\"http://localhost:8084/MyWeb/showMoviesForAdmin\">Show Movies</a></li>");
				        out.println("<li class=\"navitem\"><a href=\"\">Show Users</a></li>");
				        out.println("<li class=\"navitem\"><a href=\"upload.html\">Upload Movies</a></li>");
				        out.println("<li class=\"navitem\"><a href=\"http://localhost:8084/MyWeb/AdminLogout\">Log Out</a></li>");
				        out.println("</ul>");
				        out.println("<div class=\"table-container\">");
				        out.println("<table>");
				        out.println("<caption style=\"color:white;\"><h1>MOVIES LIST</h1></caption>");
				        out.println("<colgroup>");
				        out.println("<col style=\"width: 10%;\">");
				        out.println("<col style=\"width: 20%;\">");
				        out.println("<col style=\"width: 20%;\">");
				        out.println("<col style=\"width: 20%;\">");
				        out.println("<col style=\"width: 10%;\">");
				        out.println("<col style=\"width: 18%;\">");
				        out.println("</colgroup>");
				        out.println("<tr>");
				        out.println("<th>SERIAL NO</th>");
				        out.println("<th>MOVIE NAME</th>");
				        out.println("<th>ACTORS</th>");
				        out.println("<th>DIRECTOR</th>");
				        out.println("<th>TICKET PRICE</th>");
				        out.println("<th>ACTION</th>");
				        out.println("</tr>");
				        
				        for(pojo pp : p){
				        	out.println("<tr>");
				            out.println("<td>"+pp.getid()+"</td>");
				            out.println("<td>"+pp.getMovieN()+"</td>");
				            out.println("<td>"+pp.getActor()+"</td>");
				            out.println("<td>"+pp.getDirector()+"</td>");
				            out.println("<td>"+pp.getPrice()+"</td>");
				            out.println("<td>");
				            
				            out.print("<div class=\"button-container\">");
				            out.print("<a href=\"#\"><button class=\"button1\">UPDATE</button></a>");
				            out.print("<a href=\"#\"><button class=\"button1\">DELETE</button></a>");
				            out.print("</div>");


				            out.println("</td>");
				            out.println("</tr>");
				            
				        }
				        out.println("</table>");
				        out.println("</div>");
				        
				        out.println("<div class='pagination'>");
				        
				       /* if(pageID==1){
					        out.println("<button class='active'>Button 1</button>");
					        out.println("<a href='home?page=1'>1</a></li");
		 	
				        }
				        if(pageID==2){
					        out.println("<button class='active'>Button 2</button>");
					        out.println("<a href='home?page=2'>2</a></li");
		 	
				        }
				        if(pageID==3){
					        out.println("<button class='active'>Button 3</button>");
					        out.println("<a href='home?page=3'>3</a></li");
		 	
				        }*/
				        out.println("</div>");
				               
				        out.println("</body>");
				        out.println("</html>");


				} 
				
				
				catch (ClassNotFoundException | SQLException e) {

					e.printStackTrace();
				}
				
			}
			
		}
		else{
            request.getRequestDispatcher("signIn.html").include(request, response);  

		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

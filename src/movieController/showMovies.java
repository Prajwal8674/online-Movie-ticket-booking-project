package movieController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movieModel.MovieDao;
import movieModel.pojo;


@WebServlet("/movieList")
public class showMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		
		MovieDao md = new MovieDao();
		try {
			ArrayList<pojo> p = md.getallMovies();
			 out.println("<!DOCTYPE html>");
		        out.println("<html>");
		        out.println("<head>");
		        out.println("<style>");
		        
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
		        ///css
		        out.println("</style>");
		        out.println("</head>");
		        out.println("<body>");
		        out.println("<div class=\"table-container\">");
		        out.println("<table>");
		        out.println("<caption style=\"color:white;\"><h1>MOVIES LIST</h1></caption>");
		        out.println("<colgroup>");
		        out.println("<col style=\"width: 20%;\">");
		        out.println("<col style=\"width: 20%;\">");
		        out.println("<col style=\"width: 20%;\">");
		        out.println("<col style=\"width: 20%;\">");
		        out.println("<col style=\"width: 10%;\">");
		        out.println("<col style=\"width: 10%;\">");
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
		            out.println("<a href=\"buyTickets.html\"><button class=\"button1\">BUY TICKETS</button></a>");
		            out.println("</td>");
		            out.println("</tr>");
		        }
		        out.println("</table>");
		        out.println("</div>");
		        out.println("</body>");
		        out.println("</html>");


		} 
		
		
		catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		
	

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}

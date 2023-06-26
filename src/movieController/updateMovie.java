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


@WebServlet("/updateMovie")
public class updateMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        int id= Integer.parseInt(request.getParameter("id"));

	        	String movieN = request.getParameter("movieN");
			    String actor = request.getParameter("actor");
				String director= request.getParameter("director");
		  		String price = request.getParameter("price");
	        
	        
	        pojo p= new pojo(id, movieN, actor, director, price);
	        
	        System.out.println(movieN);
	        try {
		        int a= new MovieDao().upMovie(p);
		        System.out.println(movieN);

				if(a>0){
					
					response.sendRedirect("showMoviesForAdmin");
				}
				
			} 
	        
	        catch (ClassNotFoundException | SQLException e)
	        {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        

	       
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

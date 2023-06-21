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


@WebServlet("/HomeAdmin")
public class uploadMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();	
	    String movieN = request.getParameter("movieN");
		String actor = request.getParameter("actor");
			String director= request.getParameter("director");
	  		String price = request.getParameter("price");

	  		System.out.println(movieN);
	  		System.out.println(actor);
	  		System.out.println(director);
	  		System.out.println(price);
	  		
	  	MovieDao md = new MovieDao();
	  	pojo p = new pojo(movieN, actor, director, price);
	  	
	  	try {
			md.addMovie(p);
	        request.getRequestDispatcher("/showMovies").include(request, response);	
		    

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	  	
	  	

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

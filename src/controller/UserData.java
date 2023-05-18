package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDao;
import model.pojo;


@WebServlet("/Userdata")
public class UserData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
    PrintWriter out = response.getWriter();	
    
    String uname = request.getParameter("uname");
	String dob = request.getParameter("dob");
		String ugen= request.getParameter("ugen");

  		String uemail = request.getParameter("uemail");
  		String upass = request.getParameter("upass");
  		String cupass = request.getParameter("cupass");
  		
  		System.out.println(uname);
  		System.out.println(dob);
  		System.out.println(ugen);
  		System.out.println(uemail);
  		System.out.println(upass);
  		System.out.println(cupass);
  		
  		uname.trim();
  		dob.trim();
  		ugen.trim();
		uemail.trim(); 
		upass.trim();
		cupass.trim();

  		UserDao ud = new UserDao();
  		pojo p = new pojo(uname,ugen,dob,uemail,upass);
  		
  		
  		try {
  			if(!ud.checkUser(uemail)){
				 if (upass.equals(cupass)) {	  
					    ud.addData(p); 
				        System.out.println("Added Successfullly !!");
				        out.print("Registeration successful !! please login");
				        request.getRequestDispatcher("signIn.html").include(request, response);	

				  } 
				  else if (!upass.equals(cupass))

					{
						request.getRequestDispatcher("signUp.html").include(request, response);
						out.print("Enter Both Passwords Same !");
					}
  			}
  			else if(ud.checkUser(uemail)){
  				out.print("YOUR EMAIL IS ALREADY EXIST PLEASE LOGIN !!");
		        request.getRequestDispatcher("signIn.html").include(request, response);			  
  			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
  		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

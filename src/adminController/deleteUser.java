package adminController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminModel.adminDao;


@WebServlet("/delete")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();

int id= Integer.parseInt(request.getParameter("id"));
String pid = request.getParameter("pid");

adminDao ad = new adminDao();

try {
	int a= ad.delById(id);
	if (a>0){
		System.out.print(" User deleted");
		response.sendRedirect("showUsers");
	}
}

catch (ClassNotFoundException | SQLException e) 

{

	e.printStackTrace();
}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

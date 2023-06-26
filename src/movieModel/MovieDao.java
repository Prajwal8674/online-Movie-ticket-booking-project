package movieModel;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import movieModel.pojo;

public class MovieDao {
	String driver = "com.mysql.jdbc.Driver";
	String dbName = "onlinemovietickets";
	String url    = "jdbc:mysql://localhost:3306/"+dbName;
	String dbname ="root";
	String dbpass = "admin01";
	
Connection getConnect() throws ClassNotFoundException, SQLException{
		
		Class.forName(driver);
		return  (Connection) DriverManager.getConnection(url,dbname,dbpass);
	}
    public int addMovie(pojo p) throws ClassNotFoundException, SQLException{
	String sql = "insert into movies (movie,actors,director,price) values(?,?,?,?)";
	Connection con = getConnect();
	PreparedStatement  ps = con.prepareStatement(sql);
	
	ps.setString(1, p.getMovieN());
	ps.setString(2, p.getActor());
	ps.setString(3, p.getDirector());
	ps.setString(4, p.getPrice());

	
	int a = ps.executeUpdate();
	con.close();
	
	 return a;
}
    public ArrayList<pojo> getallMovies() throws ClassNotFoundException, SQLException{
    	String sql = "select * from movies";
    	Connection con = getConnect();
    	Statement  s = (Statement) con.createStatement();
    	ResultSet rs = s.executeQuery(sql);
    	ArrayList<pojo> showMovie =new ArrayList<>();
    	
    	while(rs.next()){
    		
    		pojo p = new pojo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
    		showMovie.add(p);
    	}
    	con.close();

		return showMovie;	
    }
    
    public int upMovie(pojo p) throws ClassNotFoundException, SQLException{
    	String sql = "UPDATE movies SET movie=?,actors=?,director=?,price=? WHERE id=?";
    	Connection con = getConnect();
    	PreparedStatement  ps = con.prepareStatement(sql);
    	
    	ps.setString(1, p.getMovieN());
    	ps.setString(2, p.getActor());
    	ps.setString(3, p.getDirector());
    	ps.setString(4, p.getPrice());
    	ps.setInt(5, p.getid());
    	
    	int a = ps.executeUpdate();
    	con.close();
    	return a;
    }
    
    
    public pojo getOneUser(int id) throws ClassNotFoundException, SQLException {
    	Connection con = getConnect();
	
		 PreparedStatement ps = con.prepareStatement("SELECT * FROM movies WHERE id=?");
		 ps.setInt(1,id);
		
		ResultSet rs = ps.executeQuery();
		rs.absolute(1);
		pojo p = new pojo(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		return p;
	}

}

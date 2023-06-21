package movieModel;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

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
    	String sql = "select from movies";
    	Connection con = getConnect();
    	PreparedStatement  ps = con.prepareStatement(sql);
    	ResultSet rs = ps.executeQuery();
    	ArrayList<pojo> showMovie =new ArrayList<>();
    	
    	while(rs.next()){
    		
    		pojo p = new pojo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
    		showMovie.add(p);
    	}
    	con.close();

		return showMovie;
    	
    }

}

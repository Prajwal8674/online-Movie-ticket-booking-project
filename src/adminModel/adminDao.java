package adminModel;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


public class adminDao {
	String driver = "com.mysql.jdbc.Driver";
	String dbName = "onlinemovietickets";
	String url    = "jdbc:mysql://localhost:3306/"+dbName;
	String dbname ="root";
	String dbpass = "admin01";
	
	Connection getConnect() throws ClassNotFoundException, SQLException{
		
		Class.forName(driver);
		return  (Connection) DriverManager.getConnection(url,dbname,dbpass);
	}
	
	public int addData(pojo p) throws ClassNotFoundException, SQLException{
		String sql = "insert into admindata (username,gender,birthDate,email,password) values(?,?,?,?,?)";
		Connection con = getConnect();
		PreparedStatement  ps = con.prepareStatement(sql);
		
		ps.setString(1, p.getUname());
		ps.setString(2, p.getUgen());
		ps.setString(3, p.getUdob());
		ps.setString(4, p.getUemail());
		ps.setString(5, p.getUpass());

		int a = ps.executeUpdate();
		con.close();
		
		 return a;
	}
	
	public boolean checkUser(String email) throws SQLException, ClassNotFoundException{
		Class.forName(driver) ;
		Connection con =(Connection) DriverManager.getConnection(url,dbname,dbpass);
		PreparedStatement ps = con.prepareStatement("select * from admindata where email=?");
		ps.setString(1, email) ;
		ResultSet rs = ps.executeQuery() ;
		
		if(rs.absolute(1))
			return true;
			
			con.close() ;
			return false;						
}
}
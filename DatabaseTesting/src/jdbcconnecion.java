import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class jdbcconnecion {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//  "jdbc:mysql://"+host+":"+port+"/databasename";
		String host = "localhost";
		String port = "3306";
		//String databasename = "qadbt";
		String url = "jdbc:mysql://"+host+":"+port+"/qadbt";
		Connection con =DriverManager.getConnection(url, "root", "admin"); // should import java.sql.connection
		
		System.out.println("DB connected");
		
		Statement s = con.createStatement(); // import java.sql
		ResultSet rs = s.executeQuery("select * from Employeeinfo where id =3"); //import resutSet
		
		
		//=============================//
		while (rs.next()){
			
		
		//=============================//
		System.out.println(rs.getString("name"));
		System.out.println(rs.getString("location"));
		System.out.println(rs.getString("id"));
		System.out.println(rs.getString("age"));
		
		}
	}

}

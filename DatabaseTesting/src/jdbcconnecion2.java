import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class jdbcconnecion2 {

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
		ResultSet rs = s.executeQuery("select * from LoginInfo;"); //import resutSet
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Dev\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("http://www.spicejet.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://login.salesforce.com");
		
		//=============================//
		while (rs.next()){
			
		driver.findElement(By.id("username")).sendKeys(rs.getString("username"));  //rs.getString('username')
		driver.findElement(By.id("password")).sendKeys(rs.getString("id"));  //rs.getString('id')
		
		//=============================//
		//System.out.println(rs.getString("username"));
		//System.out.println(rs.getString("id"));
		// output     kimr01;rk550221/akim; mk970902
		//=============================//
		
		
		}
	}

}

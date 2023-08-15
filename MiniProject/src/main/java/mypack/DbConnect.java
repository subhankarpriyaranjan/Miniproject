package mypack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public final class DbConnect{
	public static Statement getStatement()
	{
		Connection con=null;
		Statement st=null;
		try
		{
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","subhankar");
		st=con.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return st;
}

}

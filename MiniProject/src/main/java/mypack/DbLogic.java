package mypack;
import java.sql.*;
public class DbLogic {
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	public ResultSet RetLogin(String username,String password,String usertype)throws SQLException,ClassNotFoundException{
		
		rs=DbConnect.getStatement().executeQuery("select * from login1 where username='"+username+"'and password='"+password+"'and usertype='"+usertype+"'");
		return rs;
		
	}
	
	
	public ResultSet RetUser()throws SQLException,ClassNotFoundException
	{
		rs=DbConnect.getStatement().executeQuery("select * from login1 where usertype='user'");
		return rs;
		
	}
	
	
	public  ResultSet SelectUser(Long userid)throws SQLException,ClassNotFoundException
	{
		
		rs=DbConnect.getStatement().executeQuery("select l.loginid,l.username,s.name,s.ADDRESS,s.age,s.sex,s.phno from login1 l,studentinfo s where l.loginid=s.loginid and l.loginid="+userid+"");
		return rs;
		
	}
	
	public int ApprovedUser(Long id)throws SQLException,ClassNotFoundException
	{
		int i=DbConnect.getStatement().executeUpdate("update login1 set userstatus='approved'where loginid="+id+"");
		return i;
	}
	public int RejectUser(Long id)throws SQLException,ClassNotFoundException
	{
		int i=DbConnect.getStatement().executeUpdate("delete from login1 where loginid="+id+"");
		return i;
		
	}
	public int RegisterStudent(String username,String password,String name,String address,Long age,String sex,Long phone)throws SQLException
	{
		int i=0;
		@SuppressWarnings("unused")
		int j=0;
		
		 i= DbConnect.getStatement().executeUpdate("insert into LOGIN1 values(LOGIN1_SEQ.nextval,'"+username+"','"+password+"','user','notapproved')");
		 j=DbConnect.getStatement().executeUpdate("insert into STUDENTINFO values(STUDENTINFO_SEQ.nextval,'"+name+"','"+address+"',"+age+",'"+sex+"',"+phone+",LOGIN1_SEQ.nextval-1)");
			
		
		return i;
	}
	public ResultSet ViewOwn(Long loginid)throws SQLException
	{
		rs=DbConnect.getStatement().executeQuery("select l.loginid,l.username,s.name,s.address,s.age,s.sex,s.phno from login1 l,studentinfo s where l.loginid=s.loginid and l.loginid="+loginid+"");
		return rs;
	}
	public int updateAcc(String name,String address,Long age,String sex,Long phone,Long userid)throws SQLException
	{
		int i=DbConnect.getStatement().executeUpdate("update studentinfo set name='"+name+"',address='"+address+"',age="+age+",sex='"+sex+"',phno="+phone+" where loginid="+userid+"");
		return i;
	}
	}

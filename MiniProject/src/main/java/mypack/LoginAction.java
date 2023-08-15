package mypack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	private String username;
	private String password;
	private String usertype;
	private String msg;
	private String studid;
	private String name;
	private String address;
	private Long age;
	private Long phone;
	private String sex;
	private Long userid;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	private Map<Integer, String> mapForSelect;
	Map session;

	public String getUsername() {

		return username;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	public String getPassword() {
		return password;

	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getMsg() {
		return msg;

	}

	public void setMsg(String msg) {
		this.msg = msg;

	}

	public String getStudid() {
		return studid;
	}

	public void setStudid(String studid) {
		this.studid = studid;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {

		return name;

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;

	}

	public void setAddres(String address) {
		this.address = address;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;

	}

	public Map<Integer, String> getMapForSelect() {
		return mapForSelect;

	}

	public void setMapForSelect(Map<Integer, String> mapForSelect) {
		this.mapForSelect = mapForSelect;

	}

	@SuppressWarnings("rawtypes")
	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	DbLogic dl = new DbLogic();

	public String RegisterData() throws Exception {
		int i = 0;
		i = dl.RegisterStudent(getUsername(), getPassword(), getName(), getAddress(), getAge(), getSex(), getPhone());
		reset();
		setMsg("Resister Succcesfull");
		return "registersuccess";
	}
	
	
	

	private int loginAttempts = 0;
	private long lastLoginTime = 0;
	private static final long BLOCK_DURATION = 60000; // 1 minute in milliseconds

	public String LoginData() throws SQLException, ClassNotFoundException {
		//For Block User After Attempting 3 times
	    long currentTime = System.currentTimeMillis();

	    if (currentTime - lastLoginTime > BLOCK_DURATION) {
	        // Reset login attempts if the block duration has expired
	        loginAttempts = 0;
	    }

	    if (loginAttempts >= 3) {
	        long remainingTime = (lastLoginTime + BLOCK_DURATION - currentTime) / 1000; // Remaining time in seconds
	        setMsg("Your account is blocked for " + remainingTime + " seconds");
	        return "loginfail";
	    }

	    //---------------------
	    ResultSet rs = dl.RetLogin(username, password, usertype);
	    if (rs.next()) {
	        String status = rs.getString("userstatus");
	        if (usertype.equals("admin")) {
	            return "admin";
	        }
	        if (status.equals("approved")) {
	            Map<String, Object> session = ActionContext.getContext().getSession();
	            session.put("LOGINID", rs.getString(1));

	            // Reset login attempts and update last login time
	            loginAttempts = 0;
	            lastLoginTime = currentTime;

	            return "user";
	        } else {
	            setMsg("Waiting for Approval");
	            return "loginfail";
	        }
	    } else {
	        loginAttempts++;
	        setMsg("Incorrect password");
	        if (loginAttempts >= 3) {
	            lastLoginTime = currentTime;
	        }
	        return "loginfail";
	    }
	}



	
	
	public String viewAccount() throws SQLException, ClassNotFoundException {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String id = (String) session.get("LOGINID");
		Long loginid = Long.parseLong(id);
		ResultSet rs = dl.ViewOwn(loginid);
		if (rs.next()) {
			setUsername(rs.getString(1));

			setName(rs.getString(3));
			setAddres(rs.getString(4));
			setAge(rs.getLong(5));
			setSex(rs.getString(6));
			setPhone(rs.getLong(7));
		}
		return "view";

	}

	public String UpdateAction() throws SQLException, ClassNotFoundException {
		Long userid = Long.parseLong(getUsername());
		int i = dl.updateAcc(getName(), getAddress(), getAge(), getSex(), getPhone(), userid);
		setMsg("Upadte Successfull");
		return "update";
	}

	public String UserMgt() throws SQLException, ClassNotFoundException {
		mapForSelect = new HashMap<Integer, String>();
		ResultSet rs = dl.RetUser();
		while (rs.next())
			mapForSelect.put(rs.getInt(1), rs.getString(2));
		return "viewuser";
	}

	public String selectUser() throws SQLException, ClassNotFoundException {
		ResultSet rs = dl.SelectUser(getUserid());
		@SuppressWarnings("unused")
		LoginAction la = new LoginAction();
		if (rs.next()) {
			// setUsername(rs.getString(1));
			setUsername(rs.getString(2));
			setName(rs.getString(3));
			setAddres(rs.getString(4));
			setAge(rs.getLong(5));
			setSex(rs.getString(6));
			setPhone(rs.getLong(7));

		}
		return "displayuser";
	}

	public String Approved() throws SQLException, ClassNotFoundException {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		Long id = Long.parseLong(request.getParameter("id"));
		int i = dl.ApprovedUser(id);
		if (i > 0) {
			return UserMgt();
		}
		return null;

	}

	public String Reject() throws SQLException, ClassNotFoundException {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		Long id = Long.parseLong(request.getParameter("id"));
		int i = dl.RejectUser(id);
		if (i > 0) {
			return UserMgt();
		}
		return null;
	}

	public void reset() {
		this.username = "";
		this.password = "";
		this.name = "";
		this.address = "";
		this.age = null;
		this.phone = null;
		this.sex = "";

	}
}

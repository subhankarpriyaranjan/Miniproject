<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'home.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body bgcolor='orange'>
    <center><h1>Interface Software</h1>
    </center>
    <hr/>
    <center>
    <table>
    <s:form action="LoginAction">
    <tr><td><s:textfield name="username" label="User Name"/></td></tr>
    <tr><td><s:password name="password" label="Password"></s:password></td></tr>
    <tr><td><s:radio name="usertype" label="User Type" list="{'admin','user'}"></s:radio></td></tr>
    <tr><td colspan="2" align="right"><s:submit value="Login"></s:submit></td></tr>
    <tr><td><font color="red"><s:property value="msg"/></font></td></tr>
    </s:form>
  
    </table>
    </center>
   <center>   <a href="newuser.jsp">New User</a> </center>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mypack.LoginAction"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'displayuser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body bgcolor='red'>
  <h1>Interface Software</h1>
   <hr/> 
   <a href="home.jsp">HOME</a>
   <br/> <br/> <br/>
   <center>
   <table border="l">
   <tr>
   <td>User name</td>
   <td>Name</td>
   <td>Address</td>
   <td>Age</td>
   <td>Sex</td>
   <td>Phone</td>
   <td>Approved</td>
   <td>Reject</td></tr>
   <tr>
   <td><s:property value="username"></s:property></td>
   <td><s:property value="name"></s:property></td>
   <td><s:property value="address"></s:property></td>
   <td><s:property value="age"></s:property></td>
   <td><s:property value="sex"></s:property></td>
   <td><s:property value="phone"></s:property></td>
   <td>
   <s:url id="approvedURL" action="approvedUser">
   <s:param name="id" value="%{userid}"></s:param>
   </s:url>
   <s:a href="%{approvedURL}">Approved</s:a>
   </td>
  <td><s:url id="rejectURL" action="RejectUser">
  <s:param name="id" value="%{userid}"></s:param>
  </s:url>
  <s:a href="%{rejectURL}">Reject</s:a></td></tr>
  </table>
   </center>
  </body>
</html>

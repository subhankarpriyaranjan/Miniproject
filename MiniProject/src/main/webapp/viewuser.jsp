<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminhome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body bgcolor='red'>
  
    <h1>Inteface Software</h1> <br>
    <hr/>
    <a href="home.jsp">HOME</a>
    <br/>
    <center>
   <s:form action="SelectUser">
  <s:select label="Select User" name="userid" list="mapForSelect" headerKey="-l" headerValue="--Please Select--" />
  <s:submit value="Show" />
</s:form>

    </center>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewownaccount.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body bgcolor='pink'>
      <h1>Interface Software</h1>
      <hr/>
      <a href="home.jsp">HOME</a>
      <center>
      <table>
      <s:form action="UpdateAction">
      <s:hidden name="userid"></s:hidden>
      <tr><td><s:textfield name="username" lable="User Name" readonly="true"/></td></tr>
       <tr><td><s:textfield name="name" lable="Name"/></td></tr>
        <tr><td><s:textarea name="address" lable="address"/></td></tr>
         <tr><td><s:textfield name="age" lable="Age" /></td></tr>
          <tr><td><s:radio name="sex" lable="Sex" list="{'Male','Female'}"/></td></tr>
           <tr><td><s:textfield name="phone" lable="Phone No"/></td></tr>
           <tr><td colspan="2" align="right">
           <s:submit value="UPDATE"></s:submit></td></tr>
           <tr><td><font color="red"><s:property value="msg"/></font></td></tr>
      </s:form>
      </table></center>
  </body>
</html>

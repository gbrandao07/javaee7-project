<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Page</title>
</head>
<body>
	<h1>JSP Page</h1>
	<%System.out.println("Exemplo de texto exibido via scriptlet");%>
	<br />
	<jsp:useBean id="mJSPBean" class="br.com.javaee7.bean.JSPBean"/>
	<jsp:setProperty property="text" name="mJSPBean" param="urlParam"/>
	<jsp:getProperty property="text" name="mJSPBean"/>
</body>
</html>
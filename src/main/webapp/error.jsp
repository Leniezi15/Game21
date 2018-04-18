<%@ page isErrorPage="true" import="java.io.*" contentType="text/plain"%>

Message:
<%=exception.getMessage()%>

StackTrace2:
<%
	StringWriter stringWriter = new StringWriter();
	PrintWriter printWriter = new PrintWriter(stringWriter);
	exception.printStackTrace(printWriter);
	out.println(stringWriter);
	printWriter.close();
	stringWriter.close();
%>
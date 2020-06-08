<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="javax.servlet.http.Cookie" %>
<%
    String name = (String) session.getAttribute("name");
%>
<div>session中的name: <%=name%>
</div>
<br>
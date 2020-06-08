<%--
  Created by IntelliJ IDEA.
  User: johnson
  Date: 2020/4/24
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//    response.sendRedirect("hello.jsp");
    request.getRequestDispatcher("hello.jsp").forward(request, response);
%>
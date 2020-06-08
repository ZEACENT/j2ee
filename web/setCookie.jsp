<%--
  Created by IntelliJ IDEA.
  User: johnson
  Date: 2020/4/24
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="javax.servlet.http.Cookie"%>
<%
    Cookie c = new Cookie("name", "Gareen");
    c.setMaxAge(24 * 60 * 60);
    c.setPath("/");
    response.addCookie(c);
%>
<a href="getCookie.jsp">跳转到获取cookie的页面</a>
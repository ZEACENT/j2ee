<%--
  Created by IntelliJ IDEA.
  User: johnson
  Date: 2020/5/7
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"
         isELIgnored="false"
         import="bean.*"
         import="java.util.*" %>
<html>
<head>
    <title>EL</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="name" value="${'gareen-pageContext'}" scope="page"/>
<c:set var="name" value="${'gareen-request'}" scope="request"/>
<c:set var="name" value="${'gareen-session'}" scope="session"/>
<c:set var="name" value="${'gareen-application'}" scope="application"/>
通过标签获取name: <c:out value="${name}"/><br>
通过 EL 获取name: ${name}<br>
<%
    Hero hero = new Hero();
    hero.setName("盖伦");
    hero.setHp(617);
    request.setAttribute("hero", hero);
    List<String> heros = new ArrayList<String>();
    heros.add("塔姆");
    heros.add("艾克");
    heros.add("巴德");
    heros.add("雷克赛");
    heros.add("卡莉丝塔");
    request.setAttribute("heros",heros);
%>
英雄名字 ： ${hero.name} <br>
英雄血量 ： ${hero.hp}
<table width="200px" align="center" border="1" cellspacing="0">
    <tr>
        <td>编号</td>
        <td>英雄</td>
    </tr>
    <c:forEach items="${heros}" var="hero" varStatus="st"  >
        <tr>
            <td>${st.count}</td>
            <td>${hero}</td>
        </tr>
    </c:forEach>
</table>
<div>URL参数:${param.URLname}</div>
<%
    request.setAttribute("killNumber", "10");
%>
c:if 的用法，运行结果：
<c:if test="${killNumber>=10}">
    超神<br>
</c:if>
<c:if test="${killNumber<10}">
    还没超神<br>
</c:if>
c:choose 的用法，运行结果：
<c:choose>
    <c:when test="${killNumber>=10}">
        超神<br>
    </c:when>
    <c:otherwise>
        还没超神<br>
    </c:otherwise>
</c:choose>
EL表达式eq的用法，运行结果：
${killNumber ge 10? "超神":"还没超神" }
</body>
</html>
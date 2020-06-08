<%--
  Created by IntelliJ IDEA.
  User: johnson
  Date: 2020/5/8
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*,bean.*,java.sql.*"
         isELIgnored="false" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action='updateHero' method='post'>
    名字 ： <input type='text' name='name' value='${hero.name}'> <br>
    血量 ：<input type='text' name='hp' value='${hero.hp}'> <br>
    伤害： <input type='text' name='damage' value='${hero.damage}'> <br>
    <input type='hidden' name='id' value='${hero.id}'>
    <input type='submit' value='update'>
</form>
</body>
</html>

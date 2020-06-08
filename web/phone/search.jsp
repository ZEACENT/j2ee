<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*,bean.*,java.sql.*"
         isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>搜索</title>
    <script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <script>
        $(function () {
            $("a").addClass("btn btn-default btn-xs");
        });
    </script>
</head>
<body>
<table style="width:500px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed"
       align='center' border='1' cellspacing='0'>
    <tr>
        <c:if test="${userName==null}">
            <td colspan="7" align="center"><h1>PhoneMall</h1>
                <div>请登录</div>
            </td>
        </c:if>
        <c:if test="${userName!=null}">
            <td colspan="7" align="center"><h1>PhoneMall</h1>
                <div>当前用户:${userName}</div>
            </td>
        </c:if>
    </tr>
    <tr>
        <td align="center"><a href="/j2ee_war_exploded/phone/register.jsp"><span color="blue" size="4px">注册</span></a></td>
        <td align="center"><a href="/j2ee_war_exploded/phone/login.jsp"><span color="blue" size="4px">登录</span></a></td>
        <td align="center"><a href="/j2ee_war_exploded/listPhone"><span color="blue" size="4px">浏览</span></a></td>
        <td align="center"><a href="/j2ee_war_exploded/phone/search.jsp"><span color="blue" size="4px">搜索</span></a></td>
        <td align="center"><a href="/j2ee_war_exploded/cart"><span color="blue" size="4px">购物车</span></a></td>
        <td align="center"><a href="/j2ee_war_exploded/countlist"><span color="blue" size="4px">订单</span></a></td>
        <td align="center"><a href="/j2ee_war_exploded/logout"><span color="blue" size="4px">退出</span></a></td>
    </tr>
    <form action="/j2ee_war_exploded/search" method="GET">
        <tr>
            <td colspan="7" align="center">搜索:<input type="text" name="str"><br></td>
        </tr>
        <tr>
            <td>名称<input type="radio" name="key" value="phone_name" checked onclick="show();"></td>
            <td>型号<input type="radio" name="key" value="phone_version" onclick="hidd();"></td>
            <td>厂家<input type="radio" name="key" value="phone_made" onclick="hidd();"></td>
            <td>价格<input type="radio" name="key" value="phone_price" onclick="hidd();"></td>
            <td>功能<input type="radio" name="key" value="phone_feature" onclick="hidd();"></td>
            <td>系统<input type="radio" name="key" value="classify" onclick="hidd();"></td>
            <td><input type="submit" value="搜索"><br></td>
        </tr>
    </form>
</table>
</body>
</html>
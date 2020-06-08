<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8"
         import="java.util.*,bean.*,java.sql.*"
         isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>主页</title>
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
</table>
</body>
</html>
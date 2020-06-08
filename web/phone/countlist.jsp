<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<script>
    $(function () {
        $("a").addClass("btn btn-default btn-xs");
    });
</script>
<html>
<head>
    <title>订单</title>
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
    <tr>
        <td align="center">num</td>
        <td align="center">loginname</td>
        <td colspan="4" align="center">goods</td>
        <td align="center">sum</td>
    </tr>
    <%
        int i = 0;
    %>
    <c:forEach items="${counts}" var="counts" varStatus="st">
        <tr>
            <td align="center">
                <%=++i%>
            </td>
            <td align="center">${counts.loginname}</td>
            <td colspan="4" align="center">${counts.goods}</td>
            <td align="center">${counts.sum}</td>
        </tr>
    </c:forEach>
</table>
<nav>
    <ul class="pager">
        <li><a href="?start=0">首 页</a></li>
        <li><a href="?start=${pre}">上一页</a></li>
        <li><a href="?start=${next}">下一页</a></li>
        <li><a href="?start=${last}">末 页</a></li>
    </ul>
</nav>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*,bean.*,java.sql.*"
         isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
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
        <td colspan="2" align="center"><h1>PhoneMall</h1></td>
    </tr>
    <form action="/j2ee_war_exploded/login"
          method="POST">
        <tr>
            <td align="right"> 账号：</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td align="right">密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="登录"></td>
        </tr>
    </form>
</table>
</body>
</html>
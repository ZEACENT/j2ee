<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" %>
你好 JSP<br>
<%=new Date().toString()%><br>
<%="你好 JSP"%><br>
<%out.print("你好 JSP\n");%><br>
<html>
<head>
    <title>HTML运行JAVA代码</title>
</head>
<body>
page:<%=page%><br>
this:<%=this%><br>
<%@include file="footer.jsp" %>
<%--运行前插入，生成同一个jsp文件，不能传参--%>
<jsp:include page="footer.jsp">
    <jsp:param name="year" value="2020"></jsp:param>
</jsp:include>
<%--运行时插入，可以传参--%>
</body>
</html>
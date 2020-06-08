<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    pageContext.setAttribute("namepag", "gareenpag");
    request.setAttribute("namereq", "gareenreq");
    session.setAttribute("nameses", "gareenses");
    application.setAttribute("nameapp", "gareenapp");
//    System.out.println(application == request.getServletContext());
    response.sendRedirect("getContext.jsp");
//    pageContext.removeAttribute("namepag");
//    request.removeAttribute("namereq");
//    session.removeAttribute("nameses");
//    application.removeAttribute("nameapp");
%>
<%--<%=pageContext.getAttribute("name")%>--%>
<%--<%=request.getAttribute("name")%>--%>
<%--<jsp:forward page="getContext.jsp"/>--%>
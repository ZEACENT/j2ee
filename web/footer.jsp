<hr>
<%
    if (request.getParameter("year") != null) {
%>
<p style="text-align:center">copyright@<%=request.getParameter("year")%>
</p>
<%
} else {
%>
<p style="text-align:center">copyright@2016</p>
<%
    }
%>
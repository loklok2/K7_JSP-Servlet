<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String type = request.getParameter("type");

if (type.equals("type1")) {
	String dan = request.getParameter("dan");
    response.sendRedirect("gugudan1.jsp?dan=" + dan);
} else if (type.equals("type2")) {
    String dir = request.getParameter("dir");
    response.sendRedirect("gugudan2.jsp?dir=" + dir);
} else if (type.equals("type3")) {
    String col = request.getParameter("col");
    response.sendRedirect("gugudan3.jsp?col=" + col);
} else {
    out.println("올바르지 않은 선택입니다.");
}
%>

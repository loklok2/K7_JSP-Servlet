<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.time.LocalDateTime" %>
<%@ page import = "java.time.LocalDate" %>


<%! //이 부분은 선언부!!! // 메소드는 jspservice안으로 들어가지 못한다
	int add(int a, int b){
		return a+b; 
	}
%>


<% //이부분은 스크립트틀릿!! //<%%는 jspservice 안으로 들어감  <%!는 위로
LocalDate today = LocalDate.now();  
LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);  
%>

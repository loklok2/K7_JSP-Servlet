<%@ page import='common.Person' %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("pageInteger", 1000);
pageContext.setAttribute("pageString", "페이지 영역의 문자열");
pageContext.setAttribute("pagePerson", new Person("한석봉",99));
%>
<html>
<head>
<meta charset="UTF-8">
<title>page 영역</title>
</head>
<body>
	<h2>page 영역의 속성값 읽기</h2>
	<%
	int pInteger = (Integer)(pageContext.getAttribute("pageInteger"));
	String pString = pageContext.getAttribute("pageString").toString();
	Person pPerson = (Person)(pageContext.getAttribute("pagePerson"));
	%>
	<ul>
		<li>Integer 객체 : <%= pInteger %> </li>
		<li>String 객체 : <%= pString %></li>
		<li>Person 객체 : <%= pPerson.getName() %>, <%=pPerson.getAge() %></li>
	</ul>
	
	<h2>include된 파일에서 page 영역 읽어오기</h2> <!--include되어서 나타난 페이지이기 때문에 java 컴파일되어 저장될 필요가 없음--!>
	<%@ include file = "PageInclude.jsp" %>
	
	<h2>페이지 이동 후 page 영역 읽어오기</h2>
	<a href = "pageLocation.jsp">PageLocation.jsp 바로가기</a>  <!-- a태그를 통한 이동은 새페이지를 요청하는 것으로, 서로 다른 페이지니까  속성값이 공유되지 않아 값없음으로 뜸 -->
</body>
</html>
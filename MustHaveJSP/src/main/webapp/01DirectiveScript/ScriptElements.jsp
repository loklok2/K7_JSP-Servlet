<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%! //선언부 (메서드 선언)
int add(int num1, int num2){
	return num1+num2;
}
int add2(int num1, int num2){
	return num1-num2;
}
int mul(int num1, int num2){
	return num1*num2;
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 요소</title>
</head>
<body>
<% //스크립트플릿
int result;
int result1;

try{
	int num1 = Integer.parseInt(request.getParameter("num1")); 
	int num2 = Integer.parseInt(request.getParameter("num2")); 
	
	result = add(num1, num2);
	result1 = mul(num1, num2);
} catch(Exception e){
	result = 0;
	result1 = 0;
}

%>
덧셈 결과 1 : <%= result %> <br /> 
덧셈 결과 2 : <%= add(30, 40) %> <br /> 
곱셈 결과 4 : <%= result1 %> <br />
</body>
</html>
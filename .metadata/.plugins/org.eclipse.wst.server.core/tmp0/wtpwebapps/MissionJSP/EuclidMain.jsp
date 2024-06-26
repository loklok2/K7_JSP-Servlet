<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유클리드 호제법</title>
<!-- 유클리드 호제법
• 2보다 큰 정수 두 개를 입력 받는 폼을 만들고 최소공배수(LCM:Least Common Multiple), 
최대공약수(GCD:Greatest Common Divisor)를 구해서 출력
• 출력 예
● 입력 : 12, 18 ➔ 최대공약수 : 6, 최소공배수 : 36
• 알고리즘
• 입력 받은 두 개의 정수 중 큰 정수를 max, 작은 정수를 min
• rem = max%min
• rem이 0이면 ➔ 최대공약수 = 작은 정수, 최소공배수 = 두 정수의 곱 / 최대공약수
• rem이 0이 아니면 ➔ max = min, min = rem, 2번 반 -->

</head>

<body>
	<form action="EuclidProc.jsp" method="post">
	<table> 
       <tr>
       	<td>숫자1:</td>>
<%       if(snum1 == null){ %>
			<td><input type="text" name="num1" placeholder="숫자를 입력하세요"/></td>
<%		}else{ %>
			<td><input type="text" name="num1" value="<%=sum1 %>"/></td>
<% 		}		%>				
       </tr>
              <tr>
       	<td>숫자2:</td>>
<%       if(snum2 == null){ %>
			<td><input type="text" name="num2" placeholder="숫자를 입력하세요"/></td>
<%		}else{ %>
			<td><input type="text" name="num2" value="<%=sum2 %>"/></td>
<% 		}		%>				
       </tr>
       <tr>
       		<td>최대공약수:</td>
       		<td><input type="text" name="num3" value="<%=gcd %>" readonly/></td>
       </tr>
       <tr>
       		<td>최대공배수:</td>
       		<td><input type="text" name="num4" value="<%=lcm %>" readonly/></td>
       </tr>
       <tr>
            <td colspan="2"><input type="submit" value="계산하기" /></td>
       </tr>
    </table>   
    </form>
</body>
</html>
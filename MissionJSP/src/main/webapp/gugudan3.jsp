<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mission 1</title>
 <style>
        .gugudan {
            display: inline-block;
            padding: 10px;
            margin: 10px;
        }
        .gugudan span {
            display: block;
        }
    </style>
</head>
<body>
<%
String colParam = request.getParameter("col");
int col = 3; // 기본 값
if (colParam != null) {
    try {
        col = Integer.parseInt(colParam);
    } catch (NumberFormatException e) {
 
    }
}
%>

<table>
<%
for (int i = 2; i <= col + 1; i++) {
%>
    <tr>
        <td class="gugudan"><%= i %>단</td>
        <td>
            <table>
                <%
                for (int j = 1; j <= 9; j++) {
                %>
                <tr>
                    <td><%= i %> × <%= j %> = <%= (i * j) %></td>
                </tr>
                <%
                }
                %>
            </table>
        </td>
    </tr>
<%
}
%>
</table>

</body>
</html>
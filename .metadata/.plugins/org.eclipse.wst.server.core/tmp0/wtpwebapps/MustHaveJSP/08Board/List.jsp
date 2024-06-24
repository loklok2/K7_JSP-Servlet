<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="model1.board.BoardDAO"%>
<%@ page import="model1.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BoardDAO dao = new BoardDAO(application);  // num title id postdate visitcount


Map<String, Object> param = new HashMap<String, Object>(); 
String searchField = request.getParameter("searchField");
String searchWord = request.getParameter("searchWord");
if (searchWord != null) {
    param.put("searchField", searchField);
    param.put("searchWord", searchWord);
}

int totalCount = dao.selectCount(param);  
List<BoardDTO> boardLists = dao.selectList(param);  
dao.close();  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판</title>
<style>

table {

width: 700px;

border: 1px solid;/* 테두리 및 경계선을 1pixel 실선으로 */

border-collapse: collapse;/* 두즐로 된 선을 한선으로 */

text-align: center;/* 테이블 안 요소를 가운데 정렬 */

margin: auto;/* 테이블을 화면의 중앙에 배치 */

}

th, td {

border: 1px solid;

padding: 0px 0px;/* 테이블 셀 데이터의 상하좌우 여유 */

}


th {

background-color: teal;/* 테이블의 타이틀 셀 배경색 */

color: white;/* 테이블의 타이틀 문자색 */

}


tr:nth-child(2n) {/* 짝수줄만 배경색 */

background-color: lightgray;

}

</style>
</head>
<body>
    <jsp:include page="../Common/Link.jsp" /> <!-- ?????? 파일이 없음 예제코드 존재 안함 -->

    <h2>목록 보기(List)</h2>
    <!-- 검색폼 --> 
    <form method="get">  
    <table border="1" width="90%">
    <tr>
        <td align="center">
            <select name="searchField"> 
                <option value="title">제목</option> 
                <option value="content">내용</option>
            </select>
            <input type="text" name="searchWord" />
            <input type="submit" value="검색하기" />
        </td>
    </tr>   
    </table>
    </form>
    <table border="1" width="90%">
        <tr>
            <th width="10%">num</th>
            <th width="50%">title</th>
            <th width="15%">id</th>
            <th width="10%">postdate</th>
            <th width="15%">visitcount</th>
        </tr>
<%
if (boardLists.isEmpty()) {
    // 게시물이 하나도 없을 때 
%>
        <tr>
            <td colspan="5" align="center">
                등록된 게시물이 없습니다^^*
            </td>
        </tr>
<%
}
else {
    // 게시물이 있을 때 
    int virtualNum = 0;  
    for (BoardDTO dto : boardLists)
    {
        virtualNum = totalCount--;  // 전체 게시물 수에서 시작해 1씩 감소
%>
        <tr align="center">
            <td><%= virtualNum %></td> 
            <td align="left"> 
                <a href="View.jsp?num=<%= dto.getNum() %>"><%= dto.getTitle() %></a> 
            </td>
            <td align="center"><%= dto.getId() %></td>          
            <td align="center"><%= dto.getPostdate() %></td>    
            <td align="center"><%= dto.getVisitcount() %></td>  
        </tr>
<%
    }
}
%>
    </table>
    <table border="1" width="90%">
        <tr align="right">
            <td><button type="button" onclick="location.href='Write.jsp';">글쓰기
                </button></td>
        </tr>
    </table>
</body>
</html>
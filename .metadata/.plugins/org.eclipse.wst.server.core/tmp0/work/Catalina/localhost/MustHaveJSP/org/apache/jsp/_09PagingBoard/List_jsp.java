/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.24
 * Generated at: 2024-06-20 03:58:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._09PagingBoard;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import model1.board.BoardDAO;
import model1.board.BoardDTO;

public final class List_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(5);
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("model1.board.BoardDTO");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("java.util.HashMap");
    _jspx_imports_classes.add("model1.board.BoardDAO");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

BoardDAO dao = new BoardDAO(application);


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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>회원제 게시판</title>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("table {\r\n");
      out.write("\r\n");
      out.write("width: 700px;\r\n");
      out.write("\r\n");
      out.write("border: 1px solid;/* 테두리 및 경계선을 1pixel 실선으로 */\r\n");
      out.write("\r\n");
      out.write("border-collapse: collapse;/* 두즐로 된 선을 한선으로 */\r\n");
      out.write("\r\n");
      out.write("text-align: center;/* 테이블 안 요소를 가운데 정렬 */\r\n");
      out.write("\r\n");
      out.write("margin: auto;/* 테이블을 화면의 중앙에 배치 */\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th, td {\r\n");
      out.write("\r\n");
      out.write("border: 1px solid;\r\n");
      out.write("\r\n");
      out.write("padding: 0px 0px;/* 테이블 셀 데이터의 상하좌우 여유 */\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("th {\r\n");
      out.write("\r\n");
      out.write("background-color: teal;/* 테이블의 타이틀 셀 배경색 */\r\n");
      out.write("\r\n");
      out.write("color: white;/* 테이블의 타이틀 문자색 */\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("tr:nth-child(2n) {/* 짝수줄만 배경색 */\r\n");
      out.write("\r\n");
      out.write("background-color: lightgray;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../Common/Link.jsp", out, false);
      out.write(" <!-- ?????? 파일이 없음 예제코드 존재 안함 -->\r\n");
      out.write("\r\n");
      out.write("    <h2>목록 보기(List)</h2>\r\n");
      out.write("    <!-- 검색폼 --> \r\n");
      out.write("    <form method=\"get\">  \r\n");
      out.write("    <table border=\"1\" width=\"90%\">\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td align=\"center\">\r\n");
      out.write("            <select name=\"searchField\"> \r\n");
      out.write("                <option value=\"title\">제목</option> \r\n");
      out.write("                <option value=\"content\">내용</option>\r\n");
      out.write("            </select>\r\n");
      out.write("            <input type=\"text\" name=\"searchWord\" />\r\n");
      out.write("            <input type=\"submit\" value=\"검색하기\" />\r\n");
      out.write("        </td>\r\n");
      out.write("    </tr>   \r\n");
      out.write("    </table>\r\n");
      out.write("    </form>\r\n");
      out.write("    <table border=\"1\" width=\"90%\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th width=\"10%\">번호</th>\r\n");
      out.write("            <th width=\"50%\">제목</th>\r\n");
      out.write("            <th width=\"15%\">작성자</th>\r\n");
      out.write("            <th width=\"10%\">조회수</th>\r\n");
      out.write("            <th width=\"15%\">작성일</th>\r\n");
      out.write("        </tr>\r\n");

if (boardLists.isEmpty()) {
    // 게시물이 하나도 없을 때 

      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td colspan=\"5\" align=\"center\">\r\n");
      out.write("                등록된 게시물이 없습니다^^*\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");

}
else {
    // 게시물이 있을 때 
    int virtualNum = 0;  
    for (BoardDTO dto : boardLists)
    {
        virtualNum = totalCount--;  // 전체 게시물 수에서 시작해 1씩 감소

      out.write("\r\n");
      out.write("        <tr align=\"center\">\r\n");
      out.write("            <td>");
      out.print( virtualNum );
      out.write("</td> \r\n");
      out.write("            <td align=\"left\"> \r\n");
      out.write("                <a href=\"View.jsp?num=");
      out.print( dto.getNum() );
      out.write('"');
      out.write('>');
      out.print( dto.getTitle() );
      out.write("</a> \r\n");
      out.write("            </td>\r\n");
      out.write("            <td align=\"center\">");
      out.print( dto.getId() );
      out.write("</td>          \r\n");
      out.write("            <td align=\"center\">");
      out.print( dto.getVisitcount() );
      out.write("</td>  \r\n");
      out.write("            <td align=\"center\">");
      out.print( dto.getPostdate() );
      out.write("</td>    \r\n");
      out.write("        </tr>\r\n");

    }
}

      out.write("\r\n");
      out.write("    </table>\r\n");
      out.write("    <table border=\"1\" width=\"90%\">\r\n");
      out.write("        <tr align=\"right\">\r\n");
      out.write("            <td><button type=\"button\" onclick=\"location.href='Write.jsp';\">글쓰기\r\n");
      out.write("                </button></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
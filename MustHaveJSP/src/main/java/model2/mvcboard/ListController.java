package model2.mvcboard;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.BoardPage;

public class ListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MVCBoardDAO dao = new MVCBoardDAO(); //dao객체 생성
		
		Map<String, Object> map = new HashMap<String, Object>();
		//쿼리 스트링으로 전달받은 파라미터 중 검색어가 있으면 map에 저장
		String searchField = req.getParameter("searchField");
		String searchWord = req.getParameter("searchWord");
		if (searchWord != null) {
			map.put("searchField", searchField);
			map.put("searchWord", searchWord);
			
		}
		//게시물 갯수
		int totalCount = dao.selectCount(map);
		
		//페이지처리 시작
		ServletContext application = getServletContext();
		int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
		int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
		
		
		//현재페이지 확인
		int pageNum = 1;
		String pageTemp = req.getParameter("pageNum");
		if(pageTemp != null && !pageTemp.equals(""))
			//요청받은 페이지로 수정
			pageNum = Integer.parseInt(pageTemp);
		
		int start = (pageNum -1) * pageSize + 1;
		map.put("start", start);
		map.put("pageSize", pageSize);
		
		//게시물목록받기
		List<MVCBoardDTO> boardLists = dao.selectListPage(map);
		dao.close();
		
		String pagingImg = BoardPage.pagingStr(totalCount, pageSize,
                blockPage, pageNum, "../mvcboard/list.do");  // 바로가기 영역 HTML 문자열
		
		map.put("pagingImg", pagingImg);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		
		req.setAttribute("boardLists", boardLists);
		req.setAttribute("map", map);
		req.getRequestDispatcher("/14MVCBoard/List.jsp").forward(req, resp);
		
	}
}

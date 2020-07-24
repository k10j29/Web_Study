package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitListAction
 */
@WebServlet("/visit/list.do")
public class VisitListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//  /visit/list.do
	    //  /visit/list.do?search=all&search_text=
	    //  /visit/list.do?search=name&search_text=길동
		
		request.setCharacterEncoding("utf-8");
        //검색카테고리 받기
		String search = request.getParameter("search");
		if(search==null)search="all";
		
		//검색어 받기
		String search_text = request.getParameter("search_text");
		
		//검색옵션 Map으로 포장
		Map map = new HashMap();
		
		//전체검색이 아니면(카테고리별 검색)
		if(search.equals("all")==false) {
			
			//이름+내용
			if(search.equals("name_content")) {
				//       key=value
				//       name=길동
				//       content=길동
				map.put("name", search_text);
				map.put("content", search_text);
			}else if(search.equals("name")) {
			    //       name=길동     
				map.put("name", search_text);
			}else if(search.equals("content")) {
				map.put("content", search_text);
			}
		}
		
		
		//1.Data가져오기
		List<VisitVo> list = VisitDao.getInstance().selectList(map);
		
		//2.request binding
		request.setAttribute("list", list);
		
		//Dispatcher(forward)
		String forward_page = "visit_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
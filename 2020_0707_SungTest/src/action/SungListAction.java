package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SungTBDao;
import vo.SungVo;

/**
 * Servlet implementation class SungListActioOn
 */
@WebServlet("/sung/list.do")
public class SungListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 2. 성적 목록 가져오기 (위치중요)
		List<SungVo> list = SungTBDao.getInstance().selectList();

		// 3. Request binding (여기까지 하고 실행시 404오류)
		request.setAttribute("list", list);

		// 1. Dispatcher (forward) Templet
		String forward_page = "sung_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);

		disp.forward(request, response);

		// 4. sung 폴더 만들어서 JSP 만들어주기

		// 5. Data 가 없을경우 (JSP)

		// 6. Data 가 있는경우 (JSP)

		// 7. 수정삭제 버튼 넣기

		// 8. 성적 등록하기 (연결)

		// 9. 입력폼 만들기 (sung_insert_form.jsp)

	}

}

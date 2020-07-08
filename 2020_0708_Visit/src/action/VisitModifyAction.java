package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitModifyAction
 */
@WebServlet("/visit/modify.do")
public class VisitModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. ���� ���ڵ� ����
		// sung_insert_form.jsp (��������) �ϰ� �����ֱ�
		request.setCharacterEncoding("UTF-8");

		// 2. �Ķ���� �ޱ�
		int idx = Integer.parseInt(request.getParameter("idx"));
		String content = request.getParameter("content");

		// 3. �����ϱ�
		VisitVo vo = new VisitVo(idx, content);

		// 4. DB update
		int res = VisitDao.getInstance().update(vo);

		// 5. ��� �����̵�
		response.sendRedirect("list.do");

	}

}
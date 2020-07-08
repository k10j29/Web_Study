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
 * Servlet implementation class SungInsertAction
 */
@WebServlet("/visit/insert.do")
public class VisitInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.�������ڵ� ����
		request.setCharacterEncoding("utf-8");

		// 2.parameter
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");

		// ip
		String ip = request.getRemoteAddr();

		// textarea \n �� html <br>�� �������־���Ѵ�.
		// content="1 \n 2 \n 3 \n ==> 1 <br> 2 <br>....

		content = content.replaceAll("\n", "<br>");

		// 3.���� (�װ��� ���� �ѹ��� �ѱ��)
		VisitVo vo = new VisitVo(name, content, pwd, ip);

		// 4.DB insert
		int res = VisitDao.getInstance().insert(vo);

		// 5.��Ϻ��� �̵�
		response.sendRedirect("list.do");

	}

}
package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import vo.SawonVo;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/sawon/sajob_list.do")
public class SawonSajobListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// sawon/dept_list.do?deptno=10

		request.setCharacterEncoding("utf-8");

		String sajob = "all";

		try {
			sajob = request.getParameter("sajob");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		List<SawonVo> list = null;
		if (sajob.equals("all")) { // 전체 조회
			list = SawonDao.getInstance().selectList();
		} else {// 부서별 조회
			list = SawonDao.getInstance().selectList(sajob);
		}

		// System.out.println(list.size());

		// request binding
		request.setAttribute("list", list);

		// Dispatcher(forward)
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
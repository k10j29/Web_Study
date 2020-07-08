package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SungTBDao;
import vo.SungVo;

/**
 * Servlet implementation class SungInsertAction
 */
@WebServlet("/sung/modify.do")
public class SungModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 수신 인코딩 설정
		// sung_insert_form.jsp (보내는쪽) 하고 맞춰주기
		request.setCharacterEncoding("UTF-8");

		// 2. 파라미터 받기
		int no = Integer.parseInt(request.getParameter("no"));

		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));

		// 3. 포장하기

		SungVo vo = new SungVo(no, name, kor, eng, mat);

		// 4. DB update
		int res = SungTBDao.getInstance().update(vo);

		// 5. 목록 보기이동
		response.sendRedirect("list.do");

	}

}
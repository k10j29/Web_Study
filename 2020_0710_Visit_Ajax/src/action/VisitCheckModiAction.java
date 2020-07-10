package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

//   서버!!!!!!!!!!!!!!!!!!!!!!!!!
/**
 * Servlet implementation class VisitCheckPwdAction
 */
@WebServlet("/visit/check_modi.do")
public class VisitCheckModiAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// visit/check_pwd.do?idx=9cc_pwd=1234

		// 서버 수신 인코딩을 설정
		// 비밀번호에 특수문자가 포함될수도 있기때문에 인코딩 설정 해야함
		request.setCharacterEncoding("utf-8");

		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");
		String content = request.getParameter("content");

		// idx에 해당하는 게시물 1건을 얻어오기 (select)
		VisitVo vo = VisitDao.getInstance().selectOne(idx);

		// 보기 편하게 풀어쓴것

		// 한줄로 나타낸것 (같느냐는 비교) boolean bRes = vo.getPwd().equals(c_pwd);

		boolean bResult = false; // 비번이 같으냐? 비교
		if (vo.getPwd().equals(c_pwd)) {
			bResult = true;
		}
		// boolean bRes = vo.getPwd().equals(c_pwd);

		// 결과를 JSON생성->전달 : {"result":true}

		String json = String.format("{\"result\":%b}", bResult);

		// 응답내용정보 설정
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json);

	}

}

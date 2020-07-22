package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitCheckPwdAction
 */
@WebServlet("/visit/check_pwd.do")
public class VisitCheckPwdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest  request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//  /visit/check_pwd.do?idx=9&c_pwd=1234
		//수신인코딩 설정
		request.setCharacterEncoding("utf-8");
				
		int idx = Integer.parseInt(request.getParameter("idx"));
		//비번에 특수문자가 포함될수도 있기때문에 인코딩설정
		String c_pwd = request.getParameter("c_pwd");
		
		//idx에 해당되는 게시물 1건 얻어오기
		VisitVo  vo = VisitDao.getInstance().selectOne(idx);
		
		boolean bResult = false;//비번이 같냐?
		if(vo.getPwd().equals(c_pwd)) {
			bResult = true;
		}
		
		//boolean bRes = vo.getPwd().equals(c_pwd);
		
		//결과를 JSON생성->전달 :  {"result":true}
		 
		String json = 
				String.format("{\"result\":%b}", bResult);
		
		//응답내용정보 설정
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json);
		
		

		
	}

}
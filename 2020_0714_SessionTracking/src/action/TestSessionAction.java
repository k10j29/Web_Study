package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestSessionAction
 */

//JSP 가 있는 경로 설정

@WebServlet("/session_test/test_session.do")
public class TestSessionAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, // session 은 현재 클라이언트에있으니까 request 를 통해 session의 정보를 얻어옴
			HttpServletResponse response) throws ServletException, IOException {

		
		
		// 생성되어있는 세션 정보 얻어오기
		HttpSession session = request.getSession();

		// 세션 ID 를 알고싶다 ?
		String session_id = session.getId();

		
		//브라우저를 닫는순간 session 은 사라진다.
		// 세션 유효기간 60초 1분동안만 유효하다. 세션을 죽지않게 하는법이있다. (1분이 경과하기전에 새로고침 하면됨)
		session.setMaxInactiveInterval(60);
		
		// Session 에 저장된 값중에서 이름이 msg1 으로 저장된 값 읽어오기
		String msg1 = (String) session.getAttribute("msg1");
		
		System.out.println(session_id);

		// 세션 binding 하기
		// a.jsp 와 TestSessionAction 서블릿이랑 정보 공유 (세션을 통해) 그래서 세션에 데이터 넣기
		session.setAttribute("msg", "Hi, session!");

		// 그다음에 응답 처리하기
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();

		// jsp 에 있던 ID와 동일해야함
		out.print("서블릿 세션ID :" + session_id + "<br>");
		out.print("JSP의 msg1 : " + msg1 + "<br>");
		out.print("<a href='a.jsp'>a.jsp</a>");

	}

}

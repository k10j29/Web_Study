package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// hello.do
		// hello.do?nation=
		// hello.do?nation=kor

		// 1.parameter 수신
		String nation = request.getParameter("nation");
		if (nation == null || nation.isEmpty())
			nation = "kor";

		String message = "";

		switch (nation) {
		case "kor":
			message = String.format("[한국어:%s] 안녕하세요", nation);
			break;
		case "eng":
			message = String.format("[영어:%s] Hi~~", nation);
			break;
		case "jpn":
			message = String.format("[일본어:%s] 오겡끼~~", nation);
			break;
		default:
			message = String.format("[%s] 는 뭐지?", nation);
		}

		// 위에서 Business Logic 을 처리

		// 전송하기전에 request에 넣는다
		// request binding(연결)
		request.setAttribute("message", message);

		// 웹경로 : /hello.do
		// / <= WebContext경로
		// / <= 편집상경로 WebContent

		// Dispatcher(forward): 현재서블릿이 hello.jsp call
		RequestDispatcher disp = request.getRequestDispatcher("hello.jsp");
		disp.forward(request, response);

	}

}

package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcAction
 */
@WebServlet("/calc.do")
public class CalcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /calc.do?su1=1&su2=2
		
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));

		StringBuffer sb = new StringBuffer();
		sb.append(String.format("%d + %d = %d<br>", su1, su2, su1 + su2));
		sb.append(String.format("%d - %d = %d<br>", su1, su2, su1 - su2));
		sb.append(String.format("%d * %d = %d<br>", su1, su2, su1 * su2));

		if (su2 == 0) {
			sb.append("젯수 0으로 몫/나머지 연산을 하지 못합니다<br>");
		} else {

			sb.append(String.format("%d / %d = %d<br>", su1, su2, su1 / su2));
			sb.append(String.format("%d %% %d = %d<br>", su1, su2, su1 % su2));
		}

		// 결과 응답
		response.setContentType("text/html; charset=utf-8;");
		response.getWriter().print(sb.toString());

	}

}
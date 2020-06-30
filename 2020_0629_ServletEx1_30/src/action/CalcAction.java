package action;

import java.io.IOException;
import java.io.PrintWriter;

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
		// /2020_0629_ServletEx1_30/calc.do?su1=33&su2=11

		// 파라메터 수신 (모든 Parameter String 으로 받는다 , 파일업로드 제외)
		String su1 = request.getParameter("su1");
		String su2 = request.getParameter("su2");

		// 정수로 변환
		int s1 = Integer.parseInt(su1);
		int s2 = Integer.parseInt(su2);

		// 응답처리...
		// 응답내용에 대한 ContentType설정(mime-type)
		// 지금주는 파일은 html 형식인데 utf-8 형식으로 해석해!
		response.setContentType("text/html; charset=utf-8;");

		// 응답용 출력스트림 얻기
		PrintWriter out = response.getWriter();

		// 전송(동적 Html을 작성해서 응답)
		out.println("<html>");
		out.println("<head><title>계산결과</title></head>");
		out.println("<body>");
		out.println("::::계산결과::::<br>");

		out.printf("%d + %d = %d<br>", s1, s2, (s1 + s2));
		out.printf("%d - %d = %d<br>", s1, s2, (s1 - s2));
		out.printf("%d * %d = %d<br>", s1, s2, (s1 * s2));

		if (s2 == 0) {
			out.println("몫/나머지 연산은 0으로 나눌수 없습니다<br>");
		} else {
			out.printf("%d / %d = %d<br>", s1, s2, (s1 / s2));
			out.printf("%d %% %d = %d<br>", s1, s2, (s1 % s2));
		}

		/*
		 * out.printf("%d / %d = %d<br>", s1,s2,(s2==0) ? 0 : (s1/s2));
		 * out.printf("%d %% %d = %d<br>", s1,s2,(s2==0) ? 0 : (s1%s2));
		 */
		out.println("<a href='calc.html'>다시하기</a>");

		out.println("</body>");
		out.println("</html>");

	}

}

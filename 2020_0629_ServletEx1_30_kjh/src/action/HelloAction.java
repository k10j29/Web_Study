package action;

import java.io.IOException;
import java.io.PrintWriter;

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

		String ip = request.getRemoteAddr();

//		 요청된 URL = query 형식을 통해서  parameter가 전달됨
//		 System.out.printf("--[%s] HelloAction : WebModule 3.x Call--\n", ip);
//       http://localhost:9090/2020_0629_ServletEx1_30/hello.do?nation=kor
//                                             		  /hello.do
//		                                              /hello.do?nation=

		String nation = request.getParameter("nation");

		// 비정상적인 파라미터 처리

		if (nation == null || nation.isEmpty()) {
			nation = "kor";

		}
		String greet_message = "";

		if (nation.equals("kor")) {
			greet_message = String.format("[한국어(%s)] : 안녕하세요", nation);
		} else if (nation.equals("eng")) {
			greet_message = String.format("[영어(%s)] : Hello", nation);
		} else if (nation.equals("jpn")) {
			greet_message = String.format("[일본어(%s)] : 오겡끼", nation);
		} else if (nation.equals("chn")) {
			greet_message = String.format("[중국어(%s)] : nihao", nation);
		} else if (nation.equals("ger")) {
			greet_message = String.format("[독일어(%s)] : gutnetak", nation);
		} else {
			greet_message = String.format("[나라(%s)] : ?? ", nation);
		}

		// 응답 처리

		// 전송 해야할 내용의 정보 설정
		response.setContentType("text/html; charset=utf-8;");

		// 응답시 이용할 문자 스트림
		PrintWriter out = response.getWriter();

		// 응답 정보는 html 로 전송
		out.println("<html>");
		out.println("<head><title> Google </title></head>");
		out.println("<body>");

//		out.printf("[%s] IP님 안녕하세요 <br>", ip);
//		out.println("지금 접속하신  PC의 사용자는 김진한 입니다. <br>");
//
//		out.println("url 뒤에 ?nation=kor,eng,chn,jpn 등을 입력하시면  <br>");
//		out.println("각 나라별 인사말을 볼수있습니다. <br>");
		out.println(greet_message);

		out.println("</body>");
		out.println("</html>");
	}

}

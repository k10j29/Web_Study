package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myutil.Jumin;

/**
 * Servlet implementation class JuminAction
 */
@WebServlet("/jumin.do")
public class JuminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /jumin.do?jumin_no=801212-1234560

		// 수신인코딩 설정
		request.setCharacterEncoding("utf-8");

		// 파라메터 받기
		String jumin_no = request.getParameter("jumin_no");

		// 주민번호-> 각각의 부가정보 추출
		Jumin jumin = new Jumin();
		jumin.setJumin_no(jumin_no);

		// 각정보 추출
		int year = jumin.getYear();
		int age = jumin.getAge();
		String tti = jumin.getTti();
		String gender = jumin.getGender();
		String local = jumin.getLocal();
		String season = jumin.getSeason();

		// 응답처리.....

		response.setContentType("text/html; charset=utf-8;");

		StringBuffer html = new StringBuffer();
		html.append("<html>");
		html.append("<head><title></title></head>");
		html.append("<body>");
		html.append("<table border='1'>");

		// 1번째 줄
		html.append("<tr><th>년</th><td>");
		html.append(year);
		html.append("</td></tr>");
		// 1번째 줄
		html.append("<tr><th>나이</th><td>");
		html.append(age);
		html.append("</td></tr>");
		// 1번째 줄
		html.append("<tr><th>띠</th><td>");
		html.append(tti);
		html.append("</td></tr>");
		// 1번째 줄
		html.append("<tr><th>성별</th><td>");
		html.append(gender);
		html.append("</td></tr>");
		// 1번째 줄
		html.append("<tr><th>지역</th><td>");
		html.append(local);
		html.append("</td></tr>");
		// 1번째 줄
		html.append("<tr><th>계절</th><td>");
		html.append(season);
		html.append("</td></tr>");

		// 마지막줄
		html.append("<tr><td colspan='2' align='center'>");
		html.append("<a href='jumin.html'>다시하기</a></td></tr>");

		html.append("</body>");
		html.append("</html>");

		// 동적으로 작성된 html 전송
		// response.getWriter().println(html.toString());

		PrintWriter out = response.getWriter();
		out.print(html.toString());

	}

}

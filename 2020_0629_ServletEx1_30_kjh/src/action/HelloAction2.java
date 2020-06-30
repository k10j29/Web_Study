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
@WebServlet("/calc.do")
public class HelloAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ip = request.getRemoteAddr();

		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		int plus_res = su1 + su2;
		int minus_res = su1 - su2;
		int multi_res = su1 * su2;
		int mini_res = su1 / su2;

		// ���� �ؾ��� ������ ���� ����
		response.setContentType("text/html; charset=utf-8;");
		// ����� �̿��� ���� ��Ʈ��
		PrintWriter out = response.getWriter();

		// ���� ������ html �� ����
		out.println("<html>");
		out.println("<head><title>����</title></head>");
		out.println("<body><center>");
		out.println("<h2> || ����� || </h2>");
		out.println("<hr>");
		out.printf("%d+%d=[%d]<br>", su1, su2, plus_res);
		out.printf("%d-%d=[%d]<br>", su1, su2, minus_res);
		out.printf("%d*%d=[%d]<br>", su1, su2, multi_res);
		out.printf("%d/%d=[%d]<br>", su1, su2, mini_res);
		out.println("<a href='calc.html'>�ٽ��ϱ�</a>");
		out.println("</body></html>");

	}
}
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

		// �Ķ���� ���� (��� Parameter String ���� �޴´� , ���Ͼ��ε� ����)
		String su1 = request.getParameter("su1");
		String su2 = request.getParameter("su2");

		// ������ ��ȯ
		int s1 = Integer.parseInt(su1);
		int s2 = Integer.parseInt(su2);

		// ����ó��...
		// ���䳻�뿡 ���� ContentType����(mime-type)
		// �����ִ� ������ html �����ε� utf-8 �������� �ؼ���!
		response.setContentType("text/html; charset=utf-8;");

		// ����� ��½�Ʈ�� ���
		PrintWriter out = response.getWriter();

		// ����(���� Html�� �ۼ��ؼ� ����)
		out.println("<html>");
		out.println("<head><title>�����</title></head>");
		out.println("<body>");
		out.println("::::�����::::<br>");

		out.printf("%d + %d = %d<br>", s1, s2, (s1 + s2));
		out.printf("%d - %d = %d<br>", s1, s2, (s1 - s2));
		out.printf("%d * %d = %d<br>", s1, s2, (s1 * s2));

		if (s2 == 0) {
			out.println("��/������ ������ 0���� ������ �����ϴ�<br>");
		} else {
			out.printf("%d / %d = %d<br>", s1, s2, (s1 / s2));
			out.printf("%d %% %d = %d<br>", s1, s2, (s1 % s2));
		}

		/*
		 * out.printf("%d / %d = %d<br>", s1,s2,(s2==0) ? 0 : (s1/s2));
		 * out.printf("%d %% %d = %d<br>", s1,s2,(s2==0) ? 0 : (s1%s2));
		 */
		out.println("<a href='calc.html'>�ٽ��ϱ�</a>");

		out.println("</body>");
		out.println("</html>");

	}

}
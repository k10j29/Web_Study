package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDao;
import vo.DeptVo;

/**
 * Servlet implementation class DeptListaction
 */
@WebServlet("/dept_list.do")
public class DeptListaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, // ��ûó����ü
			HttpServletResponse response) // ����ó����ü
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		// �μ����//
		List<DeptVo> list = DeptDao.getInstance().selectList();

		// ����ó��//
		response.setContentType("text/html; charset=utf-8;");

		// html ���� //
		StringBuffer html = new StringBuffer();

		html.append("<html>");
		html.append("<head><tile>Sawon DB �� �����ͺ���</title> <meta charset=\"utf-8\">\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script></head>");
		html.append("<body>");
		html.append("<table class=\"table table-hover\">");

		// table title ����
		html.append("<tr>");
		html.append(
				"<th>�����ȣ</th><th>����̸�</th><th>����</th><th>�μ���ȣ</th><th>����</th><th>�Ի�����</th><th>������ȣ</th><th>����</th>");
		html.append("</tr>");

		// table data (for)
		// ���� loop

		// for(int i = 0; i < list.size(); i++)
		// DeptVo vo = list.get(i);

		for (DeptVo vo : list) {

			html.append("<tr>");

			html.append("<td>");
			html.append(vo.getSabun());
			html.append("</td>");

			html.append("<td>");
			html.append(vo.getSaname());
			html.append("</td>");

			html.append("<td>");
			html.append(vo.getSasex());
			html.append("</td>");

			html.append("<td>");
			html.append(vo.getDeptno());
			html.append("</td>");

			html.append("<td>");
			html.append(vo.getSajob());
			html.append("</td>");

			html.append("<td>");
			html.append(vo.getSahire());
			html.append("</td>");

			html.append("<td>");
			html.append(vo.getSamgr());
			html.append("</td>");

			html.append("<td>");
			html.append(vo.getSapay());
			html.append("</td>");

			html.append("</tr>");

		}

		html.append("</table>");
		html.append("</body>");
		html.append("</html>");

		PrintWriter out = response.getWriter();
		out.print(html.toString());

	}

}
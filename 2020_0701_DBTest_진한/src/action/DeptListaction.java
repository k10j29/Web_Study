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
	protected void service(HttpServletRequest request, // 요청처리객체
			HttpServletResponse response) // 응답처리객체
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		// 부서목록//
		List<DeptVo> list = DeptDao.getInstance().selectList();

		// 응답처리//
		response.setContentType("text/html; charset=utf-8;");

		// html 생성 //
		StringBuffer html = new StringBuffer();

		html.append("<html>");
		html.append("<head><tile>Sawon DB 를 가져와보자</title> <meta charset=\"utf-8\">\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script></head>");
		html.append("<body>");
		html.append("<table class=\"table table-hover\">");

		// table title 생성
		html.append("<tr>");
		html.append(
				"<th>사원번호</th><th>사원이름</th><th>성별</th><th>부서번호</th><th>직급</th><th>입사일자</th><th>관리번호</th><th>연봉</th>");
		html.append("</tr>");

		// table data (for)
		// 개선 loop

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

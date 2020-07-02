package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDao;
import vo.DeptVo;

/**
 * Servlet implementation class DeptListAction
 */
@WebServlet("/dept_list.do")
public class DeptListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest  request, //요청처리객체 
			HttpServletResponse response //응답처리객체
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//부서목록 가져오기
		List<DeptVo> list = DeptDao.getInstance().selectList();
		
		System.out.println(list.size());
		
		//응답처리...
		response.setContentType("text/html; charset=utf-8;");
		
		//HTML  생성
		StringBuffer html = new StringBuffer();
		html.append("<html>");
		html.append("<head><title>부서목록</title></head>");
		html.append("<body>");
		html.append("<table border='1'>");
		
		/* table title */
		html.append("<tr>");
		html.append("<th>부서번호</th><th>부서명</th><th>위치</th>");
		html.append("</tr>");
		
		/* table data */
		
		for(int i=0;i<list.size();i++) {
		   DeptVo vo = list.get(i);	

		//for(DeptVo vo: list) {
			html.append("<tr>");
				//1칸
				html.append("<td>");
				html.append(vo.getDeptno());
				html.append("</td>");
				
				//2칸
				html.append("<td>");
				html.append(vo.getDname());
				html.append("</td>");
				
				//3칸
				html.append("<td>");
				html.append(vo.getLoc());
				html.append("</td>");
			html.append("</tr>");
		}
		
		html.append("</table>");
		html.append("</body>");
		html.append("</html>");
		
		//전송(응답)
		response.getWriter().print(html.toString());
					
		
	}

}







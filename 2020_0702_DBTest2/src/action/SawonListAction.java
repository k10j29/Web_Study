package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import vo.SawonVo;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/sawon_list.do")
public class SawonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<SawonVo> list = SawonDao.getInstance().selectList();
		
		
		//출력(응답)
		//응답컨텐츠 정보 전송
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();
		//Html생성->전송
		out.write("<html>");
		out.write("<head><title>사원목록</title></head>");
		out.write("<body>");
		out.write("<table border='1'>");
		/* table title */
		out.write("<tr>");
		out.write("<th>사번</th>");
		out.write("<th>사원명</th>");
		out.write("<th>직위</th>");
		out.write("<th>성별</th>");
		out.write("<th>부서번호</th>");
		out.write("<th>입사일자</th>");
		out.write("<th>상사번호</th>");
		out.write("<th>급여</th>");
		out.write("</tr>");
		
		/* data */
		for(SawonVo vo : list) {
			out.write("<tr>");
				out.write("<td>");
				out.print(vo.getSabun());
				out.write("</td>");
				
				out.write("<td>");
				out.write(vo.getSaname());
				out.write("</td>");
				
				out.write("<td>");
				out.write(vo.getSajob());
				out.write("</td>");
				
				out.write("<td>");
				out.write(vo.getSasex());
				out.write("</td>");
				
				out.write("<td>");
				out.print(vo.getDeptno());
				out.write("</td>");
				
				out.write("<td>");
				out.write(vo.getSahire());
				out.write("</td>");
				
				out.write("<td>");
				out.print(vo.getSamgr());
				out.write("</td>");
				
				out.write("<td>");
				out.print(vo.getSapay());
				out.write("</td>");
				
			out.write("</tr>");
		}
		
		
		out.write("");
		out.write("</table>");
		out.write("</body>");
		out.write("</html>");
		
		
	}
    
}








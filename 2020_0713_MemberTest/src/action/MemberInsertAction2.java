package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberInsertAction
 */
@WebServlet("/member/insert.do")
public class MemberInsertAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//member/insert.do?m_grade=일반&m_name=박길동&m_id=park&m_pwd=1234&m_zipcode=08768&m_addr=서울+관악구+시흥대로+552
		
		//1.수신인코딩
		request.setCharacterEncoding("utf-8");
		
		//2.parameter수신
		String m_id 	= request.getParameter("m_id");
		String m_name 	= request.getParameter("m_name");
		String m_pwd 	= request.getParameter("m_pwd");
		String m_zipcode= request.getParameter("m_zipcode");
		String m_addr 	= request.getParameter("m_addr");
		String m_grade 	= request.getParameter("m_grade");
		//IP구하기
		String m_ip		= request.getRemoteAddr();
		
		//3.Vo포장
		MemberVo vo = new MemberVo(m_id, m_name, m_pwd, m_zipcode, m_addr, m_ip, m_grade);
		
		//4.DB Insert
		int res = MemberDao.getInstance().insert(vo);
		
		//5.목록보기로 이동
		response.sendRedirect("list.do");

	}

}
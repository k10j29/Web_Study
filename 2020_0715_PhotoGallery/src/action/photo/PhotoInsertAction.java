package action.photo;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.PhotoDao;
import vo.MemberVo;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoInsertAction
 */
@WebServlet("/photo/insert.do")
public class PhotoInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /photo/insert.do?p_title=aaa&p_content=bbb&p_photo=a.jpg

		// 업로드된 화일의 저장위치
		String web_path = "/upload/";// 웹경로
		// 웹경로->절대경로 전환
		ServletContext application = request.getServletContext();
		String abs_path = application.getRealPath(web_path);

		// 업로드될 화일의 크기제한(단위: byte)
		int max_size = 1024 * 1024 * 100; // 100MB

		// 객체생성 -> 업로드가 완료
		MultipartRequest mr = new MultipartRequest(request, abs_path, // 저장위치
				max_size, // 저장(최대)크기
				"utf-8", // 수신인코딩
				new DefaultFileRenamePolicy());
		// 업로드된 화일이름 얻어오기
		String p_filename = "no_file";
		File f = mr.getFile("p_photo");// form parame : <input type="file" name="p_photo">
		if (f != null) {
			p_filename = f.getName();
		}

		// 일반 parameter받기
		String p_title = mr.getParameter("p_title");
		String p_content = mr.getParameter("p_content");

		// p_content = "A\r\nB\rnC" => "A\r<br>B\r<br>C"

		p_content = p_content.replaceAll("\r\n", "<br>");

		// IP구하기
		String p_ip = request.getRemoteAddr();

		// 로그인 사용자 정보 구하기
		HttpSession session = request.getSession();
		// 세션에 저장되 유저정보 구하기
		MemberVo user = (MemberVo) session.getAttribute("user");

		int m_idx = user.getM_idx();

		// 데이터 포장
		PhotoVo vo = new PhotoVo(p_title, p_content, p_filename, p_ip, m_idx);

		// DB Insert
		int res = PhotoDao.getInstance().insert(vo);

		// 목록보기
		response.sendRedirect("list.do");

	}

}

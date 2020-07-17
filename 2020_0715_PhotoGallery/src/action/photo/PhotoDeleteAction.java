package action.photo;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoInsertAction
 */
@WebServlet("/photo/delete.do")
public class PhotoDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int p_idx = Integer.parseInt(request.getParameter("p_idx"));

		// p_idx에 해당되는 게시물 1건
		// 왜? : 삭제할 화일명 알아내기 위해
		PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);

		// 업로드된 화일의 저장위치
		String web_path = "/upload/";// 웹경로
		// 웹경로->절대경로 전환
		ServletContext application = request.getServletContext();
		String abs_path = application.getRealPath(web_path);

		// 삭제할 화일정보 구하기
		File f = new File(abs_path, vo.getP_filename());
		f.delete();

		// DB delete
		int res = PhotoDao.getInstance().delete(p_idx);

		// 목록보기
		response.sendRedirect("list.do");

	}

}

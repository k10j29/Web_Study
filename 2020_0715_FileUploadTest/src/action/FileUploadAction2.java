package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUploadAction
 */
@WebServlet("/upload2.do")
public class FileUploadAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// /upload.do?title=19TED&photo=a.jpg
		// mulitpartRequest 를 이용해서 parameter 수신을 해야함 (어디있냐면 lib cos package 에 있음)
		// 준비사항
		// 1// upload (저장될 경로) 설정 c:\\upload folder drive

		// String path = "c:\\upload";

		String web_path = "/upload2/";

		// Web 경로 (상대경로) => 절대경로 바꿀수 있는기능
		// 현재 이 request 가 사용하고있는 서브릿 컨텍스트 구하기

		ServletContext application = request.getServletContext();
		String path = application.getRealPath(web_path);

		System.out.println(path);

		// 2// 최대 저장 크기 설정
		int max_size = 1024 * 1024 * 100; // 100MB

		// request 받음
		// path 저장 위치
		// max_size 최대크기
		// utf-8 수신 인코딩
		// new DefaultFileRenamePolicy() (덮어쓰기x) 파일 이름 중복시 이름변경

		// ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ 객체 생성과 동시에 ==> 파일업로드 완료 (파일업로드 시켜준애)
		MultipartRequest mr = new MultipartRequest(request, path, max_size, "utf-8", new DefaultFileRenamePolicy());

		// ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ 실제 업로드된 파일정보 구하기 업로드랑 동일해야함 (photo 로 들어온애 (parameter 이름으로))

		// mr.getOriginalFileName("photo"); //처음에 올린 최초이름 근데 바뀌면? 아래 진행

		String filename = "no file";
		String filename2 = "no file";
		String filename3 = "no file";

		File f = mr.getFile("photo");
		if (f != null) { // if f가 null 이 아니면
			filename = f.getName(); // 최종으로 변경된 파일 이름을 구한다. 오리지널 파일이름이 아니라 new DefaultFileRenamePolicy()); 되어서 변경된
									// 이름의 파일
		}

		File f2 = mr.getFile("photo2");
		if (f2 != null) { // if f가 null 이 아니면
			filename2 = f2.getName(); // 최종으로 변경된 파일 이름을 구한다. 오리지널 파일이름이 아니라 new DefaultFileRenamePolicy()); 되어서 변경된
										// 이름의 파일
		}

		File f3 = mr.getFile("photo3");
		if (f3 != null) { // if f가 null 이 아니면
			filename3 = f3.getName(); // 최종으로 변경된 파일 이름을 구한다. 오리지널 파일이름이 아니라 new DefaultFileRenamePolicy()); 되어서 변경된
										// 이름의 파일
		}

		// Title 받아주기

		// String title = request.getParameter("title");

		// requset 는 이미 photo 에서 위임했기때문에 사용하지않음
		// 그래서 mr 에서 받아줘야함

		String title = mr.getParameter("title");

		// IP 받아주기
		// IP 는 파라메타가 아니기때문에 request 사용가능

		String ip = request.getRemoteAddr();

		// request binding
		request.setAttribute("title", title);
		request.setAttribute("filename", filename); // image file
		request.setAttribute("filename2", filename2); // image file
		request.setAttribute("filename3", filename3); // image file
		request.setAttribute("ip", ip);

		// Dispatcher (forward)
		String forward_page = "result2.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);

		disp.forward(request, response);

	}

}

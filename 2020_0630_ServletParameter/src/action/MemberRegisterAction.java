package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberRegisterAction
 */
@WebServlet("/member_register.do")
public class MemberRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest  request, 
			HttpServletResponse response
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// /member_register.do?name=홍길동&id=hong&pwd=11234&
		//                     gender=남자&
		//                     hobby=독서&hobby=운동&
		//                     friend=&friend=&friend=&
		//                     blood=A&profile=aaa
		
		
		// friend=&friend=&friend=
		
		//수신 인코딩 설정: 클라이언트측 인코딩과 일치시켜라
		//이유: 한글/특수문자이 깨짐현상 
		request.setCharacterEncoding("utf-8");
		
		
		//파라메터 수신
		String name   = request.getParameter("name");
		String id     = request.getParameter("id");
		String pwd    = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String profile= request.getParameter("profile");
		
		//동일한 parameter명이 여러개 있는경우 배열로 받는다
		String [] hobby_array  = request.getParameterValues("hobby");
		//취미항목은 체크하지 않으면 안넘어온다 => 배열은 null
		String hobby_list="취미없음";
		StringBuffer sb = new StringBuffer();
		
		if(hobby_array!=null) {
			//String [] hobby_array = {"독서","운동"};
			for(String hobby : hobby_array) {
				sb.append(hobby);
				sb.append(" ");
			}
			// sb = "독서 운동 " <=sb 내용
			//StringBuffer에 누적된 문자열을 옮겨놓는다
			hobby_list = sb.toString().trim();
		}
		
		//값의 여부와 상관없이 무조건 들어온다(무조건 배열 3개)	
		String [] friend_array = request.getParameterValues("friend");
		
		//String [] friend_array = {"","",""};
		//String [] friend_array = {"일친구","이친구",""};
		
		StringBuffer sb1 = new StringBuffer();
		for(String friend : friend_array) {
			sb1.append(friend);
			sb1.append(" ");
		}
		
		//sb1 = "";             <=친구없는경우
		//sb1 = "일친구 이친구";
		
		String friend_list="친구없음";
		
		//비어있지 않으면
		if(sb1.toString().trim().isEmpty()==false) {
			friend_list = sb1.toString().trim();
		}
		
		
		//응답처리
		//응답시 mime-type 및 인코딩 지정
		response.setContentType("text/html; charset=utf-8;");
		
		StringBuffer html = new StringBuffer();
		html.append("<html>");
		html.append("<head><title></title></head>");
		html.append("<body>");
		html.append("<table border='1'>");
		//1번째 줄
		html.append("<tr><th>이름</th><td>");
		html.append(name);
		html.append("</td></tr>");
		
		//2번째 줄
		html.append("<tr><th>아이디</th><td>");
		html.append(id);
		html.append("</td></tr>");
		
		
		//마지막줄
		html.append("<tr><td colspan='2' align='center'>");
		html.append("<a href='05_form_tags.html'>다시하기</a></td></tr>");
				
		html.append("</body>");
		html.append("</html>");
		
		
		//동적으로 작성된 html 전송
		//response.getWriter().println(html.toString());
		
		PrintWriter out  = response.getWriter();
		out.print(html.toString());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

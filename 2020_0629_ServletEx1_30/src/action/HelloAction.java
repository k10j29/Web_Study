package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */

@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest  request,  //요청처리객체
			HttpServletResponse response  //응답처리객체
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ip = request.getRemoteAddr();
		//System.out.printf("--[%s] HelloAction : WebModule 3.x Call--\n",ip);
		
		// 요청 URL => query형식을 통해서 parameter가 전달
		// http://192.168.7.206:9090/2020_0629_ServletEx1_30
		//                          /hello.do?nation=kor
		//                          /hello.do          <= null   
		//                          /hello.do?nation=  <= ""
		
		
		//                                  parameter명  
		String nation = request.getParameter("nation");
		//비정상적인 파라메터 처리
		if(nation==null || nation.isEmpty()) {
			nation="kor";
		}
		
		
		
		String greet_message = "";
		
		//nation=kor  nation=eng  nation=jpn nation=chn nation=ger
		if(nation.equals("kor")) {
			greet_message = String.format("[한국어(%s)] : 안녕하세요", nation);
		}else if(nation.equals("eng")) {
			greet_message = String.format("[영어(%s)] : Hi~~", nation);
		}else if(nation.equals("jpn")) {
			greet_message = String.format("[일본어(%s)] : 오겡끼데스까", nation);
		}else if(nation.equals("chn")) {
			greet_message = String.format("[중국어(%s)] : 니하오", nation);
		}else if(nation.equals("ger")) {
			greet_message = String.format("[독일어(%s)] : 구텐탁", nation);
		}else {
			greet_message = String.format("[나라(%s)] : 뭐지?", nation);
		}
				
		
		//응답처리
		//전송해야될 내용에 대한 정보 설정
		response.setContentType("text/html; charset=utf-8;");
		
		//응답시 이용할 문자스트림
		PrintWriter out = response.getWriter();
		//응답정보는 HTML로 전송 
		out.println("<html>");
		out.println("<head><title>환영합니다</title></head>");
		out.println("<body>");
		
		out.printf("[%s]님 환영합니다<br>",ip);
		//out.println("점심 맛있게 드세요...");
		out.println(greet_message);
		
		
		
		out.println("</body>");
		out.println("</html>");
		
	}

}






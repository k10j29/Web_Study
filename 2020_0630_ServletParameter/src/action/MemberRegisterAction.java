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
		
		// /member_register.do?name=ȫ�浿&id=hong&pwd=11234&
		//                     gender=����&
		//                     hobby=����&hobby=�&
		//                     friend=&friend=&friend=&
		//                     blood=A&profile=aaa
		
		
		// friend=&friend=&friend=
		
		//���� ���ڵ� ����: Ŭ���̾�Ʈ�� ���ڵ��� ��ġ���Ѷ�
		//����: �ѱ�/Ư�������� �������� 
		request.setCharacterEncoding("utf-8");
		
		
		//�Ķ���� ����
		String name   = request.getParameter("name");
		String id     = request.getParameter("id");
		String pwd    = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String profile= request.getParameter("profile");
		
		//������ parameter���� ������ �ִ°�� �迭�� �޴´�
		String [] hobby_array  = request.getParameterValues("hobby");
		//����׸��� üũ���� ������ �ȳѾ�´� => �迭�� null
		String hobby_list="��̾���";
		StringBuffer sb = new StringBuffer();
		
		if(hobby_array!=null) {
			//String [] hobby_array = {"����","�"};
			for(String hobby : hobby_array) {
				sb.append(hobby);
				sb.append(" ");
			}
			// sb = "���� � " <=sb ����
			//StringBuffer�� ������ ���ڿ��� �Űܳ��´�
			hobby_list = sb.toString().trim();
		}
		
		//���� ���ο� ������� ������ ���´�(������ �迭 3��)	
		String [] friend_array = request.getParameterValues("friend");
		
		//String [] friend_array = {"","",""};
		//String [] friend_array = {"��ģ��","��ģ��",""};
		
		StringBuffer sb1 = new StringBuffer();
		for(String friend : friend_array) {
			sb1.append(friend);
			sb1.append(" ");
		}
		
		//sb1 = "";             <=ģ�����°��
		//sb1 = "��ģ�� ��ģ��";
		
		String friend_list="ģ������";
		
		//������� ������
		if(sb1.toString().trim().isEmpty()==false) {
			friend_list = sb1.toString().trim();
		}
		
		
		//����ó��
		//����� mime-type �� ���ڵ� ����
		response.setContentType("text/html; charset=utf-8;");
		
		StringBuffer html = new StringBuffer();
		html.append("<html>");
		html.append("<head><title></title></head>");
		html.append("<body>");
		html.append("<table border='1'>");
		//1��° ��
		html.append("<tr><th>�̸�</th><td>");
		html.append(name);
		html.append("</td></tr>");
		
		//2��° ��
		html.append("<tr><th>���̵�</th><td>");
		html.append(id);
		html.append("</td></tr>");
		
		
		//��������
		html.append("<tr><td colspan='2' align='center'>");
		html.append("<a href='05_form_tags.html'>�ٽ��ϱ�</a></td></tr>");
				
		html.append("</body>");
		html.append("</html>");
		
		
		//�������� �ۼ��� html ����
		//response.getWriter().println(html.toString());
		
		PrintWriter out  = response.getWriter();
		out.print(html.toString());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
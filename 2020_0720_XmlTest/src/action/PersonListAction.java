package action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import vo.PersonVo;

/**
 * Servlet implementation class PersonListAction
 */
@WebServlet("/person/list.do")
public class PersonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 1 XML Parser
		SAXBuilder builder = new SAXBuilder();

		// 절대경로 설정
		String path = request.getServletContext().getRealPath("/");

		File f = new File(path, "person.xml");

		// ㅁ 리스트 만들어주기
		List<PersonVo> list = new ArrayList<PersonVo>();

		// 2 jdom 에있는 객체 Document 선택
		// XML 의 Document 구한거
		try {
			Document doc = builder.build(f);

			// Root Element 구하기
			Element root = doc.getRootElement();

			// Root 의 자식 요소 목록 얻어오기
			List<Element> element_list = root.getChildren("person");

			// 개선 for 문

			for (Element person : element_list) {
				// String name = person.getChildText("name");
				Element name_elElement = person.getChild("name");

				String name = name_elElement.getText();
				// 속성 읽어오기
				String nickname = name_elElement.getAttributeValue("nickname");
				int age = Integer.parseInt(person.getChildText("age"));
				String tel = person.getChildText("tel");
				String hometel = person.getChild("tel").getAttributeValue("hometel");
				
				
				//Vo 포장하기
				PersonVo p = new PersonVo(name, nickname, age, tel, hometel);
				//Arraylist 에추가하기
				list.add(p);
			}

		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("list", list);

		// Dispatcher (forward)
		String forward_page = "person_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);

		disp.forward(request, response);

	}

}

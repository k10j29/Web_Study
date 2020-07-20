package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MySearchUtil;
import vo.BookVo;

/**
 * Servlet implementation class BookSearchAction
 */
@WebServlet("/book_search.do")
public class BookSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// book_search.do?book_name=java

		request.setCharacterEncoding("utf-8");
		int start = 1;
		int display = 10;
		String book_name = request.getParameter("book_name");

		List<BookVo> list = MySearchUtil.search_book(book_name, start, display);

		request.setAttribute("list", list);

		// System.out.println(list.size());

		// Dispatcher(forward)
		String forward_page = "book_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
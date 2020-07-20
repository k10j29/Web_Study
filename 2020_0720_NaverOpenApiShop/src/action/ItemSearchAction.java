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
import vo.ShopVo;

/**
 * Servlet implementation class BookSearchAction
 */
@WebServlet("/item_search.do")
public class ItemSearchAction extends HttpServlet {
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
		String item_name = request.getParameter("item_name");

		List<ShopVo> list = MySearchUtil.search_item(item_name, start, display);

		// System.out.println(list.size());

		// request binding
		request.setAttribute("list", list);

		// Dispatcher(forward)
		String forward_page = "item_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
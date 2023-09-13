package coffee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list.page")
public class CoffeeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoffeeDao dao = new CoffeeDao();
		
		int currentPage = 1;
		int pageSize = 4;
		if(request.getParameter("p") != null) {
			currentPage = Integer.parseInt(request.getParameter("p"));
		}
		
		ArrayList<Coffee> list = dao.getListPage(currentPage, pageSize);
		int totRecords = dao.getTotal(); //총 레코드 수
		request.setAttribute("list", list);
		request.setAttribute("curPage", currentPage);
		request.setAttribute("totCnt", totRecords);
		request.getRequestDispatcher("WEB-INF/views/listpage.jsp").forward(request, response);
	}
}

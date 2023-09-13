package day_07_MVC실습;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class insertServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
	
		goodService s = new goodService();
		s.insertMenu(new Good(id,name,price));
		
		request.setAttribute("insert", name);
		request.getRequestDispatcher("WEB-INF/views/insertMenu.jsp").forward(request, response);
	}
}

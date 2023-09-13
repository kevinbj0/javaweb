package day_07_MVC실습;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class updateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String price = request.getParameter("price");
		
		goodService s = new goodService();
		s.updateMenu(id, price);
		
		request.setAttribute("update", id);
		request.getRequestDispatcher("WEB-INF/views/updateMenu.jsp").forward(request, response);
	}
	
}

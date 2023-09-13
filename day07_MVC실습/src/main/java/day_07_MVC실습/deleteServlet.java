package day_07_MVC실습;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class deleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		goodService s = new goodService();
		s.delectMenu(id);
		
		request.setAttribute("delete", id);
		request.getRequestDispatcher("WEB-INF/views/deleteMenu.jsp").forward(request, response);
	}
}

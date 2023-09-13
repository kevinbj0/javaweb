package MapleUpdate;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cubeService s = new cubeService();
		
		HttpSession session = request.getSession();
		ArrayList<String> list = s.AllCart();
		
		System.out.println(list);
	
		session.setAttribute("cartAll", list);
		request.getRequestDispatcher("WEB-INF/views/cartList.jsp").forward(request, response);
	}
}

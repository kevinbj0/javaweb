package cartPrj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/itemDetail")
public class ItemDetailServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//상품정보가져오기
		//서비스,dao
		String code = req.getParameter("code");
		//모델심기
		//String item ="티셔츠";
		ItemService s = new ItemService();
		String item = s.getItem(code);
		
		req.setAttribute("selItem", item);
		req.getRequestDispatcher("WEB-INF/views/itemDatail.jsp").forward(req, resp);
	}
}

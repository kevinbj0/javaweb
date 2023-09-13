package day_07_MVC실습;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectone")
public class selectOneServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//id 받아오기
		String id = request.getParameter("id");
		
		//서비스 로드
		goodService s = new goodService();
		//모델 선택(id로 조회)
		String name = s.getMenuOne(id);
		//view로 보낼준비(Set)
		request.setAttribute("good", name);
		//view로 보냄(Get)
		request.getRequestDispatcher("WEB-INF/views/selectOne.jsp").forward(request, response);
	}
}

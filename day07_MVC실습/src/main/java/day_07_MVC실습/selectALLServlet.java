package day_07_MVC실습;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectall")
public class selectALLServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서비스 로드
		goodService s = new goodService();
		
		//조회 모델로 선택
		ArrayList<String> list = s.getMenuList();
		
		//리스트 보낼준비(세팅)
		request.setAttribute("list",list);
		//view로 보냄
		request.getRequestDispatcher("WEB-INF/views/selectALL.jsp").forward(request, response);
	}
}

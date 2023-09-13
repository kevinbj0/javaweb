package day_07;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//출력
@WebServlet("/acorn")
public class AcornServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 모델
		AcornService s = new AcornService();
		//ArrayList<String> list = s.getMemberList();
		ArrayList<String> list = s.getMemberRealList();
		System.out.println(list);

		// 모델 심기
		request.setAttribute("list", list);
		// view로 forward
		request.getRequestDispatcher("WEB-INF/views/acorn.jsp").forward(request, response);
	}
}

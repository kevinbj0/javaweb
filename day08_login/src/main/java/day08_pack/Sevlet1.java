package day08_pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class Sevlet1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//모델
		String model = "test 성공";
		
		//request : 저장소로 사용가능
		//요청단위의 정보를 공유하고 싶을 떄
		//요청이 생길 때마다 새로운 request, response 객체가 생성됨
		request.setAttribute("test", model); //키값, 넘어갈 데이터
		request.getRequestDispatcher("WEB-INF/views/testview.jsp").forward(request, response);
	}
}

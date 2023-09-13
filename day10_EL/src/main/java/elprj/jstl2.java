package elprj;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstl2")
public class jstl2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//String[] books = {"부의 인문학","c언어를 배우기 전 알아야 할 것","빌린돈은 갚지마라"};
		
		//String s="문자열입니다";  //정적(static  상수영역 )
		//String s2 = new String("문자열입니다");  // heap 메모리 저장
		
		ArrayList<String> books = new ArrayList<>();
		books.add("부의 인문학");
		books.add("c언어를 배우기 전 알아야 할 것");
		books.add("빌린돈은 갚지마라");
		
		
		req.setAttribute("books", books);
		req.getRequestDispatcher("WEB-INF/views/jstl2.jsp").forward(req, resp);
	}
}
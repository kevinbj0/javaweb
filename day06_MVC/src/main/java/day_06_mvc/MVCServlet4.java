package day_06_mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/movies")
public class MVCServlet4 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//모델 만들기
		ServiceMVC4 s = new ServiceMVC4();
		ArrayList<String> list = s.getMovies();
		
		//모델심기
		request.setAttribute("movies",list);
		
		request.getRequestDispatcher("WEB-INF/views/movie.jsp").forward(request, response);
	}
}

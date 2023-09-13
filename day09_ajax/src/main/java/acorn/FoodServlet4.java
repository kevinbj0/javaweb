package acorn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/food4")
public class FoodServlet4 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//json 관련 라이브러리
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
	
		FoodService service = new FoodService();
		JSONArray arr = service.getFoodList();
		response.getWriter().println(arr);
	}
}

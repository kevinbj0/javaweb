package day08_pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class loginSerlvet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그인 처리 사용자인지 확인해야함 서비스, dao가 필요함
		//아이디와 비번이 동일하면 정상로그인
		//아니면 다시 로그인화면으로
		String id = req.getParameter("id").trim();
		String pw = req.getParameter("pwd").trim();
		
		System.out.println(id+" "+pw);
		
		//아이디와 비번이 동이랗면 정상로그인으로 간주
		if(id.equals(pw)) {
			//메인페이지로 이동
			//로그인성공시 ==> 세션저장소에 아이디를 저장해놓음
			HttpSession session = req.getSession();
			
			session.setAttribute("logid", id);
			resp.sendRedirect("/day08_login/home");
		}else {
			//로그인화면으로
			resp.sendRedirect("/day08_login/login");
		}
	}
}

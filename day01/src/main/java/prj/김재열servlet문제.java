package prj;

import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1")
public class 김재열servlet문제 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		// resp.setContentType("text/plain");
		resp.setCharacterEncoding("utf-8");

		// 1번
//		String su1_ = req.getParameter("su1");
//		String su2_ = req.getParameter("su2");
//
//		int su1 = Integer.parseInt(su1_);
//		int su2 = Integer.parseInt(su2_);
//
//		int add = su1 + su2;
//		int multi = su1 * su2;
//		int subtract = su1 - su2;
//		int division = su1 / su2;
//		
//		
//		PrintWriter out = resp.getWriter();
//		
//		out.println("<html>");
//		out.println("<head><title>계산 결과</title></head>");
//		out.println("<body>");
//		out.println("<h1>덧셈: " + add + "</h1>");
//		out.println("<h1>곱셈: " + multi + "</h1>");
//		out.println("<h1>나눗셈: " + division + "</h1>");
//		out.println("<h1>뺄셈: " + subtract + "</h1>");
//		out.println("</body>");
//		out.println("</head>");

		// 2번 겸 3번

//		String numStr = req.getParameter("num");
//		int num = Integer.parseInt(numStr);
//
//		for (int i = 1; i < 10; i++) {
//			int mt = num * i;
//			PrintWriter out = resp.getWriter();
//			out.println("<html>");
//			out.println("<head><title>계산 결과</title></head>");
//			out.println("<body>");
//			out.println("<h1>&nbsp" + mt + "&nbsp </h1>");
//			out.println("</body>");
//			out.println("</head>");
//			out.println("</html>");
//		}

		// 4번

		Book1 book = new Book1("김", "테", 120);
		PrintWriter out = resp.getWriter();
		out.println(book.toString());

		// 5번
//		PrintWriter out = resp.getWriter();
//		String Star = req.getParameter("str");
//		int str = Integer.parseInt(Star);
//		for (int i = 1; i <= str; i++) {
//			for (int j = 1; j <= i; j++) {
//				out.print("* ");
//			}
//			out.println("<br>");
//		}

		// 6번
//		PrintWriter out = resp.getWriter();
//		String num1 = req.getParameter("num");
//		int num = Integer.parseInt(num1);
//		for (int i = 1; i <= num; i++) {
//			if (num % i == 0) {
//				out.println(i);
//			}
//		}

		// 7번
//		PrintWriter out = resp.getWriter();
//		out.println("화이팅");

		// 8번
		// PrintWriter out = resp.getWriter();
		// String[] message = { "화이팅", "잠은 죽어서 자자", "시작은 시작이다", "늦었을땐 진짜 늦은거다" };
		// Random ran = new Random();
		// int randomIndex = ran.nextInt(message.length);
		// String selmessage = message[randomIndex];
		// out.println(selmessage);

		// 9번
//		PrintWriter out = resp.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>큐티 섹시</h1>");
//		out.println("<img src = \"/PRJ/img/초롱이.jpg\">"); 
//		out.println("</body>");
//		out.println("</html>");

		// 10번
		/*
		 * PrintWriter out = resp.getWriter(); String[] randomimg = {
		 * "<img src = \"/PRJ/img/초롱이.jpg\">", "<img src = \"/PRJ/img/img.jpg\">",
		 * "<img src = \"/PRJ/img/img2.jpg\">"
		 * 
		 * }; Random ran = new Random(); int randomIndex =
		 * ran.nextInt(randomimg.length); String selimg = randomimg[randomIndex];
		 * out.println(selimg);
		 */

	}
}
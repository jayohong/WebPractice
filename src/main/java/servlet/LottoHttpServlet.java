package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value= {"/servlet/lotto"})
public class LottoHttpServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		Set<Integer> nums = new LinkedHashSet<>();
		Random r = new Random();
		while(nums.size()<5) {
			nums.add(r.nextInt(39)+1);
		}
		
		PrintWriter out = resp.getWriter();
		out.print("539樂透"+nums);
	}

}

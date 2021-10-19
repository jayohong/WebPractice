package servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/servlet/circlecalc")
public class CircleCalcHttpServlet extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//在 Web 應用程式中，有時需要多個 Servlet 來完成請求，像是將另一個 Servlet 的回應包括進來，
	//或將請求轉發給別的 Servlet 處理。
	//透過 HttpServletRequest的getRequestDispatcher()取得的是一個實作了RequestDispatcher介面的物件，
	//呼叫 HttpServletRequest的getRequestDispatcher()需要傳入一個相對於目前請求 URL 的路徑資訊。
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/circle_form.jsp");
		rd.forward(req,resp);
	}
	//這篇寫的不錯 可以參考
	//https://ithelp.ithome.com.tw/articles/10185109

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String radius = req.getParameter("radius");
		String items[]= req.getParameterValues("item");
		System.out.println("radius: "+radius);
		System.out.println("item: "+Arrays.stream(items));
		
		double r = Double.parseDouble(radius);
		//StringBuffer和StringBuiler之間的最大不同在於StringBuilder 的方法不是執行緒安全的。
		StringBuilder result = new StringBuilder();
		for(String item:items) {
			switch(item) {
				case "A":
					System.out.println("直徑"+2*r);
					result.append("直徑"+2*r).append("<br />");
					break;
				case "B":
					System.out.println(String.format("圓周: %.2f", 2*r*Math.PI));
					result.append(String.format("圓周: %.2f", 2*r*Math.PI)).append("<br />");
					break;
				case "C":
					System.out.println("面積"+2*Math.PI*Math.pow(r, 2));
					result.append("面積"+2*Math.PI*Math.pow(r, 2)).append("<br />");
					break;
				case "D":
					System.out.println("體積"+4.0/3*Math.PI*Math.pow(r, 3));
					result.append("體積"+4.0/3*Math.PI*Math.pow(r, 3)).append("<br />");
					break;
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/circle_result.jsp");
		//什麼是Attribute，在程式語言中Attribute指的是屬性的意思，但在Request中，常被用為參遞參數之用。
		//下列淺談Request中的Attribute的幾個特性
		
		//Attribute的設值及取值(Set and Get)，以使用者於前端輸入值，傳到Servlet再到Jsp顯示為例。
		
		//browser(user)->setAttribute(servlet)->jsp(getattribute)->attribute dead
		req.setAttribute("result", result);
		rd.forward(req, resp);
	}
	
}

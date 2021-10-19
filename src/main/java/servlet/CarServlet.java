package servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/servlet/car")
public class CarServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		//顯示 Http 文件 Header(Part 2)
		
		//Enumeration接口定義，通過它可以枚舉（獲得一次一個）的對象集合的元素的方法。
		//這個原有的接口已經被取代了迭代器。雖然未過時，枚舉被認為是過時的新代碼。
		//然而，它是用來通過由舊版的類，如向量和屬性定義了幾種方法，所使用的其它幾個API類，而且目前在應用程序代碼中的廣泛使用。
		//通過枚舉中聲明的方法總結如下表：
		//1 boolean hasMoreElements( )當實現，同時還有更多的元素來提取它必須返回true和false當所有的元素都被列舉.
		//2 Object nextElement( )這將返回枚舉中的下一個對象作為一種通用的對象引用.
		Enumeration headerNames = req.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement().toString();
			String headerValue = req.getHeader(headerName);
			out.println(headerName+"="+headerValue+"<br />");
		}
		//<hr>: horizontal rule
		out.println("<hr>");
		out.println(req.getHeader("accept-language"));
		out.println("<hr>");
		//顯示 HTTP 文件內容(Part 4)
		InputStreamReader isr = new InputStreamReader(req.getInputStream());//取得 http 文件串流
		char[] buffer = new char[1];
		while(isr.read(buffer)!=-1) {
			out.print(new String(buffer));
		}
		
	}
	
}

package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CycleServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/charset=utf-8;");
		//1. 接收資料
		String radiu = req.getParameter("r");
		PrintWriter out = res.getWriter();
		if(radiu == null) {
			out.print("please input r");
		}else {
			double r = Double.parseDouble(radiu);
			double area = Math.PI*Math.pow(r, 2);
			double volume = 4.0/3*Math.PI*Math.pow(r, 3);
			String result =String.format("area =%.1f volume=%.2f", area, volume);
			out.print(result);
			out.print("\n"+area +"\n"+volume);
			
		}
		
		
		
	}
	
	

}

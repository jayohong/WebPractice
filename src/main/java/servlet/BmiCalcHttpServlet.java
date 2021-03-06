package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = {"/servlet/bmicalc"})
public class BmiCalcHttpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得參數資料
		String height = req.getParameter("height"); // 取得表單 height 欄位的資料
		String weight = req.getParameter("weight"); // 取得表單 weight 欄位的資料
		// 轉型
		double h = Double.parseDouble(height);
		double w = Double.parseDouble(weight);
		// 計算 bmi
		double bmi = w / Math.pow(h/100, 2);
		
		//---------------------------------------------------------------------
		// 透過 jsp 渲染資料
		// 1. 建立分派器(並指定 jsp)
		// 2. 建立要送資料
		// 3. 分派方式 forward, include
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/bmi_result.jsp");
		req.setAttribute("bmi", bmi); // 建立一個 request 變數名叫 bmi 裡面放入 bmi 的計算結果
		rd.forward(req, resp); // 重新導向
	
		
		
//		PrintWriter out = resp.getWriter();
//		out.print(bmi);
	}
	
}

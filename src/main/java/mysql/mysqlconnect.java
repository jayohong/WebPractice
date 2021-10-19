package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysqlconnect {
	public static void main(String[] args) {
        //判斷驅動是否載入成功
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //固定語法
			System.out.print("成功載入驅動！");//提示語
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("載入驅動失敗！");
			e.printStackTrace();
		}
        //連線mysql
		Connection con;   
        //localhost為主機名  3306為mysql的埠號   web：進行連線的目標資料庫  
		String url = "jdbc:mysql://127.0.0.1:3306/mysql?serverTimezone=UTC";
        //登入資料庫使用者名稱
		String user = "root";
        //登入資料庫的密碼
		String password = "12345678";
		try {
			 con = DriverManager.getConnection(url,user,password); //將引數傳給驅動進行連線
			if(!con.isClosed()) {
				System.out.print("成功連線資料庫！");
                //建立statement物件
				//Statement statement = con.createStatement();
                //宣告一個sql語句查詢student表中所有資訊
				//String sql = "select * from student";
				//ResultSet rs = statement.executeQuery(sql);
                //迴圈輸出列印student表中的id name age
				//while (rs.next()){System.out.print(rs.getString("id"));
				//System.out.print("");
//				System.out.print(rs.getString("name"));
//				System.out.print("");
//				System.out.print(rs.getString("age"));
//				System.out.print("\t");}			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}


	}

}
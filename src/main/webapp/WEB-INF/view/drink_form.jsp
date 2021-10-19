<%@page import="java.util.*"%>
<%@page import="entity.Drink"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Drink form</title>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<script>
	//prompt() 方法用于显示可提示用户进行输入的对话框。 
	//語法prompt(text,defaultText)
	//text 可选。要在对话框中显示的纯文本（而不是 HTML 格式的文本）。
	//defaultText 可选。默认的输入文本。
	function updateAmount(id,amount){
		console.log("console.log測試");	
		var updateAmount = prompt("修改" + id + "號訂單數量"+amount);
		alert("alert Test");
		console.log(updateAmount);
		var updateUrl = '${pageContext.request.contextPath}/servlet/drink?updateRowId=' + id + '&updateAmount=' + updateAmount;
		console.log(updateUrl);
		//location.href是屬性 另一個很想的location.replace()則是方法
		location.href=updateUrl;		
	}
	
</script>
</head>
<body style="padding: 15px">
	<!-- form屬性說明 -->
	<!-- method: 用來指定資料傳輸時用的 HTTP 協議，最常用的是 get 或 post： -->
	<!-- action: 用來指定一個位址 (URL)，這個位址是告訴瀏覽器 (browser) 當 user 按送出表單後，要將表格的內容送去哪邊 -->

	<!-- html表單其實只支援get post 其他html方法其實是靠第三方(spring)支援 -->

	<form class="pure-form" method="post"
		action='${pageContext.request.contextPath}/servlet/drink'>
		<fieldset>
			<legend>(legend)Drink 訂單</legend>  <!-- 表單標題 -->
			<!-- 
			select下拉式選單->屬性 name:聲明欄位名稱  
							   *disabled: 將欄位設定為禁用的狀態，是一個布林 (boolean) 屬性 
							   required: 將欄位設定為必填，是一個布林 (boolean) 屬性
			option 選單內容->屬性 value: 指定如果選了該選項，表單要傳送什麼值給遠端伺服器，如果沒設定 value，預設是送 option 的內容
							   *selected: 設定預先選取此選項，是一個布林屬性
							   label: 說明選項的含義，有設定時會被瀏覽器顯示為選項內容，通常用來當做簡短版的選項文字
							   disabled: 將選項設定為不可選的狀態，是一個布林 (boolean) 屬性
			 -->			
			品名: 
			<select name="id" required="required">
				<option  selected="selected">屬性 預設選項</option>
				<option  disabled="disabled">屬性 不可選擇</option>				
				<% if (request.getAttribute("drinks") != null) { %>
					<% for (Object item : (List) request.getAttribute("drinks")) { %>
						<% Drink drink = (Drink) item; %>
						<option value="<%= drink.getId() %>">
						<%= drink.getName() %> $<%= drink.getPrice() %> (庫存:<%= drink.getStock() %>)
						</option>
					<% } %>
				<% } %>
			</select>
			<p />  <!-- p 段落換行 -->
			
			<!-- 
			input標籤->屬性 name: 欄位名稱,用來指定送出去的該筆資料要用什麼名稱，目的是讓遠端伺服器才能透過明確定義好的名稱去取出對應的欄位值。 
			              value: 指定初始值 (default value)
			              disabled: 將元件設定為禁用狀態
			              readonly: 將元件設為唯獨不可更改內容的狀態
			              autocomplete: 是否啟用瀏覽器自動完成功能
			              autofocus: 當頁面載入後，自動聚焦在此欄位上
			              required: 指定為必填欄位
			              type 屬性: 建立不同類型的表單元件
			              placeholder 屬性: 輸入的提示訊息
			              <input type="password"> 密碼輸入欄位
			              <input type="checkbox"> 核取方塊
			              <input type="radio"> 選項按鈕
			              太多了 剩下參考這篇https://www.fooish.com/html/input-tag.html
			 -->
			數量:<input type="number" placeholder="請輸入訂購數量" name="amount"
				maxlength="4">
			<p />
			<button type="submit" class="pure-button pure-button-primary">訂購</button>
			<button type="reset" class="pure-button pure-button-primary">清除</button>
		</fieldset>
	</form>
	${ list }
	<p />
	<!-- 
	TABLE代表表格
	TR代表表格中的一行 TD代表表格中(行裡)的一列 
	'TR'与'TD'交成一个单元格
	TABLE.../TABLE之间有多少个TR，就有多少行
	T>.../TR之间有多少个TD，就有多少列
	
	THEAD則是表單的標頭
	注意 tr包裹內容則是th 而非td
	-->
	<table class="pure-table pure-table-bordered">
		<thead>
			<tr>
				<th>#</th>
				<th>id</th>
				<th>name</th>
				<th>amount</th>
				<th>subtotal</th>
				<th>memo</th>
				<th>update</th>>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
			<%int rowId = 0;%>
			<%if (request.getAttribute("list") != null) {%>
				<%for (Object item : (List)request.getAttribute("list")) {%>
					<%Map map = (Map) item;	%>
					<tr>
						<td><%=rowId%></td>
						<td><%=map.get("id")%></td>
						<td><%=map.get("name")%></td>
						<td>
							<!-- 
							<span> 標籤 (tag) 是用來當作容器 (container)，用來包裹文字 (text) 或其他行內 (inline) 的 HTML，
							用途是方便給 CSS 做樣式排版或方便給 JavaScript 做互動操作，至於 <span> 本身沒任何特殊意義也不帶任何標籤語意。
							
							 -->
							
							<%if(Boolean.parseBoolean(map.get("flag").toString())){ %>
								<span style="cursor: pointer;text-decoration-color:blue;text-decoration: underline;"
									  title="按我一下可以修改數量"
									  onclick="updateAmount(<%=rowId %>, <%=map.get("amount") %>)">
									  <%=map.get("amount") %>											
								</span>	
							<% } %>
						</td>
						
						<td><%=Integer.parseInt(map.get("amount").toString())	*Integer.parseInt(map.get("price").toString()) %></td>
						<td><%=map.get("memo")%></td>
						<td>
							<%if(Boolean.parseBoolean(map.get("flag").toString())){ %>
								<button type="button"
										onclick="updateAmount(<%=rowId%>,<%=map.get("amount")%>)"
										class="pure-button">修改數量</button>
							<% } %>
						</td>
						<td>
							<%if(Boolean.parseBoolean(map.get("flag").toString())){ %>
								<button type="button"
										onclick="location.href='${pageContext.request.contextPath}/servlet/drink?deleteRowId=<%=rowId %>';"
										class="pure-button">刪除</button>
							<% } %>
						</td>
					</tr>
				<% rowId++; %>
				<% } %>
			<%	}	%>
		

		</tbody>
	</table>

</body>
</html>
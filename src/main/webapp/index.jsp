<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	現在時刻: <%=new Date() %>
	<hr /> <!-- 水平線 -->
	
	<!-- HTML <li> 元素 （或称 HTML 列表条目元素） 用于表示列表里的条目。它必须包含在一个父元素里：
	一个有序列表(<ol>)，一个无序列表(<ul>)，或者一个菜单 (<menu>)。
	在菜单或者无序列表里，列表条目通常用点排列显示；在有序列表里，
	列表条目通常在左边显示按升序排列的计数，例如数字或者字母。 -->
	<ol>
		<li><a href="./servlet/bmi?h=170&w=60">BmiServlet</a></li>
		<li><a href="./servlet/cycle?r=10">CycleServlet</a></li>
		<li><a href="./servlet/random?n=5">RandomServlet</a></li>
		<li><a href="./servlet/lotto">LottoHttpServlet</a></li>
		<li><a href="./form/bmi_form.jsp">bmi_form.jsp</a></li>
		<li><a href="./servlet/circlecalc">CircleCalcHttpServlet</a></li>
		<li><a href="./servlet/drink">DrinkHttpServlet</a></li>		
	</ol>
</body>
</html>
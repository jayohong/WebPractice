<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Circle Result</title>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body style="padding: 15px">

	<form class="pure-form">
	<!-- fieldset 標籤 (tag) 用來對表單 (form) 中的控制元件做分組 (group)，而 legend 標籤通常是 
	fieldset 裡面的第一個元素作為該分組的標題 (caption)。 -->
		<fieldset name="text">
			<legend>Circle 計算結果</legend>
			<h1>使用樣板字樣的方式:<br />${result}</h1>
			<h2>使用getAttribute的方式<br /><%=request.getAttribute("result") %></h2>
			<p />
			<button type="button"
				onclick="location.href='${pageContext.request.contextPath}/servlet/circlecalc'"
				class="pure-button pure-button-primary">返回</button>
		</fieldset>
	</form>

</body>
</html>
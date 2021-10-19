<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- rel 属性规定当前文档与被链接文档之间的关系。 -->
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
</head>
<body>
	<!-- 樣板字面值${bmi} -->
	<form style ="pure-form">
		<fieldset>
			<legend>BMI 計算結果</legend>
			${ bmi }
			<p />
			
			<button type="button"
					onclick="location.href='${pageContext.request.contextPath}/form/bmi_form.jsp';" 
					class ="pure-button pure-button-primary"
			>返回</button>
		</fieldset>	
	</form>

</body>
</html>
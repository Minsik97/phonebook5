<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		                            <!-- pbc에서 받은 값 -->
		                            <!-- 대문자는 sql의 키 값이다 -->
		<form action= "${pageContext.request.contextPath }/phone/modify" method="get">
			이름(name): <input type="text" name="name" value="${requestScope.pMap.name}"> <br>
			핸드폰(hp): <input type="text" name="hp" value="${requestScope.pMap.HP }"> <br>
			회사(company): <input type="text" name="company" value="${requestScope.pMap.COMPANY }"> <br> 
			
			<!-- 아이디 -->
		    <input type="hidden" name="phoneId" value ="${requestScope.pMap.phoneId}"><br>
			
			<button type="submit">수정</button>
		</form>
		
		
</body>
</html>
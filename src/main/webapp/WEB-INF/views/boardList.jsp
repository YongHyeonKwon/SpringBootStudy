<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>게시판 목록</h1>

	<table border="1">
	
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.idx}</td>
				<td>${board.title}</td>
				<td>${board.writer}</td>
				<td>${board.indate}</td>
				<td>
				
					<!--  static을 기준으로 작성하면 된다. -->
					<img src="img/${board.img}">
				</td>
				
			</tr>
		</c:forEach>
	
	</table>

	<a href="goWrite">작성하기</a>

	
</body>
</html>
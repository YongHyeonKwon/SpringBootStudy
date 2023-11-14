<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>게시글 작성하기</h1>

	<form action="write" method="post" enctype="multipart/form-data">
	
		Title : <input type="text" name="title"> <br>
		
		Writer : <input type="text" name="writer"> <br>
					
		IMG : <input type="file" name="file"> <br>
		
		Content : <textarea rows="15" cols="30" name="content"></textarea> <br>
		
		<button>작성하기</button>
				
		
	
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<header >
		<h2>게시판 글쓰기</h2>
	</header>
	<section>
		<form action="">
			제목: <input type="text" name="TITLE"
				placeHolder="제목을 입력하세요" size="20"><br>
			내용: <br>
			<textarea rows="5" cols="80" name="CONTENT"></textarea>
			<br>
			<input type="submit" value="글 올리기">
			<input type="reset" value="취 소">
		</form>
	</section>
</div>
</body>
</html>
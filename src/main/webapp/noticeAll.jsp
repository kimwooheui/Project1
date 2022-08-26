<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>�������� ���</h2>
		<table>
			<tr>
				<th width="15%">�۹�ȣ</th>
				<th width="20%">�ۼ���</th>
				<th width="30%">�� ��</th>
				<th width="40%">�ۼ���</th>
			</tr>
			<c:forEach items="${LIST }" var="notice">
			<tr>
				<td>${notice.seqno }</td>
				<td>${notice.id }</td>
				<td>${notice.title }</td>
				<td>${notice.datt }</td>
			</tr>
			</c:forEach>
		</table>
		<c:forEach begin="1" end="${PAGES }" var="page">
			<a href="">${page }</a>
		</c:forEach>
		
	</div>
</body>
</html>
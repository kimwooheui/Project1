<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<section>
	<div align="right"><a href="template.jsp?BODY=entry.jsp">�����ϱ�</a></div>
	<div align="center">
		<form action="login.do" method="post" onSubmit="return check(this)">
			�� �� : <input type="text" name="ID" size="10"/><br/>
			�� ȣ : <input type="password" name="PWD" size="10"/><br/><br/>
			<input type="submit" value="�α���"/>
			<input type="reset" value="�� ��"/>
		</form>
	</div>
</section>

<script type="text/javascript">
function check(f){
	if(f.ID.value == ''){
		alert("������ �Է��ϼ���."); return false;
	}
	if(f.PWD.value == ''){
		alert("��ȣ�� �Է��ϼ���."); return false;
	}
}
</script>
</body>
</html>







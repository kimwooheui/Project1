<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="myStyle.css">
</head>
<body>
<%
	String id=request.getParameter("ID");
%>
<header>
	<h2 align="center"> ȸ������</h2>
</header>

<section>
	<form action="memberRegister.do" method="post" 
			onSubmit="return checkEntry(this)">
	<div align="center">
	<table border="1">
	<tr><th>ȸ����ȣ(�ڵ��߻�)</th><td><input type="text" 
		name="IDD" readonly/></td></tr>
	<tr><th>ȸ������</th><td><input type="text"
		name="NAME"/></td></tr>
	<tr><th>ȸ����ȭ</th><td><input type="text"
		name="TEL"/></td></tr>
	<tr><th>ȸ���ּ�</th><td><input type="text"
		name="ADDR"/></td></tr>
	<tr><th>��������</th><td><input type="date"
		name="DATE"/></td></tr>
	<tr><th>�����[A:VIP,B:�Ϲ�,C:����]</th><td>
		<select name="LEVEL">
			<option value="A">VIP</option>
			<option value="B">�Ϲ�</option>
			<option value="C">����</option>
		</select></td></tr>
	<tr><th>�����ڵ�</th><td>
		<select name="CITY">
			<option value="01">����</option>
			<option value="60">����</option>
			<option value="30">�︪��</option>
		</select></td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="���" name="btn"/>
		<input type="button" value="��ȸ" 
					onClick="doSelect()"/>
		</td></tr>
	</table>
	</div>
	</form>
</section>

<script type="text/javascript">
function doSelect(){
	if(confirm("������ ��ȸ�Ͻðڽ��ϱ�?")){
		location.href="memberAll.do";//��ȸ���� ȣ��
	}
}
function checkEntry(frm){
	if(frm.NAME.value == ''){
		alert("�̸��� �Է��ϼ���."); return false;
	}
	if(frm.TEL.value == ''){
		alert("ȸ����ȭ�� �Է��ϼ���."); return false;
	}
	if(frm.ADDR.value == ''){
		alert("�ּҸ� �Է��ϼ���."); return false;
	}
	if(frm.DATE.value == ''){
		alert("��¥�� �����ϼ���."); return false;
	}
	if(confirm("�Է��� ������ �½��ϱ�?")){
		return true;
	}else{
		return false;
	}
}
</script>
</body>
</html>










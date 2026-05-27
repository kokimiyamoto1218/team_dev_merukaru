<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="all.css" rel="stylesheet">
<title>ログイン</title>

</head>
<div style="text-align: center;">

<body>
<form action = "/team_dev_merukaru/SystemServlet" method = "post">
<h2><font size="6">ログイン</h2>
<p>${message }</p>
<font size="6">名前</font><br>
<input type="text" name="name" cols="20" value="${name}"><br>
<font size="6">Pass</font><br>
<input type="password" name="pass" cols="20"><br><br>
<button name = "action" value = "login">ログイン</button><br>
</form>
<p><a href="/team_dev_merukaru/SystemServlet?action=new">新規会員登録</a> <a href="/team_dev_merukaru/SystemServlet?action=seikyoulogin">生協の方はこちら</a></p>

</body>

</div>
</html>
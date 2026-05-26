<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link href="all.css" rel="stylesheet">
</head>
<body>
<form action = "/team_dev_merukaru/SystemServlet" method = "post">
<h2>ログイン</h2>
<p>${message }</p>
名前<br>
<input type="text" name="name" cols="20"><br>
Pass<br>
<input type="password" name="pass" cols="20"><br><br>
<button name = "action" value = "login">ログイン</button><br>
</form>
<p><a href="/team_dev_merukaru/SystemServlet?action=new">新規会員登録</a> <a href="/team_dev_merukaru/SystemServlet?action=seikyoulogin">生協の方はこちら</a></p>

</body>
</html>
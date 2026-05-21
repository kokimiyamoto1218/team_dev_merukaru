<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生協ログイン</title>
<link href="all.css" rel="stylesheet">
</head>
<body>
<form action = "/team_dev_merukaru/SystemServlet" method = "post">
<h2>生協ログイン</h2>
名前<br>
<input type="text" name="name" cols="20"><br>
Pass<br>
<input type="text" name="pass" cols="20"><br><br>
<button name = "action" value = "slogin">ログイン</button><a href="/team_dev_merukaru/SystemServlet">一般の方はこちら</a>
</form>


</body>
</html>





































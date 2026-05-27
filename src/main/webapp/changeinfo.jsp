<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="all.css" rel="stylesheet">
<title>会員情報変更</title>
</head>
<body>
<form action = "/team_dev_merukaru/SystemServlet" method = "post">
<p><a href="/team_dev_merukaru/SystemServlet?action=info">会員情報照会に戻る</a></p><br><br>
<h2>会員情報変更</h2>
<p>${message }</p>
名前<br>
<input type="text" name="name" cols="20"><br>
現在のパスワード<br>
<input type="text" name="pass" cols="20"><br>
新しいパスワード<br>
<input type="password" name="newpass" cols="20"><br>
新パスワード確認用<br>
<input type="password" name="newpass2" cols="20"><br>

<p><button name = "action" value = "change">変更</button></a></p>
</form>
</body>
</html>
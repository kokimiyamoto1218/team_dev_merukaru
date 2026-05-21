<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品</title>
</head>
<body>
<form action = "/team_dev_merukaru/SystemServlet" method = "post">
<p><a href="/team_dev_merukaru/SystemServlet?action=slogin">一覧表示に戻る</a></p><br><br>
<h2>出品フォーム</h2>
教科書名<br>
<input type="text" name="name" cols="20"><br>
金額<br>
<input type="text" pass="pass" cols="20"><br>




<p><button name = "action" value = "seikyousale">出品</button></p>
</form>
</body>
</html>
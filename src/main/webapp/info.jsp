<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="all.css" rel="stylesheet">
<title>会員情報照会</title>
</head>
<body>
<form action ="/team_dev_merukaru/ItemServlet" method = "post">
<p><a href="/team_dev_merukaru/SystemServlet?action=mypage">マイページに戻る</a></p><br><br>
<h2>会員情報照会</h2>
名前：<br>

現在のパスワード：<br>

<p><button name = "action" value = "cinfo">会員情報変更</button></a></p>
</form>
</body>
</html>
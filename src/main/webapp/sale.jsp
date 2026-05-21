<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品</title>
<link href="all.css" rel="stylesheet">
</head>
<body>
<form action = "/team_dev_merukaru/ItemServlet" method = "get">
<p><a href="/team_dev_merukaru/SystemServlet?action=login">一覧表示に戻る</a></p><br><br>
<h2>出品フォーム</h2>
教科書名<br>
<input type="text" name="name" cols="20"><br>
金額<br>
<input type="text" name="price" cols="20"><br>

使用状態<br>
<input type="checkbox" name="nu" value="新品">新品<br>
<input type="checkbox" name="nu" value="中古">中古<br>

教科書状態<br>
<input type="checkbox" name="lang" value="シミあり">シミあり<br>
<input type="checkbox" name="lang" value="傷あり">傷あり<br>
<input type="checkbox" name="lang" value="書き込みあり">書き込みあり<br>

コメント<br>
<input type="text" name="comment" cols="50">
<p><button name = "action" value = "go">出品</button></p>
</form>
</body>
</html>
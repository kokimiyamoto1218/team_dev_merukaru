<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品</title>
</head>
<body>
<form>
<p><a href="/team_dev_merukaru/SystemServlet?action=slogin">一覧表示に戻る</a></p><br><br>
<h2>出品フォーム</h2>
教科書名<br>
<input type="text" name="name" cols="20"><br>
金額<br>
<input type="text" pass="pass" cols="20"><br>

教科書状態<br>
<input type="checkbox" name="lang" value="未使用">未使用
<input type="checkbox" name="lang" value="中古">中古<br>
<input type="checkbox" name="lang" value="傷あり">傷あり
<input type="checkbox" name="lang" value="書き込みあり">書き込みあり<br>

コメント<br>
<input type="text" pass="pass" cols="50">
<p><button><a href="/team_dev_merukaru/SystemServlet?action=seiykousale">出品</a></button></p>
</form>
</body>
</html>
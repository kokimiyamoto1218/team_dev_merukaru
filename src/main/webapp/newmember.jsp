<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規棋院登録</title>
<link href="all.css" rel="stylesheet">
</head>
<body>
<form>
<p><a href="/team_dev_merukaru/SystemServlet">ログイン画面に戻る</a></p><br><br>
<h2>新規会員登録</h2>
名前<br>
<input type="text" name="name" cols="20"><br>
パスワード<br>
<input type="text" pass="pass" cols="20"><br>
パスワード確認用<br>
<input type="text" pass="newpass" cols="20"><br>
<p><a href="/team_dev_merukaru/SystemServlet?action=newmember"><button>会員登録</button></a></p>
</form>
</body>
</html>
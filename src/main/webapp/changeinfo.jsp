<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報変更</title>
</head>
<body>
<form>
<p><a href="Servlet">会員情報照会に戻る</a></p><br><br>
<h2>会員情報変更</h2>
名前<br>
<input type="text" name="name" cols="20"><br>
現在のパスワード<br>
<input type="text" pass="pass" cols="20"><br>
新しいパスワード<br>
<input type="text" pass="newpass" cols="20"><br>
新パスワード確認用<br>
<input type="text" pass="newpass" cols="20"><br>

<p><a href="Servlet"><button>変更</button></a></p>
</form>
</body>
</html>
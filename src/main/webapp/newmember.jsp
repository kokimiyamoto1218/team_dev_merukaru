<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="all.css" rel="stylesheet">
<title>新規棋院登録</title>

</head>
<div style="text-align: center;">

<body>

<p>${message}</p>
<form action="${pageContext.request.contextPath}/SystemServlet" method="post">



<br><br>
<h2 class="titleH2">新規会員登録</h2><br>
名前<br>
<input type="text" name="name" cols="20"><br>
パスワード<br>
<input type="text" name="pass" cols="20"><br>
パスワード確認用<br>
<input type="text" name="newpass" cols="20"><br>


<p><button name = "action" value = "newmember">会員登録</button></p>
</form>

<p><a href="/team_dev_merukaru/SystemServlet">ログイン画面に戻る</a></p>
</body>

</div>
</html>
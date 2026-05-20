<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
</head>
<body>
<form action ="/team_dev_merukaru/SystemServlet">
<p><a href="/team_dev_merukaru/SystemServlet?action=login">一覧表示に戻る</a></p><br><br>
<h2>マイページ</h2>
<p><button  name = "action" value = "info">会員情報照会</button></p><br>

<p><button name = "action" value = "shistory">出品履歴・取消</button></p><br>

<p><button name = "action" value ="bhistory">購入履歴</button></p><br>

<p><button name = "action" value ="logout">ログアウト</button></p>


</form>
</body>
</html>
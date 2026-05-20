<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
</head>
<body>
<form>
<p><a href="/team_dev_merukaru/SystemServlet?action=login">一覧表示に戻る</a></p><br><br>
<h2>マイページ</h2>
<p><button><a href="/team_dev_merukaru/SystemServlet?action=info">会員情報照会</a></button></p><br>
<p><button><a href="/team_dev_merukaru/SystemServlet?action=shistory">出品履歴・取消</a></button></p><br>
<p><button><a href="/team_dev_merukaru/SystemServlet?action=bhistory">購入履歴</a></button></p>
</form>
</body>
</html>
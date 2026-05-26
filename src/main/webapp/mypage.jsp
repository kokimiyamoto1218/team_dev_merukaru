<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="all.css" rel="stylesheet">
<title>マイページ</title>
</head>
<body>


<h2 align="center">マイページ</h2>
<p align="center"><a href="/team_dev_merukaru/ItemServlet?action=info">会員情報照会</a></p>

<p align="center"><a href="/team_dev_merukaru/ItemServlet?action=shistory">出品履歴・取り消し</a></p>

<p align="center"><a href="/team_dev_merukaru/ItemServlet?action=bhistory">購入履歴</a></p>

<p align="center"><a href="/team_dev_merukaru/SystemServlet?action=logout">ログアウト</a></p><br><br>
<p><a href="/team_dev_merukaru/SystemServlet?action=back">一覧表示に戻る</a></p>


</body>
</html>
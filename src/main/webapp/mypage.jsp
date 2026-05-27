<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="mypage.css" rel="stylesheet">
<title>マイページ</title>
</head>
<body>

<div class="mypage-container">

    <h2 align="center">マイページ</h2>
    
    <div class="menu-list">
        <a class="menu-btn" href="/team_dev_merukaru/ItemServlet?action=info">会員情報照会</a>
        <a class="menu-btn" href="/team_dev_merukaru/ItemServlet?action=shistory">出品履歴・取り消し</a>
        <a class="menu-btn" href="/team_dev_merukaru/ItemServlet?action=bhistory&id=${sessionScope.userId}">購入履歴</a>
        <a class="menu-btn logout" href="/team_dev_merukaru/SystemServlet?action=logout">ログアウト</a>
    </div>

    <div class="back-link-wrap">
        <a class="back-link" href="/team_dev_merukaru/SystemServlet?action=back">← 一覧表示に戻る</a>
    </div>

</div>

</body>
</html>
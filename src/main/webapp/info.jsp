<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="info.css" rel="stylesheet">
<title>会員情報照会</title>
</head>
<body>

<div class="mypage-container">

    <h2>会員情報照会</h2>

    <form action="/team_dev_merukaru/ItemServlet" method="post">
        
        <div class="info-box">
            <div class="info-item">
                <div class="info-label">名前</div>
                <div class="info-value">${name}</div>
            </div>
            
            <div class="info-item">
                <div class="info-label">現在のパスワード</div>
                <div class="info-value">${pass}</div>
            </div>
        </div>

        <div class="info-btn-wrap">
            <button name="action" value="cinfo" class="info-submit-btn">
                会員情報変更
            </button>
        </div>
    </form>

    <div class="info-back-wrap">
        <a href="/team_dev_merukaru/ItemServlet?action=mypage" class="back-btn-custom">
            マイページに戻る
        </a>
    </div>

</div>

</body>
</html>
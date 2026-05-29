<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="chageinfo.css" rel="stylesheet">
<link href="all.css" rel="stylesheet">
<title>会員情報変更</title>
</head>
<body>

	<div style="text-align: center; padding-top: 20px;">

    <h2 class="titleH2">会員情報変更</h2>
    
    <p id="error">${message}</p>

    <div class="seikyou-form-box">
        <form action="/team_dev_merukaru/SystemServlet" method="post">
            
            <p>
                <label>名前</label><br>
                <input type="text" name="name" class="seikyou-input">
            </p>
            
            <p>
                <label>現在のパスワード</label><br>
                <input type="password" name="pass" class="seikyou-input">
            </p>
            
            <p>
                <label>新しいパスワード</label><br>
                <input type="password" name="newpass" class="seikyou-input">
            </p>
            
            <p>
                <label>新パスワード確認用</label><br>
                <input type="password" name="newpass2" class="seikyou-input text-center">
            </p>
            
            <p style="margin-top: 25px;">
                <button type="submit" name="action" value="change" class="seikyou-submit-btn">変更</button>
            </p>
            
        </form>
    </div>

    <p style="margin-top: 30px;">
        <a href="/team_dev_merukaru/ItemServlet?action=info" class="back-btn-custom">会員情報照会に戻る</a>
    </p>

</div>

</body>
</html>
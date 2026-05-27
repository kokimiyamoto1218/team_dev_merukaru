<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品</title>
<link href="all.css" rel="stylesheet">
<link href="sale.css" rel="stylesheet">
</head>
<body>

<div class="mypage-container">

    <h2>出品フォーム</h2>

    <form action="/team_dev_merukaru/ItemServlet" method="get">
    <p id="error">${errorMsg}</p> 
        
        <div class="info-box">
            <div class="form-item">
                <label class="info-label">教科書名</label>
                <input type="text" name="name" class="input-text">
            </div>
            
            <div class="form-item">
                <label class="info-label">金額</label>
                <input type="text" name="price" class="input-text">
            </div>

            <div class="form-item">
                <label class="info-label">使用状態</label>
                <div class="radio-group">
                    <label><input type="radio" name="nu" value="新品" checked> 新品</label>
                    <label><input type="radio" name="nu" value="中古"> 中古</label>
                </div>
            </div>

            <div class="form-item">
                <label class="info-label">教科書状態</label>
                <div class="checkbox-group">
                    <label><input type="checkbox" name="lang" value="シミあり"> シミあり</label>
                    <label><input type="checkbox" name="lang" value="傷あり"> 傷あり</label>
                    <label><input type="checkbox" name="lang" value="書き込みあり"> 書き込みあり</label>
                </div>
            </div>

            <div class="form-item">
                <label class="info-label">コメント</label>
                <input type="text" name="comment" class="input-text">
            </div>
        </div>

        <div class="info-btn-wrap">
            <button name="action" value="go" class="info-submit-btn">
                出品する
            </button>
        </div>
    </form>

    <div class="info-back-wrap">
        <a href="/team_dev_merukaru/SystemServlet?action=back" class="back-btn-custom">
            一覧表示に戻る
        </a>
    </div>

</div>

</body>
</html>
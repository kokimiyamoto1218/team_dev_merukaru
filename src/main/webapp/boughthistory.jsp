<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
<meta charset="UTF-8">
<title>購入履歴</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kiwi+Maru:wght@500&display=swap" rel="stylesheet">
<link href="boughthistory.css" rel="stylesheet">
</head>
</head>
<body>

<div class="history-container">

    <h2>購入履歴</h2>
    
    <table class="history-table">
        <thead>
            <tr>
                <th>教科書名</th>
                <th >金額</th> <th>受け取り予定日</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${purchasehistory}" var="pachasehistorys">
                <tr>
                    <td>${pachasehistorys.product_name}</td>
                    <td class="price-col">¥${pachasehistorys.price}</td>
                    <td>${pachasehistorys.booking}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="back-link-wrap">
        <a class="back-link" href="/team_dev_merukaru/SystemServlet?action=back">← 一覧表示に戻る</a>
    </div>

</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title >購入履歴</title>
<!-- <link href="boughthistory.css" rel="./team_dev_group7/styleseet"> -->
<link href="all.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="boughthistory.css" /> 
</head>
<body>
<br><br><br>

<h2>購入履歴</h2>
<table align="center" border="1">
<style>
  
  th {
    background-color: #afeeee;
    }
    </style>

<tr><th>教科書名</th><th>金額</th><th>受け取り予定日</th></tr>
<c:forEach items="${purchasehistory}" var="pachasehistorys">
<tr><td>${pachasehistorys.product_name}</td><td>${pachasehistorys.price}</td><td>${pachasehistorys.booking}</td></tr>
</c:forEach>
</table>

<p><a href="/team_dev_merukaru/SystemServlet?action=back">一覧表示に戻る</a></p><br><br>
</body>
</html>
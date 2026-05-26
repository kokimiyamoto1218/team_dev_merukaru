<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品履歴</title>
<link href="all.css" rel="stylesheet">
</head>
<body>
<br><br><br>

<h2>出品履歴</h2>

<table border="1">
<tr><th>教科書名</th><th>金額</th><td></td></tr>
<c:forEach items="${showitem}" var="showitems">
    <tr>
        <td>${showitems.productName}</td>
        <td>${showitems.price}</td>
        <td>
        <form action = "/team_dev_merukaru/ItemServlet" method = "post">
            <button name="action" value="delete">
                取り消し
            </button>
            <input type = "hidden" name = "pid" value = "${showitems.productId}">
            </form>
        </td>
    </tr>
</c:forEach>
</table>

<p><a href="/team_dev_merukaru/SystemServlet?action=back">一覧表示に戻る</a></p><br><br>
</body>
</html>
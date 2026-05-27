<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品履歴</title>
<link href="boughthistory.css" rel="stylesheet">
</head>
<body>

<div class="history-container">

    <h2>出品履歴</h2>

    <table class="history-table">
        <thead>
            <tr>
                <th >教科書名</th>
                <th>金額</th>
                <th>出品削除</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${showitem}" var="showitems">
                <tr>
                    <td>${showitems.productName}</td>
                    <td>${showitems.price}</td>
                    <td><c:if test="${showitems.delete_flag eq 0 }">
                        <form action="/team_dev_merukaru/ItemServlet" method="post" style="margin: 0;">
                            <button name="action" value="delete" class="menu-btn logout" style="padding: 5px 10px; font-size: 13px; margin: 0 auto; display: block; width: auto;">
                                取り消し
                            </button>
                            <input type="hidden" name="pid" value="${showitems.productId}">
                        </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="back-link-wrap">
        <a href="/team_dev_merukaru/SystemServlet?action=back" class="back-link">一覧表示に戻る</a>
    </div>

</div>

</body>
</html>
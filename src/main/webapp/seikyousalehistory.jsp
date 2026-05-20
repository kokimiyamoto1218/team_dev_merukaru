<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品履歴</title>
</head>
<body>

	<br>
	<br>
	<br>

	<h2>出品履歴</h2>
	<table border="1">
		<tr>
			<th>新品・中古</th>
			<th>教科書名</th>
			<th>金額</th>
			<th>傷状態・コメント</th>
			<th></th>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><c:if test="${deletedragon eq 0}">
					<button>
						<a herf="Servlet">取消</a>
					</button>
				</c:if></td>
		</tr>
	</table>

</body>
</html>
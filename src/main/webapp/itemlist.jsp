<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧表示</title>
<link href="all.css" rel="stylesheet">
<link rel="stylesheet" href="itemlist.css" />
</head>
<body>

	<br>
	<br>
	<br>
	<table>
		<tr>
			<td>
				<!-- メニュー -->
					<p>メニュー</p>
					<p>
						<a href="/team_dev_merukaru/ItemServlet?action=mypage">マイページ</a>
					</p>
					<p>
						<a href="/team_dev_merukaru/ItemServlet?action=sale">出品</a>
					</p>
			</td>
			<td class="custom-cell">
				<!--検索 --><form action="/team_dev_merukaru/ItemServlet" method="get">
		<input type="hidden" name="action" value="search">

		<h2>教科書検索</h2>




		<input type="text" size="33" name="bookname" cols="50"> <select
			name="check">
			<option value="全て">全て</option>
			<option value="新品">新品</option>
			<option value="中古">中古</option>
		</select>
		<button>検索</button>
	</form>

			</td>
		</tr>
	</table>

	

	
<div class="parent">
	<table border="1">
		<tr>
			<th>新品・中古</th>
			<th>教科書名</th>
			<th>金額</th>
			<th>傷状態・コメント</th>
			<th></th>
		</tr>
<c:forEach items="${showitem}" var="showitems">
		<tr>
			<td>${showitems.neworused}</td>
			<td>${showitems.name}</td>
			<td>${showitems.price}</td>
			<td>${showitems.condition}</td>
			<td><a href="/team_dev_merukaru/ItemServlet?action=buy">購入</a></td>
		</tr>
</c:forEach>


	</table>
</div>

</body>
</html>
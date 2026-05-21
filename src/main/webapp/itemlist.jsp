<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧表示</title>
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
						<a href="/team_dev_merukaru/SystemServlet?action=mypage">マイページ</a>
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

		<c:forEach items="${items}" var="item">
	<form action ="/team_dev_merukaru/ItemServlet" method = "post">
	
		<tr><td>${item.nu}</td><td>${item.name}</td><td>${item.price}</td><td>${item.lang}:${item.comment}</td>
		<td>
			<form action="/team_dev_merukaru/ItemServlet">
				<input type="hidden" name="action" value="buy">
				<input type="hidden" name="code" value="${item.code}">
				<button>購入</button>
			</form>
		</td>
		

		</tr></c:forEach>


	</table>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧表示</title>
<link rel="stylesheet" href="seikyouitemlist.css" />
</head>
<body>
	<br>
	<br>
	<br>

	<table>
		<tr>
			<td>

				<p>メニュー</p>
				<p>
					<a href="/team_dev_merukaru/SystemServlet?action=ssale">出品</a>
				</p>
				<p>
					<a href="/team_dev_merukaru/SystemServlet">ログアウト</a>
				</p>
			</td>
			<td class="custom-cell">


				<form action="/team_dev_merukaru/SystemServlet" method="get">
					<input type="hidden" name="action" value="ssearch">
					<h2>教科書検索</h2>
					<input type="text" name="bookname" cols="50"> <select
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
		<br>
		<br>

		<div class="parent">
			<table border="1">
				<tr>
					<th>新品・中古</th>
					<th>教科書名</th>
					<th>金額</th>
					<th>傷状態・コメント</th>
				</tr>

				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>


			</table>
		</div>
</body>
</html>
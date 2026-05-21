<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入</title>
<link rel="stylesheet" type="text/css" href="buy.css" />
<style>
th {
	background-color: #afeeee;
}

.cellleft {
	padding: 5px;
}
#outer {
	margin:auto;
}
</style>
</head>
<body>

	<form action = "/team_dev_merukaru/ItemServlet" method = "post">
		<table id="outer">
			<tr>
				<td>
					<h2>購入内容確認</h2>
				</td
			</tr>
			<tr>
				<td>
					<table align="center" border="1">
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
							<td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<button name = "action" value = "apointment">
						購入
					</button>
				</td>
			</tr>
		</table>
	</form>




<button><p><a href="/team_dev_merukaru/SystemServlet?action=login">前のページに戻る</a></p></button><br>


</body>
</html>
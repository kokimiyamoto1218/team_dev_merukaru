<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入</title>
<link href="all.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="buy.css" />
<style>
/* ここから追加：全体の文字を白く、中央寄せにする */
body {
	color: #ffffff;
	text-align: center;
}

/* 内側のデータが入るテーブル（border="1" のテーブル）だけを狙って白い1本線にする */
table[align="center"] {
	border-collapse: collapse !important; /* 2本線を1本に合体 */
	margin-top: 15px;
	margin-bottom: 15px;
}

table[align="center"], 
table[align="center"] th, 
table[align="center"] td {
	border: 1px solid #ffffff !important; /* 枠線を白にする */
	padding: 8px; /* セルの中に少し余白を作って見やすくします */
}

/* ボタンの中のリンク文字が青くなって見えなくなるのを防ぐ */
button a {
	color: inherit;
	text-decoration: none;
}
/* ★ここまで追加 */

th {
	background-color: #afeeee;
	color: #000000; /* ★見出しの背景が薄い青なので、文字を黒にして読みやすくします */
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
<br><br><br>
	<form action = "/team_dev_merukaru/ItemServlet" method = "post">
		<table id="outer">
			<tr>
				<td>
					<h2>購入内容確認</h2>
				</td> <!-- 💡元のコードで「>」が抜けていたので修正しました -->
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
							<td>${neworused}</td>
							<td>${name}</td>
							<td>${price}</td>
							<td>${condition}</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
				<input type="hidden" name="id" value="${sessionScope.userId}">
				<input type="hidden" name="code" value="${product_id}">
				<input type="hidden" name="name" value="${name}">
				<input type="hidden" name="price" value="${price}"> 
					<button name = "action" value = "apointment">
						購入
					</button>
				</td>
			</tr>
		</table>
	</form>




<button><p><a href="/team_dev_merukaru/SystemServlet?action=back">前のページに戻る</a></p></button><br>


</body>
</html>
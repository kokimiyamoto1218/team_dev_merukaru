<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出品</title>
<link href="all.css" rel="stylesheet">
<link href="seikyouhistory.css" rel="stylesheet">
</head>
<body>
<table>
		<tr>
			<td>

<form action = "/team_dev_merukaru/SystemServlet" method = "post">


<h2>出品フォーム</h2>

<p id="error">${errorMsg}</p> 

<div class="seikyou-form-box">
    教科書名<br>
    <input type="text" name="name" class="seikyou-input"><br><br>
    金額<br>
    <input type="text" name="price" class="seikyou-input"><br>
</div>

<input type="hidden" name="nu" value="新品">

<p><button name = "action" value = "seikyousale" class="seikyou-submit-btn">出品</button></p>
<p><a href="/team_dev_merukaru/SystemServlet?action=sback" class="back-btn-custom">一覧表示に戻る</a></p><br><br>
</form>

			</td>
		</tr>
</table>
</body>
</html>
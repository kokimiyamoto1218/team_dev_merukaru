<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="all.css" rel="stylesheet">
<link href="apointment.css" rel="stylesheet">
<title>受け取り日時予約</title>
</head>
<body>
<form action = "/team_dev_merukaru/ItemServlet" method = "post">
<h2>
受け取り日時予約
</h2><br><br>

<label class="date-edit"><input type="date"  name="date" value=""></label>
<input type="hidden" name="code" value="${product_id}">

<button name = "action" value = "res">予約</button>
</form>
</body>
</html>
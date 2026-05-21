<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="all.css" rel="stylesheet">
<title>受け取り日時予約</title>
</head>
<body>
<form action = "/team_dev_merukaru/ItemServlet" method = "post">
<h2>
受け取り日時予約
</h2><br><br>
<select name="apointment1">
<option value="月">1月</option>
<option value="月">2月</option>
<option value="月">3月</option>
<option value="月">4月</option>
<option value="月">5月</option>
<option value="月">6月</option>
<option value="月">7月</option>
<option value="月">8月</option>
<option value="月">9月</option>
<option value="月">10月</option>
<option value="月">11月</option>
<option value="月">12月</option>

</select>

<select name="apointment2">
<option value="日">1日</option>
<option value="日">2日</option>
<option value="日">3日</option>
<option value="日">4日</option>
<option value="日">5日</option>
<option value="日">6日</option>
<option value="日">7日</option>
<option value="日">8日</option>
<option value="日">9日</option>
<option value="日">10日</option>
<option value="日">11日</option>
<option value="日">12日</option>
<option value="日">13日</option>
<option value="日">14日</option>
<option value="日">15日</option>
<option value="日">16日</option>
<option value="日">17日</option>
<option value="日">18日</option>
<option value="日">19日</option>
<option value="日">20日</option>
<option value="日">21日</option>
<option value="日">22日</option>
<option value="日">23日</option>
<option value="日">24日</option>
<option value="日">25日</option>
<option value="日">26日</option>
<option value="日">27日</option>
<option value="日">28日</option>
<option value="日">29日</option>
<option value="日">30日</option>
<option value="日">31日</option>
</select>

<select>
<option value="時間">9時</option>
<option value="時間">10時</option>
<option value="時間">11時</option>
<option value="時間">12時</option>
<option value="時間">13時</option>
<option value="時間">14時</option>
<option value="時間">15時</option>
<option value="時間">16時</option>
<option value="時間">17時</option>



</select>
<br><br>

<button name = "action" value = "res">予約</button>
</form>
</body>
</html>
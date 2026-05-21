<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧表示</title>
</head>
<body>
<br><br><br>
<form>
<caption>メニュー</caption>
<p><a href="/team_dev_merukaru/ItemServlet?action=mypage">マイページ</a></p>
<p><a href="/team_dev_merukaru/ItemServlet?action=sale">出品</a></p>                
</form>

<form action ="/team_dev_merukaru/ItemServlet" method = "get">
<input type = "hidden" name= "action" value = "search">
<h2>教科書検索</h2>

<input type="text" size="33" name="bookname" cols="50">
<select name="bookname">

<input type="text" name="bookname" cols="50">
<select name="check">

<option value="全て">全て</option>
<option value="新品">新品</option>
<option value="中古">中古</option>
</select>
<button>検索</button><br><br>

<table border="1">
<tr><th>新品・中古</th><th>教科書名</th><th>金額</th><th>傷状態・コメント</th><th></th></tr>

<tr><td></td><td></td><td></td><td></td><td><a href="/team_dev_merukaru/ItemServlet?action=buy" >購入</a></td></tr>


</table>

</form>

</body>
</html>
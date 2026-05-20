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
<p><a href="Servlet">出品</a></p>
<p><a href="Servlet">出品履歴・取消</a></p>                
</form>

<form>
<h2>教科書検索</h2>
<input type="text" name="bookname" cols="50">
<select name="bookname">
<option value="全て">全て</option>
<option value="新品">新品</option>
<option value="中古">中古</option>
</select>
<button>検索</button><br><br>

<table border="1">
<tr><th>新品・中古</th><th>教科書名</th><th>金額</th><th>傷状態・コメント</th></tr>

<tr><td></td><td></td><td></td><td></td></tr>


</table>

</form>

</body>
</html>
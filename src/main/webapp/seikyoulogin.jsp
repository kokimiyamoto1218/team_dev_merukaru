<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生協ログイン</title>
<link href="all.css" rel="stylesheet">
<style>
  /* 画面全体の中央寄せ（上下のみ位置を約3センチ上に調整） */
  body {
    display: flex;
    justify-content: center;
    align-items: flex-start; /* 上寄せに変更 */
    padding-top: 15vh;        /* 上から約3センチ（画面の高さの15%）の位置に固定 */
    min-height: 100vh;
    box-sizing: border-box;   /* 余白の計算を狂わせないための設定 */
    margin: 0;
    font-family: sans-serif;
  }
  /* コンテナとフォーム内要素の中央寄せ */
  .mypage-container, form {
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
  }
  /* 入力フォームやボタンの余白調整 */
  input, button, a {
    margin-bottom: 15px;
  }
</style>
</head>
<body>

<div class="mypage-container">

<p>${message}</p>
<form action="/team_dev_merukaru/SystemServlet" method="post">
<h2>生協ログイン</h2>
<label>名前</label>
<input type="text" name="name" size="20" value="${name}">
<label>Pass</label>
<input type="password" name="pass" size="20">
<input type="hidden" name="action" value="sdragon">
<button>ログイン</button>
<a href="/team_dev_merukaru/SystemServlet">一般の方はこちら</a>
</form>

</div>

</body>
</html>




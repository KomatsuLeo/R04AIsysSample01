<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CognitiveServiceを使うサイト</title>
</head>

<body>
<header>
<a href="./languageRequest">DetectedLanguageへ</a>
</header>
<h1>Sentiment</h1>
<h1>CognitiveServiceを使うサイト</h1>

<h3>調べたい文字列を教えてください</h3>
<form method="POST" action="./SResult">
<input type="TEXT" name="string" />
<input type="submit" />
</form>
</body>
</html>
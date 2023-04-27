<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>
<div>
<h2>게시글 보기</h2>
${boardVO.name }
${boardVO.subject }
${boardVO.content }
${boardVO.date }
		<input type="hidden" value="${boardVO.no }">
   		<button type="button" onclick="location.href='update.do?no=${boardVO.no }'"> 수정</button>
   		<button type="button" onclick="location.href='delete.do?no=${boardVO.no }'"> 삭제</button>
   		<button type="button" onclick="location.href='list.do'"> 취소</button>
</div>

</body>
</html>
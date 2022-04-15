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
<script>
	function check(){

		var formCheck = document.myForm;
	
	    if(!formCheck.name.value) {
	    	alert("이름을 입력해 주세요.");
	    	formCheck.name.focus();
	    	return false;
	    	}
	    
	    if(!formCheck.subject.value) {
	    	alert("제목을 입력해 주세요.");
	    	formCheck.subject.focus();
	    	return false;
	    	}
	    
	    if(!formCheck.content.value) {
	    	alert("내용을 입력해 주세요.");
	    	formCheck.content.focus();
	    	return false;
	    	}
	    formCheck.action = "updateSuccess.do?no=${boardVO.no }";
		formCheck.submit();
	}
</script>
<div>
	<h2>게시글 수정</h2>
	<form name="myForm" method="post">
		작성자
		<input type="text" name="name" value="${boardVO.name }" placeholder="이름을 입력해주세요.">
		<br>
		글제목
		<input type="text" name="subject" value="${boardVO.subject }" placeholder="제목을 입력해주세요.">
		<br>
		내용&nbsp;&nbsp;&nbsp;&nbsp;
		<textarea name="content" rows="20" placeholder="내용을 입력해주세요.">${boardVO.content }</textarea>
		<br>
		<input type="hidden" value="${boardVO.no }">
   		<button type="button" onclick="check();"> 수정</button>
 	 </form>
 	 <button type="button" onclick="location.href='created.do?no=${boardVO.no }'"> 취소</button>
</div>

</body>
</html>
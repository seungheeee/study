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
	function sendIt(){
		
    const formCheck = document.myForm;
	
    if(!formCheck.name.value) {
    	alert("이름을 입력해 주세요.");
    	formCheck.name.focus();
    	return;
    	}
    
    if(!formCheck.subject.value) {
    	alert("제목을 입력해 주세요.");
    	formCheck.subject.focus();
    	return;
    	}
    if(!formCheck.content.value) {
    	alert("내용을 입력해 주세요.");
    	formCheck.content.focus();
    	return;
    	}
	formCheck.action = "writeSuccess.do";
	formCheck.submit();
	}

</script>
<div>
	<h2>게시글 작성</h2>
	<form name = "myForm" action="" method="post">
		작성자
		<input type="text" name="name" placeholder="이름을 입력해주세요.">
		<br>
		글제목
		<input type="text" name="subject" placeholder="제목을 입력해주세요.">
		<br>
		내용&nbsp;&nbsp;&nbsp;&nbsp;
		<textarea name="content" rows="20" placeholder="내용을 입력해주세요."></textarea>
		<br>
   		<button type="submit" onclick="sendIt();"> 등록</button>
   		<button type="button" onclick="location.href='list.do'"> 취소</button>
 	 </form>
</div>

</body>
</html>
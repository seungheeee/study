<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
</head>
<style>
	table {
	  width: 50%;
	  border-collapse: collapse;
	  text-align: center;
	}
	.title{
	font-weight: bold;
	background-color: AliceBlue;
	border-bottom: 1px solid #444444;
	border-top: 1px solid #444444;
	border-left: 1px solid #444444;
	border-right: 1px solid #444444;
	padding: 10px;
	}
	.list{
	border-bottom: 1px solid #444444;
	border-top: 1px solid #444444;
	border-left: 1px solid #444444;
	border-right: 1px solid #444444;
	padding: 10px;
	}
	.box{
	width : 20px;
	border-left: 1px solid #444444;
	border-right: 1px solid #444444;
	}
	.no{
	width : 30px;
	border-left: 1px solid #444444;
	border-right: 1px solid #444444;
	}
	.name{
	width : 80px;
	border-left: 1px solid #444444;
	border-right: 1px solid #444444;
	}
	.subject{
	width : 150px;
	border-left: 1px solid #444444;
	border-right: 1px solid #444444;
	}
	.date{
	width : 150px;
	border-left: 1px solid #444444;
	border-right: 1px solid #444444;
	}
	.delete{
	  border-bottom: none;
	  border-top: none;
	  border-left: none;
	  border-right: none;
	}
</style>
<body>
<script type="text/javascript">
function selectAll(selectAll)  {
	  const checkboxes = document.getElementsByName('checkno');
	  checkboxes.forEach((checkbox) => {
	    checkbox.checked = selectAll.checked;
	  })
	}
</script>
<h2>게시글 리스트</h2>
<button id="writeBtn" onclick="location.href='write.do'">
	글 작성하기
</button>
<form action="deleteSelect.do" method="post">
<table>
	<tr class="title">
		<td class="box"><input type="checkbox" name="checkno" onclick="selectAll(this)"/></td>
		<td class="no">번호</td>
		<td class="name">작성자</td>
		<td class="subject">글제목</td>
		<td class="date">날짜</td>
	</tr>
	<c:forEach var="boardVO" items="${list }">
		<tr class="list">
			<td class="box"><input name="checkno" value="${boardVO.no }" type="checkbox"/></td>
			<td class="no">${boardVO.rownum }</td>
			<td class="name">${boardVO.name }</td>
			<td class="subject">
				<a href="created.do?no=${boardVO.no }">
					${boardVO.subject }
				</a>
			</td>
			<td class="date">${boardVO.date }</td>
		</tr>
	</c:forEach>
		<tr><td class="delete"><input type="submit" value="삭제"></td></tr>
</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!-- uri="" 에서 ctrl+space 후 3번째 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" type="image/ico" href="/img/favicon_w3c.ico" />
<link rel="stylesheet" href="/css/common.css" />
<!-- SCSS cdn url 복붙-->
<script src="https://cdn.jsdelivr.net/npm/browser-scss@1.0.3/dist/browser-scss.min.js"></script> <!-- 복붙 시 한줄에 다 표현 -->

<style>
	td {
		padding: 10px;
		width: 150px;
		text-align: center;
	}
	tr:first-child {
		background-color: black;
		color: white;
		font-weight: bold;
		/* SCSS 문법 적용 -> download -> 13줄 url 주소 복붙 */
		td {
			border-color: red;
		}
	}
	/*
	tr:first-child > td {
		border-color: white;
	}
	*/
	/* ---------------------- */
	/*
	td:nth-child(2) {
		text-align: right;
	}
	*/
	tr:nth-child(2) > td {
		text-align: right;
	}
	
</style>
</head>
<body>
	<main>
	  <h2>메뉴 목록</h2>
	  
	  <table>
	    <tr>
	      <td>Menu_id</td>
	      <td>Menu_name</td>
	      <td>Menu_seq</td>
	      <td>삭제</td>
	      <td>수정</td>
	    </tr>
	    
	    <tr>
	      <td colspan="5">[<a href="/Menus/WriteForm">메뉴 등록</a>]</td>
	    </tr>

		<c:forEach var="menu" items="${ menuList }">		<!-- items : Model 에 담겨있는 것 -->
	    <tr>
	      <td>${ menu.menu_id }</td>
	      <td>${ menu.menu_name }</td>
	      <td>${ menu.menu_seq }</td>
	      <td><a href="">삭제</a></td>
	      <td><a href="">수정</a></td>
	    </tr>
	    </c:forEach>
	    
	  </table>
	  
	</main>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: pipir
  Date: 2019-06-21
  Time: 오후 3:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content= "text/html; charset=UTF-8">
    <!-- BootStrap CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <title>음식 상세정보</title>
</head>
<body>
<h3>음식 상세정보</h3>
<div style="padding : 30px;">
    <div class="form-group">
        <label>음식 이름</label>
        <span>${menu.menuname}</span>
    </div>
    <div class="form-group">
        <label>가격</label>
        <span>${menu.price}</span>
    </div>
    <div class="form-group">
        <label>내용</label>
        <p>${menu.content}</p>
    </div>

    <div class="form-group">
        <input type="button" value="수정" onclick='location.href="/menu/post/${menu.bno}"'>
        <form:form action="/menu/post/${menu.bno}" method="DELETE">
            <input type="submit" value="삭제">
        </form:form>
    </div>
</div>
</body>
</html>

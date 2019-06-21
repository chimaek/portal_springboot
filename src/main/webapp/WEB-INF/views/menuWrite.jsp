<%--
  Created by IntelliJ IDEA.
  User: pipir
  Date: 2019-06-21
  Time: 오후 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content= "text/html; charset=UTF-8">
    <!-- BootStrap CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <title>음식 정보 작성</title>
</head>
<body>
<h3>음식 정보 작성</h3>
<div style="padding : 30px;">
    <form method="POST" action="/menu/post/${bno}">
        <div class="form-group">
            <label>음식 이름</label>
            <input type="text" name="menuname" class="form-control" value=${menu.menuname}>
        </div>
        <div class="form-group">
            <label>가격</label>
            <input type="text" name="price" class="form-control" value=${menu.price}>
        </div>
        <div class="form-group">
            <label>내용</label>
            <textarea name="content" class="form-control" rows="5">${menu.content   }</textarea>
        </div>
        <button type="submit" class="btn btn-default">작성</button>
    </form>
</div>
</body>
</html>

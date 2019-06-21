<%--
  Created by IntelliJ IDEA.
  User: pipir
  Date: 2019-06-21
  Time: 오후 1:54
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
    <title>음식 목록</title>
</head>
<body>
<h3>음식 목록</h3>
<button class="btn btn-primary" style="float : right;" onclick="location.href='/menu/post'">작성</button>
<table class="table">
    <tr>
        <th>No</th>
        <th>이름</th>
        <th>가격</th>
        <th>내용</th>
    </tr>
    <c:forEach var="menu" items="${list}">
        <tr>
            <td>${menu.bno}</td>
            <td><a href="/menu/${menu.bno}">${menu.menuname}</a></td>
            <td>&#8361 ${menu.price}</td>
            <td>${menu.content}</td>
        </tr>
    </c:forEach>
</table>
</body>

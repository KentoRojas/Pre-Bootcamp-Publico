<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Detalles del Libro</title>
</head>
<body>
    <h1>Detalles del Libro</h1>
    <c:if test="${not empty nombreLibro}">
        <p>Nombre del libro: ${nombreLibro}</p>
        <p>Autor: ${nombreAutor}</p>
    </c:if>
    <c:if test="${empty nombreLibro}">
        <p>${mensaje}</p>
    </c:if>
    <a href="/libros">Regresar a la lista de libros</a>
</body>
</html>
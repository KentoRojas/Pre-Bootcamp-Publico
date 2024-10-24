<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Libros</title>
</head>
<body>
    <h1>Lista de Libros</h1>
    <ul>
        <c:forEach var="libro" items="${listaLibros}">
            <li>
                <a href="/libros/${libro}">${libro}</a>
            </li>
        </c:forEach>
    </ul>
    <a href="/libros/formulario">Agregar un nuevo libro</a>
</body>
</html>
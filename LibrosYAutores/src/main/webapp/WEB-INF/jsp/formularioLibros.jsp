<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Agregar Libro</title>
</head>
<body>
    <h1>Agregar Nuevo Libro</h1>
    <form action="/procesa/libro" method="post">
        <label for="nombreLibro">Nombre del Libro:</label>
        <input type="text" id="nombreLibro" name="nombreLibro" required>
        <br>
        <label for="nombreAutor">Autor:</label>
        <input type="text" id="nombreAutor" name="nombreAutor" required>
        <br>
        <input type="submit" value="Agregar">
    </form>
    <a href="/libros">Regresar a la lista de libros</a>
</body>
</html>
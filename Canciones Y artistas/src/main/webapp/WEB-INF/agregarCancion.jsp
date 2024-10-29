<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Agregar Canción</title>
</head>
<body>
    <h2>Agregar Canción</h2>

    <form:form action="/canciones/procesa/agregar" method="post" modelAttribute="cancion">
        <div>
            <form:label path="titulo">Título:</form:label>
            <form:input path="titulo" type="text" />
            <form:errors path="titulo" cssClass="error" />
        </div>

        <div>
            <label for="artista">Artista:</label>
            <select id="idArtista" name="idArtista" required>
                <c:forEach var="artista" items="${artistas}">
                    <option value="${artista.id}">${artista.nombre} ${artista.apellido}</option>
                </c:forEach>
            </select>
            <form:errors path="artista" cssClass="error" />
        </div>

        <div>
            <form:label path="album">Álbum:</form:label>
            <form:input path="album" type="text" />
            <form:errors path="album" cssClass="error" />
        </div>

        <div>
            <form:label path="genero">Género:</form:label>
            <form:input path="genero" type="text" />
            <form:errors path="genero" cssClass="error" />
        </div>

        <div>
            <form:label path="idioma">Idioma:</form:label>
            <form:input path="idioma" type="text" />
            <form:errors path="idioma" cssClass="error" />
        </div>

        <button type="submit">Guardar Canción</button>
    </form:form>

    <a href="/canciones">Volver a lista de canciones</a>
</body>
</html>
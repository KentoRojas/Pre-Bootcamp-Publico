<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Canción</title>
</head>
<body>
    <h2>Editar Canción</h2>

    <form:form action="/canciones/procesa/editar/${cancion.id}" method="POST" modelAttribute="cancion">
        <input type="hidden" name="_method" value="PUT"/>

        <div>
            <form:label path="titulo">Título:</form:label>
            <form:input path="titulo" type="text" />
            <form:errors path="titulo" cssClass="error"/>
        </div>

        <div>
            <form:label path="artista">Artista:</form:label>
            <form:input path="artista" type="text" />
            <form:errors path="artista" cssClass="error"/>
        </div>

        <div>
            <form:label path="album">Álbum:</form:label>
            <form:input path="album" type="text" />
            <form:errors path="album" cssClass="error"/>
        </div>

        <div>
            <form:label path="genero">Género:</form:label>
            <form:input path="genero" type="text" />
            <form:errors path="genero" cssClass="error"/>
        </div>

        <div>
            <form:label path="idioma">Idioma:</form:label>
            <form:input path="idioma" type="text" />
            <form:errors path="idioma" cssClass="error"/>
        </div>

        <button type="submit">Actualizar Canción</button>
    </form:form>

    <a href="/canciones">Volver a lista de canciones</a>
</body>
</html>
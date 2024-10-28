<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Agregar Canción</title>
    <style>
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: inline-block;
            width: 100px;
        }
    </style>
</head>
<body>
    <h2>Agregar Canción</h2>

    <form:form action="/canciones/procesa/agregar" method="post" modelAttribute="cancion">

        <div class="form-group">
            <label for="titulo">Título:</label>
            <form:input path="titulo" id="titulo" />
            <form:errors path="titulo" cssClass="error" />
        </div>

        <div class="form-group">
            <label for="artista">Artista:</label>
            <form:input path="artista" id="artista" />
            <form:errors path="artista" cssClass="error" />
        </div>

        <div class="form-group">
            <label for="album">Álbum:</label>
            <form:input path="album" id="album" />
            <form:errors path="album" cssClass="error" />
        </div>

        <div class="form-group">
            <label for="genero">Género:</label>
            <form:input path="genero" id="genero" />
            <form:errors path="genero" cssClass="error" />
        </div>

        <div class="form-group">
            <label for="idioma">Idioma:</label>
            <form:input path="idioma" id="idioma" />
            <form:errors path="idioma" cssClass="error" />
        </div>

        <div class="form-group">
            <input type="submit" value="Guardar Canción"/>
        </div>
    </form:form>

    <div style="margin-top: 20px;">
        <a href="/canciones">Volver a lista de canciones</a>
    </div>

</body>
</html>
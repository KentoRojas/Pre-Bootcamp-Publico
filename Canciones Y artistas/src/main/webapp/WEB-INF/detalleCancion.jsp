<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalle de la Canción</title>
</head>
<body>
    <h1>Detalle de la Canción</h1>

    <table border="1">
        <tr>
            <th>ID</th>
            <td>${cancion.id}</td>
        </tr>
        <tr>
            <th>Título</th>
            <td>${cancion.titulo}</td>
        </tr>
        <tr>
            <th>Artista</th>
            <td>${cancion.artista.nombre} ${cancion.artista.apellido}</td>
        </tr>
        <tr>
            <th>Álbum</th>
            <td>${cancion.album}</td>
        </tr>
        <tr>
            <th>Género</th>
            <td>${cancion.genero}</td>
        </tr>
        <tr>
            <th>Idioma</th>
            <td>${cancion.idioma}</td>
        </tr>
        <tr>
            <th>Fecha de Creación</th>
            <td>${cancion.fechaCreacion}</td>
        </tr>
        <tr>
            <th>Fecha de Actualización</th>
            <td>${cancion.fechaActualizacion}</td>
        </tr>
    </table>

    <p>
        <a href="/canciones/formulario/editar/${cancion.id}">
            <button>Actualizar Canción</button>
        </a>
    </p>

    <form action="/canciones/procesa/eliminar/${cancion.id}" method="POST">
        <input type="hidden" name="_method" value="DELETE"/>
        <button type="submit">Eliminar Canción</button>
    </form>
    
    <p>
        <a href="/canciones">Volver a lista de canciones</a>
    </p>
</body>
</html>
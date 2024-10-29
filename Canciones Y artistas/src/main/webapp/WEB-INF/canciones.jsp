<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Canciones</title>
</head>
<body>
    <h2>Lista de Canciones</h2>

    <table border="1">
        <thead>
            <tr>
                <th>Título</th>
                <th>Artista</th>
                <th>Detalle</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cancion" items="${canciones}">
                <tr>
                    <td>${cancion.titulo}</td>
                    <td>${cancion.artista.nombre} ${cancion.artista.apellido}</td>
                    <td><a href="/canciones/detalle/${cancion.id}">Detalle</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div>
    <a href="/canciones/formulario/agregar">
        <button>Agregar Canción</button>
    </a>
</div>
    

    <a href="/artistas">Ir a artistas</a>
</body>
</html>
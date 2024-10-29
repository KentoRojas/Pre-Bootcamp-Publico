<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Artistas</title>
</head>
<body>
    <h2>Lista de Artistas</h2>
    <ul>
        <c:forEach var="artista" items="${artistas}">
            <li>
                <a href="/artistas/detalle/${artista.id}">
                    ${artista.nombre} ${artista.apellido}
                </a>
            </li>
        </c:forEach>
    </ul>

    <a href="/canciones">Ir a canciones</a>

    <br><br>

    <a href="/artistas/formulario/agregar">
        <button>Añadir Artista</button>
    </a>
</body>
</html>
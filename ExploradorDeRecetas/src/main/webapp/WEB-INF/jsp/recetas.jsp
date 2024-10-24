<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Recetas</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <h1>Lista de Recetas</h1>
    <ul>
        <c:forEach var="receta" items="${listaRecetas}">
            <li><a href="/recetas/${receta}">${receta}</a></li>
        </c:forEach>
    </ul>
</body>
</html>

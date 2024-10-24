<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalle de Receta</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <h1>Detalle de la Receta</h1>
    <c:if test="${not empty mensaje}">
        <p>${mensaje}</p>
    </c:if>
    <c:if test="${not empty nombreReceta}">
        <h2>${nombreReceta}</h2>
        <ul>
            <c:forEach var="ingrediente" items="${ingredientes}">
                <li>${ingrediente}</li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>

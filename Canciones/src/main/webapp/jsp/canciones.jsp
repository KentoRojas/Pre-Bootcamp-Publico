<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Canciones</title>
</head>
<body>
    <h1>Lista de Canciones</h1>
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
                    <td>${cancion.artista}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/canciones/detalle/${cancion.id}">Detalle</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

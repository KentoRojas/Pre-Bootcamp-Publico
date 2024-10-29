<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


    
    <!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Agregar Artista</title>
</head>
<body>
    <h2>Agregar Artista</h2>

    <form:form action="/artistas/procesa/agregar" method="post" modelAttribute="artista">
        <div>
            <form:label path="nombre">Nombre:</form:label>
            <form:input path="nombre" type="text" required="true"/>
            <form:errors path="nombre"/>
        </div>

        <div>
            <form:label path="apellido">Apellido:</form:label>
            <form:input path="apellido" type="text" required="true"/>
            <form:errors path="apellido"/>
        </div>

        <div>
            <form:label path="biografia">Biografía:</form:label>
            <form:textarea path="biografia" required="true"></form:textarea>
            <form:errors path="biografia"/>
        </div>

        <button type="submit">Guardar Artista</button>
    </form:form>

    <a href="/artistas">Volver a lista de artistas</a>
</body>
</html>
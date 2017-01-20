<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registro Usuario</title>
</head>
<body>


<div>
    <form:form action="registrar-usuario" method="POST" modelAttribute="usuario">

        <label for="nombre">Ingresar Nombre</label>
        <form:input path="nombre" id="nombre" type="text" class="form-control"/>
        <br>

        <label for="apellido">Ingresar Apellido</label>
        <form:input path="apellido" id="apellido" type="text" class="form-control"/>
        <br>

        <label for="email">Ingresar Correo Electronico</label>
        <form:input path="email" id="email" type="email" class="form-control"/>

        <br>
        <label for="password">Ingresar Contraseña</label>
        <form:input path="password" type="password" id="password" class="form-control"/>

        <br>

        <div class="form-group col-lg-12">
            <button type="submit" class="btn btn-success">Registrar</button>
        </div>

        <br>

    </form:form>
</div>

</body>
</html>


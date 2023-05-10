<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<<<<<<< HEAD
=======
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
>>>>>>> dev
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
<<<<<<< HEAD
</head>
<body id="bodyLogin">
<div class = "container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form:form action="registrar-usuario" method="POST" modelAttribute="datosRegistro">
            <h3 class="form-signin-heading">Nuevo Usuario</h3>
            <hr class="colorgraph"><br>

            <form:input path="correo" id="correo" class="form-control"/>
            <form:input path="clave" type="password" id="clave" class="form-control"/>

            <button id="btn-registrarme" class="btn btn-lg btn-primary btn-block" Type="Submit"/>Registrarme</button>
        </form:form>

        <c:if test="${not empty error}">
            <h4><span>${error}</span></h4>
            <br>
        </c:if>
=======
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Registro de usuario</title>
</head>
<body id="bodyRegistro">
<div class = "container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <img src="./img/logo-hurr.png" alt="" id="logoLogin">
        <form:form action="registrar-usuario" method="POST" modelAttribute="datosRegistro">
            <form:input path="correo" id="correo" class="form-control" placeholder="Email"/>
            <form:input path="clave" type="password" id="clave" class="form-control" placeholder="Password"/>

            <button id="btnLogin" class="btn btn-lg btn-block" Type="Submit"/>Registrarme</button>
        </form:form>
        <c:if test="${not empty error}">
            <h4 class="mensajeErrorRegistro"><span>${error}</span></h4>
            <br>
        </c:if>
        <a href="login" class="registrarme">Volver a Login</a>
>>>>>>> dev
    </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
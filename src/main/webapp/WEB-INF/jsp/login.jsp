<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div class = "container">
	<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<form:form action="validar-login" method="POST" modelAttribute="usuario">      
		    <h3 class="form-signin-heading">Taller Web I</h3>
			  <hr class="colorgraph"><br>
			  
			  <form:input path="email" id="email" type="email" class="form-control" />
			  <form:input path="password" type="password" id="password" class="form-control"/>     		  
			 
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>  			
		</form:form>			
	</div>
</div>
<!-- <h3> Login Taller web 1 </h3> -->

<!-- <div> -->
<%--     <form:form action="validar-login" method="POST" modelAttribute="usuario"> --%>

<!--         <label for="email">Ingresar Correo Electronico</label> -->
<%--         <form:input path="email" id="email" type="email" class="form-control"/> --%>

<!--         <br> -->
<!--         <label for="password">Ingresar Contrase�a</label> -->
<%--         <form:input path="password" type="password" id="password" class="form-control"/> --%>

<!--         <br> -->

<!--         <div class="form-group col-lg-12"> -->
<!--             <button type="submit" class="btn btn-success">Ingresar</button> -->
<!--         </div> -->

<!--         <br> -->

<!--         <div> -->
<!--             <a href="registrar"> Para registrarse Hace click aca</a> -->
<!--         </div> -->

<%--     </form:form> --%>
<!-- </div> -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>

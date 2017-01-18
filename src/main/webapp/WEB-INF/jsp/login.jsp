<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	
			<h3> Login Taller web 1 </h3>
					
					<div>
										<form:form action="loginvalidar" method="POST" modelAttribute="usuario">
										
											<label for="email">Ingresar Correo Electronico</label>
											<form:input path="email" id="email" type="email" class="form-control" />

                                            <br>		
											<label for="password">Ingresar Contraseña</label>
											<form:input path="password" type="password" id="password" class="form-control" />

											<br>

											<div class="form-group col-lg-12">
												<button type="submit" class="btn btn-success">Ingresar</button>
											</div>

											<br>
											
											<div>
												<a href="registrar"> Para registrarse Hace click aca</a>
											</div>

										</form:form>
					</div>
		
</body>
</html>
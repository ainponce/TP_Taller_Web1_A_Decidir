<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ain Ponce
  Date: 25/5/2023
  Time: 7:52 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Hurr</title>
    <title>Title</title>
</head>
<body>
<div class="row">
    <div class="col-lg-12 nav-perfil">
        <a class="nav-link" href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle icon-home" viewBox="0 0 16 16">
                <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
            </svg>
            Nombre
        </a>
        <a class="nav-link" href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bell" viewBox="0 0 16 16">
                <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z"/>
            </svg>
        </a>
    </div>
</div>
<div class="row">
    <div class="col-md-2 d-none d-md-block bg-light sidebar">
        <div class="sidebar-sticky">
            <nav class="navbar flex-column navbar-expand-md">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="home">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house icon-home" viewBox="0 0 16 16">
                                <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5ZM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5 5 5Z"/>
                            </svg>
                            Home
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="establecerTransaccion">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle icon-home" viewBox="0 0 16 16">
                                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                                <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                            </svg>
                            Crear Transaccion
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="establecerPresupuesto">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-up-circle icon-home" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-7.5 3.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V11.5z"/>
                            </svg>
                            Establecer presupuesto
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="crearCategoria">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-plus-circle icon-home" viewBox="0 0 16 16">
                                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                                <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                            </svg>
                            Crear categoria
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="calculadoraDeAhorro">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-plus-circle icon-home" viewBox="0 0 16 16">
                                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                                <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                            </svg>
                            Calcular Ahorros
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" >
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-left icon-home" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0v2z"/>
                                <path fill-rule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>
                            </svg>
                            Cerrar sesion
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <div class="col-lg-5">
        <h3>Editar su presupuesto</h3>

            <form:form action="editarPresupuesto" method="post" modelAttribute="presupuesto">
                <form:input value="${presupuesto.id}" type="hidden" id="id" path="id" name="id" class="form-control" />

                <label>Monto</label>
                <form:input value="${presupuesto.montoPresupuesto}" type="text" id="montoPresupuesto" path="montoPresupuesto" name="montoPresupuesto" class="form-control" placeholder="Ingrese monto..."/>
                <label>Fecha de inicio</label>
                <form:input value="${presupuesto.fechaDesde}" type="text" id="monto" path="fechaDesde" name="fechaDesde" class="form-control" placeholder="Ingrese fecha de inicio"/>
                <label>Fecha de fin</label>
                <form:input value="${presupuesto.fechaHasta}" type="text" id="monto" path="fechaHasta" name="fechaHasta" class="form-control" placeholder="Ingrese fecha de fin"/>
                <label>Categoria del presupuesto</label>
                <span class="form-control" disabled>${presupuesto.categoria.getNombre()}</span>
                <input type="hidden" value="${presupuesto.categoria.getId()}" name="categoria" path="categoria" >
                <button  id="btnLogin" type="submit" class="btn btnLogin btn-lg btn-block">Guardar</button>
            </form:form>
    </div>
    <div class="col-lg-5">
        <div >
            <h3>Presupuestos Ingresados</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>Monto</th>
                    <th>Categoría</th>
                    <th>Fecha Desde</th>
                    <th>Fecha Hasta</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="presupuesto" items="${presupuestos}">
                    <tr>
                        <td>${presupuesto.montoPresupuesto}</td>
                        <td>${presupuesto.categoria.getNombre()}</td>
                        <td>${presupuesto.fechaDesde}</td>
                        <td>${presupuesto.fechaHasta}</td>
                        <td><form action="editarPresupuesto" method="get">
                            <input type="hidden" name="id" value="${presupuesto.id}" />
                            <button class="fa fa-edit " style="background-color: initial; border: none" type="submit"></button>
                        </form></td>
                        <td>
                            <form action="deletePresupuesto" method="post">
                                <input type="hidden" name="id" value="${presupuesto.id}" />
                                <button class="fa fa-trash" type="submit" style="background-color: transparent; border: none;"></button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

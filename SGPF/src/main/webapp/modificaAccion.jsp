<%@page import="unam.mx.SGPF.model.controller.AccionJpaController"%>
<%@page import="unam.mx.SGPF.model.EntityProvider"%>
<%@page import="unam.mx.SGPF.model.Accion"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifica Acción</title>
                        <meta name="viewport"
	content="width=device-width,user-scalable=no, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0">
<!--===============================================================================================-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Inconsolata">
<link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
    <% Accion accion = (Accion) session.getAttribute("accionMod");%>
    <header>
		<div class="container">
			<h1>Sistema Gestor de Procesos Funcionales</h1>
		</div>
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">

					</ul>

					<a href="acciones"> <input class="btn btn-info"
						type="submit" value="Cancelar">
					</a>
				</div>
			</nav>
		</div>
	</header>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>Modifica Acción</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<form action="modificandoAccion" method="post">
					<div class="form-group">
						<label>Nombre de la acción</label>
						<input type="hidden" name="idAccion" value="<%=accion.getIdaccion()%>">
            <input class="form-control" type="text" name="nombreAccion" value="<%=accion.getNomAccion()%>" required>
					</div>
					<div class="form-group">
						<label>Movimiento de datos</label>
						<%
							if (accion.getMovDatos().equals("E")) {
						%>
						<select class="form-control" name="movDatos">
							<option value="E" selected>E</option>
							<option value="X">X</option>
							<option value="R">R</option>
							<option value="W">W</option>
							<option value="S">S</option>
						</select>
						<%
							} else {
								if (accion.getMovDatos().equals("X")) {
						%>
						<select class="form-control" name="movDatos">
							<option value="E">E</option>
							<option value="X" selected>X</option>
							<option value="R">R</option>
							<option value="W">W</option>
							<option value="S">S</option>
						</select>
						<%
							} else {
									if (accion.getMovDatos().equals("R")) {
						%>
						<select class="form-control" name="movDatos">
							<option value="E">E</option>
							<option value="X">X</option>
							<option value="R" selected>R</option>
							<option value="W">W</option>
							<option value="S">S</option>
						</select>
						<%
							} else {
										if (accion.getMovDatos().equals("W")) {
						%>
						<select class="form-control" name="movDatos">
							<option value="E">E</option>
							<option value="X">X</option>
							<option value="R">R</option>
							<option value="W" selected>W</option>
							<option value="S">S</option>
						</select>
						<%
							} else {
						%>
						<select class="form-control" name="movDatos">
							<option value="E">E</option>
							<option value="X">X</option>
							<option value="R">R</option>
							<option value="W">W</option>
							<option value="S" selected>S</option>
						</select>
						<%
							}
									}
								}
							}
						%>
					</div>
					<div class="form-group">
						<label>Descripción</label>
						<textarea class="form-control" name="descripcion" rows="3"><%=accion.getDescripcion()%></textarea>
					</div>
					<input class="btn btn-outline-info" type="submit" value="Aceptar">
				</form>
			</div>
		</div>
	</div>
        
<script src="js/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
    </body>
</html>

<%@page import="unam.mx.SGPF.model.ProcesoFuncional"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252">
<title>Modificar Proceso Funcional</title>
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
<%ProcesoFuncional detalle = (ProcesoFuncional) session.getAttribute("pfDetalle");%>

	<header>
		<div class="container">
			<h1>Sistema Gestor de Procesos Funcionales</h1>
		</div>
			<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">

					</ul>
					<form action="detallePF.jsp"
							method="POST">
							<input  class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;" type="submit" value="Cancelar" />
					</form>

				</div>
			</nav>
			</div>
	</header>
	<div class="container ">
		<div class="row">
			<div class="col-md-12">
				<h2>Modificar Proceso Funcional</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<form action="actualizarPF" method="POST">
					<div class="form-group">
						<label>Nombre del Grupo</label>
						<input type="hidden" name="idProcesoFuncional"
										value="<%=detalle.getIdprocesoFuncional()%>"> 
									<input class="form-control" type="text" name="nombreProcesoFuncional"
										value="<%=detalle.getNomPF()%>" required>
					</div>
					<div class="form-group">
						<label>Evento desencadenante</label>
						<input class="form-control" type="text" name="eventoDes"
										value="<%=detalle.getEventoDes()%>" required>
					</div>
					<div class="form-group">
						<label>Descripción</label>
						<textarea class="form-control" name="descripcionPF" rows="3" required><%=detalle.getDescripcion()%></textarea>					
					</div>

					<input class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;" type="submit" value="Guardar" />
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

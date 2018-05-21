<%@page import="unam.mx.SGPF.model.InterUP"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252">
<title>Gestiona Usuarios Proyectos</title>
<% List<InterUP> ListaInterUP = (List<InterUP>) session.getAttribute("ListaInterUP"); %>
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
	<header>
		<div class="container">
			<h1>Sistema Gestor de Procesos Funcionales</h1>
		</div>
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active"><a class="nav-link"
							href="agregaUsuarioProyecto.jsp">Agregar relación</a></li>
					</ul>

					<a class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
						href="proyectos.jsp">Regresar</a>

				</div>
			</nav>
		</div>
	</header>
	<div class="container py-5">
		<section class="row">
			<div class="col-md-12">
				<h2>Gestión de Usuarios Proyectos</h2>
			</div>
			<div class="table-responsive">
				<table class="table ">
					<thead>
						<tr>
							<th scope="col">Usuario</th>
							<th scope="col">Proyecto</th>
						</tr>
					</thead>
					<tbody>
						<% for(InterUP iter : ListaInterUP){%>
						<tr>
							<td><%=iter.getIdusuario().getNomUsuario()%></td>
							<td><%=iter.getIdproyecto().getNomProy()%></td>
						</tr>
						<%}%>
					</tbody>
				</table>
			</div>
		</section>
	</div>

	<script src="js/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>

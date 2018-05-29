<%@page import="unam.mx.SGPF.model.InterUP"%>
<%@page import="java.util.List"%>
<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de proyectos</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Inconsolata">
<link rel="stylesheet" href="css/estilos.css">
</head>
<%
        List<InterUP> inters = (List<InterUP>) session.getAttribute("inters");
        int tipoUsuario = Integer.parseInt(String.format("%s", session.getAttribute("tipoUsuario")));
    %>
<body>
	<header>
		<div class="container">
			<h1>Sistema Gestor de Procesos Funcionales</h1>
		</div>
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">


				<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active">
							<%
					if (tipoUsuario == 1 || tipoUsuario == 2) {
					%> <a class="nav-link" href="agregaProyecto">Agregar Proyecto</a> <% } %>
						</li>
						<li class="nav-item active">
							<%if(tipoUsuario==1){%> <a class="nav-link"
							href="crudCatalogos.jsp"> Gestión de Catálogos </a> <% } %>
						</li>
						<li class="nav-item active ">
							<%if(tipoUsuario == 1){%> <a class="nav-link"
							href="gestionUsuarios"> Gestión de Usuarios </a> <% } %>
						</li>

						<%if(tipoUsuario == 1 || tipoUsuario == 2){%>
						<li class="nav-item active"><a class="nav-link"
							href="gestionUsuariosProyectos"> Gestión de
								Usuarios-Proyectos </a></li>
						<% } %>
					</ul>
					<form class="col-md-2" action="cerrarSesion" method="post">
						<input class="btn btn-outline-info .btn-sm text-white"
							type="submit"
							style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
							value="Cerrar Sesión">
					</form>
				</div>
			</nav>
		</div>
	</header>

	<div class="container py-5">
		<section class="row">
			<div class="col-md-12">
				<h2>Proyectos</h2>
			</div>

			<div class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">Nombre Proyecto</th>
							<th scope="col">Estado de finalización</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
								for (InterUP inter : inters) {
									Proyecto p = inter.getIdproyecto();
							%>
						<tr>
							<td><a
								href="BuscaProyecto?idProyecto=<%=p.getIdproyecto()%>"><%=p.getNomProy()%></a>
							</td>
							<td>
								<%if(p.getEstatus()==0){%> Completado <%}else{ %> En proceso <%} %>
							</td>
							<td>
								<div class="dropdown">
									<button
										class="btn btn-outline-info .btn-sm btn-secondary dropdown-toggle text-white"
										style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
										type="button" id="dropdownMenu2" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">Opciones</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenu2">

										<a class="dropdown-item btn btn-outline-info .btn-sm"
											href="GeneraReporte?idProyecto=<%=p.getIdproyecto()%>">
											Generar Reporte </a>
										<% if(tipoUsuario!=3){%>
										<form action="eliminaProyecto" method="post">
											<input type="hidden" name="idProyecto"
												value="<%=p.getIdproyecto()%>"> <input
												class="dropdown-item btn btn-outline-info .btn-sm"
												type="submit" value="Cambiar Estatus" />
										</form>
										<% } %>

									</div>
								</div>
							</td>
						</tr>
						<%
								}
							%>
					
					<tbody>
				</table>
			</div>

		</section>
	</div>

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.bundle.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>

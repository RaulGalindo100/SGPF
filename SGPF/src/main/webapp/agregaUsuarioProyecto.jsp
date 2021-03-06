<%@page import="unam.mx.SGPF.model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252">
<title>Agrega Relaci�n Usuario Proyecto</title>
<%
	List<Usuario> ListaUsuario = (List<Usuario>) session.getAttribute("ListaUsuario");
	List<Proyecto> ListaProyectos = (List<Proyecto>) session.getAttribute("ListaProyectos");
	String result=request.getParameter("error");
	
%>
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

					</ul>
					<a href="gestionaUsuariosProyectos.jsp"> <input
						class="btn btn-outline-info .btn-sm text-white"
						style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
						type="submit" value="Cancelar">
					</a>
				</div>
			</nav>
		</div>
	</header>
	<div class="container ">
		<div class="row">
			<div class="col-md-12">
				<h2>Agregar Relaci�n Usuario Proyecto</h2>

				<%
								if (result!=null && result.equals("1")) {
							%>
				<div class="alert alert-warning alert-dismissible fade show"
					role="alert">
					<strong>�sta relaci�n ya existe.</strong>
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<%
								}
							%>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<form action="agregandoUsuarioProyecto" method="post">
					<div class="form-group">
						<label>Usuario</label> <select class="form-control"
							name="IdUsuario">
							<%
							for (Usuario iter : ListaUsuario) {
							%>
							<option value="<%=iter.getIdusuario()%>"><%=iter.getNomUsuario()%></option>
							<% } %>
						</select>
					</div>
					<div class="form-group">
						<label>Proyecto</label> <select class="form-control"
							name="IdProyecto">
							<%
								for (Proyecto iter : ListaProyectos) {
							%>
							<option value="<%=iter.getIdproyecto()%>"><%=iter.getNomProy()%></option>
							<%
								}
							%>
						</select>
					</div>
					<input class="btn btn-outline-info .btn-sm text-white"
						style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
						type="submit" value="Gurardar">
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

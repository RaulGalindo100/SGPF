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
						class="btn btn-info" type="submit" value="Cancelar">
					</a>
				</div>
			</nav>
		</div>
	</header>
	<div class="container ">
		<div class="row">
			<div class="col-md-12">
				<h2>Agrega Relaci�n Usuario Proyecto</h2>
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
							<%
								}
							%>
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
					<input class="btn btn-outline-info" type="submit" value="Gurardar">
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
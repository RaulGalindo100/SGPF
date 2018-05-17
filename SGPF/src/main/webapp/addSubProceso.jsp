<%@page import="unam.mx.SGPF.model.SubProceso"%>
<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page import="unam.mx.SGPF.model.Accion"%>
<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252">
<title>Agregar SubProceso</title>
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
<%
	SubProceso SubProceso = (SubProceso) session.getAttribute("SubProceso");
	
%>
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
					<form action="BuscaProcesoFuncional" method="POST">
						<input type="hidden" name="idprocesoFuncional"
							value="<%=SubProceso.getIdprocesoFuncional().getIdprocesoFuncional()%>" />
						<input class="btn btn-info" type="submit" value="Cancelar" />
					</form>
				</div>
			</nav>
		</div>
	</header>
	<div class="container ">
		<div class="row">
			<div class="col-md-12">
				<h2>Agregar Sub-Proceso</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<form action="agregandoSubProceso" method="POST">
					<div class="form-group">
						<label>Actividad</label>
                                                <input  type="hidden"
							name="actividad" value="<%=SubProceso.getActividad()%>">
                                                <input class="form-control" type="text"
							 value="<%=SubProceso.getActividad()%>" disabled>
					</div>
					<div class="form-group">
						<label>Descripción</label>
						<textarea class="form-control" name="descripcion" rows="3"
							required></textarea>
					</div>
					<div class="form-group">
						<label>Usuario funcional</label> <select class="form-control"
							name="usuarioFuncional" required>
							<%
								List<UsuarioFuncional> usuarioFuncionalCat = (List<UsuarioFuncional>) session.getAttribute("ufCatalogo");
								for (UsuarioFuncional usuarioF : usuarioFuncionalCat) {
									if (usuarioF.getActivo() == 1) {
							%>
							<option value="<%=usuarioF.getIdusuarioFuncional()%>">
								<%=usuarioF.getNomUF()%> --
								<%=usuarioF.getDescripcion()%>
							</option>
							<%
								}
								}
							%>
						</select>
					</div>
					<div class="form-group">
						<label>Acción</label> <select class="form-control" name="accion"
							required>
							<%
								List<Accion> accionesCat = (List<Accion>) session.getAttribute("accCatalogo");
								for (Accion accion : accionesCat) {
									if (accion.getActivo() == 1) {
							%>
							<option value="<%=accion.getIdaccion()%>">
								<%=accion.getNomAccion()%> --
								<%=accion.getMovDatos()%> --
								<%=accion.getDescripcion()%>
							</option>
							<%
								}
								}
							%>
						</select>
					</div>
					<div class="form-group">
						<label>Grupo de datos</label> <select class="form-control"
							name="grupoDatos" required>
							<%
								List<GrupoDato> grupoDatoCat = (List<GrupoDato>) session.getAttribute("grupoDatosCatalogo");
								for (GrupoDato grupoDato : grupoDatoCat) {
									if (grupoDato.getActivo() == 1) {
							%>
							<option value="<%=grupoDato.getIdgrupoDato()%>">
								<%=grupoDato.getNomGD()%> --
								<%=grupoDato.getDescripcion()%>
							</option>
							<%
								}
								}
							%>
						</select>
					</div>
					<div class="form-group">
						<input class="form-check-input" type="checkbox" name="flujoAl"
							value="true"> <label class="form-check-label">Flujo
							alterno</label>
					</div>
					<input class="btn btn-outline-info" type="submit" value="Guardar" />
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

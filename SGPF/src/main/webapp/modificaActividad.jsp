<%@page import="unam.mx.SGPF.model.EntityProvider"%>
<%@page import="unam.mx.SGPF.model.controller.SubProcesoJpaController"%>
<%@page import="unam.mx.SGPF.model.SubProceso"%>
<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page import="unam.mx.SGPF.model.Accion"%>
<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modificar Actividad</title>
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
	<%
		SubProceso subProcesoMod = (SubProceso) session.getAttribute("subProcesoMod");
		int idUF = subProcesoMod.getIdusuarioFuncional().getIdusuarioFuncional();
		int idAccion = subProcesoMod.getIdaccion().getIdaccion();
		int idGrupoDato = subProcesoMod.getIdgrupoDato().getIdgrupoDato();
	%>

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
						<div class="btn-group" role="group">
							<input class="btn btn-info" type="hidden"
								name="idprocesoFuncional"
								value="<%=subProcesoMod.getIdprocesoFuncional().getIdprocesoFuncional()%>" />
							<input class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;" type="submit" value="Cancelar" />
						</div>
					</form>
				</div>
			</nav>
		</div>
	</header>
	<div class="container ">
		<div class="row">
			<div class="col-md-12">
				<h2>Modificar Actividad</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<form action="modificandoActividad" method="POST">
					<div class="form-group">
						<label>Actividad</label> 
                                                
                                                <%if(subProcesoMod.getActividad().equals("Inicio de Proceso Funcional")){%>
                                                <input type="hidden"
							name="actividad" value="<%=subProcesoMod.getActividad()%>"
							>
                                                <input class="form-control" type="text"
							 value="<%=subProcesoMod.getActividad()%>"
							disabled>
                                                <%}else{%>
                                                 <input class="form-control" type="text"
							name="actividad" value="<%=subProcesoMod.getActividad()%>"
							required>
                                                <%}%>
					</div>
					<div class="form-group">
						<label>Descripción</label> <input class="form-control" type="text"
							name="descripcion" value="<%=subProcesoMod.getDescripcion()%>"
							required>
					</div>
					<div class="form-group">
						<label>Usuario funcional</label> <select class="form-control"
							name="usuarioFuncional">
							<%
								List<UsuarioFuncional> usuarioFuncionalCat = (List<UsuarioFuncional>) session.getAttribute("ufCatalogo");
								for (UsuarioFuncional usuarioF : usuarioFuncionalCat) {
									if (usuarioF.getActivo() == 1) {
										if (usuarioF.getIdusuarioFuncional() == idUF) {
							%>
							<option value="<%=usuarioF.getIdusuarioFuncional()%>" selected>
								<%
									} else {
								%>
							
							<option value="<%=usuarioF.getIdusuarioFuncional()%>">
								<%
									}
								%>
								<%=usuarioF.getNomUF()%> --
								<%=usuarioF.getDescripcion()%>
							</option>
							<%
								} //IF ACTIVO
								} //FOR
							%>
						</select>
					</div>
					<div class="form-group">
						<label>Acción</label> <select class="form-control" name="accion">
							<%
								List<Accion> accionesCat = (List<Accion>) session.getAttribute("accCatalogo");
								for (Accion accion : accionesCat) {
									if (accion.getActivo() == 1) {
										if (accion.getIdaccion() == idAccion) {
							%>
							<option value="<%=accion.getIdaccion()%>" selected="true">
								<%
									} else {
								%>
							
							<option value="<%=accion.getIdaccion()%>">
								<%
									}
								%>
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
							name="grupoDatos">
							<%
								List<GrupoDato> grupoDatoCat = (List<GrupoDato>) session.getAttribute("grupoDatosCatalogo");
								for (GrupoDato grupoDato : grupoDatoCat) {
									if (grupoDato.getActivo() == 1) {
										if (grupoDato.getIdgrupoDato() == idGrupoDato) {
							%>
							<option value="<%=grupoDato.getIdgrupoDato()%>" selected="true">
								<%
									} else {
								%>
							
							<option value="<%=grupoDato.getIdgrupoDato()%>">
								<%
									}
								%>
								<%=grupoDato.getNomGD()%> --
								<%=grupoDato.getDescripcion()%>
							</option>
							<%
								}
								}
							%>
						</select>
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

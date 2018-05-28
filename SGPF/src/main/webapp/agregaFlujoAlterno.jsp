<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page import="unam.mx.SGPF.model.Accion"%>
<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page import="java.util.List"%>
<%@page import="unam.mx.SGPF.model.EntityProvider"%>
<%@page import="unam.mx.SGPF.model.controller.SubProcesoJpaController"%>
<%@page import="unam.mx.SGPF.model.SubProceso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agregar Flujo Alterno</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Inconsolata">
<link rel="stylesheet" href="css/estilos.css">
</head>
<% 
    SubProceso SubProceso = (SubProceso) session.getAttribute("SubProceso");
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

					</ul>
					<a href="detallePF.jsp"><input
						class="btn btn-outline-info .btn-sm text-white"
						style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
						type="submit" value="Cancelar"></a>

				</div>
			</nav>
		</div>
	</header>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>Agregar Flujo Alterno</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<form action="agregandoFlujoAlterno" method="post">
					<div class="form-group">
						<label>Actividad</label> <input class="form-control" type="text"
							value="<%=SubProceso.getActividad()%>" disabled>
					</div>
					<div class="form-group">
						<label>Descripción</label> <input class="form-control" type="text"
							name="descripcionFA" required>

					</div>
					<div class="form-group">
						<label>Usuario funcional</label> <select class="form-control"
							name="usuarioFuncionalFA" required>
							<%
               List<UsuarioFuncional> usuarioFuncionalCat = (List<UsuarioFuncional>) session.getAttribute("ufCatalogo");
							for (UsuarioFuncional usuarioF : usuarioFuncionalCat) {
								if (usuarioF.getActivo() == 1) {%>
								<option value="<%=usuarioF.getIdusuarioFuncional()%>">
									<%=usuarioF.getNomUF()%> --
									<%=usuarioF.getDescripcion()%>
								</option>
							<% } } %>
						</select>
					</div>
					<div class="form-group">
						<label>Acción</label> <select class="form-control" name="accionFA"
							required>
							<%
                    List<Accion> accionesCat = (List<Accion>) session.getAttribute("accCatalogo");
                    for (Accion accion : accionesCat) {
                    if (accion.getActivo() == 1) {%>
				<option value="<%=accion.getIdaccion()%>">
					<%=accion.getNomAccion()%> --
					<%=accion.getMovDatos()%> --
					<%=accion.getDescripcion()%>
				</option>
				<% } } %>
						</select>
					</div>
					<div class="form-group">
						<label>Grupo de datos</label> <select class="form-control"
							name="grupoDatosFA" required>
							<%
                    List<GrupoDato> grupoDatoCat = (List<GrupoDato>) session.getAttribute("grupoDatosCatalogo");
                    for (GrupoDato grupoDato : grupoDatoCat) {
                         if (grupoDato.getActivo() == 1) {%>
				<option value="<%=grupoDato.getIdgrupoDato()%>">
					<%=grupoDato.getNomGD()%> --
					<%=grupoDato.getDescripcion()%>
				</option>
				<% } } %>
						</select>
					</div>
										<input class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;" type="submit" value="Guardar" />
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>

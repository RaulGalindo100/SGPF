<%@page import="unam.mx.SGPF.model.SubProceso"%>
<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page import="unam.mx.SGPF.model.Accion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!-- 
Falta que al agregar sólo lo hahrá en caso de que no exista ya el NOMBRE DE LA
ACTIVIDAD CON EL PF, de no ser así mandar ERROR.

Validad ID del PF con ....
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agregar Actividad</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Inconsolata">
<link rel="stylesheet" href="css/estilos.css">
<%
            List<SubProceso> ListaSubprocesos = (List<SubProceso>) session.getAttribute("ListaSubprocesos");
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

					<a href="detallePF.jsp"><input class="btn btn-info"
						type="submit" value="Cancelar"></a>

				</div>
			</nav>
		</div>
	</header>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>Agregar Actividad</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<form action="agregandoActividad" method="POST">
					<div class="form-group">
						<label>Actividad</label>
						<%
							if (ListaSubprocesos.isEmpty()) {
						%>
						<input class="form-control" type="hidden" name="actividad"
							value="Inicio de Proceso Funcional"> <input
							class="form-control" type="text"
							value="Inicio de Proceso Funcional" disabled>
						<%
							} else {
						%>
						<input class="form-control" type="text" name="actividad" required>
						<%
							}
						%>
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

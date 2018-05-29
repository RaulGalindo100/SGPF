<%-- 
    Document   : agregaGrupoDatos
    Created on : 28/05/2018, 04:41:03 PM
    Author     : jlope
--%>

<%@page import="unam.mx.SGPF.model.FlujoAlterno"%>
<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agrega Grupo de Datos para el Flujo Alterno</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Inconsolata">
<link rel="stylesheet" href="css/estilos.css">
</head>
<% String result=request.getParameter("error");%>
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
				<h2>Agregar Grupo de Datos para el Flujo Alterno</h2>
				<%if (result!=null && result.equals("1")) {%>
				<div class="alert alert-warning alert-dismissible fade show"
					role="alert">
					<strong>Este Grupo de datos ya existe para este Flujo Alterno.</strong>
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
				<form action="agregagndoGrupoDatosFlujoAlterno" method="post">
					<div class="form-group">
						<label>Grupo de datos</label> <select name="grupoDatosFA" class="form-control">
							<%List<GrupoDato> grupoDatoCat = (List<GrupoDato>) session.getAttribute("grupoDatosCatalogo");
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
<script src="js/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>

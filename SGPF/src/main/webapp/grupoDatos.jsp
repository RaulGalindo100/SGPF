<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Grupos de Datos</title>
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
     <% List<GrupoDato> grupoDatos = (List<GrupoDato>) session.getAttribute("grupoDatos"); %>
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
					<a class="nav-link" href="agregarGrupoDatos.jsp">Agregar Grupo</a>
					</li>
	
					</ul>
					<a href="crudCatalogos.jsp"><input class="btn btn-info"
						type="submit" value="Regresar"></a>
				</div>
			</nav>
		</div>
	</header>
	<div class="container py-5">
		<section class="row">
			<div class="col-md-12">
				<h2>Administración de Grupo de datos</h2>
			</div>
			<div class="table-responsive ">
				<table class="table ">
					<thead>
					<tr>
							<th scope="col">Nombre del grupo</th>
							<th scope="col">Descripción</th>
							<th scope="col">Activo</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<% for(GrupoDato iter : grupoDatos){  %>
						<tr>
							<td><%=iter.getNomGD()%></td>
							<td><%=iter.getDescripcion()%></td>
							<% if(iter.getActivo()==1){%>
							<td>Si</td>
							<td>
								<div class="container">
									<!-- Trigger the modal with a button -->
									<button type="button" class="btn btn-outline-info"
										data-toggle="modal"
										data-target="#myModal-<%=iter.getIdgrupoDato()%>">
										Desactivar</button>
									<!-- Modal -->
									<div class="modal fade"
										id="myModal-<%=iter.getIdgrupoDato()%>" role="dialog">
										<div class="modal-dialog">
											<!-- Modal content-->
											<div class="modal-content">
												<div class="modal-body">
													<p>El grupo de datos será desactivado.</p>
												</div>
												<div class="modal-footer">
													<a class="btn btn-outline-info"
														href="EliminaGrupoDato?idGrupoDato=<%=iter.getIdgrupoDato()%>">Aceptar</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</td>
							<td><a class="btn btn-outline-info"
								href="modificaGrupoDato?idGrupoDato=<%=iter.getIdgrupoDato()%>">Modificar</a>
							</td>
							<%}else{%>
							<td>No</td>
							<td>
								<div class="container">
									<!-- Trigger the modal with a button -->
									<button type="button" class="btn btn-outline-info"
										data-toggle="modal"
										data-target="#myModal-<%=iter.getIdgrupoDato()%>">
										Activar</button>
									<!-- Modal -->
									<div class="modal fade"
										id="myModal-<%=iter.getIdgrupoDato()%>" role="dialog">
										<div class="modal-dialog">
											<!-- Modal content-->
											<div class="modal-content">
												<div class="modal-body">
													<p>El grupo de datos será activado.</p>
												</div>
												<div class="modal-footer">
													<a class="btn btn-outline-info"
								href="EliminaGrupoDato?idGrupoDato=<%=iter.getIdgrupoDato()%>">Aceptar</a>
												</div>
											</div>
										</div>
									</div>
								</div> 
							</td>
							<% } %>
						</tr>
						<% } %>
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

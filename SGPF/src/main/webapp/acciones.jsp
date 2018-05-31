<%@page import="unam.mx.SGPF.model.InterUP"%>
<%@page import="unam.mx.SGPF.model.Accion"%>
<%@page import="java.util.List"%>
<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Gestión de acciones</title>
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
		List<Accion> acciones = (List<Accion>) session.getAttribute("action");
                List<InterUP> inters = (List<InterUP>) session.getAttribute("inters");
	%>
	<header>
		<div class="container">
			<h1>Sistema Gestor de Procesos Funcionales</h1>
		</div>
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active">
					<a class="nav-link" href="agregarAccion.jsp">Agregar Acción</a>
					</li>
	
					</ul>
					<a href="crudCatalogos.jsp"><input class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
						type="submit" value="Regresar"></a>
				</div>
			</nav>
		</div>
	</header>
	<div class="container">
		<section class="row">
			<div class="col-md-12">
				<h2>Gestión de Acciones</h2>
			</div>
			<div class="table-responsive ">
				<table class="table ">
					<thead>
						<tr>
							<th scope="col">Nombre de la acción</th>
                                                        <th scope="col">Descripción</th>
							<th scope="col">Movimiento de datos relacionado</th>
							<th scope="col">Proyecto Asociado</th>
							<th scope="col">Activa</th>
							<th></th>
							<th></th>
						</tr>
						</thead>
					<tbody>
						<%
							for (Accion accion : acciones) {
						%>
						<tr>
							<td><%=accion.getNomAccion()%></td>
              <td><%=accion.getDescripcion()%></td>
							<td><%=accion.getMovDatos()%></td>
							<td><%for(InterUP iter : inters){
                                                            if(iter.getIdproyecto().getIdproyecto()==accion.getIdproyecto()){%>
                                                                <%=iter.getIdproyecto().getNomProy()%>
                                                            <%}}%>
                                                        </td>
							<td>
								<%
									if (accion.getActivo() == 1) {
								%>Si<%
									} else {
								%>No<%
									}
								%>
							</td>

							<td>
							<%
								if (accion.getActivo() == 1) {
							%>
							<div class="container">
									<!-- Trigger the modal with a button -->
									<button type="button" class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
										data-toggle="modal"
										data-target="#myModal-<%=accion.getIdaccion()%>">
										Desactivar</button>
									<!-- Modal -->
									<div class="modal fade"
										id="myModal-<%=accion.getIdaccion()%>" role="dialog">
										<div class="modal-dialog">
											<!-- Modal content-->
											<div class="modal-content">
												<div class="modal-body">
													<p>La acción será desactivada.</p>
												</div>
												<div class="modal-footer">
													<a class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
								href="EliminaAccion?idAccion=<%=accion.getIdaccion()%>">Aceptar</a>
								<button type="button" class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;" data-dismiss="modal">Cancelar</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								
							</td>
							<td>
							<%
								} else {
							%>
							<div class="container">
									<!-- Trigger the modal with a button -->
									<button type="button" class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
										data-toggle="modal"
										data-target="#myModal-<%=accion.getIdaccion()%>">
										Activar</button>
									<!-- Modal -->
									<div class="modal fade"
										id="myModal-<%=accion.getIdaccion()%>" role="dialog">
										<div class="modal-dialog">
											<!-- Modal content-->
											<div class="modal-content">
												<div class="modal-body">
													<p>La acción será activada.</p>
												</div>
												<div class="modal-footer">
													<a class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
								href="EliminaAccion?idAccion=<%=accion.getIdaccion()%>">Aceptar</a>
								<button type="button" class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;" data-dismiss="modal">Cancelar</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								
							</td>
							<td>
							<%
								}
							%>
							<%
								if (accion.getActivo() == 1) {
							%>
							
								<a class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
								href="modificaAccion?idAccion=<%=accion.getIdaccion()%>">Modificar</a>
							
							<%
								}
							%>
							</td>
						</tr>
						<%
							}
						%>
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

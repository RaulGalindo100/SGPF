<%@page import="unam.mx.SGPF.model.InterUP"%>
<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Gestión de UF</title>
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
					<li class="nav-item active">
					 <a class="nav-link" href="agregarUF.jsp">Agregar Usuario Funcional</a>
					</li>
	
					</ul>
					<a href="crudCatalogos.jsp"><input class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
						type="submit" value="Regresar"></a>
				</div>
			</nav>
		</div>
	</header>
	 <%
   	List<UsuarioFuncional> uf = (List<UsuarioFuncional>) session.getAttribute("usuarioFuncional");
        List<InterUP> inters = (List<InterUP>) session.getAttribute("inters");
	 %>
	<div class="container py-5">
		<section class="row">
			<div class="col-md-12">
				<h2>Gestión de Usuarios Funcionales</h2>
			</div>
			<div class="table-responsive ">
				<table class="table ">
					<thead>
						<tr>
							<th scope="col">Nombre del Usuario Funcional</th>
							<th scope="col">Descripción</th>
							<th scope="col">Proyecto Asociado</th>
							<th scope="col">Activo</th>
							<th scope="col" colspan=2>Opciones</th>
							
						</tr>
						</thead>
					<tbody>
						<%
							for (UsuarioFuncional iter : uf) {
						%>
						<tr>
							<td><%=iter.getNomUF()%></td>
							<td><%=iter.getDescripcion()%></td>
                                                        <td><%for(InterUP iterador : inters){
                                                            if(iterador.getIdproyecto().getIdproyecto()==iter.getIdproyecto()){%>
                                                                <%=iterador.getIdproyecto().getNomProy()%>
                                                            <%}}%>
                                                        </td>
							<td>
								<%
									if (iter.getActivo() == 1) {
								%>Si<%
									} else {
								%>No<%
									}
								%>
							</td>
							<%
								if (iter.getActivo() == 1) {
							%>
							<td>
							
							<div class="container">
									<!-- Trigger the modal with a button -->
									<button type="button" class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
										data-toggle="modal"
										data-target="#myModal-<%=iter.getIdusuarioFuncional()%>">
										Desactivar</button>
									<!-- Modal -->
									<div class="modal fade"
										id="myModal-<%=iter.getIdusuarioFuncional()%>" role="dialog">
										<div class="modal-dialog">
											<!-- Modal content-->
											<div class="modal-content">
												<div class="modal-body">
													<p>El usuario funcional será desactivado.</p>
												</div>
												<div class="modal-footer">
													<a class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
								href="EliminaUF?idUF=<%=iter.getIdusuarioFuncional()%>">Aceptar</a>
								<button type="button" class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;" data-dismiss="modal">Cancelar</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							
							</td>
							<%
								} else {
							%>
							<td>
							<div class="container">
									<!-- Trigger the modal with a button -->
									<button type="button" class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
										data-toggle="modal"
										data-target="#myModal-<%=iter.getIdusuarioFuncional()%>">
										Activar</button>
									<!-- Modal -->
									<div class="modal fade"
										id="myModal-<%=iter.getIdusuarioFuncional()%>" role="dialog">
										<div class="modal-dialog">
											<!-- Modal content-->
											<div class="modal-content">
												<div class="modal-body">
													<p>El usuario funcional será activado.</p>
												</div>
												<div class="modal-footer">
													<a class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
								href="EliminaUF?idUF=<%=iter.getIdusuarioFuncional()%>">Aceptar</a>
								<button type="button" class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;" data-dismiss="modal">Cancelar</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							
							</td>
							<%
								}
							%>
							<%
								if (iter.getActivo() == 1) {
							%>
							<td><a class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
								href="modificaUF?idUF=<%=iter.getIdusuarioFuncional()%>">Modificar</a>
							</td>
							<%
								}
							%>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</section>
	</div>
	
      
        
        </table>
 
    
	<script src="js/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
    </body>
</html>

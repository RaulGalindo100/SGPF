<%@page import="unam.mx.SGPF.model.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gesti�n de Usuarios</title>
        <% List<Usuario> usuarios = (List<Usuario>) session.getAttribute("CatalogoUsuarios");
           Usuario usuarioAtual = (Usuario) session.getAttribute("usuario");
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
						<li class="nav-item active"><a class="nav-link"
							href="agregarUsuario.jsp"> Agregar Usuario </a></li>
					</ul>

					<a class="btn btn-outline-info .btn-sm text-white"
						style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
						href="proyectos.jsp">Regresar</a>
				</div>
			</nav>
		</div>
	</header>

	<div class="container py-5">
		<section class="row">
			<div class="col-md-12">
				<h2>Gesti�n de Usuarios</h2>
			</div>
			<div class="table-responsive">
				<table class="table ">
					<thead>
<<<<<<< HEAD
						<tr>
							<th scope="col">Nombre</th>
							<th scope="col">Tipo usuario</th>
							<th scope="col">Opciones</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%for(Usuario usuario : usuarios){%>
						<tr>
							<td><%=usuario.getNomUsuario()%></td>
=======
							<tr>
								<th scope="col">Nombre</th>
								<th scope="col">Tipo usuario</th>
								<th scope="col">Opciones</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
                                                    <%for(Usuario usuario : usuarios){ if(!usuarioAtual.getNomUsuario().equals(usuario.getNomUsuario())){ %>
            <tr>
                <td>
                    <%=usuario.getNomUsuario()%>
                </td>
                <td>
                    <%if(usuario.getUsuTipo1()!=null){%>Administrador
                    <%}else{if(usuario.getUsuTipo2()!=null){%>Gestor de Proyecto
                    <%}else{if(usuario.getUsuTipo3()!=null){%>Consultor
                    <%}else{%> = Inactivo = <%}}}%>
                </td>
                <td>
						<% if (usuario.getActivo() == 1) { %>

>>>>>>> 4934c36e68d46f44516695c13092851bcf91b8e8
							<td>
								<%if(usuario.getUsuTipo1()!=null){%>Administrador <%}else{if(usuario.getUsuTipo2()!=null){%>Gestor
								de Proyecto <%}else{if(usuario.getUsuTipo3()!=null){%>Consultor <%}else{%>
								= Inactivo = <%}}}%>
							</td>


								<% if (usuario.getActivo() == 1) { %>

							<td>

								<div class="container">
									<!-- Trigger the modal with a button -->
									<button type="button"
										class="btn btn-outline-info .btn-sm text-white"
										style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
										data-toggle="modal"
										data-target="#myDesUF-<%=usuario.getIdusuario()%>">
										Desactivar</button>
									<!-- Modal -->
									<div class="modal fade"
										id="myDesUF-<%=usuario.getIdusuario()%>" role="dialog">
										<div class="modal-dialog">
											<!-- Modal content-->
											<div class="modal-content">
												<div class="modal-body">
													<p>El usuario ser� desactivado.</p>
												</div>
												<div class="modal-footer">
													<a class="btn btn-outline-info .btn-sm text-white"
														style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
														href="modificaUsuario?idUsuario=<%=usuario.getIdusuario()%>">Aceptar</a>
													<button type="button"
														class="btn btn-outline-info .btn-sm text-white"
														style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
														data-dismiss="modal">Cancelar</button>
												</div>
											</div>
										</div>
									</div>
								</div>

							</td>
							<td><a
								href="modificarUsuario?idUsuario=<%=usuario.getIdusuario()%>">
									<input class="btn btn-outline-info .btn-sm text-white"
									style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
									type="submit" value="Modificar">
							</a></td>
							<%
								} else {
							%>
							<td>
								<div class="container">
									<!-- Trigger the modal with a button -->
									<button type="button"
										class="btn btn-outline-info .btn-sm text-white"
										style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
										data-toggle="modal"
										data-target="#myModal-<%=usuario.getIdusuario()%>">
										Activar</button>
									<!-- Modal -->
									<div class="modal fade"
										id="myModal-<%=usuario.getIdusuario()%>" role="dialog">
										<div class="modal-dialog">
											<!-- Modal content-->
											<div class="modal-content">
												<div class="modal-body">
													<p>El usuario funcional ser� activado.</p>
												</div>
												<div class="modal-footer">
													<a class="btn btn-outline-info .btn-sm text-white"
														style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
														href="modificaUsuario?idUsuario=<%=usuario.getIdusuario()%>">Aceptar</a>
													<button type="button"
														class="btn btn-outline-info .btn-sm text-white"
														style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
														data-dismiss="modal">Cancelar</button>
												</div>
											</div>
										</div>
									</div>
								</div>

							</td>
							<%
								}

							%>

<<<<<<< HEAD

						</tr>
						<%}%>

					</tbody>
=======
            </tr>
            <%}}%>
            <tr>
						</tbody>
>>>>>>> 4934c36e68d46f44516695c13092851bcf91b8e8
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

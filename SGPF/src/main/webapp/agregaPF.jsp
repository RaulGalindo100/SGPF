<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252">
<title>Agrega PF</title>
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
<%
			Proyecto p = (Proyecto) session.getAttribute("proy");
    %>
<header>
	<body>
		<div class="container">
			<h1>Sistema Gestor de Procesos Funcionales</h1>
		</div>
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">

					</ul>
					<form action="BuscaProyecto" method="POST">
						<input type="hidden" name="idProyecto"
							value="<%=p.getIdproyecto()%>"> <input
							class="btn btn-info" type="submit" value="Cancelar">
					</form>
				</div>
			</nav>
		</div>
</header>
<div class="container py-5">
	<section class="row">
		<div class="col-md-12">
			<h1>Agrega Proceso Funcional</h1>
		</div>
		<div class="table-responsive">
			<form action="agregarPF" method="POST">
				<table class="table">
					<tbody>
						<tr>
							<th scope="col" style="text-align: right;">Nombre Proceso
								funcional:</th>
							<td><input type="text" name="nombrePF" required></td>
						</tr>
						<tr>
							<th scope="col" style="text-align: right;">Descripción:</th>
							<td><input type="text" name="descripcioPF" required></td>
						</tr>
						<tr>
							<th scope="col" style="text-align: right;">Evento
								desencadenante:</th>
							<td><input type="text" name="eventoDes" required> <input
								type="hidden" name="idProyecto" value="<%=p.getIdproyecto()%>">
							</td>
						</tr>
					</tbody>
				</table>
				<input class="btn btn-outline-info" type="submit" value="Guardar">
			</form>
		</div>
	</section>
</div>


</body>
</html>

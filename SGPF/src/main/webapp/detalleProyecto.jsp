<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page import="unam.mx.SGPF.model.ProcesoFuncional"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalles proyecto</title>
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
     List<ProcesoFuncional> pfs = (List<ProcesoFuncional>) session.getAttribute("procFunc");
  	 Proyecto p = (Proyecto) session.getAttribute("proy"); 
     int tipoUsuario = Integer.parseInt(session.getAttribute("tipoUsuario").toString());
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
						<li class="nav-item active">
							<%if(tipoUsuario!=3 && p.getEstatus()==1){%> <a class="nav-link"
							href="modificaProy">Modificar Proyecto</a> <% } %>
						</li>
						<li class="nav-item activ">
							<% if(tipoUsuario!=3){%>
							<form action="eliminaProyecto" method="post">
								<input type="hidden" name="idProyecto"
									value="<%=p.getIdproyecto()%>"> <input
									class="nav-link myclass "
									style="color: rgba(0, 0, 0, .9); border-style: none; background-color: transparent; cursor: pointer; cursor: hand;"
									type="submit" value="Cambiar Estatus" />
							</form> <% } %>
						</li>
						<li class="nav-item active">
							<%if(tipoUsuario!=3 && p.getEstatus()==1){ %> <a class="nav-link"
							href="agregaPF.jsp">Agregar PF</a> <%} %>
						</li>
					</ul>

					<a class="btn btn-outline-success my-2 my-sm-0"
						href="proyectos.jsp">Regresar</a>

				</div>
			</nav>
		</div>
	</header>

	<div class="container py-5">
		<div class="row">
			<div class="col-md-12">
				<h2>Detalle proyecto</h2>
			</div>

		</div>
		<div class="row">
			<div class="col-md-4">Nombre Proyecto</div>
			<div class="col-md-4">
				<%=p.getNomProy()%>
			</div>
			<div class="col-md-4">
				<button class="btn btn-outline-info" data-toggle="collapse"
					data-target="#demo">Más detalle</button>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-12">
				<div id="demo" class="collapse">
					<div class="row">
						<div class="col-md-8">Información de proyecto</div>
						<div class="col-md-2">
							<button class="btn btn-outline-info" data-toggle="collapse"
								data-target="#infoProy">Más</button>
						</div>
					</div>
					<div class="row">
						<div class="col-md-8">
							<div id="infoProy" class="collapse">
								<table class="table " style="border-width: 2px; border-style: solid; border-color: #17a2b8;">
									<tbody>
										<tr>
											<td>Propósito:</td>
											<td><%=p.getProposito() %></td>
										</tr>
										<tr>
											<td>Alcance:</td>
											<td><%=p.getAlcance()%></td>
										</tr>
										<tr>
											<td>Año:</td>
											<td><%=p.getAnioProy() %></td>
										</tr>
										<tr>
											<td>Tipo desarrollo:</td>
											<td><%=p.getIdTipoDesarrollo().getTipodeDesarrollo()%></td>
										</tr>
										<tr>
											<td>Sector de la Organización Usuaria</td>
											<td><%=p.getIdsectorOrganizacion().getSectorOrganizacion()%></td>
										</tr>
										<tr>
											<td>Tipo Organización Usuaria</td>
											<td><%=p.getIdtipoOrganizacion().getTipoOrganizacion()%></td>
										</tr>
										<tr>
											<td>Tipo de Capacidad de Desarrollo usada</td>
											<td><%=p.getIdtipoCapDes().getTipoCapDes() %></td>
										</tr>

										<tr>
											<td>Tamaño de la Organización que desarrolló el software</td>
											<td><%=p.getIdtamOrgDes().getTamOrgDes() %></td>
										</tr>
										<tr>
											<td>Tamaño de la Organización que usaria el software</td>
											<td><%=p.getTamOrgUsa().getTamOrgDes() %></td>
										</tr>
									<tbody>
								</table>

							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-8">Contexto de desarrollo</div>
						<div class="col-md-2">
							<button class="btn btn-outline-info" data-toggle="collapse"
								data-target="#contDes">Más</button>
						</div>
					</div>
					<div class="row">
						<div class="col-md-8">
							<div id="contDes" class="collapse">
								<table class="table " style="border-width: 2px; border-style: solid; border-color: #17a2b8;">
									<tbody>
										<tr>
											<td>Arquitectura de Proyecto</td>
											<td><%=p.getIdarqProyecto().getArqProyecto() %></td>
										</tr>
										<tr>
											<td>Lenguaje Principal de Programación</td>
											<td><%=p.getIdlenguaje().getLenguaje() %></td>
										</tr>
										<tr>
											<td>Sistema Operativo Principal</td>
											<td><%=p.getIdsisOpe().getSisOpe() %></td>
										</tr>
										<tr>
											<td>Base de Datos</td>
											<td><%=p.getIdbaseDatos().getBaseDatos() %></td>
										</tr>
										<tr>
											<td>¿Se utilizó una herramienta CASE?</td>
											<td>
												<%if(p.getOperProy() == 1){%>Si <%}else{%>No<%} %>
											</td>
										</tr>
										<tr>
											<td>Ciclo de Vida Utilizado</td>
											<td><%=p.getIdmetDesarrollo().getMetDesarrollo() %></td>
										</tr>
										<tr>
											<td>Marco de Procesos Utilizado</td>
											<td><%=p.getIdmarcoPosUsa().getMarcoPosUsa() %></td>
										</tr>
										<tr>
											<td>Modelo de Calidad Utilizado</td>
											<td><%=p.getIdmodCalidad().getModCalidad() %></td>
										</tr>
										<tr>
											<td>¿Tiene Certificación en el Modelo de Calidad?</td>
											<td>
												<%if(p.getMedidorCertProy() == 1){%> Si <%  } else {%>No<%} %>
											</td>
										</tr>
										<tr>
											<td>Comentar la certificación</td>
											<td><%=p.getComCertModelo()%></td>
										</tr>
										<tr>
											<td>Contabilidad de la información</td>
											<td><%=p.getIdconfInfo().getConfInfo()%></td>
										</tr>
									<tbody>
								</table>

							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-8">Información de recursos</div>
						<div class="col-md-2">
							<button class="btn btn-outline-info" data-toggle="collapse"
								data-target="#infoRec">Más</button>
						</div>
					</div>
					<div class="row">
						<div class="col-md-8">
							<div id="infoRec" class="collapse">
								<table class="table " style="border-width: 2px; border-style: solid; border-color: #17a2b8;">
									<tbody>
										<tr>
											<td>Duración del Proyecto</td>
											<td><%=p.getDuraProy() %> <%=p.getIdescala().getEscala() %></td>
									
										</tr>
										<tr>
											<td>Esfuerzo Total del Proyecto [hh]</td>
											<td><%=p.getEsfuTotProy() %></td>
										</tr>
										<tr>
											<td>Esfuerzo de Planeación [hh]</td>
											<td><%=p.getEsfuPlaneProy() %></td>
										</tr>
										<tr>
											<td>Esfuerzo de Especificación de Requerimientos
										[hh]</td>
											<td><%=p.getEsfuEsReqProy() %></td>
										</tr>
										<tr>
											<td>Esfuerzo de Análisis y Diseño [hh]</td>
											<td><%=p.getEsfuAnaDisProy()  %></td>
										</tr>
										<tr>
											<td>Esfuerzo de Construcción [hh]</td>
											<td><%=p.getEsfuConstProy() %></td>
										</tr>
										<tr>
											<td>Esfuerzo de Pruebas [hh]</td>
											<td><%=p.getEsfuPrueProy() %></td>
										</tr>
										<tr>
											<td>Esfuerzo de Implementación / Despliegue [hh]</td>
											<td><%=p.getEsfuImpleDesProy()  %></td>
										</tr>
										<tr>
											<td>Costo Total del Proyecto $(MNX)</td>
											<td><%=p.getCostTotProy() %></td>
										</tr>
										<tr>
											<td>Costo de Planeación $(MNX)</td>
											<td><%=p.getCostPlanProy() %></td>
										</tr>
										<tr>
											<td>Costo de Especificación de Requerimientos $(MNX)</td>
											<td><%=p.getCostEsReqProy() %></td>
										</tr>
										<tr>
											<td>Costo de Análisis y Diseño $(MNX)</td>
											<td><%=p.getCostAnaDisProy() %></td>
										</tr>
										<tr>
											<td>Costo de Construcción $(MNX)</td>
											<td><%=p.getCostConstProy() %></td>
										</tr>
										<tr>
											<td>Costo de Pruebas $(MNX)</td>
											<td><%=p.getCostPrueProy() %></td>
										</tr>
										<tr>
											<td>Costo de Implementación / Despliegue $(MNX)</td>
											<td><%=p.getCostImpleDesProy() %></td>
										</tr>
										
									<tbody>
								</table>

							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-8">Tamaño funcional</div>
						<div class="col-md-2">
							<button class="btn btn-outline-info" data-toggle="collapse"
								data-target="#tamFun">Más</button>
						</div>
					</div>
					<div class="row">
						<div class="col-md-8">
							<div id="tamFun" class="collapse">
								<table class="table" style="border-width: 2px; border-style: solid; border-color: #17a2b8;">
									<tbody>
									<tr>
											<td>Método de Medición</td>
											<td><%=p.getIdmetMedicion().getMetMedicion() %></td>
										</tr>
										<tr>
											<td>Tamaño Funcional medido utilizando el estándar
                  seleccionado</td>
											<td><%=p.getTamFunProy() %></td>
										</tr>
										<tr>
											<td>Function Points Ajustados (si el método utiliado
                  lo permite)</td>
											<td><%=p.getFpAjusProy() %></td>
										</tr>
										<tr>
											<td>El medidor de software está certifiado en el
                  Método Utilizado</td>
											<td><%if(p.getCertModelo() == 1){%> Si
											<%  }else{ %>No<%} %></td>
										</tr>
										<tr>
											<td>Experiencia en años del medidor utilizando el
                  método</td>
											<td><%=p.getExpeMedMetProy() %></td>
										</tr>
									<tbody>
								</table>

							</div>
						</div>
					</div>

				</div>
			</div>

		</div>
	</div>

	<div class="container py-5">
		<section class="row">
			<div class="col-md-12">
				<h3>Procesos funcionales del proyecto</h3>
			</div>
			<div class="table-responsive">
				<table class="table ">
					<!-- 
					<thead>
							<tr>
								<th scope="col">Nombre Proyecto</th>
								<th scope="col">Año</th>
								<th scope="col">Duración</th>
							</tr>
						</thead>
					 -->
					<thead>
					</thead>
					<tbody>
						<%
							for (ProcesoFuncional inter : pfs) {
						%>
						<tr>
							<th>Nombre del Proceso Funcional:</th>
							<td><a
								href="BuscaProcesoFuncional?idprocesoFuncional=<%=inter.getIdprocesoFuncional()%>"><%=inter.getNomPF()%></a>
							</td>
							<td>
								<%if(tipoUsuario!=3 && p.getEstatus()==1){ %> <!-- 
									<input class="btn btn-outline-info" type="submit" value="Eliminar" data-dismiss="modal">
									 -->
								<div class="container">
									<!-- Trigger the modal with a button -->
									<button type="button" class="btn btn-outline-info"
										data-toggle="modal"
										data-target="#myModal-<%=inter.getIdprocesoFuncional()%>">
										Eliminar</button>
									<!-- Modal -->
									<div class="modal fade"
										id="myModal-<%=inter.getIdprocesoFuncional()%>" role="dialog">
										<div class="modal-dialog">
											<!-- Modal content-->
											<div class="modal-content">
												<div class="modal-body">
													<p>El Proceso Funcional será eliminado.</p>
												</div>
												<div class="modal-footer">
													<form action="eliminaPF" method="post">
                                                                                                            <input type="hidden" name="idProyecto" value="<%=p.getIdproyecto()%>">
														<input type="hidden" name="idPF"
															value="<%=inter.getIdprocesoFuncional()%>"> <input
															class="btn btn-outline-info" type="submit"
															value="Eliminar">
													</form>
												</div>
											</div>
										</div>
									</div>
								</div> <%} %>
							</td>
						</tr>

						<%
							}
						%>
					
					<tbody>
				</table>
			</div>
		</section>
	</div>


	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.bundle.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>
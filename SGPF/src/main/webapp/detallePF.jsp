<%@page import="unam.mx.SGPF.model.controller.FlujoAlternoJpaController"%>
<%@page
	import="unam.mx.SGPF.model.controller.SubprocesoGrupoDatoJpaController"%>
<%@page import="unam.mx.SGPF.model.controller.GrupoDatoJpaController"%>
<%@page import="unam.mx.SGPF.model.controller.SubProcesoJpaController"%>
<%@page import="unam.mx.SGPF.model.EntityProvider"%>
<%@page
	import="unam.mx.SGPF.model.controller.ProcesoFuncionalJpaController"%>
<%@page import="unam.mx.SGPF.model.FlujoAlterno"%>
<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page import="unam.mx.SGPF.model.ProcesoFuncional"%>
<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page import="unam.mx.SGPF.model.Accion"%>
<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page import="unam.mx.SGPF.model.SubProceso"%>
<%@page import="unam.mx.SGPF.model.SubprocesoGrupoDato"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252">

<title>Detalle Proceso Funcional</title>
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
            ProcesoFuncional detalle = (ProcesoFuncional) session.getAttribute("pfDetalle");
            List<SubProceso> spList = (List<SubProceso>) session.getAttribute("subProc");
            int tipoUsuario = Integer.parseInt(session.getAttribute("tipoUsuario").toString());
            int flujoAlternos = Integer.parseInt(session.getAttribute("flujoAlternos").toString());
            List<FlujoAlterno> listaFlujoAlterno = (List<FlujoAlterno>) session.getAttribute("ListaflujoAlternos");
            Proyecto p = (Proyecto) session.getAttribute("proy");
            int contador = 0;
            int contador2 = 0;
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
							<%if (p.getEstatus() == 1) {%> <a
							class="nav-link border-top-0 border-bottom-0 border-right-0"
							href="modifyPF.jsp">Modificar PF</a> <%}%>
						</li>
						<li class="nav-item active">
							<%if (p.getEstatus() == 1) { %>
							<form action="agregarActividad" method="post">
								<input type="hidden" name="idProcesoFuncional"
									value="<%=detalle.getIdprocesoFuncional()%>"> <input
									type="hidden" name="idProyecto" value="<%=p.getIdproyecto()%>">
								<!--<input
									class="nav-link border-top-0 border-bottom-0 border-right-0"
									style="color: rgba(0, 0, 0, .9); border-style: none; background-color: transparent; cursor: pointer; cursor: hand;"
									type="submit" value="Agregar Actividad" />-->
							</form> <%}%>
						</li>
						<li class="nav-item active"></li>
					</ul>

					<a class="btn btn-outline-info .btn-sm text-white"
						style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
						href="BuscaProyecto?idProyecto=<%=p.getIdproyecto()%>">Regresar</a>

				</div>
			</nav>
		</div>
	</header>
	<div class="container py-5">
		<section class="row">
			<div class="col-md-12">
				<h2>Detalle de Proceso Funcional</h2>
			</div>
			<div class="table-responsive ">
				<table class="table ">
					<tbody>
						<tr>
							<th scope ="col">Nombre del Proyecto:</th>
							<td><%=p.getNomProy()%></td>
						</tr>
						<tr>
							<th scope="col">Nombre Proceso Funcional:</th>
							<td><%=detalle.getNomPF()%></td>
						</tr>
						<tr>
							<th scope="col">Descripci�n:</th>
							<td><%=detalle.getDescripcion()%></td>
						</tr>
						<tr>
							<th scope="col">Evento desencadenante</th>
							<td><%=detalle.getEventoDes()%></td>
						</tr>
					<tbody>
				</table>
			</div>
		</section>
	</div>
	<div class="container py-5">
		<section class="row">
			<div class="col-md-12">
				<h3>Lista de Actividades</h3>
			</div>
			<div class="table-responsive">
				<table class="table ">
					<thead>
						<tr>
							<!--<th scope="col">Actividad</th>-->
							<th scope="col"># SP</th>
							<th scope="col">Descripci�n</th>
							<th scope="col">Usuario funcional</th>
							<th scope="col">Acci�n</th>
							<th scope="col">Grupo de datos</th>
							<th scope="col">Opciones</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<%for (SubProceso inter : spList) {
            	UsuarioFuncional uf = new UsuarioFuncional();
              Accion acc = new Accion();
              GrupoDato gd = new GrupoDato();
              uf = inter.getIdusuarioFuncional();
              acc = inter.getIdaccion();
              gd = inter.getIdgrupoDato();
            //Obtener todos los grupos de datos del PF:
            SubprocesoGrupoDatoJpaController spgdJpa = new SubprocesoGrupoDatoJpaController(EntityProvider.provider());
            List<SubprocesoGrupoDato> listaSPGD = spgdJpa.findByIdSP(inter); 
            GrupoDatoJpaController gdJpa = new GrupoDatoJpaController(EntityProvider.provider());
            GrupoDato grupoDato; 
            %>
						<tr>
							<%if (inter.getIndice() == 1) {%>
							
							<!--<td><%//=inter.getActividad()%></td>-->
							<td><%=inter.getIndice()%></td>
							<td><%=inter.getDescripcion()%></td>
							<td><%=uf.getNomUF()%></td>
							<td><%=acc.getNomAccion()%></td>
							<td>
								<div class="form-group">
									<select class="selectpicker form-control" data-width="fit">
										<% for(SubprocesoGrupoDato actual : listaSPGD){
                    grupoDato = gdJpa.findGrupoDato(actual.getIdGrupoDato().getIdgrupoDato());%>
										<option>
											<%=grupoDato.getNomGD()%>
										</option>
										<%}%>
									</select>
								</div>
							</td>
							<%if ( p.getEstatus() == 1) {%>
							<td>
								<div class="dropdown">
									<button
										class="btn btn-outline-info .btn-sm btn-secondary dropdown-toggle text-white"
										style="font-size: 10pt; border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50; width:100px;"
										type="button" id="dropdownMenu2" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">Agregar</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenu2">

										<form action="addSubProceso" method="POST">
											<input type="hidden" name="opcion" value="2" /> <input
												type="hidden" name="idSubProceso"
												value="<%=inter.getIdsubProceso()%>" /> <input
												class="dropdown-item btn btn-outline-info .btn-sm"
												style="font-size: 10pt;" type="submit" value="SP Despu�s" />
										</form>
										<form action="agregaFlujoAlterno" method="POST">
											<input type="hidden" name="idSubProceso"
												value="<%=inter.getIdsubProceso()%>" /> <input
												type="hidden" name="opcion" value="3" /> <input
												class="dropdown-item btn btn-outline-info"
												style="font-size: 10pt;" type="submit" value="Flujo Alterno" />
										</form>
										<form action="agregaGrupoDatos" method="POST">
											<input type="hidden" name="idSubProceso"
												value="<%=inter.getIdsubProceso()%>" /> <input
												class="dropdown-item btn btn-outline-info"
												style="font-size: 10pt;" type="submit"
												value="Grupo de Datos" />
										</form>
									</div>
								</div>
							</td>
							<td>
								<!--<div class="container">
								<form action="modActividad" method="POST">
									<input type="hidden" name="idSubProceso"
										value="<%//=inter.getIdsubProceso()%>" /> <input
										class="btn btn-outline-info .btn-sm text-white"
										style="font-size: 10pt; border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50; width:100px;"
										type="submit" value="Modificar" />
								</form>
								</div>
								-->
								<br>

								<%if (!inter.getActividad().equals("Inicio de Proceso Funcional") && inter.getIndice() == 1) {%>
								<div class="container">
									<button type="button"
										class="btn btn-outline-info .btn-sm text-white"
										style="font-size: 10pt; border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50; width:100px;"
										style="font-size: 10pt;" data-toggle="modal"
										data-target="#eliAct-<%=inter.getIdsubProceso()%>">Eliminar
										Act.</button>
									<div class="modal fade"
										id="eliAct-<%=inter.getIdsubProceso()%>" role="dialog">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-body">
													<p>La Actividad ser� eliminada junto con todos los
														subprocesos que contenga.</p>
													<p>�Desea continuar?</p>
												</div>
												<div class="modal-footer">
													<form action="eliActividad" method="POST">
														<input type="hidden" name="idSubProceso"
															value="<%=inter.getIdsubProceso()%>" /> <input
															class="btn btn-outline-info .btn-sm text-white"
															style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
															type="submit" value="Aceptar" />
														<button type="button"
															class="btn btn-outline-info .btn-sm text-white"
															style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
															data-dismiss="modal">Cancelar</button>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div> <%} %>
							</td>
							<!--  -->
							<%}%>
							<%} else {%>
							<!--<td></td>-->
							<td><%=inter.getIndice()%></td>
							<td><%=inter.getDescripcion()%></td>
							<td><%=uf.getNomUF()%></td>
							<td><%=acc.getNomAccion()%></td>
							<td>
								<div class="form-group">
									<select class="selectpicker form-control" style="width: 150px;">

										<% for(SubprocesoGrupoDato actual : listaSPGD){
                     grupoDato = gdJpa.findGrupoDato(actual.getIdGrupoDato().getIdgrupoDato());%>
										<option>
											<%=grupoDato.getNomGD()%>
										</option>
										<%}%>
									</select>
								</div>
							</td>
							<td>
								<%if (p.getEstatus() == 1) {%>
								<div class="dropdown">
									<button
										class="btn btn-outline-info .btn-sm btn-secondary dropdown-toggle text-white"
										style="font-size: 10pt; border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50; width:100px;"
										type="button" id="dropdownMenu2" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">Agregar</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenu2">

										<%if (p.getEstatus() == 1) {%>
										<form action="addSubProceso" method="POST">
											<input type="hidden" name="idSubProceso"
												value="<%=inter.getIdsubProceso()%>" /> <input
												type="hidden" name="opcion" value="1" /> <input
												class="dropdown-item btn btn-outline-info"
												style="font-size: 10pt;" type="submit" value="SP Antes" />
										</form>
										<form action="addSubProceso" method="POST">
											<input type="hidden" name="idSubProceso"
												value="<%=inter.getIdsubProceso()%>" /> <input
												type="hidden" name="opcion" value="2" /><input
												class="dropdown-item btn btn-outline-info"
												style="font-size: 10pt;" type="submit" value="SP Despu�s" />
										</form>
										<form action="agregaFlujoAlterno" method="POST">
											<input type="hidden" name="idSubProceso"
												value="<%=inter.getIdsubProceso()%>" /> <input
												type="hidden" name="opcion" value="3" /><input
												class="dropdown-item btn btn-outline-info"
												style="font-size: 10pt;" type="submit" value="Flujo Alterno" />
										</form>
										<form action="agregaGrupoDatos" method="POST">
											<input type="hidden" name="idSubProceso"
												value="<%=inter.getIdsubProceso()%>" /> <input
												type="hidden" name="opcion" value="4" /><input
												class="dropdown-item btn btn-outline-info"
												style="font-size: 10pt;" type="submit"
												value="Grupo de Datos" />
										</form>
										<%}%>

									</div>
								</div> <%}%>

								</td>

							
							<td>

								<%if ( p.getEstatus() == 1) {%>
								<div class="container">
									<button type="button"
										class="btn btn-outline-info .btn-sm text-white"
										style="font-size: 10pt; border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50; width:100px;"
										style="font-size: 10pt;" data-toggle="modal"
										data-target="#eliSP-<%=inter.getIdsubProceso()%>">Eliminar
										SP</button>
									<div class="modal fade" id="eliSP-<%=inter.getIdsubProceso()%>"
										role="dialog">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-body">
													<p>El Sub-Proceso ser� eliminado.</p>
													<p>�Desea continuar?</p>
												</div>
												<div class="modal-footer">
													<form action="eliSubproceso" method="POST">
														<input type="hidden" name="idSubProceso"
															value="<%=inter.getIdsubProceso()%>" /> <input
															class="btn btn-outline-info .btn-sm text-white"
															style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
															type="submit" value="Aceptar" />
														<button type="button"
															class="btn btn-outline-info .btn-sm text-white"
															style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
															data-dismiss="modal">Cancelar</button>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div> <%}%>
							</td>
							<%}%>
						</tr>
						<%}%>
					
					<tbody>
				</table>
			</div>
		</section>
	</div>
	<%if (flujoAlternos == 1) {%>
	<div class="container py-5">
		<section class="row">
			<div class="col-md-12">
				<h2>Flujos Alternos</h2>
			</div>
			<div class="table-responsive ">
				<table class="table ">
					<thead>
						<tr>
<!--							<th scope="col">Actividad</th>-->
							<th scope="col"># SP</th>
							<th scope="col">Descripci�n</th>
							<th scope="col">Usuario funcional</th>
							<th scope="col">Acci�n</th>
							<th scope="col">Grupo de datos</th>
							<th scope="col">Opciones</th>
						</tr>
					</thead>
					<tbody>
						<%SubProcesoJpaController spjpa = new SubProcesoJpaController(EntityProvider.provider());
              for (FlujoAlterno inter : listaFlujoAlterno) {
              	SubProceso pf = spjpa.findSubProceso(inter.getIdsubProceso().getIdsubProceso());
                UsuarioFuncional uf = inter.getIdusuarioFuncional();
                Accion acc = inter.getIdaccion();
                GrupoDato gd = inter.getIdgrupoDato();
                contador2++;
                //Obtener todos los grupos de datos del FA
                FlujoAlternoJpaController faJpa = new FlujoAlternoJpaController(EntityProvider.provider());
                List<FlujoAlterno> listaFAGD = faJpa.findByIdSubProcesoActividad(pf, pf.getActividad());
                GrupoDatoJpaController gdJpa = new GrupoDatoJpaController(EntityProvider.provider());
                GrupoDato grupoDato; 
                                                %>
						<tr>
			<!--				<td><%//=inter.getActividad()%></td>-->
							<td><%=pf.getIndice() %></td>
							<td><%=inter.getDescripcion()%></td>
							<td><%=uf.getNomUF()%></td>
							<td><%=acc.getNomAccion()%></td>
							<td>

								<div class="form-group">
									<select class="selectpicker form-control" style="width: 150px;">

										<% for(FlujoAlterno actual : listaFAGD){
                     grupoDato = gdJpa.findGrupoDato(actual.getIdgrupoDato().getIdgrupoDato());%>
										<option>
											<%=grupoDato.getNomGD()%>
										</option>
										<%}%>
									</select>
								</div>

							</td>
							<td>
							<div class="container">
							<form action="agregaGrupoDatosFlujoAlterno" method="POST">
									<input type="hidden" name="idFlujoAlterno"
										value="<%=inter.getIdflujoAlterno()%>" /> <input
										class="btn btn-outline-info .btn-sm text-white"
										style="font-size: 10pt; border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50; width:100px;"
										type="submit" value="Agregar GD" />
								</form>
							</div>
								
								<br>

								<%if ( p.getEstatus() == 1) { %>
								<div class="container">
									<button type="button"
										class="btn btn-outline-info .btn-sm text-white"
										style="font-size: 10pt; border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50; width:100px;"
										data-toggle="modal"
										data-target="#eliFA-<%=inter.getIdflujoAlterno()%>">Eliminar</button>
									<div class="modal fade"
										id="eliFA-<%=inter.getIdflujoAlterno()%>" role="dialog">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-body">
													<p>El Flujo Alterno ser� eliminado.</p>
													<p>�Desea continuar?</p>
												</div>
												<div class="modal-footer">
													<form action="eliFlujoAlterno" method="POST">
														<input type="hidden" name="idFA"
															value="<%=inter.getIdflujoAlterno()%>" /> <input
															type="hidden" name="idPF"
															value="<%=detalle.getIdprocesoFuncional()%>" /> <input
															class="btn btn-outline-info .btn-sm text-white"
															style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
															type="submit" value="Aceptar" />
														<button type="button"
															class="btn btn-outline-info .btn-sm text-white"
															style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
															data-dismiss="modal">Cancelar</button>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div> <%}%>
							</td>
						</tr>
						<% } %>
					
				</table>
			</div>
		</section>
	</div>
	<%}%>
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.bundle.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>

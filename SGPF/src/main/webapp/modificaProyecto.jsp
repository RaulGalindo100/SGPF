<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page import="unam.mx.SGPF.model.Escala"%>
<%@page import="unam.mx.SGPF.model.MarcoPosUsa"%>
<%@page import="unam.mx.SGPF.model.TamOrg"%>
<%@page import="unam.mx.SGPF.model.TipoCapDes"%>
<%@page import="unam.mx.SGPF.model.TipoOrganizacion"%>
<%@page import="unam.mx.SGPF.model.SectorOrganizacion"%>
<%@page import="unam.mx.SGPF.model.BaseDatos"%>
<%@page import="unam.mx.SGPF.model.ModCalidad"%>
<%@page import="unam.mx.SGPF.model.Lenguaje"%>
<%@page import="unam.mx.SGPF.model.TipodeDesarrollo"%>
<%@page import="unam.mx.SGPF.model.SisOpe"%>
<%@page import="unam.mx.SGPF.model.MetMedicion"%>
<%@page import="unam.mx.SGPF.model.MetDesarrollo"%>
<%@page import="unam.mx.SGPF.model.ArqProyecto"%>
<%@page import="unam.mx.SGPF.model.ConfInfo"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modifica Proyecto</title>
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
					Proyecto p = (Proyecto) session.getAttribute("proy");
	List<ConfInfo> ListaConfInfo = (List<ConfInfo>) session.getAttribute("ListaConfInfo");
    List<ArqProyecto> ListaArqProyecto = (List<ArqProyecto>) session.getAttribute("ListaArqProyecto");
    List<MetDesarrollo> ListaMetDesarrollo =(List<MetDesarrollo>) session.getAttribute("ListaMetDesarrollo");
    List<MetMedicion> ListaMetMedicon = (List<MetMedicion>) session.getAttribute("ListaMetMedicon");
    List<SisOpe> ListaSisOpe = (List<SisOpe>) session.getAttribute("ListaSisOpe");
    List<TipodeDesarrollo> ListaTipoDes = (List<TipodeDesarrollo>) session.getAttribute("ListaTipoDes");
    List<Lenguaje> ListaLenguaje = (List<Lenguaje>) session.getAttribute("ListaLenguaje");
    List<ModCalidad> ListaModCalidad = (List<ModCalidad>) session.getAttribute("ListaModCalidad");
    List<BaseDatos> ListaBaseDatos = (List<BaseDatos>) session.getAttribute("ListaBaseDatos");
    List<SectorOrganizacion> ListaSectorOrganizacion = (List<SectorOrganizacion>) session.getAttribute("ListaSectorOrganizacion");
    List<TipoOrganizacion> ListaTipoOrg = (List<TipoOrganizacion>) session.getAttribute("ListaTipoOrg");
    List<TipoCapDes> ListaTipoCapDes = (List<TipoCapDes>) session.getAttribute("ListaTipoCapDes");
    List<TamOrg> ListaTamOrg = (List<TamOrg>) session.getAttribute("ListaTamOrg");
    List<MarcoPosUsa> ListaMarcoPosUsa = (List<MarcoPosUsa>) session.getAttribute("ListaMarcoPosUsa");
    List<Escala> ListaEscala = (List<Escala>) session.getAttribute("ListaEscala");
				%>
	<header>
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
							class="btn btn-outline-info .btn-sm text-white"
							style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
							type="submit" value="Cancelar">
					</form>

				</div>
			</nav>
		</div>
	</header>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>Modificar Proyecto</h2>
			</div>
		</div>
		<!-- 
		<input class="form-control" >
		 -->
		<form action="actualizaRproyectO" method="POST">
			<div class="row">
				<div class="col-md-1">
					<input type="hidden" name="idProyecto"
						value="<%=p.getIdproyecto()%>" required>
				</div>
				<div class="col-md-10 text-right">
					<input class="btn btn-outline-info .btn-sm text-white"
						style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
						type="submit" value="Guardar" />
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row">
				<div class="col-md-1"></div>



				<div class="col-md-10">

					<div class="container">
						<ul class="nav nav-tabs">
							<li class="active"><a class="btn btn-outline-info"
								style="font-size: 12pt; border-style: none;" data-toggle="tab"
								href="#home">Información de proyecto</a></li>
							<li><a class="btn btn-outline-info"
								style="font-size: 12pt; border-style: none;" data-toggle="tab"
								href="#menu1">Contexto de desarrollo</a></li>
							<li><a class="btn btn-outline-info"
								style="font-size: 12pt; border-style: none;" data-toggle="tab"
								href="#menu2">Información de recursos</a></li>
							<li><a class="btn btn-outline-info"
								style="font-size: 12pt; border-style: none;" data-toggle="tab"
								href="#menu3">Tamaño Funcional</a></li>

						</ul>

						<div class="tab-content">
							<div id="home" class="tab-pane active">
								<div class="form-group text-right" style="color: red;">Continua con la pestaña de: Contexto de desarrollo</div>
								<h3>Información del Proyecto</h3>
								<div class="form-group">
									<label>Nombre del Proyecto</label> <input type="hidden"
										name="idProy" value="<%=p.getIdproyecto()%>"> <input
										class="form-control" type="text" name="nombreProyecto"
										value="<%=p.getNomProy()%>" required>
								</div>

								<div class="form-group">
									<label>Año de realización del proyecto</label> <select
										class="form-control" style="width: 80px" name="anio">
										<option value="2015" <%if(p.getAnioProy().equals("2015")){%>
											selected <%  } %>>2015</option>
										<option value="2016" <%if(p.getAnioProy().equals("2016")){%>
											selected <%  } %>>2016</option>
										<option value="2017" <%if(p.getAnioProy().equals("2017")){%>
											selected <%  } %>>2017</option>
										<option value="2018" <%if(p.getAnioProy().equals("2018")){%>
											selected <%  } %>>2018</option>
										<option value="2019" <%if(p.getAnioProy().equals("2019")){%>
											selected <%  } %>>2019</option>
										<option value="2020" <%if(p.getAnioProy().equals("2020")){%>
											selected <%  } %>>2020</option>
									</select> <label>¿Se puso en operación?</label> <select
										class="form-control" style="width: 80px" name="operProy">
										<option value="1" <%if(p.getOperProy() == 1){%> selected
											<%  } %>>Si</option>
										<option value="0" <%if(p.getOperProy() == 0){%> selected
											<%  } %>>No</option>
									</select>
								</div>
								<div class="form-group">
									<label>Tipo Desarrollo</label> <select class="form-control"
										name="IdTipodeDesarrollo">
										<%for(TipodeDesarrollo i : ListaTipoDes){%>
										<option value="<%=i.getIdTipodeDesarrollo()%>"
											<%if(p.getIdTipoDesarrollo().getIdTipodeDesarrollo() == i.getIdTipodeDesarrollo()){%>
											selected <%  } %>>
											<%=i.getTipodeDesarrollo()%>
										</option>
										<%   }    %>
									</select>
								</div>
								<div class="form-group">
									<label>Ámbito de la Organización Usuaria</label> <select
										class="form-control" name="IdsectorOrganizacion">
										<%for(SectorOrganizacion iter : ListaSectorOrganizacion){%>
										<option value="<%=iter.getIdsectorOrganizacion()%>"
											<%if(p.getIdsectorOrganizacion().getIdsectorOrganizacion()== iter.getIdsectorOrganizacion()){%>
											selected <%  } %>>
											<%=iter.getSectorOrganizacion()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Sector de la Organización Usuaria</label> <select
										class="form-control" name="IdtipoOrganizacion">
										<%for(TipoOrganizacion i : ListaTipoOrg){%>
										<option value="<%=i.getIdtipoOrganizacion() %>"
											<%if(p.getIdtipoOrganizacion().getIdtipoOrganizacion()== i.getIdtipoOrganizacion()){%>
											selected <%  } %>>
											<%=i.getTipoOrganizacion() %>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Tipo de Capacidad de Desarrollo usada</label> <select
										class="form-control" name="IdtipoCapDes">
										<%for(TipoCapDes i : ListaTipoCapDes){%>
										<option value="<%=i.getIdtipoCapDes()%>"
											<%if(p.getIdtipoCapDes().getIdtipoCapDes()== i.getIdtipoCapDes()){%>
											selected <%  } %>>
											<%=i.getTipoCapDes()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Tamaño de la Organización que desarrolló el
										software</label> <select class="form-control" name="IdtamOrgDes">
										<%for(TamOrg i : ListaTamOrg){%>
										<option value="<%=i.getIdtamOrgDes()%>"
											<%if(p.getIdtamOrgDes().getIdtamOrgDes()== i.getIdtamOrgDes()){%>
											selected <%  } %>>
											<%=i.getTamOrgDes()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Tamaño de la Organización que usaria el software</label>
									<select class="form-control" name="tamOrgUsa">
										<%for(TamOrg i : ListaTamOrg){%>
										<option value="<%=i.getIdtamOrgDes()%>"
											<%if(p.getTamOrgUsa().getIdtamOrgDes() == i.getIdtamOrgDes() ){%>
											selected <%  } %>>
											<%=i.getTamOrgDes()%>
										</option>
										<%}%>

									</select>
								</div>
								<div class="form-group text-right" style="color:red;">Continua con la pestaña
									de: Contexto de desarrollo</div>
							</div>
							<!-- del id home -->
							<div id="menu1" class="tab-pane fade">
								<div class="form-group text-right" style="color: red;">Continua con la pestaña de: Información de recursos</div>
								<h3>Contexto de Desarrollo</h3>
								<div class="form-group">
									<label>Arquitectura de Proyecto</label> <select
										class="form-control" name="idarqProyecto">
										<%for(ArqProyecto i : ListaArqProyecto){%>
										<option value="<%=i.getIdarqProyecto()%>"
											<%if(p.getIdarqProyecto().getIdarqProyecto()== i.getIdarqProyecto()){%>
											selected <%  } %>>
											<%=i.getArqProyecto()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Lenguaje Principal de Programación</label> <select
										class="form-control" name="Idlenguaje">
										<%for(Lenguaje i : ListaLenguaje){%>
										<option value="<%=i.getIdlenguaje()%>"
											<%if(p.getIdlenguaje().getIdlenguaje()== i.getIdlenguaje()){%>
											selected <%  } %>>
											<%=i.getLenguaje()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Sistema Operativo Principal</label> <select
										class="form-control" name="idsisOpe">
										<%for(SisOpe i : ListaSisOpe){%>
										<option value="<%=i.getIdsisOpe()%>"
											<%if(p.getIdsisOpe().getIdsisOpe()== i.getIdsisOpe()){%>
											selected <%  } %>>
											<%=i.getSisOpe()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Base de Datos</label> <select class="form-control"
										name="IdbaseDatos">
										<%for(BaseDatos i : ListaBaseDatos){%>
										<option value="<%=i.getIdbaseDatos()%>"
											<%if(p.getIdbaseDatos().getIdbaseDatos()== i.getIdbaseDatos()){%>
											selected <%  } %>>
											<%=i.getBaseDatos()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>¿Se utilizó una herramienta CASE?</label> <select
										class="form-control" style="width: 80px" name="usoCase">
										<option value="1" <%if(p.getOperProy() == 1){%> selected
											<%  } %>>Si</option>
										<option value="0" <%if(p.getOperProy() == 0){%> selected
											<%  } %>>No</option>
									</select>
								</div>
								<div class="form-group">
									<label>Ciclo de Vida Utilizado</label> <select
										class="form-control" name="IdmetDesarrollo">
										<%for(MetDesarrollo i : ListaMetDesarrollo){%>
										<option value="<%=i.getIdmetDesarrollo()%>"
											<%if(p.getIdmetDesarrollo().getIdmetDesarrollo()== i.getIdmetDesarrollo()){%>
											selected <%  } %>>
											<%=i.getMetDesarrollo()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Marco de Procesos Utilizado</label> <select
										class="form-control" name="IdmarcoPosUsao">
										<%for(MarcoPosUsa i : ListaMarcoPosUsa){%>
										<option value="<%=i.getIdmarcoPosUsa()%>"
											<%if(p.getIdmarcoPosUsa().getIdmarcoPosUsa()== i.getIdmarcoPosUsa()){%>
											selected <%  } %>>
											<%=i.getMarcoPosUsa()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Modelo de Calidad Utilizado</label> <select
										class="form-control" name="IdmodCalidad">
										<%for(ModCalidad i : ListaModCalidad){%>
										<option value="<%=i.getIdmodCalidad()%>"
											<%if(p.getIdmodCalidad().getIdmodCalidad()== i.getIdmodCalidad()){%>
											selected <%  } %>>
											<%=i.getModCalidad()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>¿Tiene Certificación en el Modelo de Calidad?</label> <select
										class="form-control" style="width: 80px"
										name="medidorCertProy">
										<option value="1" <%if(p.getMedidorCertProy() == 1){%>
											selected <%  } %>>Si</option>
										<option value="0" <%if(p.getMedidorCertProy() == 0){%>
											selected <%  } %>>No</option>
									</select>
								</div>
								<div class="form-group">
									<label>Comentar la certificación</label> <input
										class="form-control" type="text" name="comCertModelo"
										value="<%=p.getComCertModelo()%>" required>
								</div>
								<div class="form-group">
									<label>Contabilidad de la información</label> <select
										class="form-control" name="IdconfInfo">
										<%for(ConfInfo i : ListaConfInfo){%>
										<option value="<%=i.getIdconfInfo() %>"
											<%if(p.getIdconfInfo().getIdconfInfo()== i.getIdconfInfo()){%>
											selected <%  } %>>
											<%=i.getConfInfo() %>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group text-right" style="color:red;">Continua con la pestaña
									de: Información de recursos</div>
							</div>
							<!-- del menu1 -->
							<div id="menu2" class="tab-pane fade">
							<div class="form-group text-right" style="color: red;">Continua con la pestaña de: Tamaño Funcional</div>
								<h3>Información de Recursos</h3>
								<div class="form-group ">
									<label>Duración del Proyecto</label>
									<div class="form-inline">
										<input class="form-control" type="text" name="duraProy"
											value="<%=p.getDuraProy()%>" >

										<!-- <label>Escala</label> -->
										<select class="form-control" name="Idescala">
											<%for(Escala i : ListaEscala){%>
											<option value="<%=i.getIdescala() %>"
												<%if(p.getIdescala().getIdescala()== i.getIdescala()){%>
												selected <%  } %>>
												<%=i.getEscala() %>
											</option>
											<%}%>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label>Esfuerzo Total del Proyecto [hh]</label> <input
										class="form-control" type="text" name="esfuTotProy"
										value="<%=p.getEsfuTotProy()%>" >
								</div>
								<div class="form-group">
									<label>Esfuerzo de Planeación [hh]</label> <input
										class="form-control" type="text" name="esfuPlaneProy"
										value="<%=p.getEsfuPlaneProy()%>" >
								</div>
								<div class="form-group">
									<label>Esfuerzo de Especificación de Requerimientos
										[hh]</label> <input class="form-control" type="text"
										name="esfuEsReqProy" value="<%=p.getEsfuEsReqProy() %>"
										>
								</div>
								<div class="form-group">
									<label>Esfuerzo de Análisis y Diseño [hh]</label> <input
										class="form-control" type="text" name="esfuAnaDisProy"
										value="<%=p.getEsfuAnaDisProy() %>" >
								</div>
								<div class="form-group">
									<label>Esfuerzo de Construcción [hh]</label> <input
										class="form-control" type="text" name="esfuConstProy"
										value="<%=p.getEsfuConstProy()%>" >
								</div>
								<div class="form-group">
									<label>Esfuerzo de Pruebas [hh]</label> <input
										class="form-control" type="text" name="esfuPrueProy"
										value="<%=p.getEsfuPrueProy() %>" >
								</div>
								<div class="form-group">
									<label>Esfuerzo de Implementación / Despliegue [hh]</label> <input
										class="form-control" type="text" name="esfuImpleDesProy"
										value="<%=p.getEsfuImpleDesProy() %>" >
								</div>
								<div class="form-group">
									<label>Costo Total del Proyecto $(MNX)</label> <input
										class="form-control" type="text" name="costTotProy"
										value="<%=p.getCostTotProy()  %>" >
								</div>

								<div class="form-group">
									<label>Costo de Planeación $(MNX)</label> <input
										class="form-control" type="text" name="costPlanProy"
										value="<%=p.getCostPlanProy()%>" >
								</div>
								<div class="form-group">
									<label>Costo de Especificación de Requerimientos $(MNX)</label>
									<input class="form-control" type="text" name="costEsReqProy"
										value="<%=p.getCostEsReqProy() %>" >
								</div>
								<div class="form-group">
									<label>Costo de Análisis y Diseño $(MNX)</label> <input
										class="form-control" type="text" name="costAnaDisProy"
										value="<%=p.getCostAnaDisProy() %>" >
								</div>
								<div class="form-group">
									<label>Costo de Construcción $(MNX)</label> <input
										class="form-control" type="text" name="costConstProy"
										value="<%=p.getCostConstProy() %>" >
								</div>
								<div class="form-group">
									<label>Costo de Pruebas $(MNX)</label> <input
										class="form-control" type="text" name="costPrueProy"
										value="<%=p.getCostPrueProy()  %>" >
								</div>
								<div class="form-group">
									<label>Costo de Implementación / Despliegue $(MNX)</label> <input
										class="form-control" type="text" name="costImpleDesProy"
										value="<%=p.getCostImpleDesProy() %>" >
								</div>
								<h3>Estimación</h3>
								<div class="form-group">
									<label>Costo de estimación</label> <input class="form-control"
										type="text" name="estimacionCosto"
										value="<%=p.getEstimacionCosto()%>">
								</div>
								<div class="form-group">
									<label>Esfuerzo estimado</label> <input class="form-control"
										type="text" name="estimacionEsfuerzo"
										value="<%=p.getEstimacionEsfuerzo()%>">
								</div>
								<div class="form-group ">
									<label>Duración estimada</label>
									<div class="form-inline">
										<input class="form-control" type="text"
											name="estimacionDuracion"
											value="<%=p.getEstimacionDuracion()%>"> <select
											class="form-control" name="idescalaEstimacionDuracion">
											<%for(Escala i : ListaEscala){%>
											<option value="<%=i.getIdescala() %>"
												<%if(p.getIdescalaEstimacionDuracion().getIdescala()== i.getIdescala()){%>
												selected <%  } %>>
												<%=i.getEscala() %>
											</option>
											<%}%>
										</select>
									</div>
								</div>
								<div class="form-group text-right" style="color:red;">Continua con la pestaña
									de: Tamaño Funcional</div>
							</div>
							<!-- del menu 2 -->
							<div id="menu3" class="tab-pane fade">
								<h3>Tamaño Funcional</h3>
								<div class="form-group">
									<label>Propósito de la medición</label> <input
										class="form-control" type="text" name="proposito"
										value="<%=p.getProposito()%>" >
								</div>
								<div class="form-group">
									<label>Alcance de la medición</label> <input
										class="form-control" type="text" name="alcance"
										value="<%=p.getAlcance()%>" >
								</div>
								<div class="form-group">
									<label>Método de Medición</label> <label></label> <select
										class="form-control" name="IdmetMedicion">
										<%for(MetMedicion i : ListaMetMedicon){%>
										<option value="<%=i.getIdmetMedicion() %>"
											<%if(p.getIdmetMedicion().getIdmetMedicion()== i.getIdmetMedicion()){%>
											selected <%  } %>>
											<%=i.getMetMedicion() %>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Tamaño Funcional medido utilizando el estándar
										seleccionado</label> <input class="form-control" type="text"
										name="tamFunProy" value="<%=p.getTamFunProy()%>" >
								</div>
								<div class="form-group">
									<label>Function Points Ajustados (si el método utiliado
										lo permite)</label> <input class="form-control" type="text"
										name="fpAjusProy" value="<%=p.getFpAjusProy() %>" >
								</div>
								<div class="form-group">
									<label>El medidor de software está certifiado en el
										Método Utilizado</label> <select class="form-control"
										style="width: 80px" name="certModelo">
										<option value="1" <%if(p.getCertModelo() == 1){%> selected
											<%  } %>>Si</option>
										<option value="0" <%if(p.getCertModelo() == 0){%> selected
											<%  } %>>No</option>
									</select>

								</div>
								<div class="form-group">
									<label>Experiencia en años del medidor utilizando el
										método</label> <input class="form-control" type="text"
										name="expeMedMetProy" value="<%=p.getExpeMedMetProy() %>"
										>
								</div>


							</div>
							<!-- del menu 3 -->


						</div>
						<!-- tab-container -->
					</div>
					<!-- del container -->

				</div>
				<div class="col-md-1"></div>
			</div>
		</form>
	</div>





	<script src="js/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>

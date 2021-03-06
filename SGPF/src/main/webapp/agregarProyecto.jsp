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
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252">
<title>Agregar Nuevo Proyecto</title>
<% List<ConfInfo> ListaConfInfo = (List<ConfInfo>) session.getAttribute("ListaConfInfo");
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

					</ul>
					<a href="proyectos.jsp"> <input class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
						type="submit" value="Cancelar">
					</a>
				</div>
			</nav>
		</div>
	</header>


	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>Agregar Proyecto</h2>
			</div>
		</div>
		<!-- 
		<input class="form-control" >
		 -->
		<form action="AgregarProyecto" method="POST">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10 text-right">
					<input class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;" type="submit" value="Guardar" />
				</div>
				<div class="col-md-1"></div>



			</div>
			<div class="row">

				<div class="col-md-1"></div>
				<div class="col-md-10">

					<div class="container"
						>
						<ul class="nav nav-tabs">
							<li class="active"><a class="btn btn-outline-info" 
								style="font-size: 12pt; border-style: none; font-color: #2c3e50;" data-toggle="tab"
								href="#home">Informaci�n de proyecto</a></li>
							<li><a class="btn btn-outline-info"
								style="font-size: 12pt; border-style: none;" data-toggle="tab"
								href="#menu1">Contexto de desarrollo</a></li>
							<li><a class="btn btn-outline-info"
								style="font-size: 12pt; border-style: none;" data-toggle="tab"
								href="#menu2">Informaci�n de recursos</a></li>
							<li><a class="btn btn-outline-info"
								style="font-size: 12pt; border-style: none;" data-toggle="tab"
								href="#menu3">Tama�o Funcional</a></li>

						</ul>

						<div class="tab-content">
							<div id="home" class="tab-pane active">
								<div class="form-group text-right" style="color: red;  text-align: right;">Continua con la pesta�a de: Contexto de desarrollo</div>
								<h3>Informaci�n del Proyecto</h3>
								<div class="form-group">
									<label>Nombre del Proyecto</label> <input class="form-control"
										type="text" name="nombreProyecto" required>
								</div>
								
								<div class="form-group">
									<label>A�o de realizaci�n del proyecto</label> <select class="form-control"
										style="width: 80px" name="anio">
										<option value="2015">2015</option>
										<option value="2016">2016</option>
										<option value="2017">2017</option>
										<option value="2018">2018</option>
										<option value="2019">2019</option>
										<option value="2020">2020</option>
									</select> <label>�Se puso en operaci�n?</label> <select
										class="form-control" style="width: 80px" name="operProy">
										<option value="1">Si</option>
										<option value="0">No</option>
									</select>
								</div>
								<div class="form-group">
									<label>Tipo Desarrollo</label> <select class="form-control"
										name="IdTipodeDesarrollo">
										<%for(TipodeDesarrollo i : ListaTipoDes){%>
										<option value="<%=i.getIdTipodeDesarrollo()%>">
											<%=i.getTipodeDesarrollo()%>
										</option>
										<%   }    %>
									</select>
								</div>
								<div class="form-group">
									<label>�mbito de la Organizaci�n Usuaria</label> <select
										class="form-control" name="IdsectorOrganizacion">
										<%for(SectorOrganizacion iter : ListaSectorOrganizacion){%>
										<option value="<%=iter.getIdsectorOrganizacion()%>">
											<%=iter.getSectorOrganizacion()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Sector de la Organizaci�n Usuaria</label> <select
										class="form-control" name="IdtipoOrganizacion">
										<%for(TipoOrganizacion i : ListaTipoOrg){%>
										<option value="<%=i.getIdtipoOrganizacion() %>">
											<%=i.getTipoOrganizacion() %>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Tipo de Capacidad de Desarrollo usada</label> <select
										class="form-control" name="IdtipoCapDes">
										<%for(TipoCapDes i : ListaTipoCapDes){%>
										<option value="<%=i.getIdtipoCapDes()%>">
											<%=i.getTipoCapDes()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Tama�o de la Organizaci�n que desarroll� el
										software</label> <select class="form-control" 
										name="IdtamOrgDes">
										<%for(TamOrg i : ListaTamOrg){%>
										<option value="<%=i.getIdtamOrgDes()%>">
											<%=i.getTamOrgDes()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Tama�o de la Organizaci�n que usaria el software</label>
									<select class="form-control" 
										name="tamOrgUsa">
										<%for(TamOrg i : ListaTamOrg){%>
										<option value="<%=i.getIdtamOrgDes()%>">
											<%=i.getTamOrgDes()%>
										</option>
										<%}%>

									</select>
								</div>
								<div class="form-group text-right" style="color: red;">Continua con la pesta�a de: Contexto de desarrollo</div>
							</div>
							<div id="menu1" class="tab-pane fade">
							<div class="form-group text-right" style="color: red; text-align: right;">Continua con la pesta�a de: Informaci�n de recursos</div>
								<h3>Contexto de Desarrollo</h3>
								<div class="form-group">
									<label>Arquitectura de Proyecto</label> <select
										class="form-control"  name="idarqProyecto">
										<%for(ArqProyecto i : ListaArqProyecto){%>
										<option value="<%=i.getIdarqProyecto()%>">
											<%=i.getArqProyecto()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Lenguaje Principal de Programaci�n</label> <select
										class="form-control"  name="Idlenguaje">
										<%for(Lenguaje i : ListaLenguaje){%>
										<option value="<%=i.getIdlenguaje()%>">
											<%=i.getLenguaje()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Sistema Operativo Principal</label> <select
										class="form-control"  name="idsisOpe">
										<%for(SisOpe i : ListaSisOpe){%>
										<option value="<%=i.getIdsisOpe()%>">
											<%=i.getSisOpe()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Base de Datos</label> <select class="form-control"
										 name="IdbaseDatos">
										<%for(BaseDatos i : ListaBaseDatos){%>
										<option value="<%=i.getIdbaseDatos()%>">
											<%=i.getBaseDatos()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>�Se utiliz� una herramienta CASE?</label> <select
										class="form-control" style="width: 80px" name="usoCase">
										<option value="1">Si</option>
										<option value="0">No</option>
									</select>
								</div>
								<div class="form-group">
									<label>Ciclo de Vida Utilizado</label> <select
										class="form-control" 
										name="IdmetDesarrollo">
										<%for(MetDesarrollo i : ListaMetDesarrollo){%>
										<option value="<%=i.getIdmetDesarrollo()%>">
											<%=i.getMetDesarrollo()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Marco de Procesos Utilizado</label> <select
										class="form-control" 
										name="IdmarcoPosUsao">
										<%for(MarcoPosUsa i : ListaMarcoPosUsa){%>
										<option value="<%=i.getIdmarcoPosUsa()%>">
											<%=i.getMarcoPosUsa()%>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group">
									<label>Modelo de Calidad Utilizado</label> <select
										class="form-control" name="IdmodCalidad">
										<%for(ModCalidad i : ListaModCalidad){%>
										<option value="<%=i.getIdmodCalidad()%>">
											<%=i.getModCalidad()%>
										</option>
										<%}%>
									</select>

								</div>
								<div class="form-group">
									<label>�Tiene Certificaci�n en el Modelo de Calidad?</label> <select
										class="form-control" style="width: 80px"
										name="medidorCertProy">
										<option value="1">Si</option>
										<option value="0">No</option>
									</select>
								</div>
								<div class="form-group">
									<label>Comentar la certificaci�n</label> <input
										class="form-control" type="text" name="comCertModelo" required>
								</div>
								<div class="form-group">
									<label>Confiabilidad de la informaci�n</label> <select class="form-control" name="IdconfInfo">
										<%for(ConfInfo i : ListaConfInfo){%>
										<option value="<%=i.getIdconfInfo() %>">
											<%=i.getConfInfo() %>
										</option>
										<%}%>
									</select>
								</div>
								<div class="form-group text-right" style="color: red;">Continua con la pesta�a de: Informaci�n de recursos</div>
							</div>
							<div id="menu2" class="tab-pane fade">
								<div class="form-group text-right" style="color: red; text-align: right;">Continua con la pesta�a de: Tama�o Funcional</div>
								<h3>Informaci�n de Recursos</h3>
								<div class="form-group">
									<label>Duraci�n del Proyecto</label> 
									<div class="form-inline">
									<input
										class="form-control" type="text" name="duraProy">
								<select class="form-control"
										name="Idescala">
										<%for(Escala i : ListaEscala){%>
										<option value="<%=i.getIdescala() %>">
											<%=i.getEscala() %>
										</option>
										<%}%>
									</select>
									</div>
								</div>
								<div class="form-group">
									<label>Esfuerzo Total del Proyecto [hh]</label> <input
										class="form-control" type="text" name="esfuTotProy" >
										<div class="form-group text-right" style="color: red; font-size:small;">Este campo debe coincidir con la suma de los esfuezos individuales.</div>
								</div>

								<div class="form-group">
									<label>Esfuerzo de Planeaci�n [hh]</label> <input
										class="form-control" type="text" name="esfuPlaneProy" >
								</div>
								<div class="form-group">
									<label>Esfuerzo de Especificaci�n de Requerimientos
										[hh]</label> <input class="form-control" type="text"
										name="esfuEsReqProy" >
								</div>
								<div class="form-group">
									<label>Esfuerzo de An�lisis y Dise�o [hh]</label> <input
										class="form-control" type="text" name="esfuAnaDisProy"
										>
								</div>
								<div class="form-group">
									<label>Esfuerzo de Construcci�n [hh]</label> <input
										class="form-control" type="text" name="esfuConstProy" >
								</div>
								<div class="form-group">
									<label>Esfuerzo de Pruebas [hh]</label> <input
										class="form-control" type="text" name="esfuPrueProy" >
								</div>
								<div class="form-group">
									<label>Esfuerzo de Implementaci�n / Despliegue [hh]</label> <input
										class="form-control" type="text" name="esfuImpleDesProy"
										>
								</div>
								<div class="form-group">
									<label>Costo Total del Proyecto $(MNX)</label> <input
										class="form-control" type="text" name="costTotProy" >
									<div class="form-group text-right" style="color: red; font-size:small;">Este campo debe coincidir con la suma de los costos individuales.</div>
										
								</div>

								<div class="form-group">
									<label>Costo de Planeaci�n $(MNX)</label> <input
										class="form-control" type="text" name="costPlanProy" >
								</div>
								<div class="form-group">
									<label>Costo de Especificaci�n de Requerimientos $(MNX)</label>
									<input class="form-control" type="text" name="costEsReqProy"
										>
								</div>
								<div class="form-group">
									<label>Costo de An�lisis y Dise�o $(MNX)</label> <input
										class="form-control" type="text" name="costAnaDisProy"
										>
								</div>
								<div class="form-group">
									<label>Costo de Construcci�n $(MNX)</label> <input
										class="form-control" type="text" name="costConstProy" >
								</div>
								<div class="form-group">
									<label>Costo de Pruebas $(MNX)</label> <input
										class="form-control" type="text" name="costPrueProy" >
								</div>
								<div class="form-group">
									<label>Costo de Implementaci�n / Despliegue $(MNX)</label> <input
										class="form-control" type="text" name="costImpleDesProy"
										>
								</div>
								<h3>Estimaci�n</h3>
								<div class="form-group">
									<label>Costo de estimaci�n</label> <input class="form-control" type="text" name="estimacionCosto" >
								</div>
								<div class="form-group">
									<label>Esfuerzo estimado</label> <input class="form-control" type="text" name="estimacionEsfuerzo" >
								</div>
								<div class="form-group">
									<label>Duraci�n estimada</label> 
									<div class="form-inline">
									<input class="form-control" type="text" name="estimacionDuracion" >
									<select class="form-control"
										name="idescalaEstimacionDuracion">
										<%for(Escala i : ListaEscala){%>
										<option value="<%=i.getIdescala() %>">
											<%=i.getEscala() %>
										</option>
										<%}%>
									</select>
									</div>
									
								</div>
								<div class="form-group text-right" style="color: red;">Continua con la pesta�a de: Tama�o Funcional</div>
							</div>
							<div id="menu3" class="tab-pane fade">
								<h3>Tama�o Funcional</h3>
								<div class="form-group">
									<label>Prop�sito</label> <input class="form-control"
										type="text" name="proposito" >
								</div>
								<div class="form-group">
									<label>Alcance</label> <input class="form-control" type="text"
										name="alcance" >
								</div>
								<div class="form-group">
									<label>M�todo de Medici�n</label>
									<label></label> <select class="form-control"
										name="IdmetMedicion">
										<%for(MetMedicion i : ListaMetMedicon){%>
										<option value="<%=i.getIdmetMedicion() %>">
											<%=i.getMetMedicion() %>
										</option>
										<%}%>
									</select>

								</div>
								<div class="form-group">
									<label>Tama�o Funcional medido utilizando el est�ndar
										seleccionado</label> <input class="form-control" type="text"
										name="tamFunProy" >
								</div>
								<div class="form-group">
									<label>Function Points Ajustados (si el m�todo utiliado
										lo permite)</label> <input class="form-control" type="text"
										name="fpAjusProy" >
								</div>
								<div class="form-group">
									<label>El medidor de software est� certifiado en el
										M�todo Utilizado</label> <select class="form-control" style="width: 80px"
										name="certModelo">
										<option value="1">Si</option>
										<option value="0">No</option>
									</select>

								</div>
								<div class="form-group">
									<label>Experiencia en a�os del medidor utilizando el
										m�todo</label> <input class="form-control" type="text"
										name="expeMedMetProy" >
								</div>
								
							</div>
						</div>
					</div>


					<div class="col-md-1"></div>
				</div>
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

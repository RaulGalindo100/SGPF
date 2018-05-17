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
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet"	href="https://fonts.googleapis.com/css?family=Inconsolata">
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
					<a href="proyectos.jsp"> <input class="btn btn-info"
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
		<div class="row">
			<div class="col-md-8">
				<form action="AgregarProyecto" method="POST">
					<div class="form-group">
						<label>Nombre del Proyecto</label>
						<input class="form-control" type="text" name="nombreProyecto" required>
					</div>
					<input class="btn btn-outline-info" type="submit" value="Guardar">
				</form>
			</div>
		</div>
	</div>

        <h1>Agregar Nuevo Proyecto</h1>
        <div>
            <table><form action="AgregarProyecto" method="POST">
                <tr><td><H3>Información del Proyecto</H3></td></tr>
            <tr>
                <td>Nombre:</td>
                <td> <input type="text" name="nombreProyecto" required></td>
                <td>Propósito:</td>
                <td> <input type="text" name="proposito" required></td>
                <td>Alcance:</td>
                <td> <input type="text" name="alcance" required></td>
                <td>Año:</td>
                <td><select name="anio">
                        <option value="2015">2015</option>
                        <option value="2016">2016</option>
                        <option value="2017">2017</option>
                        <option value="2018">2018</option>
                        <option value="2019">2019</option>
                        <option value="2020">2020</option>
                    </select>
                </td>
                <td>¿Se puso en operación?:</td>
                <td>
                    <select name="operProy">
                        <option value="1">Si</option>
                        <option value="0">No</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Tipo de Desarrollo:</td>
                <td>
                    <select name="IdTipodeDesarrollo">
                        <%for(TipodeDesarrollo i : ListaTipoDes){%>
                        <option value="<%=i.getIdTipodeDesarrollo()%>">
                            <%=i.getTipodeDesarrollo()%>
                        </option>
                        <%   }    %>
                    </select>
                </td>
                <td>Sector de la Organización Usuaria:</td>
                <td>
                    <select name="IdsectorOrganizacion">
                        <%for(SectorOrganizacion iter : ListaSectorOrganizacion){%>
                        <option value="<%=iter.getIdsectorOrganizacion()%>">
                            <%=iter.getSectorOrganizacion()%>
                        </option>
                        <%}%>
                    </select>
                </td>
                <td>Tipo Organización Usuaria:</td>
                <td>
                    <select name="IdtipoOrganizacion">
                        <%for(TipoOrganizacion i : ListaTipoOrg){%>
                        <option value="<%=i.getIdtipoOrganizacion() %>">
                            <%=i.getTipoOrganizacion() %>
                        </option>
                        <%}%>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Tipo de Capacidad de Desarrollo usada:</td>
                <td>
                    <select name="IdtipoCapDes">
                        <%for(TipoCapDes i : ListaTipoCapDes){%>
                        <option value="<%=i.getIdtipoCapDes()%>">
                            <%=i.getTipoCapDes()%>
                        </option>
                        <%}%>

                    </select>
                </td>
                <td>Tamaño de la Organización que desarrolló el software:</td>
                <td>
                    <select name="IdtamOrgDes">
                        <%for(TamOrg i : ListaTamOrg){%>
                        <option value="<%=i.getIdtamOrgDes()%>">
                            <%=i.getTamOrgDes()%>
                        </option>
                        <%}%>
                    </select>
                </td>
                <td>Tamaño de la Organización que usaria el software:</td>
                <td>
                    <select name="tamOrgUsa">
                        <%for(TamOrg i : ListaTamOrg){%>
                        <option value="<%=i.getIdtamOrgDes()%>">
                            <%=i.getTamOrgDes()%>
                        </option>
                        <%}%>
                        
                    </select>
                </td>
            </tr>
                <tr><td><H3>Contexto de Desarrollo</H3></td></tr>
            <tr>
                <td>Arquitectura de Proyecto:</td>
                <td>
                    <select name="idarqProyecto">
                        <%for(ArqProyecto i : ListaArqProyecto){%>
                        <option value="<%=i.getIdarqProyecto()%>">
                            <%=i.getArqProyecto()%>
                        </option>
                        <%}%>
                    </select>
                </td>
                <td>Lenguaje Principal de Programación:</td>
                <td>
                    <select name="Idlenguaje">
                        <%for(Lenguaje i : ListaLenguaje){%>
                        <option value="<%=i.getIdlenguaje()%>">
                            <%=i.getLenguaje()%>
                        </option>
                        <%}%>
                    </select>
                </td>
                <td>Sistema Operativo Principal:</td>
                <td>
                    <select name="idsisOpe">
                        <%for(SisOpe i : ListaSisOpe){%>
                        <option value="<%=i.getIdsisOpe()%>">
                            <%=i.getSisOpe()%>
                        </option>
                        <%}%>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Base de Datos:</td>
                <td>
                    <select name="IdbaseDatos">
                        <%for(BaseDatos i : ListaBaseDatos){%>
                        <option value="<%=i.getIdbaseDatos()%>">
                            <%=i.getBaseDatos()%>
                        </option>
                        <%}%>
                    </select>
                </td>
                <td>¿Se utilizó una herramienta CASE?:</td>
                <td>
                    <select name="usoCase">
                        <option value="1">Si</option>
                        <option value="0">No</option>
                    </select>
                </td>
                <td>Ciclo de Vida Utilizado:</td>
                <td>
                    <select name="IdmetDesarrollo">
                        <%for(MetDesarrollo i : ListaMetDesarrollo){%>
                        <option value="<%=i.getIdmetDesarrollo()%>">
                            <%=i.getMetDesarrollo()%>
                        </option>
                        <%}%>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Marco de Procesos Utilizado:</td>
                <td>
                    <select name="IdmarcoPosUsao">
                        <%for(MarcoPosUsa i : ListaMarcoPosUsa){%>
                        <option value="<%=i.getIdmarcoPosUsa()%>">
                            <%=i.getMarcoPosUsa()%>
                        </option>
                        <%}%>
                    </select>
                </td>
                <td>Modelo de Calidad Utilizado:</td>
                <td>
                    <select name="IdmodCalidad">
                        <%for(ModCalidad i : ListaModCalidad){%>
                        <option value="<%=i.getIdmodCalidad()%>">
                            <%=i.getModCalidad()%>
                        </option>
                        <%}%>
                    </select>
                </td>
                <td>¿Tiene Certificación en el Modelo de Calidad?:</td>
                <td>
                    <select name="medidorCertProy">
                        <option value="1">Si</option>
                        <option value="0">No</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Comentar la certificación:</td>
                <td>
                    <input type="text" name="comCertModelo">
                </td>
                <td>
                    <select name="IdconfInfo">
                        <%for(ConfInfo i : ListaConfInfo){%>
                        <option value="<%=i.getIdconfInfo() %>">
                            <%=i.getConfInfo() %>
                        </option>
                        <%}%>
                    </select>
                </td>
            </tr>
                <tr><td><H3>Información de Recursos</H3></td></tr>
                <tr>
                    <td>
                        Duración del Proyecto:
                    </td>
                    <td>
                        <input type="text" name="duraProy" required>
                    </td>
                    <td>Escala:</td>
                    <td>
                    <select name="Idescala">
                        <%for(Escala i : ListaEscala){%>
                        <option value="<%=i.getIdescala() %>">
                            <%=i.getEscala() %>
                        </option>
                        <%}%>
                    </select>
                    </td>
                    <td>
                        Esfuerzo Total del Proyecto [hh]:
                    </td>
                    <td>
                        <input type="text" name="esfuTotProy" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        Esfuerzo de Planeación  [hh]:
                    </td>
                    <td>
                        <input type="text" name="esfuPlaneProy" required>
                    </td>
                    <td>
                        Esfuerzo de Especificación de Requerimientos  [hh]:
                    </td>
                    <td>
                        <input type="text" name="esfuEsReqProy" required>
                    </td>
                    <td>
                        Esfuerzo de Análisis y Diseño  [hh]:
                    </td>
                    <td>
                        <input type="text" name="esfuAnaDisProy" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        Esfuerzo de Construcción  [hh]:
                    </td>
                    <td>
                        <input type="text" name="esfuConstProy" required>
                    </td>
                    <td>
                        Esfuerzo de Pruebas  [hh]:
                    </td>
                    <td>
                        <input type="text" name="esfuPrueProy" required>
                    </td>
                    <td>
                        Esfuerzo de Implementación / Despliegue  [hh]:
                    </td>
                    <td>
                        <input type="text" name="esfuImpleDesProy" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        Costo Total del Proyecto $(MNX):
                    </td>
                    <td>
                        <input type="text" name="costTotProy" required>
                    </td>
                    <td>
                        Costo de Planeación  $(MNX):
                    </td>
                    <td>
                        <input type="text" name="costPlanProy" required>
                    </td>
                    <td>
                        Costo de Especificación de Requerimientos $(MNX):
                    </td>
                    <td>
                        <input type="text" name="costEsReqProy" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        Costo de Análisis y Diseño  $(MNX):
                    </td>
                    <td>
                        <input type="text" name="costAnaDisProy" required>
                    </td>
                    <td>
                        Costo de Construcción $(MNX):
                    </td>
                    <td>
                        <input type="text" name="costConstProy" required>
                    </td>
                    <td>
                        Costo de Pruebas $(MNX):
                    </td>
                    <td>
                        <input type="text" name="costPrueProy" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        Costo de Implementación / Despliegue $(MNX):
                    </td>
                    <td>
                        <input type="text" name="costImpleDesProy" required>
                    </td>
                </tr>
                <tr><td><H3>Tamaño Funcional</H3></td></tr>
                <tr>
                <td>Método de Medición:</td>
                    <td>
                    <select name="IdmetMedicion">
                        <%for(MetMedicion i : ListaMetMedicon){%>
                        <option value="<%=i.getIdmetMedicion() %>">
                            <%=i.getMetMedicion() %>
                        </option>
                        <%}%>
                    </select>
                    </td>
                    <td>
                        Tamaño Funcional medido utilizando el estándar seleccionado:
                    </td>
                    <td>
                        <input type="text" name="tamFunProy" required>
                    </td>
                    <td>
                        Function Points Ajustados (si el método utiliado lo permite):
                    </td>
                    <td>
                        <input type="text" name="fpAjusProy" required>
                    </td>
            </tr>
            <tr>
                    <td>
                        El medidor de software está certifiado en el Método Utilizado:
                    </td>
                    <td>
                        <select name="certModelo">
                            <option value="1">Si</option>
                            <option value="0">No</option>
                        </select>
                    </td>
                    <td>
                        Experiencia en años del medidor utilizando el método:
                    </td>
                    <td>
                        <input type="text" name="expeMedMetProy" required>
                    </td>
            </tr>
            <tr>
                <td>
                    <a href="AgregarProyecto">
                        <input type="submit" value="Guardar">
                    </a>
                </td></form>
            </tr>
            <tr>
                <td>
                    <a href="proyectos.jsp">
                        <input type="submit" value="Cancelar">
                    </a>
                </td>
            </tr>
        </table>
       
	<script src="js/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>        
    </body>
</html>

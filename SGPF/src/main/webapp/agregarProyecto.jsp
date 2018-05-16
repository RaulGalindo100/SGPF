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
           List<TipodeDesarrollo> ListaTipoDes = (List<TipodeDesarrollo>) session.getAttribute("ListaTipoDes1");
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
        <form action="AgregarProyecto" method="POST">
        <div>
            <table>
                <tr><td>Información del Proyecto</td></tr>
            <tr>
                <td>Nombre:</td>
                <td> <input type="text" name="nombreProyecto" required></td>
                <td>Año:</td>
                <td><select name="anio">
                        <option value=""> - Selecciona - </option>
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
                        <option value=""> - Selecciona - </option>
                        <option value="1">Si</option>
                        <option value="0">No</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Tipo de Desarrollo:</td>
                <td>
                    
                    <select name="IdTipodeDesarrollo">

                        <%List<TipodeDesarrollo> ListaTipoDes2 = (List<TipodeDesarrollo>) session.getAttribute("ListaTipoDes");%>
                        <%for(TipodeDesarrollo i : ListaTipoDes2){%>
                        <option value="<%=i.getIdTipodeDesarrollo()%>">
                            <%=i.getTipodeDesarrollo()%>

                        </option>
                        <%   }    %>
                    </select>
                </td>
                <td>Sector de la Organización Usuaria:</td>
                <td>
                    <select name="IdsectorOrganizacion">
                        <option value="null"> - Selecciona - </option>
                        
                    </select>
                </td>
                <td>Tipo Organización Usuaria:</td>
                <td>
                    <select name="IdtipoOrganizacion">
                        <option value="null"> - Selecciona - </option>
                        
                    </select>
                </td>
            </tr>
            <tr>
                <td>Tipo de Capacidad de Desarrollo usada:</td>
                <td>
                    <select name="IdtipoCapDes">
                        <option value="null"> - Selecciona - </option>
                    </select>
                </td>
                <td>Tamaño de la Organización que desarrolló el software:</td>
                <td>
                    <select name="IdtamOrgDes">
                        <option value="null"> - Selecciona - </option>
                    </select>
                </td>
                <td>Tamaño de la Organización que usaria el software:</td>
                <td>
                    <select name="tamOrgUsa">
                        <option value="null"> - Selecciona - </option>
                        
                    </select>
                </td>
            </tr></form>
        </table>    
        </div>
        <table><tr>
                <td> <input type="submit" value="Submit"> </td>
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

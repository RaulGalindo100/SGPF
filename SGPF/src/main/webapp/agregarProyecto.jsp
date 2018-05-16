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
    </head>
    <body>
        <h1>Agregar Nuevo Proyecto</h1>
        <form action="AgregarProyecto" method="POST">
        <div>
            <table>
                <tr><td>Informaci�n del Proyecto</td></tr>
            <tr>
                <td>Nombre:</td>
                <td> <input type="text" name="nombreProyecto" required></td>
                <td>A�o:</td>
                <td><select name="anio">
                        <option value="2015">2015</option>
                        <option value="2016">2016</option>
                        <option value="2017">2017</option>
                        <option value="2018">2018</option>
                        <option value="2019">2019</option>
                        <option value="2020">2020</option>
                    </select>
                </td>
                <td>�Se puso en operaci�n?:</td>
                <td><select name="operProy">
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
                        <%}%>
                    </select>
                </td>
                <td>Sector de la Organizaci�n Usuaria:</td>
                <td>
                    <select name="IdsectorOrganizacion">
                        <%for(SectorOrganizacion i : ListaSectorOrganizacion){%>
                        <option value="<%=i.getIdsectorOrganizacion()%>">
                            <%=i.getSectorOrganizacion()%>
                        </option>
                        <%}%>
                    </select>
                </td>
                <td>Tipo Organizaci�n Usuaria:</td>
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
                <td>Tama�o de la Organizaci�n que desarroll� el software:</td>
                <td>
                    <select name="IdtamOrgDes">
                        <%for(TamOrg i : ListaTamOrg){%>
                        <option value="<%=i.getIdtamOrgDes()%>">
                            <%=i.getTamOrgDes()%>
                        </option>
                        <%}%>
                    </select>
                </td>
                <td>Tama�o de la Organizaci�n que usaria el software:</td>
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
        
        
    </body>
</html>

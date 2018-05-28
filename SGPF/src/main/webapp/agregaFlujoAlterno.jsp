<%-- 
    Document   : agregaFlujoAlterno
    Created on : 28/05/2018, 11:27:44 AM
    Author     : jlope
--%>

<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page import="unam.mx.SGPF.model.Accion"%>
<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page import="java.util.List"%>
<%@page import="unam.mx.SGPF.model.EntityProvider"%>
<%@page import="unam.mx.SGPF.model.controller.SubProcesoJpaController"%>
<%@page import="unam.mx.SGPF.model.SubProceso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Flujo Alterno</title>
    </head>
    <% 
    SubProceso SubProceso = (SubProceso) session.getAttribute("SubProceso");
    %>
    <body>
        <h1>Agregar Flujo Alterno</h1>
        <table><form action="agregandoFlujoAlterno" method="post">
            <tr>
                <td>Actividad: (FIJO)</td>
                <td><%=SubProceso.getActividad()%></td>
            </tr>
            <tr>
                <td>Descripción: </td>
                <td><input type="text" name="descripcionFA" required></td>
            </tr>
            <tr>
                <td>Usuario Funcional:</td>
                <td>
                    <select name="usuarioFuncionalFA">
                    <%
                    List<UsuarioFuncional> usuarioFuncionalCat = (List<UsuarioFuncional>) session.getAttribute("ufCatalogo");
		    for (UsuarioFuncional usuarioF : usuarioFuncionalCat) {
			if (usuarioF.getActivo() == 1) {%>
			<option value="<%=usuarioF.getIdusuarioFuncional()%>">
			<%=usuarioF.getNomUF()%> -- <%=usuarioF.getDescripcion()%>
			</option>
		    <% } } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Acción:</td>
                <td>
                    <select name="accionFA">
                    <%
                    List<Accion> accionesCat = (List<Accion>) session.getAttribute("accCatalogo");
                    for (Accion accion : accionesCat) {
                    if (accion.getActivo() == 1) {%>
			<option value="<%=accion.getIdaccion()%>">
			<%=accion.getNomAccion()%> -- <%=accion.getMovDatos()%> -- <%=accion.getDescripcion()%>
			</option>
		    <% } } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Grupo de Datos:</td>
                <td>
                    <select name="grupoDatosFA">
                    <%
                    List<GrupoDato> grupoDatoCat = (List<GrupoDato>) session.getAttribute("grupoDatosCatalogo");
                    for (GrupoDato grupoDato : grupoDatoCat) {
                         if (grupoDato.getActivo() == 1) {%>
                            <option value="<%=grupoDato.getIdgrupoDato()%>">
				<%=grupoDato.getNomGD()%> -- <%=grupoDato.getDescripcion()%>
			    </option>
		    <% } } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Aceptar"></td></form>
                <td><a href="detallePF.jsp"><input type="submit" value="Cancelar"></a></td>
            </tr>
        </table>
    </body>
</html>

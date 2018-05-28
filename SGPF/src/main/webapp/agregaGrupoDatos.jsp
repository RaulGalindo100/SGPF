<%-- 
    Document   : agregaGrupoDatos
    Created on : 28/05/2018, 04:41:03 PM
    Author     : jlope
--%>

<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agrega Grupo de Datos</title>
    </head>
    <% 
    int idSubProceso = (Integer) session.getAttribute("idSubProceso");
    %>
    <body>
        <h1>Agrega Grupo de Datos!</h1>
        <table><form action="agregagndoGrupoDatos" method="post">
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
                <td><input type="hidden" name="idSubProceso" value="<%=idSubProceso%>">
                    <input type="submit" value="Aceptar"></td></form>
                <td><a href="detallePF.jsp"><input type="submit" value="Cancelar"></a></td>
            </tr>
        </table>
    </body>
</html>

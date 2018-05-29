<%-- 
    Document   : consultaHistoricos
    Created on : 29/05/2018, 10:30:16 AM
    Author     : jlope
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="unam.mx.SGPF.model.Historico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Históricos</title>
    </head>
    <%
        List<Historico> listaProyectos = (List<Historico>) session.getAttribute("listaProyectos");
        String nomProy = (String) session.getAttribute("nomProy");
        int contador = 0;
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy, hh:mm");
        %>
    <body>
        <h1>Históricos Registrados!</h1>
        <% if(listaProyectos==null || listaProyectos.isEmpty()){%>
        <br><H1> El proyecto no cuenta con datos históricos</h1><br>
        <%}else{%>
        <table>
            <tr>
                <td> Nombre del Proyecto:</td>
                <td><%=nomProy%></td>
            </tr>
            <tr>
                <td> Versión </td>
                <td> Fecha de Creación</td>
                <td> </td>
            </tr>
            <% for(Historico aux : listaProyectos){contador++;%>
            <tr>
                <td> <%=contador%> </td>
                <td> <%=formatter.format(aux.getFecha())%> </td>
                <td> <input type="submit" value="Generar Reporte">
                     <input type="hidden" name="fechaHistorico" value="<%=aux.getFecha()%>">
                     <input type="hidden" name="idProyecto" value="<%=aux.getIdProy()%>">
                </td>
            </tr>
             <% }%>
            <tr>
                <td><a href="proyectos.jsp"><input type="submit" value="Regresar"></a></td>
            </tr>
        </table>
        <%}%>
    </body>
</html>

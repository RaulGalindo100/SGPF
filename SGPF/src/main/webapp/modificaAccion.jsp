<%@page import="unam.mx.SGPF.model.controller.AccionJpaController"%>
<%@page import="unam.mx.SGPF.model.EntityProvider"%>
<%@page import="unam.mx.SGPF.model.Accion"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifica Acción</title>
    </head>
    <body>
        <h1>Modifica Acción</h1>
        <% Accion accion = (Accion) session.getAttribute("accionMod");%>
        <table><form action="modificandoAccion" method="post">
                <tr>
                    <td>
                        Nombre de la acción:
                    </td>
                    <td>
                        <input type="hidden" name="idAccion" value="<%=accion.getIdaccion()%>">
                        <input type="text" name="nombreAccion" value="<%=accion.getNomAccion()%>" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        Movimiento de datos:
                    </td>
                    <td>
                        <%if(accion.getMovDatos().equals("E")){%>
                        <select name="movDatos">
                            <option value="E" selected>E</option>
                            <option value="X">X</option>
                            <option value="R">R</option>
                            <option value="W">W</option>
                            <option value="S">S</option>
                        </select>
                        <%}else{if(accion.getMovDatos().equals("X")){%>
                        <select name="movDatos">
                            <option value="E">E</option>
                            <option value="X" selected>X</option>
                            <option value="R">R</option>
                            <option value="W">W</option>
                            <option value="S">S</option>
                        </select>
                        <%}else{if(accion.getMovDatos().equals("R")){%>
                        <select name="movDatos">
                            <option value="E">E</option>
                            <option value="X">X</option>
                            <option value="R" selected>R</option>
                            <option value="W">W</option>
                            <option value="S">S</option>
                        </select>
                        <%}else{if(accion.getMovDatos().equals("W")){%>
                        <select name="movDatos">
                            <option value="E">E</option>
                            <option value="X">X</option>
                            <option value="R">R</option>
                            <option value="W" selected>W</option>
                            <option value="S">S</option>
                        </select>
                        <%}else{%>
                        <select name="movDatos">
                            <option value="E">E</option>
                            <option value="X">X</option>
                            <option value="R">R</option>
                            <option value="W">W</option>
                            <option value="S" selected>S</option>
                        </select>
                        <%}}}}%>
                    </td>
                </tr>
                <tr>
                    <td>
                        Descripción:
                    </td>
                    <td>
                        <input type="text" name="descripcion" value="<%=accion.getDescripcion()%>" required>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Aceptar"></td></form>
                    <td>
                        <a href="acciones.jsp">
                            <input type="submit" value="Cancelar">
                        </a>
                    </td>
                </tr>
        </table>
    </body>
</html>

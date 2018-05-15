<%@page import="unam.mx.SGPF.model.InterUP"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Gestiona Usuarios Proyectos</title>
        <% List<InterUP> ListaInterUP = (List<InterUP>) session.getAttribute("ListaInterUP"); %>
    </head>
    <body>
        <h1>Gestiona Usuarios Proyectos!</h1>
        <table>
            <tr>
                <td>Usuario</td>
                <td>Proyecto</td>
            </tr>
            <% for(InterUP iter : ListaInterUP){%>
            <tr>
                <td><%=iter.getIdusuario().getNomUsuario()%></td>
                <td><%=iter.getIdproyecto().getNomProy()%></td>
            </tr>
            <%}%>
            <tr>
                <td>
                    <a href="agregaUsuarioProyecto.jsp">
                        <input type="submit" value="Agregar relación">
                    </a>
                </td>
                <td>
                    <a href="proyectos.jsp">
                        <input type="submit" value="Regresar">
                    </a>
                </td>
            </tr>
        </table>
    </body>
</html>

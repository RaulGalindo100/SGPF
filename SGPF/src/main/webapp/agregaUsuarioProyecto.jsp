<%@page import="unam.mx.SGPF.model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Agrega Relación Usuario Proyecto</title>
        <% List<Usuario> ListaUsuario = (List<Usuario>) session.getAttribute("ListaUsuario");
           List<Proyecto> ListaProyectos = (List<Proyecto>) session.getAttribute("ListaProyectos"); %>
    </head>
    <body>
        <h1>Agrega Relación Usuario Proyecto!</h1>
        <table>
            <form action="agregandoUsuarioProyecto" method="post">
            <tr>
                <td>Usuario:</td>
                <td>
                    <select name="IdUsuario">
                        <%for(Usuario iter : ListaUsuario){%>
                        <option value="<%=iter.getIdusuario()%>"><%=iter.getNomUsuario()%></option>
                        <%}%>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Proyecto:</td>
                <td>
                    <select name="IdProyecto">
                        <%for(Proyecto iter : ListaProyectos){%>
                        <option value="<%=iter.getIdproyecto() %>"><%=iter.getNomProy()%></option>
                        <%}%>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Agregar"></form>
                </td>
                <td>
                    <a href="gestionaUsuariosProyectos.jsp">
                        <input type="submit" value="Cancelar">
                    </a>
                </td>
            </tr>
        </table>
    </body>
</html>

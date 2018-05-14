<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page import="unam.mx.SGPF.model.ProcesoFuncional"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Detalles proyecto</title>
  </head>
  <%
     List<ProcesoFuncional> pfs = (List<ProcesoFuncional>) session.getAttribute("procFunc");
  	 Proyecto p = (Proyecto) session.getAttribute("proy"); 
         int tipoUsuario = Integer.parseInt(session.getAttribute("tipoUsuario").toString());
  %>

  <body>
    <h1>Detalle proyecto</h1>
    <table border="1">
      <tr>
        <td>Nombre Proyecto:</td>
        <td><%=p.getNomProy()%></td>
      </tr>
      <tr>
        <td>Año:</td>
        <td><%=p.getAnioProy()%></td>
      </tr>
      <tr>
        <td>Duracion:</td>
        <td><%=p.getDuraProy()%></td>
      </tr>
      <tr>
        <%if(tipoUsuario!=3&&p.getEstatus()==1){%>  
      	<td>
            <a href="modificaProyecto.jsp"><input type="submit" value="Modificar"/></a> </td>
        <% } %>
        <% if(tipoUsuario!=3){%>
      	<form action="eliminaProyecto" method="post">
                <input type="hidden" name="idProyecto" value="<%=p.getIdproyecto()%>">
       		<input type="submit" value="Cambiar Estatus"/>
      	</form>
        <% } %>
      </tr>
    </table>
    <br>
    <h1>Procesos funcionales relacionados al Proyecto</h1>
    <br><br>
    <!--<form action="agregarPF" method="POST">-->
        <!--<input type="hidden" name="idPF" value="<%=p.getIdproyecto()%>">-->
    <%if(tipoUsuario!=3&&p.getEstatus()==1){%>
    <a href="agregaPF.jsp">
        <input type="submit" value="Agregar PF">
    </a>
    <% } %>
    <!--</form>-->
    <br>
    <table border="1">
    <%
      for (ProcesoFuncional inter : pfs) {
    %>
    <tr>
        <td>Nombre del Proceso Funcional:</td>
        <td><a href="BuscaProcesoFuncional?idprocesoFuncional=<%=inter.getIdprocesoFuncional()%>"><%=inter.getNomPF()%></a></td>
        <td>
            <%if(tipoUsuario!=3&&p.getEstatus()==1){%>  
            <form action="eliminaPF" method="post">
                <input type="hidden" name="idPF" value="<%=inter.getIdprocesoFuncional()%>">
                <input type="submit" value="Eliminar">
            </form>
            <% } %>
        </td>
      </tr>
  
    <%
      }
    %>
    
     </table>
    <br>
    <br>
    <a href="proyectos.jsp"><input type="submit" value="Back to Projects"</a>
  </body>
</html>


<%@page import="unam.mx.SGPF.model.ProcesoFuncional"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Sub Proceso Eliminado</title>
        <%
          ProcesoFuncional PF_Actual = (ProcesoFuncional) session.getAttribute("PF_Actual");
        %>
    </head>
    <body>
        <h1>Se ha eliminado el SubProceso de una forma completamente exitosa,
            gracias por usar SGPF!</h1>
        <form action="BuscaProcesoFuncional?idprocesoFuncional=<%=PF_Actual.getIdprocesoFuncional()%>" method="POST">
            <input type="submit" value="Regresar"/>
        </form>
    </body>
</html>

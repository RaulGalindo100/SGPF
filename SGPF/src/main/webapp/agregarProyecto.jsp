<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Agregar Nuevo Proyecto</title>
    </head>
    <body>
        <h1>Nuevo</h1>
            <table>
            <form action="AgregarProyecto" method="POST">
            <tr>
                <td>Nombre: <input type="text" name="nombreProyecto" required></td>
                <td> <input type="submit" value="Submit"> </td></form>
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

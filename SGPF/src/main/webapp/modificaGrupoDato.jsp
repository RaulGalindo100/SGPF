<%@page import="unam.mx.SGPF.model.InterUP"%>
<%@page import="java.util.List"%>
<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Modificar Grupo de Datos</title>
        <% GrupoDato grupoDatoMod = (GrupoDato) session.getAttribute("grupoDatoMod");
           List<InterUP> inters = (List<InterUP>) session.getAttribute("inters");%>
        <meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0">
        <!--===============================================================================================-->
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inconsolata">
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <header>
            <div class="container">
                <h1>Sistema Gestor de Procesos Funcionales</h1>
            </div>
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">

                        </ul>
                        <a href="grupoDatos.jsp"> <input class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
                                                         type="submit" value="Cancelar">
                        </a>
                    </div>
                </nav>
            </div>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2>Modificar Grupo de Datos</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8">
                    <form action="modificandoGrupoDato" method="post">
                        <div class="form-group">
                            <label>Nombre del Grupo</label>
                            <input type="hidden" name="idGD" value="<%=grupoDatoMod.getIdgrupoDato()%>">
                            <input class="form-control" type="text" name="nombreGD" value="<%=grupoDatoMod.getNomGD()%>" required>             
                        </div>
                        <div class="form-group">
                            <label>Descripción</label>
                            <textarea class="form-control" name="descripcionGD" rows="3"><%=grupoDatoMod.getDescripcion()%></textarea>
                        </div>
                        <div class="form-group">
		            <select class="form-control" name="idProyecto">
                                <% for(InterUP iter : inters){
                                    if(iter.getIdproyecto().getIdproyecto()==grupoDatoMod.getIdproyecto()){%>
                                        <option value="<%=iter.getIdproyecto().getIdproyecto()%>" selected>
                                            <%=iter.getIdproyecto().getNomProy()%>
                                        </option>
                                    <%}else{%>
                                        <option value="<%=iter.getIdproyecto().getIdproyecto()%>">
                                            <%=iter.getIdproyecto().getNomProy()%>
                                        </option>
                                    <%}}%>
			    </select>
			</div>
                        <div class="container">
                            <!-- Trigger the modal with a button -->
                            <button type="button" class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;"
                                    data-toggle="modal"
                                    data-target="#modiGD">
                                Modificar</button>
                            <!-- Modal -->
                            <div class="modal fade" id="modiGD" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-body">
                                            <p>Estos cambios se aplicarán a todos los Procesos Funcionales que utilizan este grupo de datos.</p>
                                            <p>¿Desea continuar?
                                        </div>
                                        <div class="modal-footer">
                                            <input class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;" type="submit" value="Aceptar">
                                            <button type="button" class="btn btn-outline-info .btn-sm text-white" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;" data-dismiss="modal">Cancelar</button>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="js/jquery.js"></script>
        <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    </body>
</html>

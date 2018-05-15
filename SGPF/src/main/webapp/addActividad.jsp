<%@page import="unam.mx.SGPF.model.SubProceso"%>
<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page import="unam.mx.SGPF.model.Accion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!-- 
Falta que al agregar sólo lo hahrá en caso de que no exista ya el NOMBRE DE LA
ACTIVIDAD CON EL PF, de no ser así mandar ERROR.

Validad ID del PF con ....
-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Actividad</title>
        <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Inconsolata">
<link rel="stylesheet" href="css/estilos.css">
        <%
            List<SubProceso> ListaSubprocesos = (List<SubProceso>) session.getAttribute("ListaSubprocesos");
            %>
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
				
<a href="detallePF.jsp"><input class="btn btn-info"  type="submit" value="Cancelar"></a>
			
				</div>
			</nav>
			</div>
	</header>
<div class="container py-5">
		<section class="row">
			<div class="col-md-12">
				<h1>Agregar Actividad</h1>
			</div>
			<div class="table-responsive ">
			 	<form action="agregandoActividad" method="POST">
				<table class="table">
				<tbody>
					<tr>
							<th scope="col" style="text-align: right;">Actividad:</th>
							<td>
            	<% 
            		if(ListaSubprocesos.isEmpty()){
            	%>  
                	<input type="hidden" name="actividad" value="Inicio de Proceso Funcional">
                Inicio de Proceso Funcional
            	<%
                }else{
            	%>
                	<input type="text" name="actividad" required>    
            	<% } %>
            </td>
					</tr>
					<tr>
							<th scope="col" style="text-align: right;">Descripción:</th>
							<td>
                <input type="text" name="descripcion" required>
            	</td>
					</tr>
					<tr>
							<th scope="col" style="text-align: right;">Usuario funcional:</th>
							<td>
                <select name="usuarioFuncional" required>
                    <%
                        List<UsuarioFuncional> usuarioFuncionalCat = (List<UsuarioFuncional>) session.getAttribute("ufCatalogo");
                        for (UsuarioFuncional usuarioF : usuarioFuncionalCat){
                            if(usuarioF.getActivo()==1){
                                %>
                            <option value="<%=usuarioF.getIdusuarioFuncional()%>">
                                <%=usuarioF.getNomUF()%> -- <%=usuarioF.getDescripcion()%>
                            </option>
                       <%
                           }
                        }
                        %>
                </select>
            	</td>
					</tr>
					<tr>
							<th scope="col" style="text-align: right;">Acción:</th>
							<td>
                <select name="accion" required>
                    <%
                        List<Accion> accionesCat = (List<Accion>) session.getAttribute("accCatalogo");
                        for (Accion accion : accionesCat){
                            if(accion.getActivo()==1){
                                %>
                            <option value="<%=accion.getIdaccion()%>">
                                <%=accion.getNomAccion()%> -- <%=accion.getMovDatos()%> -- <%=accion.getDescripcion()%>
                            </option>
                       <%
                           }
                        }
                        %>
                </select>
            </td>
					</tr>
					<tr>
							<th scope="col" style="text-align: right;">Grupo de datos:</th>
							<td>
                <select name="grupoDatos" required>
                    <%
                        List<GrupoDato> grupoDatoCat = (List<GrupoDato>)session.getAttribute("grupoDatosCatalogo");
                        for (GrupoDato grupoDato : grupoDatoCat){ 
                            if(grupoDato.getActivo()==1){ 
                                %>
                            <option value="<%=grupoDato.getIdgrupoDato()%>">
                                <%=grupoDato.getNomGD()%> -- <%=grupoDato.getDescripcion()%>
                            </option>
                       <%
                           }
                        }
                        %>
                </select>
            </td>
					</tr>
					<tr>
							<th scope="col" style="text-align: right;">Flujo alterno:</th>
							<td>
                <input type="checkbox" name="flujoAl" value="true">
            	</td>
					</tr>
				</tbody>
				</table>
				<input class="btn btn-outline-info" type="submit" value="Guardar"/>
				
				</form>
				
			</div>
			</section>
</div>
        
    	<script src="js/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
    </body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Sistema Gestor de Procesos Funcionales</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,user-scalable=no, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0">
<!--===============================================================================================-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Inconsolata">
<link rel="stylesheet" href="css/estilos.css">
<%String result=request.getParameter("error"); %>
</head>
<body>
	<header>
		<div class="container">
			<h1>Sistema Gestor de Procesos Funcionales</h1>
		</div>
	</header>
	<div class="container py-5">
		<%if (result!=null && result.equals("1")) {%>
						<div class="alert alert-warning alert-dismissible fade show"
					role="alert">
					<strong>No se puede validar el usuario.</strong>
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>	
	  <%}%>
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-6 mx-auto">

						<!-- form card login -->
						<div class="card rounded-0">
							<div class="card-header">
								<h3 class="mb-0">Login</h3>
							</div>
							<div class="card-body">
								<form class="form" role="form" autocomplete="off" id="formLogin"
									novalidate="" action="Login" method="POST">
									<div class="form-group">
										<label for="uname1">Usuario</label> <input
											class="form-control form-control-lg rounded-0" type="text"
											name="uname" placeholder="Ingrese su usuario" value=""
											required>
										<div class="invalid-feedback">Es requerido.</div>
									</div>
									<div class="form-group">
										<label>Contrase�a</label> <input
											class="form-control form-control-lg rounded-0"
											type="password" name="psw"
											placeholder="Ingrese su contrase�a" value="" required>
										<div class="invalid-feedback">Es requerido.</div>
									</div>
									<button type="submit"
										class="btn btn-success btn-lg float-right" id="btnLogin" style="border-width: 2px; border-style: solid; border-color: #2c3e50; background-color: #2c3e50;" >Ingresar</button>
								</form>
							</div>
							<!--/card-block-->
						</div>
						<!-- /form card login -->
					</div>
				</div>
				<!--/row-->

			</div>
			<!--/col-->
		</div>
		<!--/row-->
	</div>
	<!--/container-->
	<!-- ------------------------------------------------ -->



	<script src="js/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>
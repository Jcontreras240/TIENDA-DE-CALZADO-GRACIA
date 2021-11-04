<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>CALZADO GRACIA - Tienda Virtual</title>
<link rel="shortcut icon" href="img/logo.png" type="image/x-icon">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400|Roboto:300,400,700">
<link rel="stylesheet" href="assets/css/index.css">
<link rel="stylesheet" href="css/bg.css">
</head>

<body>
	<!-- Start: Black Navbar -->
	<nav
		class="navbar navbar-light navbar-expand-md navbar-fixed-top navigation-clean-button"
		style="background: rgb(34, 34, 34); border-radius: 20; border-top-left-radius: 20; border-top-right-radius: 20; border-bottom-right-radius: 20; border-bottom-left-radius: 20; border-style: none; padding-top: 0; padding-bottom: 10px;">
		<div class="container">
			<div>
				<a class="navbar-brand" href="inicio.jsp"><span><img
						src="assets/img/logo.png" width="70px" height="70px">&nbsp;Calzado Gracia</span> </a>
			</div>
			
			<p class="ms-auto actions">
			<div class="dropdown">
				<button class="btn btn-primary" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown"
								aria-expanded="false" style= "border-radius: 10px" >${usuario.getNombre_usuario()}</button>
							<div class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<a class="dropdown-item" href="#"><img src="img/user.png" width="40" alt="40"></a> <a
									class="dropdown-item" href="#">${usuario.getUsuario()}</a>
								<a class="dropdown-item" href="#">${usuario.getEmail_usuario()}</a>
								<div class="dropdown-divider"></div>
					<a class=" action-button" role="button"
					href="index.jsp"
					style="color: rgba(0, 0, 0, 0.9); background: var(- -bs-gray-200); border-radius: 10px; border-style: solid; border-color: rgba(0, 0, 0, 0.9); font-size: 16px; padding: 5px 8px;">Cerrar
					Sesión</a>
				</div>
			</div>
				
			</p>
		</div>
	</nav>
	<!-- End: Black Navbar -->
	<!-- Start: Black Navbar -->
	<nav
		class="navbar navbar-light navbar-expand-md navbar-fixed-top navigation-clean-button"
		style="background: rgb(34, 34, 34); border-radius: 20; border-top-left-radius: 20; border-top-right-radius: 20; border-bottom-right-radius: 20; border-bottom-left-radius: 20; border-style: none; padding-top: 0; padding-bottom: 10px;">
		<div class="container">
			<button data-bs-toggle="collapse" class="navbar-toggler"
				data-bs-target="#navcol-1">
				<span class="visually-hidden">Toggle navigation</span><span
					class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navcol-1"
				style="color: rgb(255, 255, 255);">
				<ul class="navbar-nav nav-right">
					<li class="nav-item"><a class="nav-link active"
						href="Controlador?menu=Usuarios&accion=Listar"" style="color: rgba(224, 217, 217, 0.9);" target="myFrame">Usuarios</a></li>
					<li class="nav-item"><a class="nav-link" href="Controlador?menu=Clientes&accion=Listar" style="color: rgba(224, 217, 217, 0.9);" target="myFrame">Clientes</a></li>
					<li class="nav-item"><a class="nav-link" href="Controlador?menu=Proveedores&accion=Listar" style="color: rgba(224, 217, 217, 0.9);"target="myFrame">Proveedores</a></li>
					<li class="nav-item"><a class="nav-link" href="Controlador?menu=Productos&accion=Listar" style="color: rgba(224, 217, 217, 0.9);"target="myFrame">Productos</a></li>
					<li class="nav-item"><a class="nav-link" href="Controlador?menu=Ventas&accion=default&UsuarioActivo=${usuario.getCedula_usuario()}"
						style="color: rgba(224, 217, 217, 0.9);"target="myFrame">Ventas</a></li>
					<li class="nav-item"><a class="nav-link" href="Controlador?menu=Reportes"
						style="color: rgba(224, 217, 217, 0.9);"target="myFrame">Reportes</a></li>
			</div>
		</div>
	</nav>
	<!-- End: Black Navbar -->
	<div class="m-4" style="height: 550px;">
		<iframe style="height: 100%; width: 100%; border: none" name="myFrame"></iframe>
	</div>
	<hr>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
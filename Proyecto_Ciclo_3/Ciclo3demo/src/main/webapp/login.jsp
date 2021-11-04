<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <meta name="generator" content="Hugo 0.88.1">
  <title>Iniciar Sesión - CALZADO GRACIA</title>
  <link rel="shortcut icon" href="img/logo.png" type="image/x-icon">

  <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">



  <!-- Bootstrap core CSS -->
  <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
      -webkit-user-select: none;
      -moz-user-select: none;
      user-select: none;
    }

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }
  </style>


  <!-- Custom styles for this template -->
  <link href="css/login.css" rel="stylesheet">
  <link rel="stylesheet" href="css/bg.css">
</head>

<body class="text-center">
    <main class="form-signin bg-dark">
      <form class="form-sign" method="get" action="./DemoServlet">
        <img class="mb-1" src="img/logo.png" alt="" width="200" height="200">
        <h1 class="h3 mb-3 fw-normal text-light">Iniciar Sesión</h1>

        <div class="form-floating mb-2">
          <input type="text" class="form-control" id="txtusuario" placeholder="Usuario" name="txtusuario">
          <label for="usuario">Usuario</label>
        </div>
        <div class="form-floating">
          <input type="password" class="form-control" id="txtpassword" placeholder="Password" name="txtpassword">
          <label for="password">Contraseña</label>
        </div>

        <div class="checkbox mb-3 text-light">
        </div>
        <button class="w-50 btn btn-lg btn-outline-light" type="submit" name="accion" value="Ingresar">Iniciar Sesión</button>
        <button class="w-50 btn btn-lg btn-outline-light mt-3" type="submit" name="accion" value="Cancelar">Cancelar</button>
        <p class="mt-5 mb-3 text-muted">CALZADO GRACIA &copy; 2021</p>
      </form>
    </main>

</body>
</html>
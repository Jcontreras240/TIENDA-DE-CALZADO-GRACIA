<!DOCTYPE html>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="css/signin.css" >
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    
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
  
      
      <!--Custom styles for this template -->
      

</head>

<body>
  
    <main class="form-signin">
    	<form class="form-sign" method="get" action="./DemoServlet">
        
          <h1 class="form-title">CALZADO GRACIA</h1>
          
          <img class="form-mb-4" src="img/logo.png" alt="logo CG">
      
          <div class="form-floating">
            <input type="text" class="form-control" id="txtusuario" name="txtusuario" placeholder="Usuario">
            <label for="floatingInput">Usuario</label>
          </div>
          <div class="form-floating">
            <input type="password" class="form-control" id="txtpassword" name="txtpassword" placeholder="Contraseña">
            <label for="floatingPassword">Contrase�a</label>
          </div>

          <input type="submit" name="accion" value="Ingresar" class="btn btn-primary">
          <a href="#" class="btn btn-secondary" type="submit">Cancelar</a>
        </form>
      </main>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
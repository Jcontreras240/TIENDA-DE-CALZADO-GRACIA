<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuarios</title>
    <link rel="stylesheet" href="css/usuario.css">


    <!-- Bootstrap core CSS -->
    <!--link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous"-->



</head>

<body>

    <div class="container">
        <div class="col">
            <div class="row">
                <div class="col-md-12">
                    <h1><img class="avatar" src="img/logo.png" alt="logo de CG">Usuarios</h1>
                </div>
            </div>
            <form method="get" action="./usuarios">
                <div class="col">
                    <div class="table-responsive">
                        <table class="table">
                            <tbody>
                                <tr>
                                    <td><label class="form-label">Cédula:</label></td>
                                    <td><input type="text" class="form-control1" name="cedula" placeholder="Cédula" />
                                    </td>
                                </tr>
                                <tr>
                                    <td><label class="form-label">Nombre Completo:</label></td>
                                    <td><input type="text" class="form-control" name="nombre"
                                            placeholder="Nombres y apellidos" /></td>
                                </tr>
                                <tr>
                                    <td><label class="form-label">Correo Electrónico:</label></td>
                                    <td><input type="email" class="form-control" name="email"
                                            placeholder="Corroe Electronico" /></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr></tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><label class="form-label">Usuario:</label></td>
                                    <td><input type="text" class="form-control2" name="usuario" placeholder="Usuario" />
                                    </td>
                                </tr>
                                <tr>
                                    <td><label class="form-label">Contraseña:</label></td>
                                    <td><input type="password" class="form-control2" name="password"
                                            placeholder="Contraseña" /></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row-botones">
                    <button class="btn1 btn-primary" type="button submit">Consultar</button>
                    <button class="btn btn-secondary" style="background:rgb(56, 230, 79); color:black"  type="button submit" name="crear">Crear</button>
                    <button class="btn btn-secondary" type="button submit" name="Actualizar">Actualizar</button>
                    <button class="btn btn-secondary" type="button submit" name="eliminar">Borrar</button>
                </div>
            </form>
        </div>
        

    </div>
   


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>


    <!-- <script>
                function habilitar() {

                    var cedula = document.getElementById(cedula1);
                    var nombre = document.getElementById(nombre1);
                    var email = document.getElementById(email1);
                    var usuario = document.getElementById(usuario1);
                    var password = document.getElementById(password1);


                    if (cedula.value != 0) {

                        crear.disabled = false;
                    } else

                    {
                        crear.disabled = true;
                    }


                }
            </script>  Codigo para modificar la habilitacion he inabilitacion de botones 
            -->



</body>

</html>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tienda Genérica</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>
   
    <div class="container">
        <div class="col">
            <div class="row">
                <div class="col-md-12 col-lg-12 offset-lg-0" style="background: var(--bs-secondary);color: var(--bs-gray-100);">
                    <h1>Mantenimiento Usuarios</h1>
                </div>
            </div>
            <div class="row">
            <form method="get" action="./usuarios">
                <div class="row">
                    <div class="col">
                        <div class="table-responsive">
                            <table class="table">
                                <tbody>
                                    <tr>
                                        <td><label class="form-label">Cédula</label></td>
                                        <td><input type="text" class="form-control" name="cedula"/></td>
                                    </tr>
                                    <tr>
                                        <td><label class="form-label">Nombre Completo</label></td>
                                        <td><input type="text" class="form-control" name="nombre"/></td>
                                    </tr>
                                    <tr>
                                        <td><label class="form-label">Correo Electrónico</label></td>
                                        <td><input type="email" class="form-control" name="email"/></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr></tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><label class="form-label">Usuario</label></td>
                                        <td><input type="text" class="form-control" name="usuario"/></td>
                                    </tr>
                                    <tr>
                                        <td><label class="form-label">Contraseña</label></td>
                                        <td><input type="password" class="form-control" name="password"/></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="row botones">
                    <div class="col text-center"><button class="btn btn-primary" type="button submit" style="background: var(--bs-secondary);border-color: var(--bs-secondary);">Consultar</button></div>
                    <div class="col text-center"><button class="btn btn-primary" type="button submit" name="crear" style="background: var(--bs-secondary);border-color: var(--bs-secondary);">Crear</button></div>
                    <div class="col text-center"><button class="btn btn-primary" type="button submit" style="background: var(--bs-secondary);border-color: var(--bs-secondary);">Actualizar</button></div>
                    <div class="col text-center"><button class="btn btn-primary" type="button submit" name="eliminar" style="background: var(--bs-secondary);border-color: var(--bs-secondary);">Borrar</button></div>
                </div>
            </form>
           <div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
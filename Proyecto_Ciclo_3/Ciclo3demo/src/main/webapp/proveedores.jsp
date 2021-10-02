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
                    <h1>Tienda Genérica</h1>
                </div>
            </div>
            <div class="row">
                <div class="col d-inline-block" style="border-style: solid;border-color: var(--bs-secondary);">
                    <nav class="navbar navbar-light navbar-expand-md d-block">
                        <div class="container-fluid"><button data-bs-toggle="collapse" data-bs-target="#navcol-1" class="navbar-toggler"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                            <div class="collapse navbar-collapse" id="navcol-1">
                                <ul class="navbar-nav">
                                	<li class="nav-item"><a class="nav-link" href="usuarios.jsp">Usuarios</a></li>
                                	<li class="nav-item"><a class="nav-link" href="clientes.jsp">Clientes</a></li>
                                	<li class="nav-item"><a class="nav-link" href="proveedores.jsp">Proveedores</a></li>
                                	<li class="nav-item"><a class="nav-link" href="productos.jsp">Productos</a></li>
                                	<li class="nav-item"><a class="nav-link" href="ventas.jsp">Ventas</a></li>
                                	<li class="nav-item"><a class="nav-link" href="reportes.jsp">Reportes</a></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
            <form>
                <div class="row">
                    <div class="col">
                        <div class="table-responsive">
                            <table class="table">
                                <tbody>
                                    <tr>
                                        <td><label class="form-label">NIT</label></td>
                                        <td><input type="text" class="form-control" /></td>
                                    </tr>
                                    <tr>
                                        <td><label class="form-label">Nombre Proveedor</label></td>
                                        <td><input type="text" class="form-control" /></td>
                                    </tr>
                                    <tr>
                                        <td><label class="form-label">Dirección</label></td>
                                        <td><input type="text" class="form-control" /></td>
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
                                        <td><label class="form-label">Teléfono</label></td>
                                        <td><input type="text" class="form-control" /></td>
                                    </tr>
                                    <tr>
                                        <td><label class="form-label">Ciudad</label></td>
                                        <td><input type="password" class="form-control" /></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="row botones">
                    <div class="col text-center"><button class="btn btn-primary" type="button submit" style="background: var(--bs-secondary);border-color: var(--bs-secondary);">Consultar</button></div>
                    <div class="col text-center"><button class="btn btn-primary" type="button submit" style="background: var(--bs-secondary);border-color: var(--bs-secondary);">Crear</button></div>
                    <div class="col text-center"><button class="btn btn-primary" type="button submit" style="background: var(--bs-secondary);border-color: var(--bs-secondary);">Actualizar</button></div>
                    <div class="col text-center"><button class="btn btn-primary" type="button submit" style="background: var(--bs-secondary);border-color: var(--bs-secondary);">Borrar</button></div>
                </div>
            </form>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
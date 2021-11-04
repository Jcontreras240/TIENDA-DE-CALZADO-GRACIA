<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Proveedores</title>
    <link rel="stylesheet" href="css/proveedores.css">

    <!-- Bootstrap core CSS -->
    <!--link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous"-->

</head>
<body>
   
    <div class="container">
        <div class="col">
            <div class="row">
                <div class="col-md-12">
                    <h1><img class="avatar" src="img/logo.png" alt="logo de CG">Proveedores</h1>
                </div>
            </div>
            <!--div class="row">
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
            </div-->
            <form  method="get" action="./proveedores">
                
                    <div class="col">
                        <div class="table-responsive">
                            <table class="table">
                                <tbody>
                                    <tr>
                                        <td><label class="form-label">NIT:</label></td>
                                        <td><input type="text" class="form-control1" placeholder="Nit de la empresa"/></td>
                                    </tr>
                                    <tr>
                                        <td><label class="form-label">Nombre Proveedor:</label></td>
                                        <td><input type="text" class="form-control" placeholder="Nombre del proveedor"/></td>
                                    </tr>
                                    <tr>
                                        <td><label class="form-label">Dirección:</label></td>
                                        <td><input type="text" class="form-control" placeholder="Direccion"/></td>
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
                                        <td><label class="form-label">Telófono:</label></td>
                                        <td><input type="text" class="form-control2" placeholder="Teléfono" /></td>
                                    </tr>
                                    <tr>
                                        <td><label class="form-label">Ciudad:</label></td>
                                        <td><input type="text" class="form-control2" placeholder="Ciudad" /></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                
                <div class="row-botones">
                    <button class="btn1 btn-primary" type="button submit" name="Consultar">Consultar</button>
                    <button class="btn btn-primary" type="button submit" style="background:rgb(56, 230, 79); color:black" name="Crear">Crear</button>
                    <button class="btn btn-primary" type="button submit" name="Actualizar">Actualizar</button>
                    <button class="btn btn-primary" type="button submit" name="Borrar">Borrar</button>
                </div>
            </form>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
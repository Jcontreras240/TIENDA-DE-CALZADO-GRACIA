<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="co.edu.unbosque.model.Productos"%>
	<%@page import="java.util.ArrayList"%>
    
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Creación de Productos</title>
</head>
<body>
	<div class="container">
		<div class="col">
			<div class="row">
				<div class="col-md-12 col-lg-12 offset-lg-0"
					style="background: var(- -bs-secondary); color: var(- -bs-gray-100);">
					<h1>Actualización Productos</h1>
				</div>
			</div>
			<div class="row">
				<div class="card col-md-4">
					<div class="card-body">
						<h5 class="card-title">Productos</h5>
						<h6 class="card-subtitle mb-2 text-muted">En este panel
							podras gestionar los productos</h6>
						<div>
							<form class="form-sign" method="get" action="Controlador">

								<div class="form-group">
									<input type="hidden" name="menu" value="Productos"> <label>Código Producto:</label>
									<input type="text" name="txtcodigoproducto" class="form-control"
										value="${productoSeleccionado.getCodigo_producto()}">
								</div>
								<div class="form-group">
									<label>Nombre Producto:</label> 
									<input type="text" name="txtnombreproducto"	class="form-control"
										value="${productoSeleccionado.getNombre_producto()}">
								</div>
								<div class="form-group">
									<label>Nit proveedor:</label> <input type="text" name="txtnitproveedor"
										class="form-control"
										value="${productoSeleccionado.getNit_proveedor()}">
								</div>
								<div class="form-group">
									<label>Precio Compra:</label> <input type="text" name="txtpreciocompra"
										class="form-control"
										value="${productoSeleccionado.getPrecio_compra()}">
								</div>
								<div class="form-group">
									<label>Iva Compra:</label> <input type= "text"  name="txtivacompra" class="form-control"
										value="${productoSeleccionado.getIva_compra()}">
								</div>
								<div class="form-group">
									<label>Precio Venta:</label> <input type="text" name="txtprecioventa"
										class="form-control"
										value="${productoSeleccionado.getPrecio_venta()}">
								</div>
								<input type="submit" class="btn btn-primary" name="accion"
									value="Agregar"> <input type="submit"
									class="btn btn-success" name="accion" value="Actualizar">
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<table class="table-responsive">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Código Producto</th>
								<th scope="col">Nombre Producto</th>
								<th scope="col">Nit proveedor</th>
								<th scope="col">Precio Compra</th>
								<th scope="col">Iva Compra</th>
								<th scope="col">Precio Venta</th>
							</tr>
						</thead>
						<tbody>
							
							<% ArrayList<Productos> lista = (ArrayList<Productos>)request.getAttribute("lista");
							for (Productos productos:lista){
							%>						

							<tr>
								<td><%=productos.getCodigo_producto()%></td>
								<td><%=productos.getNombre_producto()%></td>
								<td><%=productos.getNit_proveedor()%></td>
								<td><%=productos.getPrecio_Compra()%></td>
								<td><%=productos.getIva_Compra()%></td>
								<td><%=productos.getPrecio_Venta()%></td>
								<td><a class="btn btn-warning"
									href="Controlador?menu=Productos&accion=Cargar&id=<%=productos.getCodigo_producto()%>">Editar</a>
									<a class="btn btn-danger"
									href="Controlador?menu=Productos&accion=Eliminar&id=<%=productos.getCodigo_producto()%>">Eliminar</a>
								</td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
</body>
</html>

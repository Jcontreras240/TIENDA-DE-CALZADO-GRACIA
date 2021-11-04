<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="co.edu.unbosque.model.Usuarios"%>
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
<title>Usuario |Calzado Gracias</title>
</head>
<body>
	<div class="container">
		<div class="col">
			<div class="row">
				<div class="col-md-12 col-lg-12 offset-lg-0"
					style="background: var(- -bs-secondary); color: var(- -bs-gray-100);">
					<h1>Mantenimiento Usuarios</h1>
				</div>
			</div>
			<button type="button" class="btn btn-blue px-3 d-block text-95 radius-round border-2 brc-black-tp10" data-toggle="modal" data-target="#newModal" id="btn_nuevo_Usuario">
			            <i class="fa fa-plus mr-1"></i>
			            <span class="d-sm-none d-md-inline" id="btn_nuevo_Usuario">Nuevo</span>
			          </button>
			<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap">Open modal for @getbootstrap</button>
			<div class="row">
				<div class="col-md-8">
					<table class="table-responsive">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Cedula</th>
								<th scope="col">Nombre</th>
								<th scope="col">Email</th>
								<th scope="col">Usuario</th>
								<th scope="col">Password</th>
							</tr>
						</thead>
						<tbody>
							<% ArrayList<Usuarios> lista= (ArrayList<Usuarios>) request.getAttribute("lista");
							for (Usuarios usuario:lista){
							%>

							<tr>
								<td><%=usuario.getCedula_usuario()%></td>
								<td><%=usuario.getNombre_usuario()%></td>
								<td><%=usuario.getEmail_usuario()%></td>
								<td><%=usuario.getUsuario()%></td>
								<td><%=usuario.getPassword()%></td>
								<td><a class="btn btn-warning"
									href="Controlador?menu=Usuarios&accion=Cargar&id=<%=usuario.getCedula_usuario()%>">Editar</a>
									<a class="btn btn-danger"
									href="Controlador?menu=Usuarios&accion=Eliminar&id=<%=usuario.getCedula_usuario()%>">Eliminar</a>
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
								    <!-- Modal Nuevo -->
				<div class="modal fade modal-" id="newModal" tabindex="-1" role="dialog" aria-labelledby="newModalLabel" aria-hidden="true">
					
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header bgc-primary-m1 brc-white">
				        <h5 class="modal-title text-white" id="newModalLabel">
				          Nuevo Usuario
				        </h5>

				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>

				      <div class="modal-body">
				      	<form action="" id="form_guardar" name="form_guardar" class="" autocomplete="off" method="post" accept-charset="utf-8">
				      		
					        <div class="card-body px-3 pb-1">
	                			<div class="form-body">
				                    <div class="form-group row" id="div_Cedula">
				                      <div class="col-sm-4 col-form-label text-sm-right pr-0">
				                        <label for="celula" class="mb-0">Cedula *</label>				                      </div>
				                      <div class="col-sm-8">
				                        <input type="text" name="txtcedula" value="" id="txtcedula" placeholder="Cedula" maxlength="20" class="form-control col-sm-9 col-md-10" required="1"  />
				                      </div>
				                    </div>

				                    <div class="form-group row" id="div_nombreUsuario">
				                      <div class="col-sm-4 col-form-label text-sm-right pr-0">
				                        <label for="nombre" class="mb-0">Nombre Usuario *</label>				                      </div>
				                      <div class="col-sm-8">
				                        <input type="text" name="txtnombre" value="" id="txtnombre" placeholder="Nombre" maxlength="20" class="form-control col-sm-9 col-md-10" required="1"  />
				                      </div>
				                    </div>
				                      

				                    <div class="form-group row" id="div_email">
				                      <div class="col-sm-4 col-form-label text-sm-right pr-0">
				                        <label for="email" class="mb-0">Email *</label>				                      </div>
				                      <div class="col-sm-8">
				                        <input type="text" name="txtemail" value="" id="txtemail" placeholder="Email" maxlength="20" class="form-control col-sm-9 col-md-10" required="1"  />
				                      </div>
				                     </div>
				                    
				                    <div class="form-group row" id="div_Usuario">
				                      <div class="col-sm-4 col-form-label text-sm-right pr-0">
				                        <label for="usuario" class="mb-0">Usuario *</label>				                      </div>
				                      <div class="col-sm-8">
				                        <input type="text" name="txtusuario" value="" id="txtusuario" placeholder="Usuario" maxlength="20" class="form-control col-sm-9 col-md-10" required="1"  />
				                      </div>
				                    </div>
				                      

				                    <div class="form-group row" id="div_password">
				                      <div class="col-sm-4 col-form-label text-sm-right pr-0">
				                        <label for="password" class="mb-0">Password *</label>				                      </div>
				                      <div class="col-sm-8">
				                        <input type="text" name="txtpassword" value="" id="txtpassword" placeholder="Password" maxlength="20" class="form-control col-sm-9 col-md-10" required="1"  />
				                      </div>
				                     </div>  
			                  	</div><!-- /.Form-body Modal-->
							</div><!-- /.card-body Modal-->

						    <div class="modal-footer">
						        <button type="submit" class="btn btn-primary " id="btn_guardar" name="btn_guardar">
						          Guardar
						        </button>
						        <button type="button" class="btn btn-secondary px-4" data-dismiss="modal">
						          Cerrar
						        </button>
							</div>
						</form>				      </div><!-- /.Modal-body -->
				    </div> <!-- /.modal-content -->
				  </div>
            	</div>	<!-- /.Modal -->
		
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

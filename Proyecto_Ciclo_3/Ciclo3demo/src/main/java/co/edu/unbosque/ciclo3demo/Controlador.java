package co.edu.unbosque.ciclo3demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.unbosque.jsoncontroller.VentasJSON;
import co.edu.unbosque.jsoncontroller.DetalleVentaJSON;
import co.edu.unbosque.jsoncontroller.ClientesJSON;
import co.edu.unbosque.jsoncontroller.ProductosJSON;
import co.edu.unbosque.jsoncontroller.ProveedoresJSON;
import co.edu.unbosque.jsoncontroller.UsuariosJSON;
import co.edu.unbosque.model.Clientes;
import co.edu.unbosque.model.DetalleVenta;
import co.edu.unbosque.model.Proveedores;
import co.edu.unbosque.model.Usuarios;
import co.edu.unbosque.model.Ventas;
import co.edu.unbosque.model.Productos;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	long codProducto=0, numfac=0;
	double valor_iva=0, iva=0, precio=0, subtotaliva=0,acusubtotal=0, subtotal=0, totalapagar=0;
	int cantidad=0, item=0;
	String descripcion, cedulaCliente;
	List<DetalleVenta> listaVentas= new ArrayList<>();
	Usuarios usuarios= new Usuarios();
	DetalleVenta detalle_venta = new DetalleVenta();

	public Controlador() {
		super();
	}
	
	//***********Metodos  locales para buscar clientes y productos  *****************
		public void buscarCliente(Long id,HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			try {
				ArrayList<Clientes> listac= ClientesJSON.getJSON();
				for(Clientes clientes:listac) {
					if (clientes.getCedula_cliente()==(id)) {
						request.setAttribute("clienteSeleccionado", clientes); 	}
				}	
			} catch (Exception e) {
					e.printStackTrace();
					}
		}	
		public void buscarProducto(Long cod,HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			try {
				ArrayList<Productos> listap= ProductosJSON.getJSON();
				for(Productos productos:listap) {
					if (productos.getCodigo_producto()==(cod)) {					
						request.setAttribute("productoSeleccionado", productos); //envio a ventas
					}
				}
			} catch (Exception e) {
					e.printStackTrace();
					}
		}
		
		public void buscarFactura(String numFact,HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException { 
			if(numFact==null) {
				numfac=Integer.parseInt(numFact)+1; //variable declarada arriba con valor 0
			}
			else {
				numfac=Integer.parseInt(numFact)+1; //cuando ya tiene valor la variable
			}
			request.setAttribute("numerofactura", numfac);
			
		}
		
		public void grabarDetalle(Long numFact,HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			for(int i=0; i<listaVentas.size();i++) {
				detalle_venta = new DetalleVenta();
				detalle_venta.setCodigo_detalle_venta(Long.valueOf(i+1));
				detalle_venta.setCodigo_venta(numFact);
				detalle_venta.setCodigo_producto(listaVentas.get(i).getCodigo_producto());
				detalle_venta.setCantidad_producto(listaVentas.get(i).getCantidad_producto());
				detalle_venta.setValor_total(listaVentas.get(i).getValor_total());
				detalle_venta.setValor_venta(listaVentas.get(i).getValor_venta());
				detalle_venta.setValor_iva(listaVentas.get(i).getValor_iva());
				
				int respuesta =0;
				try {
					respuesta= DetalleVentaJSON.postJSON(detalle_venta);
					PrintWriter write= response.getWriter();
					if (respuesta==200) {
						System.out.println("Registros Grabados detalle ventas");
					}else {
						write.println("Error Detall venta" +respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
			}
		}
		//*******************************************************************************


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String menu = request.getParameter("menu");
		String accion = request.getParameter("accion");

		switch (menu) {
		case "Principal":
			request.getRequestDispatcher("/Principal.jsp").forward(request, response);
			break;
		case "Usuarios":
			if (accion.equals("Listar")) {
				try {
					ArrayList<Usuarios> lista = UsuariosJSON.getJSON();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				Usuarios usuario = new Usuarios();
				usuario.setCedula_usuario(Long.parseLong(request.getParameter("txtcedula")));
				usuario.setNombre_usuario(request.getParameter("txtnombre"));
				usuario.setEmail_usuario(request.getParameter("txtemail"));
				usuario.setUsuario(request.getParameter("txtusuario"));
				usuario.setPassword(request.getParameter("txtpassword"));

				int respuesta = 0;
				try {
					respuesta = UsuariosJSON.postJSON(usuario);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
								response);
						
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Actualizar")) {
				Usuarios usuario = new Usuarios();
				usuario.setCedula_usuario(Long.parseLong(request.getParameter("txtcedula")));
				usuario.setNombre_usuario(request.getParameter("txtnombre"));
				usuario.setEmail_usuario(request.getParameter("txtemail"));
				usuario.setUsuario(request.getParameter("txtusuario"));
				usuario.setPassword(request.getParameter("txtpassword"));

				int respuesta = 0;
				try {
					respuesta = UsuariosJSON.putJSON(usuario, usuario.getCedula_usuario());
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Cargar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				try {
					ArrayList<Usuarios> lista1 = UsuariosJSON.getJSON();
					System.out.println("Parametro: " + id);
					for (Usuarios usuarios : lista1) {
						if (usuarios.getCedula_usuario() == id) {
							request.setAttribute("usuarioSeleccionado", usuarios);
							request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
									response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				try {
					respuesta = UsuariosJSON.deleteJSON(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("/GUsuarios.jsp").forward(request, response);
			break;
		case "Clientes":
			if (accion.equals("Listar")) {
				try {
					ArrayList<Clientes> lista = ClientesJSON.getJSON();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				Clientes clientes = new Clientes();
				clientes.setCedula_cliente(Long.parseLong(request.getParameter("txtcedula")));
				clientes.setNombre_cliente(request.getParameter("txtnombre"));
				clientes.setEmail_cliente(request.getParameter("txtemail"));
				clientes.setDireccion_cliente(request.getParameter("txtdireccion"));
				clientes.setTelefono_cliente(request.getParameter("txttelefono"));

				int respuesta = 0;
				try {
					respuesta = ClientesJSON.postJSON(clientes);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
								response);
						
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Actualizar")) {
				Clientes clientes = new Clientes();
				clientes.setCedula_cliente(Long.parseLong(request.getParameter("txtcedula")));
				clientes.setNombre_cliente(request.getParameter("txtnombre"));
				clientes.setEmail_cliente(request.getParameter("txtemail"));
				clientes.setDireccion_cliente(request.getParameter("txtdireccion"));
				clientes.setTelefono_cliente(request.getParameter("txttelefono"));

				int respuesta = 0;
				try {
					respuesta = ClientesJSON.putJSON(clientes, clientes.getCedula_cliente());
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Cargar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				try {
					ArrayList<Clientes> lista1 = ClientesJSON.getJSON();
//					System.out.println("Parametro: " + id);
					for (Clientes clientes : lista1) {
						if (clientes.getCedula_cliente() == id) {
							request.setAttribute("clienteSeleccionado", clientes);
							request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
									response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				try {
					respuesta = ClientesJSON.deleteJSON(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("/GClientes.jsp").forward(request, response);
			break;
		case "Proveedores":
			if (accion.equals("Listar")) {

				try {
					ArrayList<Proveedores> lista = ProveedoresJSON.getJSON();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				Proveedores proveedor = new Proveedores();
				proveedor.setNit_proveedor(Long.parseLong(request.getParameter("txtnit")));
				proveedor.setNombre_proveedor(request.getParameter("txtnombre"));
				proveedor.setCiudad_proveedor(request.getParameter("txtciudad"));
				proveedor.setDireccion_proveedor(request.getParameter("txtdireccion"));
				proveedor.setTelefono_proveedor(request.getParameter("txttelefono"));
				PrintWriter writer = response.getWriter();
				int respuesta = 0;
				try {
					respuesta = ProveedoresJSON.postJSON(proveedor);
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
								response);

					} else {
						writer.println("Error: " + respuesta);
					}
					writer.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Actualizar")) {
				Proveedores proveedor = new Proveedores();
				proveedor.setNit_proveedor(Long.parseLong(request.getParameter("txtnit")));
				proveedor.setNombre_proveedor(request.getParameter("txtnombre"));
				proveedor.setCiudad_proveedor(request.getParameter("txtciudad"));
				proveedor.setDireccion_proveedor(request.getParameter("txtdireccion"));
				proveedor.setTelefono_proveedor(request.getParameter("txttelefono"));

				int respuesta = 0;
				try {
					respuesta = ProveedoresJSON.putJSON(proveedor, proveedor.getNit_proveedor());
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Cargar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				try {
					ArrayList<Proveedores> lista1 = ProveedoresJSON.getJSON();
					System.out.println("Parametro: " + id);
					for (Proveedores proveedores : lista1) {
						if (proveedores.getNit_proveedor() == id) {
							request.setAttribute("proveedoresSeleccionado", proveedores);
							request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
									response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				try {
					respuesta = ProveedoresJSON.deleteJSON(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("/GProveedores.jsp").forward(request, response);
			break;
		case "Productos":
			if (accion.equals("Listar")) { // era minuscula

				try {
					ArrayList<Productos> lista = ProductosJSON.getJSON();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				Productos producto = new Productos();
				producto.setCodigo_producto(Long.parseLong(request.getParameter("txtcodigoproducto")));
				producto.setIva_Compra(Double.parseDouble(request.getParameter("txtivacompra")));
				producto.setNit_proveedor(Long.parseLong(request.getParameter("txtnitproveedor")));
				producto.setNombre_producto(request.getParameter("txtnombreproducto"));
				producto.setPrecio_Compra(Double.parseDouble(request.getParameter("txtpreciocompra")));
				producto.setPrecio_Venta(Double.parseDouble(request.getParameter("txtprecioventa")));
				
				PrintWriter writer = response.getWriter();
				int respuesta = 0;
				try {
					respuesta = ProductosJSON.postJSON(producto);
					if (respuesta == 200) {
						writer.println("Producto agregado!");
						request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
								response);

					} else {
						writer.println("Error: " + respuesta);
					}
					writer.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Actualizar")) {
				Productos producto = new Productos();
				producto.setCodigo_producto(Long.parseLong(request.getParameter("txtcodigoproducto")));
				producto.setIva_Compra(Double.parseDouble(request.getParameter("txtivacompra")));
				producto.setNit_proveedor(Long.parseLong(request.getParameter("txtnitproveedor")));
				producto.setNombre_producto(request.getParameter("txtnombreproducto"));
				producto.setPrecio_Compra(Double.parseDouble(request.getParameter("txtpreciocompra")));
				producto.setPrecio_Venta(Double.parseDouble(request.getParameter("txtprecioventa")));
				

				int respuesta = 0;
				try {
					respuesta = ProductosJSON.putJSON(producto, producto.getCodigo_producto());
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Cargar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				try {
					ArrayList<Productos> lista1 = ProductosJSON.getJSON();
					System.out.println("Parametro: " + id);
					for (Productos productos : lista1) {
						if (productos.getCodigo_producto()==id) {
							request.setAttribute("productoSeleccionado", productos);
							request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
									response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				try {
					respuesta = ProductosJSON.deleteJSON(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			request.getRequestDispatcher("/GProductos.jsp").forward(request, response);
			break;


		case "Ventas":
			//******************** enviaremos la cedula del usuario al formulario ventas
			request.setAttribute("usuarioSeleccionado", usuarios);
		//***********************************************************************
		
		//******************** enviaremos la Numero de Factura ******************
			request.setAttribute("numerofactura",numfac);
		//***********************************************************************
		if(accion.equals("BuscarCliente")) {
			String id=request.getParameter("cedulacliente");//como esta en ventas
			this.buscarCliente(Long.parseLong(id), request, response);
		}else if(accion.equals("BuscarProducto")) {
			String id=request.getParameter("cedulacliente");//como esta en ventas y lo repite
			this.buscarCliente(Long.parseLong(id), request, response);
							
			String cod=request.getParameter("codigoproducto");//como esta en ventas
			this.buscarProducto(Long.parseLong(cod), request, response);
			
		}else if(accion.equals("AgregarProducto")) {
			String id=request.getParameter("cedulacliente");//como esta en ventas y lo repite
			this.buscarCliente(Long.parseLong(id), request, response);
			
			detalle_venta= new DetalleVenta(); 
			item++; 
			acusubtotal=0;
			subtotaliva=0;
			totalapagar=0;
			codProducto=Long.parseLong(request.getParameter("codigoproducto")); 
			descripcion=request.getParameter("nombreproducto");
			precio=Long.parseLong(request.getParameter("precioproducto"));
			cantidad=Integer.parseInt(request.getParameter("cantidadproducto"));
			iva=Long.parseLong(request.getParameter("ivaproducto"));
			
			subtotal=(precio*cantidad);
			valor_iva=subtotal*iva/100;
			
			/*detalle_venta.setCodigo_detalle_venta(String.valueOf(item));
			detalle_venta.setCodigo_producto(codProducto);
			detalle_venta.(descripcion);
			detalle_venta.setPrecio_producto(precio);
			detalle_venta.setCantidad_producto(cantidad);
			detalle_venta.setCodigo_venta(numfac);
			detalle_venta.setValor_iva(valor_iva);
			detalle_venta.setValor_venta(subtotal);
			listaVentas.add(detalle_venta);*/
			
			for(int i=0; i<listaVentas.size();i++) {
				acusubtotal += listaVentas.get(i).getValor_venta();
				subtotaliva += listaVentas.get(i).getValor_iva();
			}
			totalapagar = acusubtotal + subtotaliva;
			detalle_venta.setValor_total(totalapagar);
			//una vez hecho todos los calculos ahora hacemos el envio de la info al formulario ventas seccion2
			request.setAttribute("listaventas", listaVentas);
			request.setAttribute("totalsubtotal", acusubtotal);
			request.setAttribute("totaliva", subtotaliva);
			request.setAttribute("totalapagar", totalapagar);
			
		}else if(accion.equals("GenerarVenta")) {
			cedulaCliente= request.getParameter("cedulacliente");
			String numFact=request.getParameter("numerofactura");
			Ventas ventas =new Ventas();
			ventas.setCodigo_venta(Long.parseLong(numFact));
			ventas.setCedula_cliente(Long.parseLong(cedulaCliente));
			ventas.setCedula_usuario(usuarios.getCedula_usuario());
			ventas.setIva_venta(subtotaliva);
			ventas.setValor_venta(acusubtotal);
			ventas.setTotal_venta(totalapagar);
			
			int respuesta=0;
			try {
				respuesta=VentasJSON.postJSON(ventas);
				PrintWriter write=response.getWriter();
				if(respuesta==200) {
					System.out.println("Grabacion Exitosa " + respuesta);
					this.grabarDetalle(ventas.getCodigo_venta(), request, response);
				}else {
					write.println("error ventas");
				}
				write.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			//*********** muestro factura por primera vez ******
			String factura= "0"; //	request.setAttribute("numerofactura");
			//String factura= request.gesetAttribute("numerofactura");
			this.buscarFactura(factura, request, response);
		}
		
		request.getRequestDispatcher("/Ventas.jsp").forward(request, response);
		break;
	}

	}
}
package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.unbosque.jsoncontroller.ProductosJSON;
import co.edu.unbosque.model.Productos;

/**
 * Servlet implementation class ProductosServlet
 */
@WebServlet("/ProductosServlet")
public class ProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public ProductosServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String listar = request.getParameter("Listar");
		String agregar = request.getParameter("crear");
		
		if (agregar != null) {
			agregarProducto(request, response);
		}

		if (listar != null) {
			listarProductos(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void agregarProducto(HttpServletRequest request, HttpServletResponse response) {
		Productos producto = new Productos();
		producto.setCodigo_producto(Long.parseLong(request.getParameter("txtcodigoproducto")));
		producto.setIva_Compra(Double.parseDouble(request.getParameter("txtivacompra")));
		producto.setNit_proveedor(Long.parseLong(request.getParameter("txtnitproveedor")));
		producto.setNombre_producto(request.getParameter("txtnombreproducto"));
		producto.setPrecio_Compra(Double.parseDouble(request.getParameter("txtpreciocompra")));
		producto.setPrecio_Venta(Double.parseDouble(request.getParameter("txtprecioventa")));
		int respuesta = 0;
		try {
			respuesta = ProductosJSON.postJSON(producto);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				writer.println("Producto agregado!");
			} else {
				writer.println("Error: " + respuesta);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listarProductos(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Productos> lista = ProductosJSON.getJSON();
			String pagina = "/resultado.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}

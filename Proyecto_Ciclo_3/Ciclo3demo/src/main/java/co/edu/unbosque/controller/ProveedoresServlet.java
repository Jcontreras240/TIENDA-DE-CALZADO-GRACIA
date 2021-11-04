package co.edu.unbosque.controller;

import javax.servlet.*;
import javax.servlet.http.*;

import co.edu.unbosque.jsoncontroller.ProveedoresJSON;
import co.edu.unbosque.model.Proveedores;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/Proveedores")
public class ProveedoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProveedoresServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String listar = request.getParameter("Listar");
		String agregar = request.getParameter("crear");
		
		if (agregar != null) {
			agregarProveedor(request, response);
		}

		if (listar != null) {
			listarProveedor(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void agregarProveedor(HttpServletRequest request, HttpServletResponse response) {
		Proveedores proveedor = new Proveedores();
		proveedor.setNit_proveedor(Long.parseLong(request.getParameter("txtnit")));
		proveedor.setNombre_proveedor(request.getParameter("txtnombre"));
		proveedor.setCiudad_proveedor(request.getParameter("txtciudad"));
		proveedor.setDireccion_proveedor(request.getParameter("txtdireccion"));
		proveedor.setTelefono_proveedor(request.getParameter("txttelefono"));
		int respuesta = 0;
		try {
			respuesta = ProveedoresJSON.postJSON(proveedor);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200) {
				writer.println("Registro agregado!");
			} else {
				writer.println("Error: " + respuesta);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listarProveedor(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Proveedores> lista = ProveedoresJSON.getJSON();
			String pagina = "/resultado.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

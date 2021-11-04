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

import co.edu.unbosque.jsoncontroller.VentasJSON;
import co.edu.unbosque.model.Ventas;

@WebServlet("/VentasServlet")
public class VentasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VentasServlet() {
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
		String eliminar = request.getParameter("eliminar");
		if (agregar != null) {
			agregarVentas(request, response);
		}

		if (listar != null) {
			listarVentas(request, response);
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

	public void agregarVentas(HttpServletRequest request, HttpServletResponse response) {
		Ventas ventas = new Ventas();
		ventas.setCodigo_venta(Long.parseLong(request.getParameter("codigo_venta")));
		ventas.setCedula_cliente(Long.parseLong(request.getParameter("cedula_cliente")));
		ventas.setCedula_usuario(Long.parseLong(request.getParameter("cedula_usuario")));
		ventas.setIva_venta(Double.parseDouble(request.getParameter("iva_venta")));
		ventas.setTotal_venta(Double.parseDouble(request.getParameter("total_venta")));
		ventas.setValor_venta(Double.parseDouble(request.getParameter("valor_venta")));
		int respuesta = 0;
		try {
			respuesta =VentasJSON.postJSON(ventas);
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

	public void listarVentas(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Ventas> lista = VentasJSON.getJSON();
			String pagina = "/resultado.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

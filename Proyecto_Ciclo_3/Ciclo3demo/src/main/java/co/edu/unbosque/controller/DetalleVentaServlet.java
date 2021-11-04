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

import co.edu.unbosque.jsoncontroller.DetalleVentaJSON;
import co.edu.unbosque.model.DetalleVenta;

/**
 * Servlet implementation class DetalleVentaServlet
 */
@WebServlet("/DetalleVentaServlet")
public class DetalleVentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleVentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String listar = request.getParameter("Listar");
		String agregar = request.getParameter("crear");
		
		if (agregar != null) {
			agregarDetalleVenta(request, response);
		}

		if (listar != null) {
			listarDetalleVenta(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	public void agregarDetalleVenta(HttpServletRequest request, HttpServletResponse response) {
		DetalleVenta detalleVenta = new DetalleVenta();
		detalleVenta.setCodigo_detalle_venta(Long.parseLong(request.getParameter("codigo_detalle_venta")));
		detalleVenta.setCantidad_producto(Integer.parseInt(request.getParameter("cantidad_producto")));
		detalleVenta.setCodigo_producto(Long.parseLong(request.getParameter("codigo_producto")));
		detalleVenta.setCodigo_venta(Long.parseLong(request.getParameter("codigo_venta")));
		detalleVenta.setValor_total(Double.parseDouble(request.getParameter("valor_total")));
		detalleVenta.setValor_venta(Double.parseDouble(request.getParameter("valor_venta")));
		detalleVenta.setValor_iva(Double.parseDouble(request.getParameter("valor_iva")));
		int respuesta = 0;
		try {
			respuesta = DetalleVentaJSON.postJSON(detalleVenta);
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

	public void listarDetalleVenta(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<DetalleVenta> lista = DetalleVentaJSON.getJSON();
			String pagina = "/resultado.jsp";
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	
	
	
}

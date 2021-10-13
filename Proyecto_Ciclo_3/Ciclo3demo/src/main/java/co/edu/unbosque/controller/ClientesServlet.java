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

import co.edu.unbosque.jsoncontroller.ClientesJSON;
import co.edu.unbosque.model.Clientes;

/**
 * Servlet implementation class ClientesServlet
 */
@WebServlet("/clientes")
public class ClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String listar = request.getParameter("Listar");
        String agregar = request.getParameter("Crear");
        String eliminar = request.getParameter("Eliminar");
        if (agregar != null) {
        	agregarCliente(request, response);
        }
        
        if (listar != null) {
        	listarClientes(request, response);
        }
        
//        if (eliminar != null) {
//        	EliminarClientes(request, response);
//        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void agregarCliente(HttpServletRequest request, HttpServletResponse response) {
		Clientes cliente = new Clientes();
		cliente.setCedula_cliente(Long.parseLong(request.getParameter("cedula")));
		cliente.setNombre_cliente(request.getParameter("nombre"));
		cliente.setEmail_cliente(request.getParameter("email"));
		cliente.setDireccion_cliente(request.getParameter("direccion"));		
		cliente.setTelefono_cliente(request.getParameter("telefono"));
		int respuesta = 0;
		try {
			respuesta = ClientesJSON.postJSON(cliente);
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
    
    
    public void listarClientes(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		ArrayList<Clientes> lista = ClientesJSON.getJSON();
    		String pagina = "/resultado.jsp";
    		request.setAttribute("lista", lista);
    		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
    		dispatcher.forward(request, response);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

}

package co.edu.unbosque.controller;

import javax.servlet.*;
import javax.servlet.http.*;

import co.edu.unbosque.jsoncontroller.UsuariosJSON;
import co.edu.unbosque.model.Usuarios;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/Usuarios")
public class UsuariosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuariosServlet() {
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
        String eliminar = request.getParameter("eliminar");
        if (agregar != null) {
        	agregarUsuario(request, response);
        }
        
        if (listar != null) {
        	listarUsuarios(request, response);
        }
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    
    public void agregarUsuario(HttpServletRequest request, HttpServletResponse response) {
		Usuarios usuario = new Usuarios();
		usuario.setNombre_usuario(request.getParameter("nombre"));
		usuario.setCedula_usuario(Long.parseLong(request.getParameter("cedula")));
		usuario.setEmail_usuario(request.getParameter("email"));
		usuario.setUsuario(request.getParameter("usuario"));
		usuario.setPassword(request.getParameter("password"));
		int respuesta = 0;
		try {
			respuesta = UsuariosJSON.postJSON(usuario);
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
    
    
    public void listarUsuarios(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		ArrayList<Usuarios> lista = UsuariosJSON.getJSON();
    		String pagina = "/resultado.jsp";
    		request.setAttribute("lista", lista);
    		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
    		dispatcher.forward(request, response);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

}

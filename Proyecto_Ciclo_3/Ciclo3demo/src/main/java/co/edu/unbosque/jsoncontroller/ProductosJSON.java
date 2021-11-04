package co.edu.unbosque.jsoncontroller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import co.edu.unbosque.model.Productos;

public class ProductosJSON {
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	//private static String sitio = "http://localhost:8080/back_TiendaDeCalzado 0.0.1-SNAPSHOT/";
	
	public static ArrayList<Productos> parsingProductos(String json) throws ParseException {
		 JSONParser jsonParser = new JSONParser();
		 ArrayList<Productos> lista = new ArrayList<Productos>();
		 JSONArray Productos = (JSONArray) jsonParser.parse(json);
		 Iterator i = Productos.iterator();
		 while (i.hasNext()) {
			 JSONObject innerObj = (JSONObject) i.next();
			 Productos producto = new Productos();
			 producto.setCodigo_producto((Long)innerObj.get("id"));			 
			 producto.setNombre_producto(innerObj.get("nombre_producto").toString());			 
			 producto.setPrecio_Compra((Double)innerObj.get("precio_compra"));
			 producto.setIva_Compra((Double)innerObj.get("iva_compra"));
			 producto.setPrecio_Venta((Double)innerObj.get("precio_venta"));
			 producto.setNit_proveedor((Long)innerObj.get("nit_proveedor"));
			 lista.add(producto);
		 }
		 return lista;
	}
	
	public static ArrayList<Productos> getJSON() throws IOException, ParseException{
		url = new URL(sitio + "productos/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<Productos> lista = new ArrayList<Productos>();
		lista = parsingProductos(json);
		http.disconnect();
		return lista;
	}
	
	public static int postJSON(Productos producto) throws IOException {
		url = new URL(sitio + "productos/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		try {
			http.setRequestMethod("POST");
		} catch (ProtocolException e) {
				e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		String data = "{"
				+ "\"codigo_producto\":\""+ producto.getCodigo_producto()
				+"\",\"iva_compra\":\""+producto.getIva_Compra()
				+"\",\"nit_proveedor\":\""+producto.getNit_proveedor()
				+"\",\"nombre_producto\": \""+producto.getNombre_producto()
				+"\",\"precio_compra\": \""+producto.getPrecio_Compra()
				+"\",\"precio_venta\":\""+producto.getPrecio_Venta()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	public static int putJSON(Productos productos, Long id) throws IOException {

		url = new URL(sitio + "productos/actualizar");
		HttpURLConnection http; // una variable de tipo conexion
		http = (HttpURLConnection) url.openConnection(); // abrimos la conexion

		try {
			http.setRequestMethod("PUT"); // el put es estrictamente para actualizar la informacion, viene
											// predeterminada en el Json
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json"); // se realiza una peticion tipo aplicacion json
		http.setRequestProperty("Content-Type", "application/json");

		String data = "{" 
				+ "\"codigo_producto\":\"" + productos.getCodigo_producto()
				+ "\",\"iva_compra\": \"" + productos.getIva_Compra() 
				+ "\",\"nit_proveedor\": \"" + productos.getNit_proveedor()
				+ "\",\"nombre_producto\":\"" + productos.getNombre_producto() 
				+ "\",\"precio_compra\":\"" + productos.getPrecio_Compra() 
				+ "\",\"precio_venta\":\""+ productos.getPrecio_Venta()
				+"\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta; //el valor de respuesta correcta es 200
	}

	
	public static int deleteJSON(Long id) throws IOException {

		url = new URL(sitio + "productos/Eliminar/"+id); //trae el metodo de Usuarios.API 
		HttpURLConnection http = (HttpURLConnection) url.openConnection();


		try {
			http.setRequestMethod("DELETE");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	

}

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

import co.edu.unbosque.model.Clientes;
import co.edu.unbosque.model.Proveedores;
import co.edu.unbosque.model.Usuarios;

public class ProveedoresJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<Proveedores> parsingProveedores(String json) throws ParseException {
		 JSONParser jsonParser = new JSONParser();
		 ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		 JSONArray proveedores = (JSONArray) jsonParser.parse(json);
		 Iterator i = proveedores.iterator();
		 while (i.hasNext()) {
			 JSONObject innerObj = (JSONObject) i.next();
			 Proveedores proveedor = new Proveedores();
			 proveedor.setNit_proveedor((Long) innerObj.get("nit_proveedor"));
			 proveedor.setDireccion_proveedor(innerObj.get("direccion_proveedor").toString());
			 proveedor.setCiudad_proveedor(innerObj.get("ciudad_proveedor").toString());
			 proveedor.setNombre_proveedor(innerObj.get("nombre_proveedor").toString());
			 proveedor.setTelefono_proveedor((Long) innerObj.get("telefono_proveedor"));
			 lista.add(proveedor);
		 }
		 return lista;
	}
	
	public static ArrayList<Proveedores> getJSON() throws IOException, ParseException{
		url = new URL(sitio + "proveedores/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		lista = parsingProveedores(json);
		http.disconnect();
		return lista;
	}
	
	public static int postJSON(Proveedores proveedores) throws IOException {
		url = new URL(sitio + "proveedores/guardar");
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
				+ "\"nit_proveedor\":\""+ proveedores.getNit_proveedor()
				+"\",\"direccion_proveedor\": \""+proveedores.getDireccion_proveedor()
				+"\",\"ciudad_proveedor\": \""+proveedores.getCiudad_proveedor()
				+"\",\"nombre_proveedor\":\""+proveedores.getNombre_proveedor()
				+"\",\"telefono_proveedor\":\""+proveedores.getTelefono_proveedor()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

public static int putJSON(Proveedores proveedores, Long id) throws IOException {
		
		
		url = new URL(sitio+"proveedores/actualizar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		
		try {
		  http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
		  e.printStackTrace();
		}
		
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		
		String data = "{"
				+ "\"nit_proveedor\":\""+ proveedores.getNit_proveedor()
				+"\",\"direccion_proveedor\": \""+proveedores.getDireccion_proveedor()
				+"\",\"ciudad_proveedor\": \""+proveedores.getCiudad_proveedor()
				+"\",\"nombre_proveedor\":\""+proveedores.getNombre_proveedor()
				+"\",\"telefono_proveedor\":\""+proveedores.getTelefono_proveedor()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}


public static int deleteJSON(Long id) throws IOException {

	url = new URL(sitio + "proveedores/eliminar/" + id);
	HttpURLConnection http;
	http = (HttpURLConnection) url.openConnection();

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


public static ArrayList<Proveedores> findByIdJSON(Long id) throws IOException, ParseException{
	url = new URL(sitio + "proveedores/consultar/"+id);
	HttpURLConnection http = (HttpURLConnection)url.openConnection();
	http.setRequestMethod("GET");
	http.setRequestProperty("Accept", "application/json");
	InputStream respuesta = http.getInputStream();
	byte[] inp = respuesta.readAllBytes();
	String json = "";
	for (int i = 0; i<inp.length ; i++) {
		json += (char)inp[i];
	}
	ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
	lista = parsingProveedores(json);
	http.disconnect();
	return lista;
}

}

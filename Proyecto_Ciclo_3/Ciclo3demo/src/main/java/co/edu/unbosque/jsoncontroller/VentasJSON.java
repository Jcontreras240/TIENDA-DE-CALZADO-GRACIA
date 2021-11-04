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

import co.edu.unbosque.model.Proveedores;
import co.edu.unbosque.model.Ventas;

public class VentasJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	//private static String sitio = "http://localhost:8080/back_TiendaDeCalzado 0.0.1-SNAPSHOT/";
	
	public static int postJSON(Ventas ventas) throws IOException {
		url = new URL(sitio + "ventas/guardar");
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
				+ "\"codigo_venta\":\""+ String.valueOf(ventas.getCodigo_venta())
				+"\",\"cedula_cliente\": \""+String.valueOf(ventas.getCedula_cliente())
				+"\",\"cedula_usuario\": \""+String.valueOf(ventas.getCedula_usuario())
				+"\",\"iva_venta\":\""+String.valueOf(ventas.getIva_venta())
				+"\",\"total_venta\":\""+String.valueOf(ventas.getTotal_venta())
				+"\",\"valor_venta\":\""+String.valueOf(ventas.getValor_venta())
				+ "\"}";
				
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	public static ArrayList<Ventas> parsingVentas(String json) throws ParseException {
		 JSONParser jsonParser = new JSONParser();
		 ArrayList<Ventas> lista = new ArrayList<Ventas>();
		 JSONArray venta = (JSONArray) jsonParser.parse(json);
		 Iterator i = venta.iterator();
		 while (i.hasNext()) {
			 JSONObject innerObj = (JSONObject) i.next();
			 Ventas ventas = new Ventas();
			 ventas.setCodigo_venta((Long) innerObj.get("codigo_venta"));
			 ventas.setCedula_cliente((Long)innerObj.get("cedula_cliente"));
			 ventas.setCedula_usuario((Long)innerObj.get("cedula_usuario"));
			 ventas.setIva_venta((Double)innerObj.get("iva_venta"));
			 ventas.setTotal_venta((Double)innerObj.get("total_venta"));
			 ventas.setValor_venta((Double)innerObj.get("valor_venta"));
			 lista.add(ventas);
		 }
		 return lista;
	}
	
	public static ArrayList<Ventas> getJSON() throws IOException, ParseException{
		url = new URL(sitio + "ventas/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<Ventas> lista = new ArrayList<Ventas>();
		lista = parsingVentas(json);
		http.disconnect();
		return lista;
	}
	
	

}

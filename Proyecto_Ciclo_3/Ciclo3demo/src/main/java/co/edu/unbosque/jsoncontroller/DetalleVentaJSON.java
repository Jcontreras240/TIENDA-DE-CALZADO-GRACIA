package co.edu.unbosque.jsoncontroller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import co.edu.unbosque.model.DetalleVenta;

public class DetalleVentaJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";


	public static int postJSON(DetalleVenta detalleVenta) throws IOException {
		url = new URL(sitio + "detalleVenta/guardar");
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
				+ "\"codigo_detalle_venta\":\""+ String.valueOf(detalleVenta.getCodigo_detalle_venta())
				+"\",\"cantidad_producto\": \""+String.valueOf(detalleVenta.getCantidad_producto())
				+"\",\"codigo_producto\": \""+String.valueOf(detalleVenta.getCodigo_producto())
				+"\",\"codigo_venta\":\""+String.valueOf(detalleVenta.getCodigo_venta())
				+"\",\"valor_total\":\""+String.valueOf(detalleVenta.getValor_total())
				+"\",\"valor_venta\":\""+String.valueOf(detalleVenta.getValor_venta())
				+"\",\"valor_iva\":\""+String.valueOf(detalleVenta.getValor_iva())
				
				+ "\"}";
				
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	

}
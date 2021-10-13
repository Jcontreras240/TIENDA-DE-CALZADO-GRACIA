package co.edu.unbosque.model;

public class Productos {
	
	private long id;	
	private String nombre_producto;	
	private double precio_Compra;
	private double precio_Venta;
	private double iva_Compra;
	
	public Productos(long id, String nombre_producto, double precio_Compra, double precio_Venta, double iva_Compra) {
		super();
		this.id = id;
		this.nombre_producto = nombre_producto;
		this.precio_Compra = precio_Compra;
		this.precio_Venta = precio_Venta;
		this.iva_Compra = iva_Compra;
		
	}
	
	public Productos() {		
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public double getPrecio_Compra() {
		return precio_Compra;
	}
	public void setPrecio_Compra(double precio_Compra) {
		this.precio_Compra = precio_Compra;
	}
	public double getPrecio_Venta() {
		return precio_Venta;
	}
	public void setPrecio_Venta(double precio_Venta) {
		this.precio_Venta = precio_Venta;
	}
	public double getIva_Compra() {
		return iva_Compra;
	}
	public void setIva_Compra(double iva_Compra) {
		this.iva_Compra = iva_Compra;
	}
	@Override
	public String toString() {
		return "Productos [id=" + id + ", nombre_producto=" + nombre_producto + ", precio_Compra=" + precio_Compra
				+ ", precio_Venta=" + precio_Venta + ", iva_Compra=" + iva_Compra + "]";
	}

	
	


}
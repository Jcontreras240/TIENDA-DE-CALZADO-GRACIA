package co.edu.unbosque.model;

public class Productos {
	
	private Long codigo_producto;
	private Double iva_Compra;
	private Long nit_proveedor;
	private String nombre_producto;	
	private Double precio_Compra;
	private Double precio_Venta;
	
	
	public Productos() {
		
	}
	
	public Productos(Long codigo_producto,Long nit_proveedor, String nombre_producto, Double precio_Compra, Double precio_Venta, Double iva_Compra) {
		this.codigo_producto = codigo_producto;
		this.nombre_producto = nombre_producto;
		this.precio_Compra = precio_Compra;
		this.precio_Venta = precio_Venta;
		this.iva_Compra = iva_Compra;
		this.nit_proveedor = nit_proveedor;
		
	}
		
		public Long getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Long codigo_producto) {
		this.codigo_producto = codigo_producto;
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

	public void setPrecio_Compra(Double precio_Compra) {
		this.precio_Compra = precio_Compra;
	}

	public double getPrecio_Venta() {
		return precio_Venta;
	}

	public void setPrecio_Venta(Double precio_Venta) {
		this.precio_Venta = precio_Venta;
	}

	public double getIva_Compra() {
		return iva_Compra;
	}

	public void setIva_Compra(Double iva_Compra) {
		this.iva_Compra = iva_Compra;
	}

	public Long getNit_proveedor() {
		return nit_proveedor;
	}

	public void setNit_proveedor(Long nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}

		@Override
	public String toString() {
		return "Productos [codigo_producto=" + codigo_producto + ", nit_proveedor=\" + nit_proveedor + \",nombre_producto=" + nombre_producto + ", precio_Compra=" + precio_Compra
				+ ", precio_Venta=" + precio_Venta + ", iva_Compra=" + iva_Compra + "]";
	}

	
	


}
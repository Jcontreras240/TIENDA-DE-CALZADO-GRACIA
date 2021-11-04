package co.edu.unbosque.ciclo3back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "productos")
public class Productos {

	@Id
	@Column(name = "codigo_producto")
	private Long codigo_producto;

	@Column(name = "nombre_producto")
	private String nombre_producto;

	@Column(name = "precio_compra", nullable = false)
	private Double precio_Compra;

	@Column(name = "precio_venta", nullable = false)
	private Double precio_Venta;

	@Column(name = "iva_Compra", nullable = false)
	private Double iva_Compra;

	@Column(name = "nit_proveedor")
	private Long nit_proveedor;
	
	public Productos() {
	}

	public Productos(Long codigo_producto, String nombre_producto, Double precio_Compra, Double precio_Venta, Double iva_Compra, Long nit_proveedor) {
		this.codigo_producto = codigo_producto;
		this.nombre_producto = nombre_producto;
		this.precio_Compra = precio_Compra;
		this.precio_Venta = precio_Venta;
		this.iva_Compra = iva_Compra;
		this.nit_proveedor=nit_proveedor;

	}

	public Long getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public String getNombre() {
		return nombre_producto;
	}

	public void setNombre(String nombre) {
		this.nombre_producto = nombre;
	}

	public double getPrecioCompra() {
		return precio_Compra;
	}

	public void setPrecioCompra(Double precioCompra) {
		this.precio_Compra = precioCompra;
	}

	public double getPrecioVenta() {
		return precio_Venta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precio_Venta = precioVenta;
	}

	public double getIvaCompra() {
		return iva_Compra;
	}

	public void setIvaCompra(Double ivaCompra) {
		this.iva_Compra = ivaCompra;
	}
	public Long getNit_proveedor() {
		return nit_proveedor;
	}

	public void setNit_proveedor(Long nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}
	@Override
	public String toString() {
		return "Producto [codigo_producto=" + codigo_producto + ", nombre_producto=" + nombre_producto + ", precio_Compra=" + precio_Compra
				+ ", precio_Venta=" + precio_Venta + ", iva_Compra=" + iva_Compra + ",nit_proveedor=" + nit_proveedor + ",]";
	}

}
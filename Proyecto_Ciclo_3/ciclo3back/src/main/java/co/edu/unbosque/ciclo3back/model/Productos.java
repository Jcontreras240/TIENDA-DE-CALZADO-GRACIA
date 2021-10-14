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
	private long id;

	@Column(name = "nombre_producto")
	private String nombre_producto;

	@Column(name = "precio_compra", nullable = false)
	private double precio_Compra;

	@Column(name = "precio_venta", nullable = false)
	private double precio_Venta;

	@Column(name = "iva_Compra", nullable = false)
	private double iva_Compra;

	public Productos() {
	}

	public Productos(long id, String nombre_producto, double precio_Compra, double precio_Venta, double iva_Compra) {
		this.id = id;
		this.nombre_producto = nombre_producto;
		this.precio_Compra = precio_Compra;
		this.precio_Venta = precio_Venta;
		this.iva_Compra = iva_Compra;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public void setPrecioCompra(double precioCompra) {
		this.precio_Compra = precioCompra;
	}

	public double getPrecioVenta() {
		return precio_Venta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precio_Venta = precioVenta;
	}

	public double getIvaCompra() {
		return iva_Compra;
	}

	public void setIvaCompra(double ivaCompra) {
		this.iva_Compra = ivaCompra;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre_producto=" + nombre_producto + ", precio_Compra=" + precio_Compra
				+ ", precio_Venta=" + precio_Venta + ", iva_Compra=" + iva_Compra + "]";
	}

}
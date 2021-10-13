package co.edu.unbosque.ciclo3back.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Detalle_Venta {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)//es el id y se va a generar de manera automatica e incremental, es lo que se dice con este @
	private Integer codigo_detalle_venta;
	private Integer cantidad_producto;
	private Long codigo_producto;
	private Long codigo_venta;
	private Long valor_total;
	private Long valor_venta;
	private Long valor_iva;	
	

}

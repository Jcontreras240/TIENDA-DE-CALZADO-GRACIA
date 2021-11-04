package co.edu.unbosque.ciclo3back.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.ciclo3back.dao.Detalle_VentasDAO;
import co.edu.unbosque.ciclo3back.model.Detalle_Venta;

@RestController
@RequestMapping("detalle_venta")
public class Detalle_VentaAPI {
	
	@Autowired
	private Detalle_VentasDAO detalle_ventasDAO;
	//solo se va a usar en el CRUD ""GUARDAR"
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Detalle_Venta detalle_venta){
				
		
	}
	
	

}

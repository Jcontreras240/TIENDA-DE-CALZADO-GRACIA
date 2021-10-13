package co.edu.unbosque.ciclo3back.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.ciclo3back.dao.VentasDAO;
import co.edu.unbosque.ciclo3back.model.Ventas;

@RestController
@RequestMapping("Ventas")
public class VentasAPI {
	
	@Autowired
	private VentasDAO ventasDao;
	
	@PostMapping("/guardar")	
	public void guargar(@RequestBody Ventas ventas){
		ventasDao.save(ventas);
	}

}

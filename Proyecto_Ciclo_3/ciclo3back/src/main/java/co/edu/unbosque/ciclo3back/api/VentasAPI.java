package co.edu.unbosque.ciclo3back.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/listar")
    public List<Ventas> listar() {
        return ventasDao.findAll();
    }
	
}

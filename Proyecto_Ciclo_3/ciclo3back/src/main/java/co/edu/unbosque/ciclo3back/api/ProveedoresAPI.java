package co.edu.unbosque.ciclo3back.api;

import java.util.List;


import co.edu.unbosque.ciclo3back.dao.ProveedoresDAO;
import co.edu.unbosque.ciclo3back.model.Proveedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("proveedores")
public class ProveedoresAPI {
	
	@Autowired
    private ProveedoresDAO proveedoresDAO;

	@PostMapping("/guardar")
    public void guardar(@RequestBody Proveedores proveedores) {
		proveedoresDAO.save(proveedores);
    }
	
	@GetMapping("/listar")
    public List<Proveedores> listar() {
        return proveedoresDAO.findAll();
    }
	
       @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Long id) {
    	proveedoresDAO.deleteById(id);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody Proveedores usuarios) {
    	proveedoresDAO.save(usuarios);
    }

}
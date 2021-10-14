package co.edu.unbosque.ciclo3back.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.ciclo3back.dao.ProductosDAO;
import co.edu.unbosque.ciclo3back.model.Productos;


@RestController
@RequestMapping("productos")
public class ProductosAPI {
	
	@Autowired
    private ProductosDAO productoDAO;

    @PostMapping("/guardar")
    public void guardar(@RequestBody Productos producto) {
    	productoDAO.save(producto);
    }
    
    @GetMapping("/consultar/{id}")
    public Optional<Productos> consultar(@PathVariable("id") Integer id) {
    	return productoDAO.findById(id);
    }
    
    @GetMapping("/listar")
    public List<Productos> listar() {
        return productoDAO.findAll();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
    	productoDAO.deleteById(id);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody Productos producto) {
    	productoDAO.save(producto);
    }

}

package co.edu.unbosque.ciclo3back.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.edu.unbosque.ciclo3back.dao.ClientesDAO;
import co.edu.unbosque.ciclo3back.model.Clientes;


@RestController
@RequestMapping("clientes")
public class ClientesAPI {
	
	@Autowired
    private ClientesDAO clientesDAO;

    @PostMapping("/guardar")
    public void guardar(@RequestBody Clientes clientes) {
    	clientesDAO.save(clientes);
    }

    @GetMapping("/listar")
    public List<Clientes> listar() {
        return clientesDAO.findAll();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
    	clientesDAO.deleteById(id);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody Clientes usuarios) {
    	clientesDAO.save(usuarios);
    }

}

package co.edu.unbosque.ciclo3back.api;

import co.edu.unbosque.ciclo3back.dao.UsuariosDAO;
import co.edu.unbosque.ciclo3back.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UsuariosAPI {

    @Autowired
    private UsuariosDAO usuariosDAO;

    @PostMapping("/guardar")
    public void guardar(@RequestBody Usuarios usuarios) {
        usuariosDAO.save(usuarios);
    }
    
    @GetMapping("/consultar/{id}")
    public Optional<Usuarios> consultar(@PathVariable("id") Long id) {
    	return usuariosDAO.findById(id);
    }
    
    @GetMapping("/listar")
    public List<Usuarios> listar() {
        return usuariosDAO.findAll();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        usuariosDAO.deleteById(id);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody Usuarios usuarios) {
        usuariosDAO.save(usuarios);
    }

}

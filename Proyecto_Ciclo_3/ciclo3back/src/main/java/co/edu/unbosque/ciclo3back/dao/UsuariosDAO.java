package co.edu.unbosque.ciclo3back.dao;

import co.edu.unbosque.ciclo3back.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosDAO extends JpaRepository<Usuarios, Long> {
}

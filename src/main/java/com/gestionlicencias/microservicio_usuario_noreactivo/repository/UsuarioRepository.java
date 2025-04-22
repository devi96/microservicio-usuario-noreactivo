package com.gestionlicencias.microservicio_usuario_noreactivo.repository;

import com.gestionlicencias.microservicio_usuario_noreactivo.model.Usuario;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
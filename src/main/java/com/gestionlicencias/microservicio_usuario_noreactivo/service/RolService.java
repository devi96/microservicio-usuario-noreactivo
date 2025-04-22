package com.gestionlicencias.microservicio_usuario_noreactivo.service;
import com.gestionlicencias.microservicio_usuario_noreactivo.model.Rol;
import com.gestionlicencias.microservicio_usuario_noreactivo.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id);
    }

    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol update(Long id, Rol rol) {
        return rolRepository.findById(id)
                .map(existingRol -> {
                    if (rol.getDescripcion() != null) existingRol.setDescripcion(rol.getDescripcion());
                    return rolRepository.save(existingRol);
                })
                .orElseThrow(() -> new RuntimeException("Rol not found with id " + id));
    }

    public void deleteById(Long id) {
        if (rolRepository.existsById(id)) {
            rolRepository.deleteById(id);
        } else {
            throw new RuntimeException("Rol not found with id " + id);
        }
    }
}
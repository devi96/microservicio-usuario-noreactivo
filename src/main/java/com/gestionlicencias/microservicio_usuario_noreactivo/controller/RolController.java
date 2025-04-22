package com.gestionlicencias.microservicio_usuario_noreactivo.controller;
import com.gestionlicencias.microservicio_usuario_noreactivo.model.Rol;
import com.gestionlicencias.microservicio_usuario_noreactivo.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> listarRoles() {
        List<Rol> roles = rolService.findAll();
        return ResponseEntity.ok(roles);
    }

    @PostMapping
    public ResponseEntity<Rol> agregarRol(@RequestBody Rol rol) {
        Rol nuevoRol = rolService.save(rol);
        return ResponseEntity.ok(nuevoRol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> editarRol(@PathVariable Long id, @RequestBody Rol rol) {
        Rol rolActualizado = rolService.update(id, rol);
        return ResponseEntity.ok(rolActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        rolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
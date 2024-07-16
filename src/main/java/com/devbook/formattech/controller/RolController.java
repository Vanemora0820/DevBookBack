package com.devbook.formattech.controller;

import com.devbook.formattech.Dto.RolDto;
import com.devbook.formattech.entity.Rol;
import com.devbook.formattech.entity.User;
import com.devbook.formattech.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/rol")

public class RolController {
  @Autowired
  RolService rolService;

  @PostMapping
  public ResponseEntity<RolDto> createRol(@RequestBody RolDto rolDto) {
    RolDto createdRol = rolService.createRol(rolDto);
    return ResponseEntity.ok(createdRol);
  }

  @GetMapping("/getRoles")
  public ResponseEntity<List<RolDto>> getRoles() {
    List<RolDto> roles = rolService.getAllRoles();
    return ResponseEntity.ok(roles);
  }

  @GetMapping("/{id}")
  public ResponseEntity<RolDto> getRolById(@PathVariable int id) {
    RolDto rol = rolService.getRolById(id);
    return ResponseEntity.ok(rol);
  }

  @PutMapping("/{id}")
  public ResponseEntity<RolDto> updateRol(@PathVariable int id, @RequestBody RolDto rolDto) {
    RolDto updatedRol = rolService.updateRol(id, rolDto);
    return ResponseEntity.ok(updatedRol);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Rol> deleteUser(@PathVariable int id) {
    Rol deleteRole = rolService.deleteRole(id);
    return ResponseEntity.ok(deleteRole);
  }
}

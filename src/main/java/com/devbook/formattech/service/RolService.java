package com.devbook.formattech.service;

import com.devbook.formattech.Dto.RolDto;
import com.devbook.formattech.entity.Rol;

import java.util.List;

public interface RolService {

  RolDto createRol(RolDto rolDto);
  List<RolDto> getAllRoles();
  RolDto getRolById(int id);
  RolDto updateRol(int id, RolDto rolDto);
  Rol deleteRole(int id);
}

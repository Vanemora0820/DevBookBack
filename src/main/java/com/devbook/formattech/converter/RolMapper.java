package com.devbook.formattech.converter;


import com.devbook.formattech.Dto.RolDto;
import com.devbook.formattech.entity.Rol;
import org.springframework.stereotype.Component;

import java.text.Collator;
import java.util.stream.Collectors;

@Component
public class RolMapper {

    public static RolDto rolDto(Rol rol) {

        RolDto rolDto = new RolDto();
        rolDto.setId(rol.getId());
        rolDto.setRol(rol.getRol());
        rolDto.setStacks(rol.getStacks().stream().map(StackMapper::stackDto).collect(Collectors.toList()));

        return rolDto;

    }

    public static Rol rol (RolDto rolDto) {

        Rol rol = new Rol();
        rol.setId(rolDto.getId());
        rol.setRol(rolDto.getRol());
        rol.setStacks(rolDto.getStacks().stream().map(StackMapper::stack).collect(Collectors.toList()));
        return rol;
    }
}

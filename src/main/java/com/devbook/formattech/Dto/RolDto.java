package com.devbook.formattech.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RolDto {
    private int id;
    private String rol;
    private List<StackDto> stacks;

}

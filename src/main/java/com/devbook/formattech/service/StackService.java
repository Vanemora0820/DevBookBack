package com.devbook.formattech.service;

import com.devbook.formattech.Dto.StackDto;
import com.devbook.formattech.entity.Stack;

import java.util.List;

public interface StackService {

    StackDto createStack (StackDto stackDto);
    List<StackDto> getAllStacks();
    StackDto getStackById(int id);
    StackDto updateStack(int id, StackDto stackDto);
    Stack deleteStack(int id);

}

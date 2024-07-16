package com.devbook.formattech.converter;


import com.devbook.formattech.Dto.StackDto;
import com.devbook.formattech.entity.Stack;
import org.springframework.stereotype.Component;

@Component
public class StackMapper {

    public static StackDto stackDto (Stack stack) {

        StackDto stackDto = new StackDto();
        stackDto.setId(stack.getId());
        stackDto.setName(stack.getName());
        return stackDto;
    }

    public static Stack stack (StackDto stackDto) {

        Stack stack = new Stack();
        stack.setId(stackDto.getId());
        stack.setName(stackDto.getName());
        return stack;

    }

}

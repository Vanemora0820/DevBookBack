package com.devbook.formattech.service.implementation;

import com.devbook.formattech.Dto.StackDto;
import com.devbook.formattech.converter.StackMapper;
import com.devbook.formattech.entity.Stack;
import com.devbook.formattech.entity.User;
import com.devbook.formattech.exceptions.ResourceNotFoundException;
import com.devbook.formattech.repository.StackRepository;
import com.devbook.formattech.service.StackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StackServiceImpl implements StackService {

    private static final Logger log = LoggerFactory.getLogger(StackServiceImpl.class);

    @Autowired
    private StackRepository stackRepository;

    @Autowired
    private StackMapper stackMapper;


    @Override
    public StackDto createStack(StackDto stackDto) {
        Stack stack = stackMapper.stack(stackDto);
        stack = stackRepository.save(stack);
        return stackMapper.stackDto(stack);
    }

    @Override
    public List<StackDto> getAllStacks() {
        return stackRepository.findAll().stream()
                .map(StackMapper::stackDto).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public StackDto getStackById(int id) {
        return stackRepository.findById(id)
                .map(StackMapper::stackDto)
                .orElseThrow(() -> new ResourceNotFoundException("Stack not found with id: " + id));
    }


    @Override
    public StackDto updateStack(int id, StackDto stackDto) {
        Stack existingStack = stackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stack not found with id: " + id));
        existingStack.setName(stackDto.getName());
        Stack updatedStack = stackRepository.save(existingStack);
        return stackMapper.stackDto(updatedStack);
    }


    public Stack deleteStack(int id) {
        Stack stack = stackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        stack.setActive(false);
        return stackRepository.save(stack);
    }

}

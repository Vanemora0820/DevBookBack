package com.devbook.formattech.controller;

import com.devbook.formattech.Dto.StackDto;
import com.devbook.formattech.entity.Stack;
import com.devbook.formattech.entity.User;
import com.devbook.formattech.service.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/stack")
public class StackController {

    @Autowired
    StackService stackService;

    @PostMapping
    public ResponseEntity<StackDto> createStack(@RequestBody StackDto stackDto) {

        StackDto createdStack = stackService.createStack(stackDto);
        return ResponseEntity.ok(createdStack);
    }


    @GetMapping("/getStacks")

    public ResponseEntity <List<StackDto>> getStacks() {
        List<StackDto> stacks = stackService.getAllStacks();
        return ResponseEntity.ok(stacks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StackDto> getStackById(@PathVariable int id) {
        StackDto stack = stackService.getStackById(id);
        return ResponseEntity.ok(stack);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StackDto> updateStack(@PathVariable int id, @RequestBody StackDto stackDto) {
        StackDto updatedStack = stackService.updateStack(id, stackDto);
        return ResponseEntity.ok(updatedStack);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Stack> deleteStack(@PathVariable int id) {
        Stack deleteStack = stackService.deleteStack(id);
        return ResponseEntity.ok(deleteStack);
    }
}


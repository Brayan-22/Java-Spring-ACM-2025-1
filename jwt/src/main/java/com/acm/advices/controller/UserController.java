package com.acm.advices.controller;

import com.acm.advices.controller.dto.UserDTO;
import com.acm.advices.model.User;
import com.acm.advices.service.IUserService;
import com.acm.advices.util.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final IUserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody UserDTO userDTO){
        User created = userService.save(userMapper.dtoToModel(userDTO));
        return ResponseEntity.ok(userMapper.modelToDto(created));
    }
}

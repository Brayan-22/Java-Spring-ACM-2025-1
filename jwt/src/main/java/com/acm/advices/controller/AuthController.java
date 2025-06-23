package com.acm.advices.controller;

import com.acm.advices.controller.dto.UserAuthDTO;
import com.acm.advices.controller.dto.UserDTO;
import com.acm.advices.persistence.entity.UserEntity;
import com.acm.advices.service.IUserService;
import com.acm.advices.service.impl.UserServiceImpl;
import com.acm.advices.util.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
@Validated
public class AuthController {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final IUserService userService;
    private final PasswordEncoder passwordEncoder;
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserAuthDTO userAuthDTO){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userAuthDTO.getUsername(), userAuthDTO.getPassword())
            );
            User user = (User) authentication.getPrincipal();
            String token = jwtUtil.generateToken(user.getUsername());
            Map<String,Object> respone = new HashMap<>();
            respone.put("token",token);
            respone.put("username", user.getUsername());
            return ResponseEntity.ok(respone);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> sigUp(@Valid@RequestBody UserDTO userDTO){
        try{
            userService.save(com.acm.advices.model.User.builder()
                            .username(userDTO.getUsername())
                            .password(passwordEncoder.encode(userDTO.getPassword()))
                            .email(userDTO.getEmail())
                    .build());
            return ResponseEntity.ok("User created successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

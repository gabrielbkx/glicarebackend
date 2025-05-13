package com.glicarebackend.glicare.controller;

import com.glicarebackend.glicare.model.dto.UserDto;
import com.glicarebackend.glicare.model.entity.User;
import com.glicarebackend.glicare.repository.UserRepository;
import com.glicarebackend.glicare.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto dto) {
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }
}

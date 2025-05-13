package com.glicarebackend.glicare.service;

import com.glicarebackend.glicare.exceptions.RegistroDuplicadoException;
import com.glicarebackend.glicare.model.entity.User;
import com.glicarebackend.glicare.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(User user){

        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new RegistroDuplicadoException();
        }

        return userRepository.save(user);
    }

}

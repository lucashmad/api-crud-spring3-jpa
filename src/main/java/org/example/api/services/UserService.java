package org.example.api.services;

import org.example.api.entities.User;
import org.example.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // retorna todos os usuarios
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> object = userRepository.findById(id);
        return object.get();
    }

    public User insert(User object){ // retorna todos os users salvos
        return userRepository.save(object);
    }


}
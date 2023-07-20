package org.example.api.config;

import org.example.api.entities.User;
import org.example.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration // classe de config
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired // instacia o user repository durante a execucao
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User userOne = new User(null, "Maria", "maria@gmail.com", "988888888", "456787");
        User userTwo = new User(null, "Guilherme", "gui@gmail.com", "788888888", "145225");

        userRepository.saveAll(Arrays.asList(userOne,userTwo)); // instanciado no banco
    }
}

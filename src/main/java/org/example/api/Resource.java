package org.example.api;

import org.example.api.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class Resource {

      @GetMapping
      public ResponseEntity<User> findAll(){
          User user = new User(1l, "Lucas", "lucas@gmail.com", "99999999999", "123456");
          return ResponseEntity.ok().body(user);
      }


}

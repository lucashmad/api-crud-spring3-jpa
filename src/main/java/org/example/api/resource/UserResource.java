package org.example.api.resource;

import org.example.api.entities.User;
import org.example.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

      @Autowired
      private UserService userService;
      @GetMapping
      public ResponseEntity<List<User>> findAll() {
          List<User> users = userService.findAll();
          return ResponseEntity.ok().body(users);
      }

      @GetMapping(value = "/{id}")
      public ResponseEntity<User> findById(@PathVariable Long id){
          User object = userService.findById(id);
          return ResponseEntity.ok().body(object);
      }

      // inserindo recurso no banco de dados
      @PostMapping
      public ResponseEntity<User> insert(@RequestBody User object){
          object = userService.insert(object);
          URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(object.getId()).toUri(); // criando uri
          return ResponseEntity.created(uri).body(object);
      }

      @DeleteMapping(value = "/{id}")
      public ResponseEntity<Void> delete(@PathVariable Long id){
          userService.delete(id);
          return ResponseEntity.noContent().build(); // resposta 204
      }

}

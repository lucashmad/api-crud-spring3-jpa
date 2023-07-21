package org.example.api.resource;

import org.example.api.entities.Order;
import org.example.api.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

      @Autowired
      private OrderService orderService;
      @GetMapping
      public ResponseEntity<List<Order>> findAll() {
          List<Order> users = orderService.findAll();
          return ResponseEntity.ok().body(users);
      }

      @GetMapping(value = "/{id}")
      public ResponseEntity<Order> findById(@PathVariable Long id){
          Order object = orderService.findById(id);
          return ResponseEntity.ok().body(object);
      }
}

package br.com.fiap.orderservice.controller;

import br.com.fiap.orderservice.model.Order;
import br.com.fiap.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable("id") Long id) {

        final Order order = repository.getById(id);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody Order order) {

        final Order savedOrder = repository.save(order);

        URI location = getUri(savedOrder);

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable("id") Long id, @RequestBody Order order) {

        repository.update(id, order);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> delete(@PathVariable("id") Long id) {

        final Order savedOrder = repository.getById(id);

        repository.delete(savedOrder);

        return new ResponseEntity(HttpStatus.OK);
    }

    private URI getUri(Order savedOrder) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedOrder.getId()).toUri();
    }

}

package com.example.ordernow.controllers;

import com.example.ordernow.models.Customer;
import com.example.ordernow.models.Order;
import com.example.ordernow.repositories.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> list(){ return  orderRepository.findAll(); }

    @GetMapping
    @RequestMapping("{id}")
    public Order get(@PathVariable Long id){return orderRepository.getOne(id);}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody final Order order){
        return orderRepository.saveAndFlush(order);
    }

    @RequestMapping(value = "{id}" , method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        orderRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}" , method = RequestMethod.PUT)
    public Order update(@PathVariable Long id, @RequestBody Order order){
        Order existingOrder = orderRepository.getOne(id);
        BeanUtils.copyProperties(order,existingOrder,"order_id");
        return orderRepository.saveAndFlush(existingOrder);}
}

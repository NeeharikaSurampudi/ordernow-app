package com.example.ordernow.controllers;

import com.example.ordernow.models.Customer;
import com.example.ordernow.repositories.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> list(){
        return customerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Customer get(@PathVariable Long id){
        return customerRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody final Customer customer){
        return customerRepository.saveAndFlush(customer);
    }

    @RequestMapping(value = "{id}" , method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        customerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}" , method = RequestMethod.PUT)
    public Customer update(@PathVariable Long id,@RequestBody Customer customer){
        Customer existingCustomer = customerRepository.getOne(id);
        BeanUtils.copyProperties(customer,existingCustomer,"customer_id");
        return customerRepository.saveAndFlush(existingCustomer);}
}

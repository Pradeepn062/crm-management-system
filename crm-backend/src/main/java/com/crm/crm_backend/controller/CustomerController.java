package com.crm.crm_backend.controller;

import com.crm.crm_backend.model.Customer;
import com.crm.crm_backend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    @GetMapping
    public List<Customer> all() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer one(@PathVariable Long id) {
        return service.getCustomer(id);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer updated) {
        return service.updateCustomer(id, updated);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.deleteCustomer(id);
    }
}

package com.crm.crm_backend.service;

import com.crm.crm_backend.model.Customer;
import com.crm.crm_backend.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public Customer createCustomer(Customer customer) {
        customer.setCreatedAt(LocalDateTime.now());
        return repository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer getCustomer(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Customer updateCustomer(Long id, Customer updated) {
        Customer customer = repository.findById(id).orElse(null);
        if (customer == null) return null;

        customer.setName(updated.getName());
        customer.setEmail(updated.getEmail());
        customer.setPhone(updated.getPhone());
        customer.setStatus(updated.getStatus());

        return repository.save(customer);
    }

    public boolean deleteCustomer(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}

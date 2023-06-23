package com.example.orderingSystem.controller;

import java.util.Optional;
import javax.validation.Valid;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.orderingSystem.Exception.CustomerException;
import com.example.orderingSystem.model.pojo.CustomerDao;
import com.example.orderingSystem.services.CustomerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/Customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping("/add")
    public ResponseEntity<CustomerDao> createCustomer(@RequestBody CustomerDao customer) {
        return new ResponseEntity<>((customerService.registerCustomer(customer)).get(), HttpStatusCode.valueOf(201));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerDao> updateCustomer(@RequestBody @Valid CustomerDao customer, @PathVariable("id") Long customerId) {
        return new ResponseEntity<>((customerService.updateCustomer(customer, customerId).get()), HttpStatusCode.valueOf(200));

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CustomerDao> getCustomer(@PathVariable("id") Long customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId).get(), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity removeCustomer(@PathVariable("id") Long customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }
}

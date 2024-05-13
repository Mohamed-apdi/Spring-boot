package com.example.jdbc;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private  final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // requests
    //getMapping methods

    @GetMapping("/customers")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    public  Customer  getacustomer(@PathVariable int id) {
        return customerService.getCustomerId(id);
    }

    @PostMapping("/create")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.AddCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) {
         customerService.deleteCustomer(id);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customer.setId(id);
        customerService.updateCustome(customer);
    }

}

package net.yousfi.customerservice.Web;


import lombok.RequiredArgsConstructor;
import net.yousfi.customerservice.Repository.CustomerRepository;
import net.yousfi.customerservice.Entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class CustomerRestController {
    private final CustomerRepository customerRepository;

    @PostMapping("/savecustomers")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return this.customerRepository.save(customer);
    }

    @GetMapping("/customers")
    public List<Customer> customerList() {
        return this.customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id) {
        return this.customerRepository.findById(id).get();
    }

    @DeleteMapping("/customers/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(id);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            this.customerRepository.delete(customer);
            return new ResponseEntity<>("id customer:" + id + " deleted ", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("id customer:" + id + " not found", HttpStatus.NOT_FOUND);
        }
    }
}

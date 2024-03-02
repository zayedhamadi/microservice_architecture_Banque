package net.yousfi.accountservice.Client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.yousfi.accountservice.Entity.Model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {


    @PostMapping("/customers/savecustomers")
  //  @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer saveCustomer(@PathVariable Long id);


    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getAllCustomers")

    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception){
        Customer customer=new Customer();
        customer.setId(id);
        customer.setFirstName("Not Available");
        customer.setLastName("Not Available");
        customer.setEmail("Not Available");
        return customer;
    }

    default List<Customer> getAllCustomers(Exception exception){
        return List.of();
    }



}

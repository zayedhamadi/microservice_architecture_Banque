package net.yousfi.accountservice.Web;

import lombok.RequiredArgsConstructor;
import net.yousfi.accountservice.Client.CustomerRestClient;
import net.yousfi.accountservice.Entity.BankAccount;
import net.yousfi.accountservice.Entity.Model.Customer;
import net.yousfi.accountservice.Repository.BankAccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class AccountRestController {


    private final BankAccountRepository bankAccountRepository;
    private final CustomerRestClient customerRestClient;


    @PostMapping("/accounts/saveaccounts")
    public BankAccount saveAccount(@RequestBody BankAccount account) {
        String id = UUID.randomUUID().toString();
        account.setAccountId(id);
        return this.bankAccountRepository.save(account);
    }

    @GetMapping("/accounts")
    public List<BankAccount> BankAccountList() {
        List<BankAccount> all = this.bankAccountRepository.findAll();
        all.forEach(acc -> acc.setCustomer(this.customerRestClient.findCustomerById(acc.getCustomerId())));
        return all;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount BankAccountById(@PathVariable String id) {

        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = this.customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }

    @GetMapping("/accounts/byCustomer/{customerId}")
    public List<?> getAccountsByCustomer(@PathVariable Long customerId) {
        return bankAccountRepository.findByCustomerId(customerId);
    }




    @DeleteMapping("/accounts/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable String id) {
        Optional<BankAccount> optionalAccount = this.bankAccountRepository.findById(id);

        if (optionalAccount.isPresent()) {
            BankAccount account = optionalAccount.get();
            this.bankAccountRepository.delete(account);
            return new ResponseEntity<>("Account with ID " + id + " deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Account with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }
//    @DeleteMapping("/accounts/deleteByCustomerId/{customerId}")
//    public ResponseEntity<String> deleteAccountsByCustomerId(@PathVariable Long customerId) {
//        List<BankAccount> accounts = bankAccountRepository.(customerId);
//        bankAccountRepository.deleteAll(accounts);
//        return new ResponseEntity<>("Accounts associated with Customer ID " + customerId + " deleted successfully", HttpStatus.OK);
//    }
}


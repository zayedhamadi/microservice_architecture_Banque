package net.yousfi.accountservice.Entity;

import jakarta.persistence.*;
import lombok.*;
import net.yousfi.accountservice.Entity.Enum.AccountType;
import net.yousfi.accountservice.Entity.Model.Customer;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String accountId;
    private double balance;
        private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private Long customerId;
    @Transient
    private Customer customer;
}

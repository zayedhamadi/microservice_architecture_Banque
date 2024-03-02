package net.yousfi.accountservice.Repository;

import net.yousfi.accountservice.Entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository  extends JpaRepository<BankAccount,String> {
    List<?> findByCustomerId(Long customerId);
}

package net.yousfi.accountservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(BankAccountRepository accountRepository, CustomerRestClient customerRestClient){
//		return args -> {
//			customerRestClient.allCustomers().forEach(c->{
//				BankAccount bankAccount1 = BankAccount.builder()
//						.accountId(UUID.randomUUID().toString())
//						.currency("MAD")
//						.balance(Math.random()*80000)
//						.createAt(LocalDate.now())
//						.type(AccountType.CURRENT_ACCOUNT)
//						.customerId(c.getId())
//						.build();
//				BankAccount bankAccount2 = BankAccount.builder()
//						.accountId(UUID.randomUUID().toString())
//						.currency("zayed")
//						.balance(Math.random()*65432)
//						.createAt(LocalDate.now())
//						.type(AccountType.SAVING_ACCOUNT)
//						.customerId(c.getId())
//						.build();
//				accountRepository.save(bankAccount1);
//				accountRepository.save(bankAccount2);
//			});
//
//
//		};
//	}

}

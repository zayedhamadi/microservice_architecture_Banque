package net.yousfi.customerservice;

import net.yousfi.customerservice.Config.GlobalConfig;
import net.yousfi.customerservice.Entity.Customer;
import net.yousfi.customerservice.Repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties({GlobalConfig.class})
public class  CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
//
//
//		return args -> {
//			List<Customer>customerList=List.of(
//					Customer.builder()
//							.firstName("zayed")
//							.lastName("hamadi")
//							.email("zayed@gmail.com")
//							.build(),
//					Customer.builder()
//							.firstName("mohamed")
//							.lastName("aziz ")
//							.email("mohamed@gmail.com")
//							.build(),
//					Customer.builder()
//							.firstName("x")
//							.lastName("y")
//							.email("x@gmail.com")
//							.build()
//			);
//			customerRepository.saveAll(customerList);
//
//		};
//	}



}

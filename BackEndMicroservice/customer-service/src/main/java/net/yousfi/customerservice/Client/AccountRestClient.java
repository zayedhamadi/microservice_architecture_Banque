package net.yousfi.customerservice.Client;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ACCOUNT-SERVICE")

public interface AccountRestClient {

}

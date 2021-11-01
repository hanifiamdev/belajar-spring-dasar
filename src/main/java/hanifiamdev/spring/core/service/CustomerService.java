package hanifiamdev.spring.core.service;

import hanifiamdev.spring.core.repository.CustomerRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    @Getter
    @Autowired     // contoh Field-based Dependency Injection, dan ini sebenarnya sudah tidak direkomendasikan untuk digunakan sebaiknya menggunakan yang contructor atau method saja
    private CustomerRepository customerRepository;


}

package hanifiamdev.spring.core.service;

import hanifiamdev.spring.core.repository.CustomerRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

   /* @Getter
    @Autowired     // contoh Field-based Dependency Injection, dan ini sebenarnya sudah tidak direkomendasikan untuk digunakan sebaiknya menggunakan yang contructor atau method saja
    private CustomerRepository customerRepository;*/


    /*
    * Qualifier
    * Seperti yang sudah dijelaskan di awal, jika terdapat bean dengan tipe data yang lebih dari satu, maka secara otomatis Spring akan bingung memilih bean yang mana yang akan digunakan
    * Kita perlu memilih salah satu menjadi primary yang secara otomatis akan dipilih oleh spring
    * Namun jika kita ingin memilih bean secara manual, kita juga bisa menggunakan @Qualifier
    * Kita bisa tambahkan @QUalifier di contructor parameter, di setter method atau di field
    * */

    @Getter
    @Autowired
    @Qualifier("normalCustomerRepository")
    private CustomerRepository normalCustomerRepository;

    @Getter
    @Autowired
    @Qualifier("premiumCustomerRepository")
    private CustomerRepository premiumCustomerRepository;




}

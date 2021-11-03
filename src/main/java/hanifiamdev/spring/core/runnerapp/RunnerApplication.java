package hanifiamdev.spring.core.runnerapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
* ## Application Runner ##
* Selain CommandLineRunner, Spring Boot menyediakan fitur Applicatio Runner
* Penggunaan ApplicationRunner sama seperti CommandLineRunner, hanya saja argument nya sudah di wrap dalam object ApplicationArguments
* Yang menarik dari ApplicationArguments adalah, memiliki fitur parsing untuk command line argument
* https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/ApplicationArguments.html
* https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/ApplicationRunner.html
* */
@SpringBootApplication
public class RunnerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RunnerApplication.class, args); // Short Cut : Alt + Shift + f10
    }
}

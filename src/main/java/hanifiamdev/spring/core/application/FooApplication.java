package hanifiamdev.spring.core.application;

import hanifiamdev.spring.core.data.Foo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


/*
* ## Spring Boot Application ##
* Sebelumnya kita selalu membuat Application Context secara manual, dan kita belum menggunakan fitur otomatis Spring Boot
* Hal ini sengaja saya jelaskan agar kita tidak kaget bagaimana semua itu bisa berjalan secara otomatis di Spring Boot
* Pada saat membuat aplikasi di Spring Boot, kita akan mengganti @Configuration utama menjadi @SpringBootApplication
* Isi dari @SpringBootApplication itu sendiri sebenarnya gabungan dari @Configuration dan banyak hal ini, seperti contohnya @ComponentScan
* https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/SpringBootApplication.html
*
* ## Spring Application ##
* Selain @SpringBootApplication, untuk membuat Application Context nya, kita tidak perlu membuat manual, kita bisa gunakan class SpringApplication
* Secara otomatis SpringApplication akan membuat AppliactionContext dan melakukan hal-hal yang dibutuhkan secara otomatis
* https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/SpringApplication.html
* */
@SpringBootApplication
public class FooApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(FooApplication.class, args);

        Foo foo = applicationContext.getBean(Foo.class);
        System.out.println(foo);
    }

    @Bean
    public Foo foo() {
        return new Foo();
    }
}


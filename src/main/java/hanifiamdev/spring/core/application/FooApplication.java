package hanifiamdev.spring.core.application;

import hanifiamdev.spring.core.data.Bar;
import hanifiamdev.spring.core.data.Foo;
import org.springframework.boot.Banner;
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
*
* ## Banner ##
* Spring Boot memiliki fitur banner, dimana saat aplikasi Spring Boot berjalan, kita bisa menampilkan tulisan banner di console
* Secara default fitur banner ini akan menyala dan mencari tulisan banner di classpath dengan nama banner.txt
* Jika tidak ada file tersebut, maka secara otomatis akan menampilkan banner Spring Boot
* Salah satu contoh tempat untuk membuat banner adalah http://www.bagill.com/ascii-sig.php
* */
@SpringBootApplication
public class FooApplication {

    /*public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(FooApplication.class, args);

        Foo foo = applicationContext.getBean(Foo.class);
        System.out.println(foo);
    }*/

    /*
    * ## Customizing Spring Appplication ##
    * Kadang ada kalanya kita ingin melakukan pengaturan di Spring Application sebelum Application Contextnya dibuat
    * https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/SpringApplication.html
    * Kita bisa menggunakan langsung SpringApplication, atau bisa juga menggunakan SpringApplicationBuilder
    * https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/builder/SpringApplicationBuilder.html
    * */
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FooApplication.class);
        application.setBannerMode(Banner.Mode.OFF);

        ConfigurableApplicationContext applicationContext = application.run(args);

        Foo foo = applicationContext.getBean(Foo.class);
        System.out.println(foo);

    }

    @Bean
    public Foo foo() { // buang parameter bar klw
        return new Foo();
    }

    /*
    * ## Startup Failure ##
    * Salah satu yang menarik di Spring Boot adalah, Spring Boot memiliki fitur FailureAnalyzer
    * FailureAnalyzer digunakan untuk melakukan analisa ketika terjadi eror startup yang menyebabkan apliaksi tidak mau berjalan
    * Spring sudah menyediakan banyak sekali class implementtasi FailureAnalyzer yang bisa mempermudah kita menganalisa kesalahan ketika terjadi startup failure
    * https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/diagnostics/FailureAnalyzer.html
    *
    * */
   /* @Bean
    public Foo foo(Bar bar) { // pakai method ini untuk test starup failure
        return new Foo();
    }*/
}


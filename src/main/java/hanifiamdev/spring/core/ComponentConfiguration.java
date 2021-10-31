package hanifiamdev.spring.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
* ## Component ##
* Sebelumnya kita sudah belajar membuat bean menggunakan method di configuration dengan annotaion @Bean
* Spring juga menyediakan cara otomatis tanpa kita membuat method @Bean
* Kita bisa menandai sebuah class dengan annotation @Component, secara otomatis Spring  akan membuatkan bean untuk class tersebut
* @Component hanya mendukung pembuatan satu bean, jadi jika kita ingin membuat beberapa bean dengan tipe yang sama, kita tetap harus menggunakan @Bean method
*
* ## Component Bean Name ##
* Saat kita menggunakan @Component nama bean akan secara otomatis dibuat otomatis oleh spring
* Jika kita menggunakan @ComponentScan, secara otomatis bean name akan menggunakan nama class namun menjadi camelCase, misal CategoryService menjadi categoryService, ProductWeb menjadi productWeb
* Jika kita menggunakan @Import, secara otomatis bean name akan menjadi NamaClass.class.getName()
* Namun jika ingin membuat nama berbeda, kita juga bisa gunakan @component(value = "namaBean")
*
* ## Annotaion ##
* Semua annotation yang sudah kita bahas @Bean juga didukung @Component
* Seperti misalnya @Scope, @PostConstruct, @PostDestroy, @Lazy, @Primary dan lain lain
* */
@Configuration
@ComponentScan(basePackages = {
        "hanifiamdev.spring.core.service"
})
public class ComponentConfiguration {
}

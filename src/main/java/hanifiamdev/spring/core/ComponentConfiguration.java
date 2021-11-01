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
*
* ## Dependency Injection ##
* Sebelumnya untuk melakukan Dependency Injection di @Bean, kita bisa menambahkan parameter di method nya
* Secara otomatis Spring akan memilih bean mana yang cocok untuk parameter tersebut
* Lalu bagaimana jika menggunakan @Component?
* Untuk @Component kita bisa melakukan beberapa cara untuk Dependency Injection nya
*
* ## Constructor-based Dependency Injection ##
* Pertama bisa kita lakukan untuk Dependency Injection di @Component adalah dengan menggunakan constructor parameter
* Kita bisa menambahkan contructor yang memiliki parameter jika membutuhkan bean lain
* Secara otomatis Spring akan mencarikan bean tersebut, dan ketika membuat bean @Component, Spring akan menggunakan bean yagn dibutuhkan di contructor
* Constructor-based Dependency Injection hanya mendukung satu constructor, jadi pastikan kita hanya membuat satu contructor
*
* ## Multiple Contructor ##
* Seperti di awal disebutkan bahwa Spring hanya mendukung satu constructor untuk Dependency Injection nya
* Namun bagaimana jika terdapat multiple constructor?
* Jika pada kasus seperti ini, kita harus menandai constructor mana yang akan diigunakan oleh Spring
* Caranya kita bisa menggunakan annotation @Autowired
* */
@Configuration
@ComponentScan(basePackages = {
        "hanifiamdev.spring.core.repository",
        "hanifiamdev.spring.core.service",
})
public class ComponentConfiguration {
}

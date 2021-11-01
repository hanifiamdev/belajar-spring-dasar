package hanifiamdev.spring.core;


import hanifiamdev.spring.core.data.MultiFoo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
*
* ## Setter-based Dependency Injectionn ##
* Selain menggunakan constructor parameter kita juga bisa menggunakan setter method jika ingin melakukan dependency injection
* Namun untuk setter method, kita perlu penambahan annotaion @Autowired pada setter method nya
* Secara otomatis Spring akan mencari bean yang dibutuhkan si setter method yang memiliki annotation @Autowired
* Setter-based DI juga bisa digabung dengan Constructor-based DI
*
* ## Field-based Dependency Injection ##
* Selain contructor dan setter, kita juga bisa melakukan dependency injection langsung menggunakan field
* Caranya sama dengan setter, kita bisa tambahkan @Autowired pada fieldnya
* Secara otomatis Spring akan mencari bean dengan tipe data tersebut
* Field-based DI bisa digaung sekaligus dengan setter-based DI dan Constructor-based DI
* Khusus Field-based DI, Spring sendiri sudah tidak merekomendasikan penggunaan cara melakukan DI dengan Field
* */
@Configuration
@ComponentScan(basePackages = {
        "hanifiamdev.spring.core.repository",
        "hanifiamdev.spring.core.service",
        "hanifiamdev.spring.core.configuration",
})
@Import(MultiFoo.class)
public class ComponentConfiguration {
}

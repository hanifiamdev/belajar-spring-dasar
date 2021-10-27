package hanifiamdev.spring.core;


import hanifiamdev.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
*
* Duplicate Bean
* Di Spring, kita bisa mendaftarkan beberapa dengan tipe yang sama
* salah satu syaratnya supaya bisa membuat bean dengan tipe data yang sama, maka kita harus menggunakan nama bean yang berbeda.
* contoh di kel;as ini dengan tipe data Foo kita buat dengan foo1 dan foo2 untuk nama method supaya unik
* */
@Configuration
public class DuplicateConfiguration {

    @Bean
    public Foo foo1() {
        return new Foo();
    }


    @Bean
    public Foo foo2() {
        return new Foo();
    }

}

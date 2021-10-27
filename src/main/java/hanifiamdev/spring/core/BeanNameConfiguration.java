package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/*
* Mengubah Nama Bean
*  secara default, nama beqan diambil dari nama method
*  Namun kadang - kadang kita tidak ingin menggunakan nama method untuk nama bean
* kita bisa menggunakan method value() / name milik anotation @Bean
* */
@Configuration
public class BeanNameConfiguration {

    @Primary
    @Bean( name = "fooFirst")
    public Foo foo1() {
        return new Foo();
    }


    @Bean( name = "fooSecond")
    public Foo foo2() {
        return new Foo();
    }

}

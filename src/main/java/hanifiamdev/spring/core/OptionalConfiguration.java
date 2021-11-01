package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.Bar;
import hanifiamdev.spring.core.data.Foo;
import hanifiamdev.spring.core.data.FooBar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;


/*
 *## Optional Dependency ##
 * Secara default, semua dependency itu wajib
 * Artinya jika Spring tidak bisa menemukan bean yang dibutuhkan pada saat DI, maka secara otomatis akan terjadi error
 * Namun jika kita memang ingin membuat sebuah dependency menjadi Optional, artinya tidak wajib
 * Kita bisa wrap dependency tersebut dengan menggunakan java.util.Optional<T>
 * Secara otomatis jika ternyata bean yang dibutuhkan tidak ada. maka tidak akan terjadi error
 * Kita bisa gunakan Optional<T> pada @Bean(method parameter) ataupun @Component( constructor parameter, setter method parameter, field
 *
 * */
@Configuration
public class OptionalConfiguration {

    @Bean
    public Foo foo() {
        return new Foo();
    }

    @Bean
    public FooBar fooBar(Optional<Foo> foo, Optional<Bar> bar) {
        return new FooBar(foo.orElse(null), bar.orElse(null));
    }
}

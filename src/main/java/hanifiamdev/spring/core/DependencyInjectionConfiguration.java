package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.Bar;
import hanifiamdev.spring.core.data.Foo;
import hanifiamdev.spring.core.data.FooBar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* Depedency Injection
*  Saat membuat object, sudah pasti kita sering membuat object yang tergantung dengan object lain
* Depency Injection(DI) adalah tekhnik dimana kita bisa mengotomatisasi proses pembuatan object yang tergantung dengan object lain, atau kita sebut dependencies
* Dependencies akan secara otomatis di-inject(dimasukkan) kedalam object yang membutuhkannya
* Spring Framework sejak awal dibilang sebuah framework IoC yang memang cara kerjanya menggunakan Dependency Injection
*
*Spring Dependency Injection
* Spring sejak awal dikenal dengan framework untuk Dependency Injection
* Ketika kita membuat method untuk bean di Spring. Kita bisa menambahkan parameter
* Secara otomatis Spring akan mencarikan bean lain yang sesuai dengan tipe parameter tersebut
* Jika ternyata tidak ada bean yang cocok maka secara otomatis akan terjadi error
* Dan jika ternyata terdapat bean lebih dari satu, secara otomatis akan terjadi error, kecuali terdapat primary bean
* */

@Configuration
public class DependencyInjectionConfiguration {

    @Bean
    public Foo foo() {
        return new Foo();
    }

    @Bean
    public Bar bar() {
        return new Bar();
    }

    @Bean
    public FooBar fooBar(Foo foo, Bar bar) {
        return new FooBar(foo, bar);
    }

}

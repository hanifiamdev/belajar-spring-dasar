package hanifiamdev.spring.core;


import hanifiamdev.spring.core.data.Bar;
import hanifiamdev.spring.core.data.Foo;
import hanifiamdev.spring.core.data.FooBar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/*
* Memilih Dependency
* Kadang saat menggunakan DI, kita ingin memilih object mana yang ingin kita gunakan
* Saat terdapat dupllicate bean dengan tipe data yang sama, secara otomatis Spring akan memilih bean yang primary
* Namun kita juga bisa memilih secara manual jika memang kita inginkan
* Kita bisa menggunakan annotation @Qualifier(value="namaBean") pada parameter di method nya
* */

@Configuration
public class MemilihDependency {

    @Primary
    @Bean
    public Foo fooFirst() {
        return new Foo();
    }

    @Bean
    public Foo fooSecond() {
        return new Foo();
    }

    @Bean
    public Bar bar() {
        return new Bar();
    }

    @Bean
    public FooBar fooBar(@Qualifier("fooSecond") Foo foo, Bar bar) {
        return new FooBar(foo, bar);
    }
}

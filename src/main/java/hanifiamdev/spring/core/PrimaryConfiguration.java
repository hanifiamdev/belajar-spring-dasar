package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
/*
* Primary Bean
*  annotation @Primsry pada bean digunakan untuk membuat secara otomatis jika kita mengakses bean tanpa
*  menyebut nama bean nya, secara otomatis primarynya yang akan dipilih
* */
@Configuration
public class PrimaryConfiguration {

    @Primary
    @Bean
    public Foo foo1() {
        return new Foo();
    }


    @Bean
    public Foo foo2() {
        return new Foo();
    }

}

package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/*
* Scope
* Scope merupakan strategy cara sebuah object dibuat
* Secara default strategy object di Spring adalah singleton, artinya hanya dibuat sekali, dan ketika kita akses, akan mengembalikan object yang sama
* Namun kita juga bisa mengubah scope bean yang kita mau di spring
* Untuk mengubah scope sebuah bean, kita bisa ditambahkan annotation @Scope(value="namaScope")
*
* */


@Slf4j
@Configuration
public class ScopeConfiguration {

    @Bean
    @Scope("prototype")
    public Foo foo() {
        log.info("Create new Foo");
        return new Foo();
    }

}

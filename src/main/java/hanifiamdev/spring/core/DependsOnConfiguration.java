package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.Bar;
import hanifiamdev.spring.core.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

/*
* Depends On
*
* Saat sebuah bean membutuhkan bean lain, secara otomatis bean tersebut akan dibuat setelah bean yang dibutuhkan dibuat
* Namun bagaiman jika bean tersebut tidak membutuhkan bean lain, namun kita ingin sebuah bean dibuat stelah bean lain dibuat?
* Jika ada kasus seperti itu, kita bisa menggunakan annotation @ DependsOn(value={"namaBean"})
* Secara otomatis, Spring akan memprioritaskan pembuatan bean yang terdapat di DependsOn terlebih dahulu
* */

@Slf4j
@Configuration
public class DependsOnConfiguration {
    /*Create bean dibuat defaulnya dari atas kebawah*/

    @Lazy  // Lazy Bean disunakan supaya bean dibuat ketika diakses saja sehingga saat statup tidak otomatis dibuat
    @Bean
    @DependsOn({                 // ini artinya bean foo akan dibuat setelah bean bar
            "bar"
    })
    public Foo foo() {
        log.info("Create new Foo");
        return new Foo();
    }

    @Bean
    public Bar bar() {
        log.info("Create new Bar");
        return new Bar();
    }


}

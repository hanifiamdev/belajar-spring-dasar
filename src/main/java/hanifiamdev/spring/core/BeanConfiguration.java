package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*Saat sebuah object kita masukkan kedalam Spring Container IoC, maka kita sebut object tersebut adalah Bean
        Secara default, bean merupakan singleton, artinya jika kita mengakses bean yang*/
@Slf4j
@Configuration
public class BeanConfiguration {
    /*
    * Membuat Bean
    * - buat method di dalam class Configuration
    * - tamabahkan annotation @Bean
    * Note : nama method akan menjadi nama bean nya, dan return object nya menjadi object bean nya. Secara otomatis
    *        spring akan mengeksekusi method tersebut, dan return valuenya akan dijadikan object bean secara otomatis, dan disimpan di container IoC
    * */

    @Bean
    public Foo foo(){
        Foo foo = new Foo();
        log.info("Create new foo");
        return foo;
    }
}

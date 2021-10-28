package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.cyclic.CyclicA;
import hanifiamdev.spring.core.data.cyclic.CyclicB;
import hanifiamdev.spring.core.data.cyclic.CyclicC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
* Circular Dependencies
* Hati - hati dengan circular dependencies
* Circular dependencies adalah kasus dimana sebuah lingkaran dependency terjadi, misal bean A membutuhkan bean B. bean B membutuhkan bean C, dan ternyata bean C membutuhkan bean A
* Jika terjadi cyclic sperti ini, secara otomatis Spring bisa mendeteksinya, dan akan menganggap bahwa itu adalah error
* */
@Configuration
public class CyclicConfiguration {

    @Bean
    public CyclicA cyclicA(CyclicB cyclicB) {
        return new CyclicA(cyclicB);
    }

    @Bean
    public CyclicB cyclicB(CyclicC cyclicC) {
        return new CyclicB(cyclicC);
    }

    @Bean
    public CyclicC cyclicC(CyclicA cyclicA) {
        return new CyclicC(cyclicA);
    }


}

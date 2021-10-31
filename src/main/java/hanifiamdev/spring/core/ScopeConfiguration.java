package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.Bar;
import hanifiamdev.spring.core.data.Foo;
import hanifiamdev.spring.core.scope.DoubletonScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/*
* # Scope #
* Scope merupakan strategy cara sebuah object dibuat
* Secara default strategy object di Spring adalah singleton, artinya hanya dibuat sekali, dan ketika kita akses, akan mengembalikan object yang sama
* Namun kita juga bisa mengubah scope bean yang kita mau di spring
* Untuk mengubah scope sebuah bean, kita bisa ditambahkan annotation @Scope(value="namaScope")
* # Jenis Bean Scope #
*   - singleton -> Hanya dibuat sekali dalam dalam Spring IoC ( ini defaultnya )
*   - prototype -> Selalu dibuat object baru setiap kali bean diakses
*   - request -> Dibuat baru per HTTP Request( hanya untuk Web App )
*   - session -> Dibuat baru per HTTP Session ( hanya untuk Web App )
*   - application -> Dibuat baru per ServletContext ( hanya untuk Web App )
*   - websocket -> Dibuat baru per WebSocket ( hanya untuk Websocket App )
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

    //Beikut contoh method membuat scope sendiri/custome scope
    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("doubleton", new DoubletonScope());
        return configurer;
    }

    @Bean
    @Scope("doubleton")
    public Bar bar() {
        log.info("create new Bar");
        return new Bar();
    }

}

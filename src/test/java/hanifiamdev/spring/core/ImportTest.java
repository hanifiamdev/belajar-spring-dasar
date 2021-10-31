package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.Bar;
import hanifiamdev.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/*
* Import
*
* Saat ini kita membuat aplikasi, tidak mungkin kita hanya akan membuat satu Configuration Class
* Biasanya kita akan membuat banyak sekali, tergantung seberapa kompleks aplikasi kita
* Spring mendukung import Configurations Class lain jika dibutuhkan
* Kita bisa mengunakan annotation @Import, lalu sebutkan Configuration Class mana yang ingin kita import
* */
public class ImportTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testImport() {

        Foo foo = applicationContext.getBean(Foo.class);
        Bar bar = applicationContext.getBean(Bar.class);
    }
}

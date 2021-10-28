package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependsOnTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(DependsOnConfiguration.class);
    }

    @Test
    void testDependsOn() {
        // Inisaialisai bean foo, nah ketika di akses baru bean foo yang merupakn Lazy bean akan dibuat
        Foo foo = applicationContext.getBean(Foo.class);

    }
}

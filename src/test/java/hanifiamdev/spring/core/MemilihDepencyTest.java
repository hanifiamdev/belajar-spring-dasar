package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.Foo;
import hanifiamdev.spring.core.data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemilihDepencyTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(MemilihDependency.class);
    }

    @Test
    void testDI() {
        Foo foo = applicationContext.getBean("fooSecond", Foo.class);

        FooBar fooBar = applicationContext.getBean(FooBar.class);

        Assertions.assertSame(foo, fooBar.getFoo());
    }
}

package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.Bar;
import hanifiamdev.spring.core.data.Foo;
import hanifiamdev.spring.core.data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjectionTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext =  new AnnotationConfigApplicationContext(DependencyInjectionConfiguration.class);
    }


    @Test
    void testDI() {
        Foo foo = applicationContext.getBean(Foo.class);
        Bar bar = applicationContext.getBean(Bar.class);
        FooBar fooBar = applicationContext.getBean(FooBar.class);

        Assertions.assertSame(foo, fooBar.getFoo()); // menyamakan bean foo dengan yang ada didalam bean fooBar
        Assertions.assertSame(bar, fooBar.getBar()); // menyamakan bean foo dengan yang ada didalam bean getBar

    }
    /*
    * cara tanpa depency injection memang bisa tapi ketika relasi antar depedency sangat kompleks,
    * agak ribet untuk melakukannya jika harus manual
    * */
    // ini untuk test yang menggunakan cara biasa atau tanpa dependency injection
    @Test
    void testNoDI() {
        var foo = new Foo();
        var bar = new Bar();

        var fooBar = new FooBar(foo, bar);

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());


    }
}

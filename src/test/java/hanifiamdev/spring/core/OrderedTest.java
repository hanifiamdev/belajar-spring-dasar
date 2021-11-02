package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.Car;
import hanifiamdev.spring.core.processor.IdGeneratorBeanPostProcessor;
import hanifiamdev.spring.core.processor.PrefixIdGeneratorBeanPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*
* Ordered
*
* Saat kita membuat Bean Post Processor, kita bisa membuat lebih dari satu
* Kadang ada kasus saat membuat beberapa Bean Post Processor, kita ingin membuat yang berurutan
* Sayangnya secara default, Spring tidak menjamin urutan eksekusi nya
* Agar kita bisa menentukan urutannya, kita bisa menggunakan interface Ordered
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/Ordered.html
* */
public class OrderedTest {

    @Configuration
    @Import({
            Car.class,
            IdGeneratorBeanPostProcessor.class,
            PrefixIdGeneratorBeanPostProcessor.class
    })
    public static class TestConfiguration {}

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testCar() {
        Car car = applicationContext.getBean(Car.class);

        Assertions.assertNotNull(car.getId());
        Assertions.assertTrue(car.getId().startsWith("HAH-"));
    }
}

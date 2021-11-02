package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.Car;
import hanifiamdev.spring.core.processor.IdGeneratorBeanPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/*
* ## Bean Post Processor ##
* Bean Post Processor merupakan sebuah interface yang bisa kita gunakan untuk memodifikasi proses pembuatan bean di Application Context
* Bean Post Processor mirip seperti middleware, yang diakses sebelum bean di initialized dan setelah bean di initialized
* Karena sangat flexible, bahkan Bean Post Processor biar memodidikasi hasil object bean
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/BeanPostProcessor.html
*
* ## Bean Id Generator ##
* Misal sekarang kita akan mencoba membuat id unique untuk bean
* Dimana kita akan membuat sebuah interface bernama IdAware, lalu memiliki method setId(String)
* Kita akan membuat Bean Post Processor, dimana jika bean nya implements IdAware, kita akan setId(String) nya menggunakan UUID
* */
public class BeanPostProcessorTest {

    @Configuration
    @Import({
            Car.class,
            IdGeneratorBeanPostProcessor.class
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

        System.out.println(car.getId());
        Assertions.assertNotNull(car.getId());
    }
}

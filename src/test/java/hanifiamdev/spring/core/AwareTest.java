package hanifiamdev.spring.core;

import hanifiamdev.spring.core.service.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/*
* ## Aware ##
* Spring memiliki sebuah interface bernama Aware
* Aware adalah super interface yang dugunakan untuk semua Aware interface
* Aware ini diperuntukkan untuk penanda adar spring melakukan injection object yang kita butuhkan
* Mirip seperti yang sudah kita lakukan ketika membuat IdAware menggunakan IdGenerator Bean Post Processor
* Namun untuk ini, kita tidak perlu lagi membuat Bean Post Processor secara manual
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/Aware.html
*
* ## Daftar Aware ##
* ApplicationContextAware : Untuk mendapatkan
* BeanFactoryAware : Untuk mendapatkan bean factory
* BeanNameAware : untuk mendapatkan nama  bean
* ApplicationEventPublisherAware : untuk mendapatkan event publisher
* EnvironmentAware : Untuk mendapatkan environment
* dan lain - lain
* */
public class AwareTest {


    @Configuration
    @Import({
            AuthService.class
    })
    public static class TestConfiguration {
    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testAware() {
        AuthService authService = applicationContext.getBean(AuthService.class);

        Assertions.assertEquals("hanifiamdev.spring.core.service.AuthService", authService.getBeanName());
        Assertions.assertNotNull(authService.getApplicationContext());
        Assertions.assertSame(applicationContext, authService.getApplicationContext());
    }
}

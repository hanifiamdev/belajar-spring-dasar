package hanifiamdev.spring.core;

import hanifiamdev.spring.core.listener.LoginAgainSuccessListener;
import hanifiamdev.spring.core.listener.LoginSuccessListener;
import hanifiamdev.spring.core.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class EventListenerTest {

    @Configuration
    @Import({
            UserService.class,
            LoginSuccessListener.class,
            LoginAgainSuccessListener.class
    })
    public static class TestConfiguration {

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext =  new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testEvent() {

        UserService userService = applicationContext.getBean(UserService.class);
        userService.login("hanif", "hanif");
        userService.login("hanif", "salah");
        userService.login("fachri", "hanif");
    }
}

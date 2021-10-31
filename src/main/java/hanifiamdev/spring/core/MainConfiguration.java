package hanifiamdev.spring.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        FooConfiguration.class,
        BeanConfiguration.class
})
public class MainConfiguration {


}

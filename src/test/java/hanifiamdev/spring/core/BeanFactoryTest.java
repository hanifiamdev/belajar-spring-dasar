package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

/*
* ## Bean Factory ##
*
* ApplicationContext adalah interface turunan dari BeanFactory
* BeanFactory merupakan kontrak untuk management bean di spring
* Method - method yang sebelumnya kita gunakan untuk mengambil bean, sebenarnya merupakan method kontrak dari interface BeanFactory
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactory.html
*
* ## Listable Bean Factory ##
*
* Bean Factory hanya bisa digunakan untuk mengakses single bean, artinya jika terdapat bean dengan tipe yang sama, kita harus kita harus sebutkan satu per satu nama bean
* Listable Bean Factory adalah turunan dari Bean Factory yang bisa kita gunakan untuk mengakses beberapa bean sekaligus
* Dalam beberapa kasus, ini sangat berguna, seperti misal kita ingin mengambil semua bean dengan tipe tertentu
* Application Context juga merupakan turunan dari interface LIstable Bean Factory
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/ListableBeanFactory.html
* */
public class BeanFactoryTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ScanConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testBeanFactory() {
        ObjectProvider<Foo> fooObjectProvider = applicationContext.getBeanProvider(Foo.class);
        List<Foo> fooList = fooObjectProvider.stream().collect(Collectors.toList());

        System.out.println(fooList);
    }
}

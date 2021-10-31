package hanifiamdev.spring.core;

import hanifiamdev.spring.core.data.Connection;
import hanifiamdev.spring.core.data.Server;
import org.springframework.context.annotation.Bean;


/*
* Life Cycle
*
* Spring Container memiliki alur hidup, dan jika ingin berinteraksi dengan alur hidup nya spring. ini juga sangat mungkin bisa dilakukan
* Saat pertama kali spring berjalan dan sudah selesai membuat bean, Spring akan memberitahu bean tersebut bahwa bean tersebut sudah siap, artinya semua dependencies sudah dimasukkan\
* Dan ketika aplikasi spring mati, Spring juga akan memberitahu semua bean bahwa bean tersebut akan dihancurkan
*
* Life Cycle Callback
* Secara default, bean tidak bisa tahu alur hidup spring ketika selesai membuat bean dan ketika akan menghancurkan bean
* agar dapat berinteraksi dengan alur hidup spring terjadi, amak kita bisa implements interface initializingBean dan DisposableBean
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/InitializingBean.html
* DisposableBean diguakan jika kita ingin bereaksi ketika spring akan  menghancurkan bean
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/DisposableBean.html
* */
public class LifeCycleConfiguration {

    @Bean
    public Connection connection() {
        return new Connection();
    }

    /*
    * Life Cycle Annotations
    *
    * Selain menggunakan interface InitializingBean dan DisposableBean, kita juga bisa menggunakan annotation untuk mendaftarkan callback method untuk lifecycle
    * Pada annotation @Bean, terdapat method initMethod() dan destroyMethod()
    * initMethod digunakan untuk meregistrasikan method yang akan dipanggil ketika bean selesai dibuat
    * destroyMethod() digunakan untuk meregistrasikan method yang akan dipanggil ketika bean akan dihancurkan
    * Methodnya harus tanpa parameter, dan return nya akan dipedulikan, jadi sebaiknya gunakan void saja
    *
    *
    * @PostConstruct dan @PreDestroy
    * Selain menggunakan annotation @Bean, untuk menandai sebuah method adalah init method dan destroy method. kita juga bisa menggunakan annotation pada method nya secara langsung
    * ini bisa digunakan untuk menghindari kita lupa menyebutkan init dan destroy method ketika membuat @Bean
    * @PostConstruct merupakan method yang ditandai harus dipanggil ketika bean selesai dibuat
    * @PreDestroy merupakan method yang ditandai harus dipanggil ketika bean akan dihancurkan
    * Jika sudah menggunakan annotaions ini, kita tidak perlu lagi menyebutnya di @Bean
    *
    * */
    //@Bean(initMethod = "start", destroyMethod = "stop")         // gunakan yang ini jika menggunakan   initMethod() dan destroyMethod()
    @Bean
    public Server server() {
        return new Server();
    }

}

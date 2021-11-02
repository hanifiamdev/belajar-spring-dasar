package hanifiamdev.spring.core.service;


import hanifiamdev.spring.core.data.User;
import hanifiamdev.spring.core.event.LoginSuccesEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/*
* ## Event Listener ##
* Spring memiliki fitur Event Listener yang bisa kita gunakan untuk komunikasi antar class menggunakan Event
* Event di Spring merupakan object turunan dari ApplicationEvent, sedangkan Listener di Spring merupakan turunan dari ApplicationListener
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationEvent.html
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationListener.html
*
*
* ## Application Event Publisher ##
* Ketika kita ingin mengirimkan event ke listener, kita bisa menggunakan object ApplicationEventPublisher, dimana ApplicationEventPublisher juga merupakan super interface dari ApplicationContext
* Atau kita bisa menggunakan ApplicationEventPublisherAware untuk mendapatkan object ApplicationEventPublisher
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationEventPublisher.html
* */
@Component
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public boolean login(String username, String password) {
        if(isLoginSuccess(username, password)) {
            applicationEventPublisher.publishEvent(new LoginSuccesEvent(new User(username)));
            return true;
        }else {
            return false;
        }
    }

    private boolean isLoginSuccess(String username, String password) {
        return "hanif".equals(username) && "hanif".equals(password);
    }
}

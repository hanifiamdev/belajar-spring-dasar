package hanifiamdev.spring.core.listener;

import hanifiamdev.spring.core.event.LoginSuccesEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/*
* ## Event Listener Annotation ##
* Selain menggunakan interface ApplicationListener, kita juga bisa menggunakan Annotation untuk membuat Listener
* Ini lebih flexible dibanding menggunakan interface ApplicationListener
* Kita bisa menggunakan annotation @EventListener
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/event/EventListener.html
*
* ## Cara Kerja Event Listener Annotation ##
* Annotation @EventListener bekerja dengan menggunakan Bean Post Processor bernama EventListenerMethodProcessor
* EventListenerMethodProcessor mendeteksi jika ada bean yang memiliki method  dengan annotation @EventListener, maka secara otomatis
* akan  membuat listener baru, lalu meregistrasikannya ke ApplicationContext.addApplicationListener(litener)
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/event/EventListenerMethodProcessor.html
* */
@Slf4j
@Component
public class UserListener {

    @EventListener(classes = LoginSuccesEvent.class)
    public void onLoginSuccessEvent(LoginSuccesEvent event) {
        log.info("Success login again for user {}", event.getUser());
    }

    @EventListener(classes = LoginSuccesEvent.class)
    public void onLoginSuccessEvent2(LoginSuccesEvent event) {
        log.info("Success login again for user {}", event.getUser());
    }

    @EventListener(classes = LoginSuccesEvent.class)
    public void onLoginSuccessEvent3(LoginSuccesEvent event) {
        log.info("Success login again for user {}", event.getUser());
    }
}

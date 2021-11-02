package hanifiamdev.spring.core.listener;


import hanifiamdev.spring.core.event.LoginSuccesEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoginSuccessListener implements ApplicationListener<LoginSuccesEvent> {

    @Override
    public void onApplicationEvent(LoginSuccesEvent event) {
        log.info("Success login for user {}", event.getUser());
    }
}

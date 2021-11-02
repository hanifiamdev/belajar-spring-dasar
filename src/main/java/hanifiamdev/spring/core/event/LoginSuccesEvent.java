package hanifiamdev.spring.core.event;


import hanifiamdev.spring.core.data.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class LoginSuccesEvent extends ApplicationEvent {

    @Getter
    private final User user;

    public LoginSuccesEvent(User user) {
        super(user);
        this.user = user;
    }
}

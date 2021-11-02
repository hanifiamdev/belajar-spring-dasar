package hanifiamdev.spring.core.data;

import hanifiamdev.spring.core.aware.IdAware;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class Car implements IdAware {

    @Getter
    private String id;


    @Override
    public void setId(String id) {
        this.id = id;
    }
}

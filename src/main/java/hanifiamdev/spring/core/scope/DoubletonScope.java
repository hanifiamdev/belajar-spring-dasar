package hanifiamdev.spring.core.scope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.ArrayList;
import java.util.List;


/* Membuat Scope
* Jika scope yang disediakan oleh Spring tidak bisa memenuhi kebutuhan kita, kita juga bisa membuat scope sendiri
* Caranya dengan membuat class yang implement interface Scope
* Selanjutnya untuk merigistrasikannya, kita bisa membuat bean CustomeScopeConfigure
* */
@Slf4j
public class DoubletonScope implements Scope {

    private List<Object> objects = new ArrayList<>(2);

    private Long counter = -1L;

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        counter++;

        if(objects.size() == 2) {
            int index = (int) (counter % 2);
            return objects.get(index);
        } else {
            Object object = objectFactory.getObject();
            objects.add(object);
            return object;
        }
    }

    @Override
    public Object remove(String name) {
        if(!objects.isEmpty()) {
            return objects.remove(0);
        }
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}

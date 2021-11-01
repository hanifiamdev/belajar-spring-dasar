package hanifiamdev.spring.core.data;

import lombok.Getter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/*
* ## Object Provider ##
* Selain menggunakan java.utils.Optional<T>, kita juga bisa menggunakan ObjectProvider<T>
* Yang membedakan pada ObjectProvider<T> adalah jika ternyata beannya lebih dari satu, ObjectProvider<T> bisa digunakan untuk mengambil semua bean tersebut
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/ObjectProvider.html
* */
@Component
public class MultiFoo {

    @Getter
    private List<Foo> foos;

    public MultiFoo(ObjectProvider<Foo> objectProvider) {
        foos = objectProvider.stream().collect(Collectors.toList());  // menyimpan bean ke dalam list foo
    };
}

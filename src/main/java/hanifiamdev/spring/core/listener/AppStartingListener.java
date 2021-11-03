package hanifiamdev.spring.core.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/*
* ## Spring Application Event ##
*   Sebelumnya kita sudah belajar tentang Event Listener
*   Di Spring Boot, terdapat banyak sekali Event yang dikirim ketika apliaksi Spring Boot berjalan
*   Jika kita ingin, kita bisa membuat Listener untuk menerima event tersebut
*   https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/event/SpringApplicationEvent.html
* ## Daftar Event ##
*   ApplicationStartingEvent : Dikirim ketika start apliaksi
*   ApplicationContextInitializedEvent : Dikirim ketika ApplicationContext sudah di inisialisasi
*   ApplicationStartedEvent : Dikirim ketika aplikasi sudah berjalan
*   ApplicationFailedEvent : Dikirim ketika aplikasi gagal berjalan
*
* ## Menambah Listener ##
*   Beberapa Event di Spring Boot Application Event di trigger bahkan sebelum Spring membuat Application Context
*   Oleh karena itu, jika kita buat menggunakan bean, bisa saja beberapa listener tidak akan dipanggil, karena beannya belum dibuat
*   Agar lebih aman kita bisa menambahkan listener ketika membuat SpringApplication
*
* */
@Slf4j
public class AppStartingListener implements ApplicationListener<ApplicationStartingEvent> {

    // ini akan dieksekusi sebelum bean dibuat, sehinggga tidak perlu menggunakan bean
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        log.info("Application Starting");
    }
}

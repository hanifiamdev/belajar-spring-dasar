package hanifiamdev.spring.core.commandapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
*  ## Command Line Runner ##
*  Saat kita membuat aplikasi, kadang kita butuh arrgument yang diberikan pada main method
*  Spring Application bisa mengirim data argument tersebut secara otomatis ke bean yang kita buat
*  Kita hanya butuh membuat bean dari CommandLineRunner
*  CommandLineRunner secara otomatis akan dijalankan ketika Spring Application berjalan
*  https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/CommandLineRunner.html
* */
@SpringBootApplication
public class CommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandApplication.class, args);
    }
}

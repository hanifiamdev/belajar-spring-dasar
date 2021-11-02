package hanifiamdev.spring.core;

import hanifiamdev.spring.core.service.MerchantServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*
* Inheritance
* Saat kita mengakses bean, kita bisa langsung menyebutkan tipe class bean tersebut, atau bisa juga dengan parent class / parent interface bean
* Misal jika kita memiliki interface bernama MerchanService, lalu kita memiliki bean dengan object implementasi classnya MerchanServiceImpl, maka untuk mengakses beannya, kita tidak hanya bisa menggunakan tipe MerchantServiceImpl, namun juga bisas dengan MerchantService
* Namun perlu berhati - hati, jika misal MerchantService memilliki bnyak turunan, pastikan tidak terjadi error duplicate
*
* */
@Configuration
@Import(MerchantServiceImpl.class)
public class InheritanceConfiguration {
}

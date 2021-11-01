package hanifiamdev.spring.core.factory;

import hanifiamdev.spring.core.client.PaymentGatewayClient;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;


/*
* ## Factory Bean ##
* Kadang ada kasus dimana sebuah class bukanlah milik kita,misal class third party library
* Sehingga agak sulit jika kita harus menambahkan annotation pada class tersebut
* Pada kasus seperti ini,cara terbaik untuk membuat beannya adalah dengan menggunakan @Bean method
* Atau di spring, kita juga bisa menggunakan @Component, namun kita perlu wrap dalam class Factory Bean
* https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/FactoryBean.html
* */
@Component("paymentGatewayClient")
public class PaymentGatewayClientFactoryBean implements FactoryBean<PaymentGatewayClient> {


    @Override
    public PaymentGatewayClient getObject() throws Exception {
        PaymentGatewayClient client = new PaymentGatewayClient();
        client.setEndpoint("https://example.com");
        client.setPrivateKey("private");
        client.setPublicKey("public");
        return client;
    }

    @Override
    public Class<?> getObjectType() {
        return PaymentGatewayClient.class;
    }
}

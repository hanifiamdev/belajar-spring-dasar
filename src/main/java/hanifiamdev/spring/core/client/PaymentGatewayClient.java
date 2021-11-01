package hanifiamdev.spring.core.client;

import lombok.Data;
/*
* Untuk simulasi Factory Bean jadi kelas ini dimisalkan tidak bisa dimodifika seperti layaknya third -party
* */
@Data
public class PaymentGatewayClient {

    private String endpoint;

    private String privateKey;

    private String publicKey;
}

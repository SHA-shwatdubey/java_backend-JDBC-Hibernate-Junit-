package pom.capgemini.Basics_of_spring_payment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pom.capgemini.DemoConfiguration;

public class mainPayment {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);

        PaymentService service = ioc.getBean(PaymentService.class);
        service.payUsingDefault(499.0);

        Payment upi = (Payment) ioc.getBean("upiPayment");
        service.payUsing(upi, 199.0);

        ioc.close();
    }
}

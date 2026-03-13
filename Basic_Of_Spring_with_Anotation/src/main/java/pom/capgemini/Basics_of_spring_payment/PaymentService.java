package pom.capgemini.Basics_of_spring_payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final Payment payment;

    @Autowired
    public PaymentService(@Qualifier("creditCardPayment") Payment payment) {
        this.payment = payment;
    }

    public void payUsingDefault(double amount) {
        payment.pay(amount);
    }

    public void payUsing(Payment payment, double amount) {
        payment.pay(amount);
    }
}


package pom.capgemini.Basics_of_spring_payment;

import org.springframework.stereotype.Component;

@Component("creditCardPayment")
public class CreditCart implements Payment {

    @Override
    public String getMethodName() {
        return "Credit Card";
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via " + getMethodName());
    }

    @Override
    public String toString() {
        return "CreditCart Payment Method";
    }
}

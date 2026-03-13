package pom.capgemini.Basics_of_spring_payment;

import org.springframework.stereotype.Component;

@Component("upiPayment")
public class UPI implements Payment {
    @Override
    public String getMethodName() {
        return "UPI";
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via " + getMethodName());
    }

    @Override
    public String toString() {
        return "UPI Payment Method";
    }
}

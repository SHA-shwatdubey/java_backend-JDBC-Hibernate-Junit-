package pom.capgemini.Basics_of_spring_payment;

public interface Payment {
    String getMethodName();

    void pay(double amount);
}

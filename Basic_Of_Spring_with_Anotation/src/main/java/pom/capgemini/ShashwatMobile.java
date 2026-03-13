package pom.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ========================================================
 * @Component + @Autowired + @Value ANNOTATION
 * ========================================================
 *
 * ShashwatMobile class - Mobile ka owner details
 *
 * Features:
 * - Owner ka naam, age, city
 * - Mobile phone ke liye owner info
 * - Dependency Injection (@Autowired) - Mobile bean ko inject karega
 * - @Value se owner ke properties inject hongi
 * ========================================================
 */
@Component
public class ShashwatMobile {

    /**
     * @Value - Owner ka naam
     * Shashwat Phone ka owner
     */
    @Value("${owner.name:Shashwat}")
    private String ownerName;

    /**
     * @Value - Owner ki age
     */
    @Value("${owner.age:20}")
    private int ownerAge;

    /**
     * @Value - Owner ki city
     */
    @Value("${owner.city:India}")
    private String ownerCity;

    /**
     * @Value - Owner ka email
     */
    @Value("${owner.email:shashwat@example.com}")
    private String ownerEmail;

    /**
     * @Value - Owner ka phone number
     */
    @Value("${owner.phone:9555660256}")
    private String ownerPhone;

    /**
     * @Autowired - Mobile dependency
     * Spring automatically Mobile bean inject karega
     * Field injection example
     */
    @Autowired
    private Mobile mobile;

    // Default Constructor
    public ShashwatMobile() {
        System.out.println("✓ ShashwatMobile object created by Spring!");
    }

    // Getters aur Setters
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getOwnerAge() {
        return ownerAge;
    }

    public void setOwnerAge(int ownerAge) {
        this.ownerAge = ownerAge;
    }

    public String getOwnerCity() {
        return ownerCity;
    }

    public void setOwnerCity(String ownerCity) {
        this.ownerCity = ownerCity;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    // Display owner aur mobile information
    public void displayCompleteInfo() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   📱 SHASHWAT MOBILE OWNER INFO 📱      ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\n--- 👤 OWNER DETAILS ---");
        System.out.println("Name: " + ownerName);
        System.out.println("Age: " + ownerAge + " years");
        System.out.println("City: " + ownerCity);
        System.out.println("Email: " + ownerEmail);
        System.out.println("Phone: " + ownerPhone);

        System.out.println("\n--- 📱 MOBILE DETAILS ---");
        if (mobile != null) {
            System.out.println("Brand: " + mobile.getBrand());
            System.out.println("Model: " + mobile.getModel());
            System.out.println("Storage: " + mobile.getStorage());
            System.out.println("RAM: " + mobile.getRam() + " GB");
            System.out.println("Color: " + mobile.getColor());
            System.out.println("Price: ₹" + mobile.getPrice());
            System.out.println("OS: " + mobile.getOs());
            System.out.println("5G: " + (mobile.is5g() ? "✓ Yes" : "✗ No"));
        } else {
            System.out.println("No mobile assigned!");
        }

        System.out.println("\n════════════════════════════════════════\n");
    }

    // Short info display
    public void displayOwnerInfo() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║       👤 OWNER INFORMATION 👤           ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Name: " + ownerName);
        System.out.println("Age: " + ownerAge);
        System.out.println("City: " + ownerCity);
        System.out.println("Email: " + ownerEmail);
        System.out.println("Phone: " + ownerPhone);
        System.out.println("════════════════════════════════════════\n");
    }
}

package pom.capgemini;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ========================================================
 * @Component + @Value ANNOTATION DEMONSTRATION
 * ========================================================
 *
 * Mobile class - Smartphone details ke saath
 * @Component se automatically bean banega
 * @Value se properties aur default values inject hongi
 *
 * FEATURES:
 * - Mobile number
 * - Brand aur Model
 * - Storage, RAM, Color
 * - Price aur 5G support
 * ========================================================
 */
@Component
public class Mobile {

    /**
     * @Value - Mobile phone number
     */
    @Value("${mobile.phone.number:9555660256}")
    private String mobileNumber;

    /**
     * @Value - Mobile brand
     */
    @Value("${mobile.brand:Apple}")
    private String brand;

    /**
     * @Value - Mobile model name
     */
    @Value("${mobile.model:iPhone 14 Pro Max}")
    private String model;

    /**
     * @Value - Mobile storage capacity
     */
    @Value("${mobile.storage:128GB}")
    private String storage;

    /**
     * @Value - Mobile color
     */
    @Value("${mobile.color:Silver}")
    private String color;

    /**
     * @Value - Mobile RAM
     */
    @Value("${mobile.ram:6}")
    private int ram;

    /**
     * @Value - Mobile price
     */
    @Value("${mobile.price:99999}")
    private double price;

    /**
     * @Value - Is 5G capable
     */
    @Value("${mobile.is5g:true}")
    private boolean is5g;

    /**
     * @Value - Operating System
     */
    @Value("${mobile.os:iOS}")
    private String os;

    // Default Constructor
    public Mobile() {
        System.out.println("✓ Mobile object created by Spring!");
    }

    // Getters aur Setters
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean is5g() {
        return is5g;
    }

    public void set5g(boolean is5g) {
        this.is5g = is5g;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    // Display mobile details
    public void displayMobileInfo() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      📱 MOBILE PHONE DETAILS 📱         ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Phone Number: " + mobileNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Storage: " + storage);
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Color: " + color);
        System.out.println("Price: ₹" + price);
        System.out.println("OS: " + os);
        System.out.println("5G Capable: " + (is5g ? "✓ Yes" : "✗ No"));
        System.out.println("════════════════════════════════════════\n");
    }
}

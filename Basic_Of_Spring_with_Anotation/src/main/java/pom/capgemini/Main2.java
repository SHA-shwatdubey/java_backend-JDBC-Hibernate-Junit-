package pom.capgemini;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ============================================
 * MAIN2 - MOBILE & SHASHWATMOBILE
 * ============================================
 *
 * Ye Main2.java sirf Mobile aur ShashwatMobile
 * classes ke liye hai
 *
 * DemoConfiguration same hai jo dono Main files use karengi
 * Real-world example: Phone aur uska owner
 */
public class Main2 {
    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║   MAIN2 - MOBILE & SHASHWATMOBILE DEMONSTRATION               ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        // Spring Container initialize karo
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);

        System.out.println("✓ Spring Container successfully initialized!\n");
        System.out.println("=" .repeat(70) + "\n");

        // ===== STEP 1: Mobile Bean =====
        System.out.println("STEP 1: @Component + @Value - Mobile Bean\n");
        System.out.println("Mobile class (@Component se automatically detect):");
        System.out.println("Properties (@Value se inject):");
        System.out.println("  - mobileNumber: @Value(\"${mobile.phone.number:9555660256}\")");
        System.out.println("  - brand: @Value(\"${mobile.brand:Apple}\")");
        System.out.println("  - model: @Value(\"${mobile.model:iPhone 14 Pro Max}\")");
        System.out.println("  - storage: @Value(\"${mobile.storage:128GB}\")");
        System.out.println("  - color: @Value(\"${mobile.color:Silver}\")");
        System.out.println("  - ram: @Value(\"${mobile.ram:6}\")");
        System.out.println("  - price: @Value(\"${mobile.price:99999}\")");
        System.out.println("  - is5g: @Value(\"${mobile.is5g:true}\")");
        System.out.println("  - os: @Value(\"${mobile.os:iOS}\")\n");

        Mobile mobile = ioc.getBean(Mobile.class);
        System.out.println("1️⃣  Mobile Bean (via @Component):");
        mobile.displayMobileInfo();

        System.out.println("=" .repeat(70) + "\n");

        // ===== STEP 2: ShashwatMobile Bean with Dependency Injection =====
        System.out.println("STEP 2: @Component + @Autowired + @Value - ShashwatMobile Bean\n");
        System.out.println("ShashwatMobile class (@Component se automatically detect):");
        System.out.println("Properties (@Value se inject):");
        System.out.println("  - ownerName: @Value(\"${owner.name:Shashwat}\")");
        System.out.println("  - ownerAge: @Value(\"${owner.age:20}\")");
        System.out.println("  - ownerCity: @Value(\"${owner.city:India}\")");
        System.out.println("  - ownerEmail: @Value(\"${owner.email:shashwat@example.com}\")");
        System.out.println("  - ownerPhone: @Value(\"${owner.phone:9555660256}\")\n");
        System.out.println("Dependency Injection (@Autowired):");
        System.out.println("  - mobile: Mobile bean (@Autowired - Automatically Injected!)\n");

        ShashwatMobile shashwatMobile = ioc.getBean(ShashwatMobile.class);
        System.out.println("2️⃣  ShashwatMobile Bean (via @Component with @Autowired):");
        shashwatMobile.displayCompleteInfo();

        System.out.println("=" .repeat(70) + "\n");

        // ===== STEP 3: Dependency Injection Details =====
        System.out.println("STEP 3: Dependency Injection - How It Works\n");
        System.out.println("ShashwatMobile.mobile ← Spring automatically inject karta hai\n");
        System.out.println("Proof:");
        System.out.println("  Mobile object is NOT null: " + (shashwatMobile.getMobile() != null ? "✓ YES" : "✗ NO"));
        System.out.println("  Mobile brand: " + shashwatMobile.getMobile().getBrand());
        System.out.println("  Mobile model: " + shashwatMobile.getMobile().getModel());
        System.out.println("  Mobile price: ₹" + shashwatMobile.getMobile().getPrice());
        System.out.println();

        System.out.println("=" .repeat(70) + "\n");

        // ===== STEP 4: Individual Property Display =====
        System.out.println("STEP 4: Detailed Property Display\n");
        System.out.println("Owner Details (@Value se inject):");
        System.out.println("  - Name: " + shashwatMobile.getOwnerName());
        System.out.println("  - Age: " + shashwatMobile.getOwnerAge());
        System.out.println("  - City: " + shashwatMobile.getOwnerCity());
        System.out.println("  - Email: " + shashwatMobile.getOwnerEmail());
        System.out.println("  - Phone: " + shashwatMobile.getOwnerPhone());
        System.out.println();

        System.out.println("Mobile Details (@Autowired se inject):");
        System.out.println("  - Brand: " + shashwatMobile.getMobile().getBrand());
        System.out.println("  - Model: " + shashwatMobile.getMobile().getModel());
        System.out.println("  - Storage: " + shashwatMobile.getMobile().getStorage());
        System.out.println("  - Color: " + shashwatMobile.getMobile().getColor());
        System.out.println("  - RAM: " + shashwatMobile.getMobile().getRam() + " GB");
        System.out.println("  - Price: ₹" + shashwatMobile.getMobile().getPrice());
        System.out.println("  - OS: " + shashwatMobile.getMobile().getOs());
        System.out.println("  - 5G: " + (shashwatMobile.getMobile().is5g() ? "✓ Yes" : "✗ No"));
        System.out.println();

        System.out.println("=" .repeat(70) + "\n");

        // ===== STEP 5: Bean Modification =====
        System.out.println("STEP 5: Bean Modification Demo\n");
        System.out.println("Owner ki details modify kar sakte hain:\n");

        shashwatMobile.setOwnerName("Shashwat Sharma");
        shashwatMobile.setOwnerAge(21);
        shashwatMobile.setOwnerCity("Mumbai");

        System.out.println("Updated Owner Details:");
        shashwatMobile.displayOwnerInfo();

        System.out.println("=" .repeat(70) + "\n");

        // ===== FINAL SUMMARY =====
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║              MAIN2 - ANNOTATIONS SUMMARY                       ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        System.out.println("📌 ANNOTATIONS USED IN MAIN2:\n");
        System.out.println("1. @Component (Mobile, ShashwatMobile)");
        System.out.println("   ➜ Automatic bean creation");
        System.out.println("   ➜ @ComponentScan se detect hota hai\n");

        System.out.println("2. @Value (Mobile, ShashwatMobile)");
        System.out.println("   ➜ Phone aur Owner ki properties inject hoti hain");
        System.out.println("   ➜ Default values ke saath safe rehta hai\n");

        System.out.println("3. @Autowired (ShashwatMobile)");
        System.out.println("   ➜ Mobile bean automatically inject hota hai");
        System.out.println("   ➜ ShashwatMobile aur Mobile linked ho jate hain");
        System.out.println("   ➜ Dependency Injection ka real-world example!\n");

        System.out.println("=" .repeat(70) + "\n");

        System.out.println("🎯 REAL-WORLD SCENARIO:\n");
        System.out.println("Shashwat ek Apple iPhone rakhta hai.");
        System.out.println("Mobile (phone) aur ShashwatMobile (owner) interconnected hain.");
        System.out.println("@Autowired se automatic linking hoti hai!");
        System.out.println();
        System.out.println("Ye praktikal example hai kaise Spring real objects ko manage karta hai!\n");

        System.out.println("=" .repeat(70) + "\n");

        // Close container
        ioc.close();
        System.out.println("✓ Spring Container closed successfully!");
        System.out.println("\n🎉 MAIN2 Demonstration Complete! 🎉\n");
    }
}


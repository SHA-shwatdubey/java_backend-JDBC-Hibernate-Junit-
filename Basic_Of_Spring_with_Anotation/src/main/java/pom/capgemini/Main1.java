package pom.capgemini;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ============================================
 * MAIN1 - EMPLOYEE, PERSON, DEPARTMENT
 * ============================================
 *
 * Ye Main1.java sirf Employee, Person aur Department
 * classes ke liye hai
 *
 * DemoConfiguration same hai jo dono Main files use karengi
 */
public class Main1 {
    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║   MAIN1 - EMPLOYEE, PERSON & DEPARTMENT DEMONSTRATION          ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        // Spring Container initialize karo
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);

        System.out.println("✓ Spring Container successfully initialized!\n");
        System.out.println("=" .repeat(70) + "\n");

        // ===== STEP 1: Employee Bean =====
        System.out.println("STEP 1: @Component + @Value - Employee Bean\n");
        System.out.println("Employee class (@Component se automatically detect):");
        System.out.println("Properties (@Value se inject):");
        System.out.println("  - id: @Value(\"0\")");
        System.out.println("  - name: @Value(\"${employee.name:Unassigned Employee}\")");
        System.out.println("  - salary: @Value(\"0.0\")\n");

        Employee empComponent = ioc.getBean(Employee.class);
        System.out.println("1️⃣  Employee Bean (via @Component):");
        empComponent.msg();
        System.out.println();

        System.out.println("=" .repeat(70) + "\n");

        // ===== STEP 2: Person Bean =====
        System.out.println("STEP 2: @Component + @Value - Person Bean\n");
        System.out.println("Person class (@Component se automatically detect):");
        System.out.println("Properties (@Value se inject):");
        System.out.println("  - name: @Value(\"Unknown Person\")");
        System.out.println("  - age: @Value(\"0\")");
        System.out.println("  - city: @Value(\"${person.city:Unknown City}\")\n");

        Person person = ioc.getBean(Person.class);
        System.out.println("2️⃣  Person Bean (via @Component):");
        person.display();
        System.out.println();

        System.out.println("=" .repeat(70) + "\n");

        // ===== STEP 3: Manual Employee Beans (via @Bean) =====
        System.out.println("STEP 3: @Bean - Manual Employee Beans\n");
        System.out.println("DemoConfiguration mein @Bean methods se beans create kiye gaye:\n");

        Employee manualEmp = (Employee) ioc.getBean("manualEmployee");
        System.out.println("3️⃣  Manual Employee Bean:");
        manualEmp.msg();
        System.out.println();

        Employee manager = (Employee) ioc.getBean("manager");
        System.out.println("4️⃣  Manager Bean:");
        manager.msg();
        System.out.println();

        Employee developer = (Employee) ioc.getBean("developer");
        System.out.println("5️⃣  Developer Bean:");
        developer.msg();
        System.out.println();

        Person manualPerson = (Person) ioc.getBean("manualPerson");
        System.out.println("6️⃣  Manual Person Bean:");
        manualPerson.display();
        System.out.println();

        System.out.println("=" .repeat(70) + "\n");

        // ===== STEP 4: Department Bean with Dependency Injection =====
        System.out.println("STEP 4: @Component + @Autowired + @Value - Department Bean\n");
        System.out.println("Department class:");
        System.out.println("  - Person automatically inject hota hai (@Autowired Field Injection)");
        System.out.println("  - Employee automatically inject hota hai (@Autowired Constructor Injection)");
        System.out.println("  - Properties @Value se inject hoti hain\n");

        Department dept = ioc.getBean(Department.class);
        dept.setDepartmentName("Software Development Department");
        System.out.println("7️⃣  Department Bean (with Dependency Injection):");
        dept.showDepartmentInfo();

        System.out.println("=" .repeat(70) + "\n");

        // ===== STEP 5: @Value Details =====
        System.out.println("STEP 5: @Value Properties Display\n");
        System.out.println("Employee Bean - @Value se values:");
        System.out.println("   - id: " + empComponent.getId());
        System.out.println("   - name: " + empComponent.getName());
        System.out.println("   - salary: " + empComponent.getSalary());
        System.out.println();

        System.out.println("Person Bean - @Value se values:");
        System.out.println("   - name: " + person.getName());
        System.out.println("   - age: " + person.getAge());
        System.out.println("   - city: " + person.getCity());
        System.out.println();

        System.out.println("Department Bean - @Value se values:");
        System.out.println("   - departmentName: " + dept.getDepartmentName());
        System.out.println("   - employeeCount: " + dept.getEmployeeCount());
        System.out.println("   - departmentBudget: " + dept.getDepartmentBudget());
        System.out.println();

        System.out.println("=" .repeat(70) + "\n");

        // ===== STEP 6: Bean Modification =====
        System.out.println("STEP 6: Bean Modification Demo\n");
        System.out.println("Beans ko modify bhi kar sakte hain:\n");

        person.setName("Rajesh Verma");
        person.setAge(28);
        person.setCity("Delhi");
        System.out.println("Modified Person Bean:");
        person.display();
        System.out.println();

        System.out.println("=" .repeat(70) + "\n");

        // ===== FINAL SUMMARY =====
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║              MAIN1 - ANNOTATIONS SUMMARY                       ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        System.out.println("📌 ANNOTATIONS USED IN MAIN1:\n");
        System.out.println("1. @Component (Employee, Person, Department)");
        System.out.println("   ➜ Automatic bean creation");
        System.out.println("   ➜ @ComponentScan se detect hota hai\n");

        System.out.println("2. @Value (All classes)");
        System.out.println("   ➜ Properties/values inject karte hain");
        System.out.println("   ➜ Default values ke saath\n");

        System.out.println("3. @Autowired (Department)");
        System.out.println("   ➜ Automatic dependency injection");
        System.out.println("   ➜ Person aur Employee beans automatically linked\n");

        System.out.println("4. @Bean (DemoConfiguration)");
        System.out.println("   ➜ Manual bean creation");
        System.out.println("   ➜ Pre-configured beans banaye hain\n");

        System.out.println("=" .repeat(70) + "\n");

        System.out.println("🎯 KEY CONCEPTS:\n");
        System.out.println("✅ IOC Container - Spring objects manage karta hai");
        System.out.println("✅ Dependency Injection - @Autowired se automatic linking");
        System.out.println("✅ Property Injection - @Value se automatic value assignment");
        System.out.println("✅ Component Scanning - @ComponentScan automatic detection");
        System.out.println("✅ Bean Lifecycle - Objects automatically manage hote hain\n");

        System.out.println("=" .repeat(70) + "\n");

        // Close container
        ioc.close();
        System.out.println("✓ Spring Container closed successfully!");
        System.out.println("\n🎉 MAIN1 Demonstration Complete! 🎉\n");
    }
}


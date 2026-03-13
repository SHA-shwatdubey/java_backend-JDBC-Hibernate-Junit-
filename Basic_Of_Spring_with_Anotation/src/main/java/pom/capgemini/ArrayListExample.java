package pom.capgemini;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Aman");
        names.add("Riya");
        names.add("Kunal");
        names.add("Zoya");

        System.out.println("Initial list: " + names);

        System.out.println("Item at index 1: " + names.get(1));

        names.set(2, "Kunal Sharma");
        System.out.println("After update: " + names);

        names.remove("Aman");
        System.out.println("After remove: " + names);

        Collections.sort(names);
        System.out.println("Sorted list: " + names);

        System.out.println("Contains 'Riya'? " + names.contains("Riya"));
        System.out.println("Size: " + names.size());

        System.out.println("Iterating with for-each:");
        for (String name : names) {
            System.out.println("- " + name);
        }
    }
}


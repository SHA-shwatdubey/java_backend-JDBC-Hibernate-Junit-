package pom.capgemini;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> rollToName = new HashMap<>();

        rollToName.put(101, "Anita");
        rollToName.put(102, "Bhavesh");
        rollToName.put(103, "Chitra");
        rollToName.put(104, "Deepak");

        System.out.println("Initial map: " + rollToName);

        System.out.println("Name for 102: " + rollToName.get(102));

        rollToName.put(103, "Chitra Mehta");
        System.out.println("After update: " + rollToName);

        rollToName.remove(101);
        System.out.println("After remove: " + rollToName);

        System.out.println("Contains key 104? " + rollToName.containsKey(104));
        System.out.println("Contains value 'Anita'? " + rollToName.containsValue("Anita"));
        System.out.println("Size: " + rollToName.size());

        System.out.println("Iterating entries:");
        for (Map.Entry<Integer, String> entry : rollToName.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}


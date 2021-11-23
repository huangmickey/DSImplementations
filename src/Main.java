import java.util.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
/*        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(5);
        queue.add(1);
        queue.add(3);
        queue.add(2);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }*/

        // Map (Key, Value) --> Collection of (K,V) Pairs.
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Mosh");
        map.put(2, "John");
        map.put(3, "Mary");
        System.out.println(map);
        map.put(3, "Marianne");
        System.out.println(map);

        //maps allow null keys or values
        map.put(4, null);
        System.out.println("\n"+map);

        map.put(null, null);
        System.out.println("\n"+map);

        map.remove(null);
        System.out.println("\n"+map);

        map.containsKey(3);             // O(1) -> because finds passes parameter to hash function and checks if it has an object
        map.containsValue("Mosh");      // O(n) -> because it iterates through all values, cannot pass value to hash function to get location

        for (int key : map.keySet()) {
            System.out.println(key);
        }

        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            System.out.println(pair);
        }

        Set<Integer> set = new HashSet<>();
        int[] numbers = {1, 2, 3, 3, 2, 1, 4};
        for (int number : numbers)
            set.add(number);
        System.out.println(set);

    }
}

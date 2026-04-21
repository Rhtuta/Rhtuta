package Set.LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        //duplicacy not allowed
        //Insertion order there due to linked list property of linking
        // random access not here also,not.get()func
        Set<Integer> set = new LinkedHashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);

        //duplicates
        set.add(20);
        set.add(10);
        System.out.println(set);
    }
}

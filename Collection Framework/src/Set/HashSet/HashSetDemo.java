package Set.HashSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        //duplicacy not allowed
        //Insertion order is not here means random storing
        // random access not here due to not knowing of order of storing,not.get()func
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20);
        set.add(10);
        System.out.println(set);
    }
}

package Set.TreeSet;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        //duplicacy not allowed
        //Insertion order will converted in sorted order
        // random access not here also,not.get()func
        Set<Integer> set = new TreeSet<>();
        set.add(50);
        set.add(770);
        set.add(70);
        set.add(140);
        set.add(60);

        //duplicates
        set.add(70);
        set.add(50);
        System.out.println(set);
    }
}

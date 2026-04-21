package Comparable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ComparableDemo {
    public static void main(String[] args) {
        ArrayList<NumberDemo> al = new ArrayList<>();
        al.add(new NumberDemo(5));
        al.add(new NumberDemo(2));
        al.add(new NumberDemo(9));
        al.add(new NumberDemo(6));
        System.out.println(al);
        Collections.sort(al);//natural sorting
        System.out.println(al);
    }
}

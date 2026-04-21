package List.ArrayList;

import java.util.Enumeration;
import java.util.Vector;

public class VectorAndEunemerationDemo {
    public static void main(String[] args) {
        //vector comes under legacy classes
//vector is same as List but it's most of the methods are synchronized so its thread safe
        Vector<Integer> nums = new Vector<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(40);
        System.out.println(nums);

        // Eunemeration to fetch elements in vector and stack only
        // but can't remove elements
        Enumeration<Integer> elements = nums.elements();
        System.out.println("Fetched using Eunemeration nextelement() method: "
                +elements.nextElement());
        // to traverse/fetch all elements in vector
        // check if there is any element,if yes then print next element and
        // then again check if true then repeat otherwise false then stop
        while (elements.hasMoreElements()){
            System.out.println("Fetched using Eunemeration nextelement() method: "
                    +elements.nextElement());
        }

    }
}

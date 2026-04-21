package List.ArrayList;

import java.util.Enumeration;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        //Stack comes under legacy classes
        Stack<Integer> nums = new Stack<>();
        nums.push(10);
        nums.push(20);
        nums.push(30);
        nums.push(40);
        nums.push(50);
        System.out.println(nums);
        System.out.println("pop: "+nums.pop());
        System.out.println("pop: "+nums.pop());
        System.out.println(nums);
        nums.push(60);
        nums.push(70);
        System.out.println(nums);

        // Eunemeration to fetch elements in vector and stack only
        // but can't remove elements
        Enumeration<Integer> elements = nums.elements();
        System.out.println("Fetched using Eunemeration nextelement() method: "
                +elements.nextElement());
        // to traverse/fetch all elements in stack
        // check if there is any element,if yes then print next element and
        // then again check if true then repeat otherwise false then stop
        while (elements.hasMoreElements()){
            System.out.println("Fetched using Eunemeration nextelement() method: "
                    +elements.nextElement());
        }




    }
}

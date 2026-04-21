package List.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArraylistAndIteratorDemo {
    public static void main(String[] args) {
        //duplicacy
        //insertion order
        //random access
        //same as vector but not thread safe because its most of the methods are not synchronized

        List<Integer> nums = new ArrayList<>();//<Integer> -> "generic" type of list here
        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(40);
        nums.add(50);
        System.out.println(nums);


        //methods
        System.out.println(nums.size());
        System.out.println(nums.get(3));
        nums.remove(4);
        System.out.println(nums);
        nums.clear();
        System.out.println(nums.isEmpty());
        System.out.println(nums);
        nums.add(0,90);
        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(40);
        nums.add(50);
        System.out.println(nums);

        Iterator<Integer> iterator = nums.iterator();
        // iterator can used in ALL collection framework and
        // has remove function to remove a element from list
        // don't use hasNext function twice because it leads to move twice in list
        // which leads to exception
        while(iterator.hasNext()){
            int data = iterator.next();
            if (data == 30){
                System.out.println("Removing 30");
                iterator.remove();
            }
            else {
                System.out.println("Fetching list using iterator: "+data);
            }
        }
        System.out.println(nums);

        //without using remove function ,
        //here we can use single iterator.hasnext() in SOP stmt
        //can't use same iterator because its traversed all elements and has nothing
        // so reset the  iterator by creating new iterator object
        Iterator<Integer> iterator2 = nums.iterator();
        while(iterator2.hasNext()){
            System.out.println("Fetching list using iterator: "+iterator2.next());
        }
        System.out.println(nums);

    }
}

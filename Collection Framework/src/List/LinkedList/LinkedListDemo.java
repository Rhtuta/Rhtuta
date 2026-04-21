package List.LinkedList;
import java.util.Scanner;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Enter List Data: ");
        for (int i = 0; i < 5; i++) {
            list.add(sc.nextLine());
        }
        System.out.println(list);
        System.out.println("first node: "+list.getFirst());
        System.out.println("last node: "+list.getLast());
        System.out.println("Third index node: "+list.get(3));
        //random access not allowed
        //internally get(3) will make loop to index 3 to return value
        //Arraylist implement RandomAccess Interface to allow random access and
        // this interface has no body known as marker interface
        // but jvm provides them power who implements this interface to random access
    }
}

package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIterator {// used only for list and
    // preferrable for list due to many methods
    // like next,previous,add,remove and update using set function
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("java","devops",
                "python","dsa","javascript"));
        java.util.ListIterator<String> listIter = list.listIterator();
        System.out.println(list);


        System.out.println("Added C++ in index 0 since iterator is at 0 " +
                "index right now");
        listIter.add("C++");

        while (listIter.hasNext()){
            String data = listIter.next();
            if(data.equals("javascript")){
                System.out.println("Removed javascript from list");
                listIter.remove();
            }
            else {
                System.out.println("List using listiterator: "+data);
            }
            if(data.equals("python")){
                listIter.set("React");
                System.out.println("List using listiterator after " +
                        "updating python to React: "+data);
            }

        }

        //iterator must be at last index of list to use previous traversing
        while (listIter.hasPrevious()){
            System.out.println("list using Listiterator using previous: "+listIter.previous());
        }


    }
}

package Hashmap.TreemapDemo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MyTreemap {
    //duplicates keys not allowed
    //Insertion order will converted in sorted order based on keys not value
    //not thread safe
    public static void main(String[] args) {
        Map<String,Integer> map = new TreeMap<>();
        //for reversing use comparator.reverseorder
        //Map<String,Integer> map = new TreeMap<>(Comparator.reverseOrder());
        map.put("D",4);
        map.put("A",1);
        map.put("C",2);
        map.put("C",3);//here three key, will have 7, repalced 3 due to duplicate
        map.put("B",2);
       // map.put(null,5);not allowed nullPointerException
       // map.put(null,6);not allowed nullPointerException
        map.put("E",null);// allowed but value will be null
        System.out.println(map);
        //internally put will store value by making hash of key and then mode
        // with 16 to store at according to 0-15 indexes in doubly linked list
        // if multiple keys occurs at same index then store using chaining

        System.out.println(map.remove("A",1));
        System.out.println(map);
        map.put("A",1);
        System.out.println(map.get("A"));
        // get function will do same as put to hash key,then mode 16, then find
        //but put ,will compare with equals to find same key
        // from various keys in doubly LL chaining

        //ways of fetching map elements
        // 1. using get
        if(map.containsKey("D")){
            System.out.println("D");
        }
        if(map.containsValue(1)){
            System.out.println("A");
        }

        // fetching all elements of map
        // 2. using keyset
        for(String data:map.keySet()){
            System.out.println("key: "+data+" value: "+map.get(data));
        }

        // 3.using values
        for (Integer value: map.values())
        {
            System.out.println("values : "+value);
        }
        // 4 . using entryset to get keyvalue pair
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            System.out.println("key: "+entry.getKey()+" value: "+entry.getValue());
        }

        // using foreach easiest way
        map.forEach((key,value) ->{
            System.out.println("key: "+key+ " value : "+ value);
        });



    }
}

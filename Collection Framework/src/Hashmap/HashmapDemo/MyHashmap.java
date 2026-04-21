package Hashmap.HashmapDemo;

import java.util.HashMap;
import java.util.Map;

public class MyHashmap {
    //duplicates keys not allowed
    //order not available
    //not thread safe
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("three",7);//here three key, will have 7, repalced 3 due to duplicate
        map.put("four",4);
        map.put(null,5);//null is allowed due to string default value is null
        //due to this null 5 will be stored in 0th index of hashmap of 0-15 index
        // total 16 default hashmap indexes
        map.put(null,6);//null will replace 5 to 6 due to dupli. key not allowed
        map.put("five",null);// allowed but value will be null
        System.out.println(map);
        //internally put will store value by making hash of key and then mode
        // with 16 to store at according to 0-15 indexes in doubly linked list
        // if multiple keys occurs at same index then store using chaining

        System.out.println(map.remove("one",1));
        System.out.println(map);
        map.put("one",1);
        System.out.println(map.get("one"));
        // get function will do same as put to hash key,then mode 16, then find
        //but put ,will compare with equals to find same key
        // from various keys in doubly LL chaining

        //ways of fetching map elements
        // 1. using get
        if(map.containsKey("four")){
            System.out.println("four");
        }
        if(map.containsValue(1)){
            System.out.println("one");
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

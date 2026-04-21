package List.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ClearDemo {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            nums.add(i);
        }
        if (nums.isEmpty()){
            System.out.println("List is empty");
        }
        else {
            System.out.println("List is not empty");
        }
        System.out.println(nums);
        nums.clear();
        if (nums.isEmpty()){
            System.out.println("List is empty");
        }
        else {
            System.out.println("List is not empty");
        }
        System.out.println(nums);
    }
}

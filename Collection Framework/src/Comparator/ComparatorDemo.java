package Comparator;

import java.util.*;

public class ComparatorDemo {
    public static void main(String[] args) {
        //comparator can do multiple sortiong but comparable can't
        List<Student> ts = new ArrayList<>();
        ts.add(new Student(1,"Rohit",70));
        ts.add(new Student(11,"Vijay",60));
        ts.add(new Student(8,"Hridoy",40));
        ts.add(new Student(9,"Yuvraj",30));
        System.out.println(ts);
        Collections.sort(ts,new MyComparator());
        System.out.println(ts);
        Comparator<Student>  myroll = (ob1, ob2) -> ob1.rollno - ob2.rollno;
        Collections.sort(ts,myroll);
        System.out.println(ts);
        Comparator<Student> mycom =  Comparator.comparing(Student::getName).thenComparing(Student::getRollno).thenComparing(Student::getMarks);
        Collections.sort(ts,mycom);
        System.out.println(ts);
    }

}

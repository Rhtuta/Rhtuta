package List.ArrayList;

import java.util.ArrayList;
import java.util.List;

class Student{
    String name;
    int id;
    String course;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", course='" + course + '\'' +
                '}';
    }

    public Student(String name, int id, String course) {
        this.name = name;
        this.id = id;
        this.course = course;
    }
}
public class CustomList{
    public static void main(String[] args) {
        Student s1 = new Student("Rohit", 1, "java");
        Student s2 = new Student("Karan", 2, "dsa");
        Student s3 = new Student("Rahul", 3, "devops");
        List<Student> student = new ArrayList<>();
        student.add(s1);
        student.add(s2);
        student.add(s3);
        System.out.println(student);
    }
}

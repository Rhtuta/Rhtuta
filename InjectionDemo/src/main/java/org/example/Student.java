package org.example;

public class Student {
    public Course course;

    public Student() {
    }
    //constructor injection
    public Student(Course course) {
        this.course = course;
    }

    // Setter Injection
    /*public void setCourse(Course course) {
        this.course = course;
    }*/

    public void study(){
        int start = course.enroll();
        if (start>=1){
            System.out.println("Study Started");
        }
        else {
            System.out.println("not enrolled in course");
        }
    }
}

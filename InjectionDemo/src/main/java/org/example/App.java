package org.example;

public class App {
    public static void main(String[] args) {
       Student student = new Student();
       // Student student = new Student(new JavaFullStack());//constructor injection
        //Course course = new DSA();// dependency injection & manual
        //student.setCourse(course); //setter injection
        student.course=new JavaFullStack();//variable /field injection

        student.study();
    }

}

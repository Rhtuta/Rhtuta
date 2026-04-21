package org.cfs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("BeanFactory started.....");
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        System.out.println("Beanfile loaded");

        System.out.println("sending request.....");
        Car car = context.getBean(Car.class);
        car.drive();


    }
}

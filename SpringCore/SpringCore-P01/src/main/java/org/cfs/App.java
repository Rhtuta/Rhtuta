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

        System.out.println("first call.....");
        Car car1 = context.getBean(Car.class);

        System.out.println("second call.....");
        Car car2 = context.getBean(Car.class);

        System.out.println("car1 = car2 ? "+(car1 == car2));

        System.out.println("first call.....");
        petrolEngine p1 = context.getBean(petrolEngine.class);

        System.out.println("second call.....");
        petrolEngine p2 = context.getBean(petrolEngine.class);

        System.out.println("p1 = p2 ? "+(p1 == p2));

    }
}

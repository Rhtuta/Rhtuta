package org.cfs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
         Motor motor = context.getBean(Motor.class);
         motor.doWork();

         context.close();
    }
}

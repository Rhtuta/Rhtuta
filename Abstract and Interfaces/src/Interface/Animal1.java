package Interface;
//can't create Interface's object
public interface Animal1 {//Interface preferred than  abstraction
    void makeSound();//interface accepts method without body except static or default methods
    void eat();
    static void run(){//Interface accept static methods accessed by interface name
        System.out.println("Animal is running");
    }
    default void sleep(){//Interface accept default methods accessed by child object
        System.out.println("Animal is sleeping");
    }
}
interface Dog1 extends Animal1{//interface extends interface
    default void makeSound1() {
        System.out.println("dog1 making sound");
    }
    static void eat1() {
        System.out.println("dog1 eating");
    }
}
class Main implements Dog1{

    @Override
    public void makeSound() {
        System.out.println("making sound");
    }

    @Override
    public void eat() {
        System.out.println("eating");
    }

    public static void main(String[] args) {
        Dog1 dog1 = new Main();
        Dog1.eat1();
        dog1.eat();
        dog1.sleep();
        dog1.makeSound();
        dog1.makeSound1();
        Animal1.run();
    }
}

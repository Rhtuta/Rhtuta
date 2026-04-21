package Interface;
//can't create Interface's object
public interface Animal {//Interface preferred than  abstraction
    void makeSound();//interface accepts method without body except static or default methods
    void eat();
    static void run(){//Interface accept static methods accessed by interface name
        System.out.println("Animal is running");
    }
    default void sleep(){//Interface accept default methods accessed by child object
        System.out.println("Animal is sleeping");
    }
}
class Dog implements Animal{

    @Override
    public void makeSound() {
        System.out.println("making sound");
    }

    @Override
    public void eat() {
        System.out.println("eating");
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.eat();
        dog.sleep();
        dog.makeSound();
        Animal.run();//static method accessed by interface name
    }
}

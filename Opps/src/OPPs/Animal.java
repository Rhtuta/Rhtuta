package OPPs;

// multilevel inheritance
class Species {
    String speciesName = "birds";
    void flying(){
        System.out.println("are flying");
    }
}
public class Animal extends Species {
    String category = "Omnivores";
    Animal(String name){
        System.out.println("Animal constructor called");
        System.out.println(name);
    }
    void sound(){
        System.out.println("Animal making sound");

    }
    void flying(){
        System.out.println("can not fly ");
    }
}
class Dog extends Animal {
    Dog(){
        super("tiger");
        System.out.println("Dog constructor called ");

    }
    void sound(){
        super.sound();
        System.out.println("Dog is barking");
        System.out.println(super.category);
    }

    // must have same method name and parameter in child class to override
}

/*static void sound(){
    System.out.println("Animal making sound");

}static void sound(){
    super.sound();
    System.out.println("Dog is barking");
    System.out.println(super.category);
} known as data hiding in inheritance with use of static keyword
in parent and child class because child class directly call its method
because parentmethod is now hidden for child class its not overriding
 */



// hierarical inheritance
/*class Species {
    String speciesName = "birds";
    void flying(){
        System.out.println("are flying");
    }
}
public class Animal extends Species {

    //String speciesName = "Dog";
    void sound(){
        System.out.println("Animal making sound");
    }
    void flying(){
        System.out.println("can not fly ");
    }
}
class Dog extends Species {

    void sound(){
        System.out.println("Dog is barking");
    }

    // must have same method name and parameter in child class to override
}
*/





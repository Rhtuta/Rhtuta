package OPPs;

public class Inheritance {
    public static void main(String[] args) {

        Species species = new Species();
        species.flying();
        System.out.println(species.speciesName = "Dog");


        Animal animal = new Animal("lion");
        animal.sound();
        animal.flying();

        System.out.println(animal.speciesName);

        Dog dog = new Dog();
        dog.sound();
        dog.flying();


        System.out.println(dog.speciesName);


        Animal a = new Dog();
        //both side are not same so jvm have to execute it at run time
        // for object creation to know which class object will create
        a.sound();


    }
}

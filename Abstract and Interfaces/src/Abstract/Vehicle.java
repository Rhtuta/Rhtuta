package Abstract;

public abstract class Vehicle {
    String brand;
    Vehicle(String brand){//cant create abstract class object but constructor is there
        //to call it from child constructor to store default value in instance variable
        // of abstract class in memory
        this.brand = brand;
    }
    abstract void fourWheeler();
    public void showbrand(){
        System.out.println("Vehicle Brand: "+ brand);
    }
}

public class Test {

    public static void main(String[] args) {
        Engine engine = FactoryEngine.getEngine("Petrol");
        car obj = new car(engine);
        obj.engine.starts();
        obj.drive();
    }
}
//factoryEngine is used to make tight coupling to loose coupling
// by using interface of Engine and
// dependency injection is implemented by factory

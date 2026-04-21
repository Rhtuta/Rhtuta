public class FactoryEngine {
    public static Engine getEngine(String type){
        if (type.equals("Petrol")){
            return new PetrolEngine();
        } else if (type.equals("Diesel")) {
            return new DieselEngine();
        }
        else {
            throw new IllegalArgumentException("Invalid argument");
        }
    }
}

package Abstract;

public class Thar extends Vehicle{
    Thar(String brand){
        super(brand);
    }
    void fourWheeler() {
        System.out.println("this is four wheeler car");
        super.showbrand();
    }

    public static void main(String[] args) {
        Thar th = new Thar("thar");
        th.fourWheeler();
        th.showbrand();
    }
}


package OPPs;

public class OuterThisUse {
    String  outerInstanceVariable = "Rohit";
    class Inner{
       void print(){
            System.out.println(OuterThisUse.this.outerInstanceVariable);
            //Inner object is created
            // but this is used to use outer class instance variable
        }
    }

    public static void main(String[] args) {
        OuterThisUse obj = new OuterThisUse();
        OuterThisUse.Inner inner = obj.new Inner();
        inner.print();
    }
}

package WrapperClasses;

public class WrapperClass {
    public static void main(String[] args) {
        Integer i = Integer.valueOf(10);//int wrapped inn class
        System.out.println(i);
        Integer i1 = Integer.parseInt("127");//Autoboxing:Primitive data to object
        int  i2 = i1;//Unboxing: object to primitive data type
        System.out.println(i1 == i2);//first unbox i1 due to comparison with primitive data type
        Integer i3 = Integer.valueOf("127");
        System.out.println(i1 == i3);//comparison b/w two objects mem loc
        Integer i4 = Integer.parseInt("1200");
        Integer i5 = Integer.valueOf("1200");
        System.out.println(i4 == i5);//false due to diff mem loc of obj
        System.out.println(i4.equals(i5));//compare content
        Double i6 = 15.55;
        System.out.println("Convert to int : "+ i6.intValue());
        System.out.println("Convert to string : "+ i6.toString());
    }
}

package StringDemo;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = new String("Rohit");
        //using new operator create object in  heap and scp
        // but s1 ref to heap obj not scp.
        String s2 = "Rohit";// using literal object in scp:- string constant pool
        // due to s1 already create Rohit in scp so s2 will also check Rohit
        // in scp and directly reference s2 to s1  prev created Rohit object

        System.out.println(s1 == s2);
        //false s1 point heap and s2 scp

        String s3 = new String("Rohit");
        System.out.println(s1 == s3);
        // false because new operator always create new object
        // so s1 and s2 their reference are not same
        System.out.println(s1.equals(s2));
        // true because content Rohit is same at s1,s2 different object in heap

        String s4 = "Rohit";
        System.out.println(s2 == s4);
        // true , s2 ref to Rohit already created by s1 in scp and
        // s4 also check Rohit existance in scp so also ref to same obj

        s1.concat(" Kumar");
        System.out.println(s1);
        //still s1 will have Rohit and concat will create another
        //object Rohit in scp & Rohit Kumar in heap having concatenation

        String s5 = s1.concat(" Kumar");
        // first Kumar object will create in scp using literal.
        // then s1.concat automatic make Rohit Kumar object in only heap
        // with s5 ref.
        //due to not use of any new operator second obj not create in scp.
        System.out.println(s5);

        s3 = s3.concat(" Gupta");
        //first Gupta object will create in scp using literal.
        // new object Rohit Gupta will create in heap only due to concat
        // s3 will cut link with prev Rohit obj and now s3 ref to Rohit Gupta in heap
        // prev Rohit obj remain in heap and scp (cant be destroyed by garbage collector)
        // unreferenced heap obj will destroyed by garbage collector after a time
        System.out.println(s3);// prints Rohit Gupta


        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s4.hashCode());
        //same content have same encrypted hashcode made by several algo


        System.out.println(s3.hashCode());
        System.out.println(s5.hashCode());

        String s6 = "Ravi";
        String s7 = new String("Ravi").intern();
        // As usual s6 make Ravi obj in heap and scp already have Ravi by s6 but
        // here due to intern() s6 will ref to scp now not heap as usual

        System.out.println(s6==s7);
        // here s6 and s7 both ref to scp obj so it is true

        String s8 = s6.concat(" Ranjan");
        String s9 = s6.concat(" Ranjan");
        System.out.println(s8 == s9);
        // false, s8 & s9 will create different new object Ravi Ranjan in heap
        // and a object Ranjan will create in scp by s8 and s9 also ref that same obj
        // this is known as String immutability

    }
}

package OPPs;

public class Calculator {
    int add(int a , int b){
        return a+b;
    }
    double add(double a , double b){
        return a+b;
    }
    String add(String a , String b){
        return a+b;
    }
    /*double add(int a , int  b){ // due to return type is not considered
        return a+b;               // for method overload differentiation
    }*/

}

package OPPs;

public class ThisKeyword {
    ThisKeyword  show(){
        System.out.println("this is show method");
        return this; // will return object used to call another object
                  // so return type is class due to returning object
    }
    ThisKeyword  call(){
        System.out.println("this is call method");
        return this;

    }
    static void showDetails(){
        System.out.println("this is showDetails method");
        //ThisKeyword.showDetails();//creates loop of showDetails
    }

    public static void main(String[] args) {
        new ThisKeyword().show().call().showDetails();
        ThisKeyword.showDetails();//call with classname if method is static
        //ThisKeyword.show(); not supported because show is not static
                           // to call in static main method,it needs object
    }
}



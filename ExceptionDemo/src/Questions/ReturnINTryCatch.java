package Questions;

public class ReturnINTryCatch {
    public static void main(String[] args) {
        System.out.println("Output: "+ m1());
    }
    public static int m1(){
        try {
            return 10;//will return 10 but replaced futher in finally due to not exception
            //return 10/0;// will produce exception, so catch will definitely run here and replace try's return value
        }
        catch (Exception e){
            return 100;//will replace try's return if there is any exception
        }
        finally {
            return 1000;//will replace try's or catch's return because finally will always execute ,since only one will return
        }
    }
}

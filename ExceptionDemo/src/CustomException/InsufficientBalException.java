package CustomException;

public class InsufficientBalException extends Exception{
    public InsufficientBalException(String msg){
        super(msg);
    }
}

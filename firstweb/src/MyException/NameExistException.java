package MyException;

public class NameExistException extends Exception {
    public NameExistException(String msg){
        super(msg);
    }
}

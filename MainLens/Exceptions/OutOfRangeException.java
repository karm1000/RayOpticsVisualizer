package MainLens.Exceptions;

public class OutOfRangeException extends Exception{
    String m = "";
    public OutOfRangeException(String s){
        this.m = s;
    }

    public OutOfRangeException(){}

    @Override
    public String toString() {
        return "OutOfRangeException occurred";
    }
    @Override
    public String getMessage() {
        return m;
    }
}

package MainLens.Exceptions;

public class NegativesNotAllowedException extends Exception{
    String m="";
    public NegativesNotAllowedException(){}

    public NegativesNotAllowedException(String s){
      m = s;
    }

    @Override
    public String toString() {
        return "NegativesNotAllowedException occurred" + m;
    }

    @Override
    public String getMessage() {
        return m;
    }
}

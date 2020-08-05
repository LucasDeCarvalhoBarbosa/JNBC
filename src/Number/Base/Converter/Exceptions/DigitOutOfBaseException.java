package Number.Base.Converter.Exceptions;

/**
 *
 * @author Lucas Barbosa
 */
public class DigitOutOfBaseException extends RuntimeException {
    
    private int digit;
    private int baseNumber;

    public DigitOutOfBaseException(int digit, int baseNumber) {
        this.digit = digit;
        this.baseNumber = baseNumber;
    }
    
    @Override
    public String getMessage() {
        return "The digit \""+digit+"\" is outside the base range. The range is from 0 to "+(baseNumber-1)+".";
    }
    
    
    
}

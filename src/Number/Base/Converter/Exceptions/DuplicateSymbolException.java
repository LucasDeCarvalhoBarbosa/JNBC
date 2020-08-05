package Number.Base.Converter.Exceptions;

/**
 *
 * @author Lucas Barbosa
 */
public class DuplicateSymbolException extends RuntimeException {
    
    private char duplicateChar;

    public DuplicateSymbolException(char duplicateChar) {
        this.duplicateChar = duplicateChar;
    }
    
    @Override
    public String getMessage(){
        return "The char \""+duplicateChar+"\" is repeated! Conversions cannot be performed safely in this way.";
    }
    
}

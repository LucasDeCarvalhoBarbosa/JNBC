package Number.Base.Converter.Exceptions;

/**
 *
 * @author Lucas Barbosa
 */
public class SymbolNotAllowedException extends RuntimeException {
    
    private char symbol;

    public SymbolNotAllowedException(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getMessage() {
        return "The symbol \""+symbol+"\" is not allowed, as it is used internally in the converter!";
    }
    
}

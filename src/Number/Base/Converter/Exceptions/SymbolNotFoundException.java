package Number.Base.Converter.Exceptions;

import Number.Base.Converter.Base;

/**
 *
 * @author Lucas Barbosa
 */
public class SymbolNotFoundException extends RuntimeException {
    
    private char symbol;
    private Base base;

    public SymbolNotFoundException(char symbol, Base base) {
        this.symbol = symbol;
        this.base = base;
    }
    
    @Override
    public String getMessage(){
        return "The \""+symbol+"\" symbol does not belong to the defined base "+base;
    }
    
}

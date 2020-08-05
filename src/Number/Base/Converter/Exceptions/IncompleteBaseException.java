package Number.Base.Converter.Exceptions;

import Number.Base.Converter.Base;

/**
 *
 * @author Lucas Barbosa
 */
public class IncompleteBaseException extends RuntimeException {
    
    private Base base;

    public IncompleteBaseException(Base base) {
        this.base = base;
    }

    @Override
    public String getMessage() {
        return "This base "+base+" is incomplete, as it has less than 2 symbols.";
    }
    
    
    
}

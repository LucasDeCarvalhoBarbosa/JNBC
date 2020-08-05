package Number.Base.Converter;

import Number.Base.Converter.Exceptions.DigitOutOfBaseException;
import Number.Base.Converter.Exceptions.DuplicateSymbolException;
import Number.Base.Converter.Exceptions.IncompleteBaseException;
import Number.Base.Converter.Exceptions.SymbolNotFoundException;
import Number.Base.Converter.Exceptions.SymbolNotAllowedException;

/**
 * A base is nothing but symbols that, when combined in a certain order, 
 * represent values.
 * With this class, it is possible to represent any base of as 
 * long as its symbols are supported by the primitive char.
 * 
 * @author Lucas Barbosa
 */
public class Base {
    
    /**
     * These are the symbols of base.
     * They are responsible for representing the numbers of any base.
     */
    private char[] symbols;
    
    /**
     * This symbol represents the minus sign,
     * if the number has this symbol, then it is a negative number.
     */
    private char minusSign;
    
    /**
     * This is the binary base, which has only the symbols 0 and 1.
     */
    public static final Base BINARY = new Base(new char[]{'0', '1'});
    
    /**
     * This is an octal base, it has the symbols 0 to 7.
     */
    public static final Base OCTAL = new Base(new char[]{'0', '1', '2', '3', '4', '5', '6', '7'});
    
    /**
     * This is the decimal base, the most used base. It has the symbols 0 through 9.
     */
    public static final Base DECIMAL = new Base(new char[]{'0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9'});
    
    /**
     * This is the hexadecimal base, it has the digits 0 to 9 and the letters A to F.
     */
    public static final Base HEXADECIMAL = new Base(new char[]{'0', '1', '2', '3', '4', '5', '6',
        '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'});
    
    /**
     * Creates a base with the symbols provided.<br>
     * Some requirements:
     * <ul>
     * <li>There can be no repeated symbols;</li>
     * <li>It is not possible to use the symbols present in minusSign and floatingPoint.;</li>
     * <li>There must be at least two symbols;</li>
     * </ul>
     * By default, minusSign is '-' and floatingPoint is '.'
     * 
     * @param symbols the symbols to represent the numbers of that base
     */
    public Base(char[] symbols) {
        minusSign = '-';
        
        if(validadeSymbols(symbols))
            this.symbols = symbols;
    }
    
    /**
     * Returns the corresponding value of this symbol in base 10.<br>
     * <b>Warning:</b> if this symbol is not recognized it will throw a 
     * <code>SymbolNotFoundException<code>.
     * 
     * @param symbol The symbol to get the value
     * @return the corresponding value of this symbol in base 10
     */
    public int correspondingValueInDecimal(char symbol){
        for (int i = 0; i < symbols.length; i++) {
            if(symbol == symbols[i])
                return i;
                
        }
        
        throw new SymbolNotFoundException(symbol, this);
    }
    
    /**
     * Returns the value corresponding to this base symbol.
     * <b>Warning:</b> if the value is less than zero, or greater than the base,
     *  it will throw a <code>DigitOutOfBaseException</code>.
     * 
     * @param digit The digit to get the value
     * @return the corresponding value of this digit in this base
     */
    public char correspondingValueInThisBase(int digit){
        if(digit < 0 || digit > symbols.length-1)
            throw new DigitOutOfBaseException(digit, getNumberBase());
            
        return symbols[digit];
    }
    
    /**
     * Validates the symbols.
     * <ul>
     * <li>Checks for duplicate symbols;</li>
     * <li>Checks if any symbols are already used internally in the conversion
     * (currently, only the "-" symbol);</li>
     * <li>Checks if there are at least 2 symbols (base 2);</li>
     * </ul>
     * 
     * @param symbols the symbols for validation
     * @return true if there are no duplicate symbols
     */
    private boolean validadeSymbols(char[] symbols){
        String s = "";
        for (int i = 0; i < symbols.length; i++) {
            char current = symbols[i];
            
            if(s.contains(current+""))
                throw new DuplicateSymbolException(current);
            
            if(current == minusSign)
                throw new SymbolNotAllowedException(current);
            
            s += current;
        }
        
        if(symbols.length < 2)
            throw new IncompleteBaseException(this);
        
        return true;
    }
    
    /**
     * Returns the number of that base, that is, the number of symbols in that base
     * <code>return symbols.length;</code>
     * 
     * @return the number of symbols in that base
     */
    public int getNumberBase(){
        return symbols.length;
    }
    
    /**
     * Returns the symbol at the given position.
     * <code>return symbols[position];</code>
     * 
     * @param position the position of the symbol
     * @return the symbol at the given position
     */
    public char getSymbolAt(int position){
        return symbols[position];
    }
    
    /**
     * Returns true, if the informed symbol belongs to this base, and otherwise, false.
     * 
     * @param symbol the symbol to be verified
     * @return true if it belongs to the base, and otherwise, it returns false
     */
    public boolean contains(char symbol){
        for (int i = 0; i < symbols.length; i++) {
            if(symbol == symbols[i])
                return true;
        }
        
        return false;
    }

    @Override
    public String toString() {
        String s = "Base{";
        for (int i = 0; i < symbols.length; i++) {
            s += symbols[i]+", ";
        }
        
        return s+"}";
    }
    
    //gets and sets
    public char getMinusSign() {
        return minusSign;
    }

    public void setMinusSign(char minusSign) {
        if(contains(minusSign))
            throw new DuplicateSymbolException(minusSign);
        
        this.minusSign = minusSign;
    }
    
}

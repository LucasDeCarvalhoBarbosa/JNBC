package Number.Base.Converter.Examples;

import Number.Base.Converter.Converter;
import Number.Base.Converter.Base;

/**
 * No problem if the numbers are negative, below you can find examples of this.
 * 
 * @author Lucas Barbosa
 */
public class NegativeConversion {
    
    public static void main(String[] args) {
        //In this example, -10 will be converted from octal to decimal, and will remain negative.
        Base hexa = Base.HEXADECIMAL;
        System.out.println(Converter.convertToDecimal("-A", hexa));//the value must be -10
        
        /*With your own bases, the conversion is the same, 
        just put the symbol that represents the minus sign before the number*/
        Base myBase = new Base(new char[]{'∑', '∆', '₪', '¥', '§', 'ʢ', '∞', 'Ω'});
        System.out.println(Converter.convertToDecimal("-∞∆∞", myBase));//the value must be -398
        
        //Changing the minus sign:
        myBase.setMinusSign('!');//now the minus sign is an exclamation point!
        System.out.println(Converter.convertToDecimal("!∞∆∞", myBase));//the value must be -398
        
        /* WARNING! If the minus symbol is changed to a symbol that already belongs to the base, 
        the exception for duplicate symbols will be thrown! */
    }
    
}

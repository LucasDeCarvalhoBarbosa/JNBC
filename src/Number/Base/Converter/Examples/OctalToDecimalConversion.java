package Number.Base.Converter.Examples;

import Number.Base.Converter.Converter;
import Number.Base.Converter.Base;


/**
 * The octal to decimal conversion is one of the most used, and can be seen below.
 * 
 * @author Lucas Barbosa
 */
public class OctalToDecimalConversion {
    
    public static void main(String[] args) {
        //In this example, 10 will be converted from octal to decimal
        Base base = Base.OCTAL;
        System.out.println(Converter.convertToDecimal("10", base));//the value must be 8
    }
    
}

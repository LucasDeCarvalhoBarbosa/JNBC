package Number.Base.Converter.Examples;

import Number.Base.Converter.Converter;
import Number.Base.Converter.Base;


/**
 * Hexadecimal to decimal conversion is one of the most used, and can be seen below.
 * 
 * @author Lucas Barbosa
 */
public class HexadecimalToDecimalConversion {
    
    public static void main(String[] args) {
        //In this example, C will be converted from hexadecimal to decimal
        Base base = Base.HEXADECIMAL;
        System.out.println("Hexa: "+Converter.convertToDecimal("CA", base));//the value must be 202
    }
    
}

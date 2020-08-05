package Number.Base.Converter.Examples;

import Number.Base.Converter.Converter;
import Number.Base.Converter.Base;



/**
 * 
 * Binary to decimal conversion is one of the most used, and can be seen below
 * 
 * @author Lucas Barbosa
 */
public class BinaryToDecimalConversion {
    
    public static void main(String[] args) {
        //In this example, 1010 will be converted from binary to decimal
        Base base = Base.BINARY;
        System.out.println(Converter.convertToDecimal("10", base));//the value must be 2
    }
    
}

package Number.Base.Converter.Examples;

import Number.Base.Converter.Converter;
import Number.Base.Converter.Base;
import Number.Base.Converter.Formatter;

/**
 * A great advantage of JNBC is the possibility to create your own custom bases,
 * and can be seen below
 * 
 * @author Lucas Barbosa
 */
public class CustomBase {
    
    public static void main(String[] args) {
        //Creating my custom base
        Base customBase = new Base(new char[]{')', '!', '@', '#', '$', '%', '¨', '&', '*', '('});
        
        //Converting from my custom base to decimal
        System.out.println(Converter.convertToDecimal("$@", customBase)+" the value must be 42\n");
        
        //Converting from decimal to my custom base
        for (int i = -20; i <= 20; i++) {
            System.out.println("#"+i+": "+Converter.convertToCustomBase(i, customBase));
        }
        
        
        //Another customized base
        Base b = new Base(new char[]{'∑', '∆', '₪', '¥', '§', 'ʢ', '∞', 'Ω'});
        System.out.println("\n\nAnother customized base\n"+Converter.convertToCustomBase(81, b)
        +" the value must be ∆₪∆");
    }
    
}

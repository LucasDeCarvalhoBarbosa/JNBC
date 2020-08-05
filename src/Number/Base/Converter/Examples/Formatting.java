package Number.Base.Converter.Examples;

import Number.Base.Converter.Base;
import Number.Base.Converter.Formatter;

/**
 * Sometimes you need to change the way numbers appear,
 * so you can use the Formatter class to format numbers
 * 
 * @author Lucas Barbosa
 */
public class Formatting {
    
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        System.out.println(formatter.format("0123456", Base.DECIMAL));
        
        
        formatter = new Formatter();
        formatter.setGroupedDigits(4);//The groups of digits will now be 4 in 4
        formatter.setSeparator('.');//the separator will now be a dot
        System.out.println(formatter.format("1010101010", Base.BINARY));
        
        
        //Formatting with my created base
        Base b = new Base(new char[]{'∑', '∆', '₪', '¥', '§', 'ʢ', '∞', 'Ω'});
        formatter.setSeparator(',');//now the separator will be a comma
        System.out.println(formatter.format("¥ʢ₪₪∆∞", b));
    }
    
}

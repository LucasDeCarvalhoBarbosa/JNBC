package Number.Base.Converter.Examples;

import Number.Base.Converter.Base;
import Number.Base.Converter.Converter;

/**
 * In JNBC, it is possible to convert two bases created
 * 
 * @author Lucas Barbosa
 */
public class CustomBaseToCustomBaseConversion {
    
    public static void main(String[] args) {
        //In JNBC, it is possible to convert two bases created as follows:
        Base sourcebase = new Base(new char[]{'a', 'b', 'c', 'd', 'e', 'f'});
        Base targetBase = new Base(new char[]{'f', 'e', 'd', 'c', 'b', 'a'});
        
        System.out.println("a == "+Converter.ConvertToCustomBase("a", sourcebase, targetBase));//the value must be f
        System.out.println("ba == "+Converter.ConvertToCustomBase("ba", sourcebase, targetBase));//the value must be ef
    }
    
}

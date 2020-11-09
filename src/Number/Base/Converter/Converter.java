package Number.Base.Converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Lucas Barbosa
 */
public class Converter {
    
    /**
     * Converts the given number, to the decimal base.<br>
     * <b>Warning:</b> if any of the digits in the number are not recognized,
     * it will throw a <code>SymbolNotFoundException</code>.
     * 
     * @param number The number of the <code>Base</code>
     * received by the Constructor
     * @param base the base to convert to decimal
     * @return the number already converted to the decimal base
     */
    public static long convertToDecimal(String number, Base base){
        char[] numberInBaseX = number.toCharArray();
        numberInBaseX = reverseDigits(numberInBaseX);
        boolean negative = false;
        long convertedNumber = 0;
        
        if(numberInBaseX[numberInBaseX.length-1] == base.getMinusSign()){
            negative = true;
            numberInBaseX = removeLastElement(numberInBaseX);
        }
        
        for (int i = 0; i < numberInBaseX.length; i++) {
            convertedNumber += base.correspondingValueInDecimal(numberInBaseX[i]) * Math.pow(base.getNumberBase(), i);
        }
        
        if(negative)
            convertedNumber *= -1;
        
        return convertedNumber;
    }
    
    /**
     * Convert a given number to this base.
     * 
     * @param number the number to be converted
     * @param base the base to which the number will be converted
     * @return the given decimal number converted to the informed base
     */
    public static String convertToCustomBase(long number, Base base){
        List<Character> quotients = new ArrayList<>();
        int numberBase = base.getNumberBase();
        boolean negative = false;
        
        if(number < 0){//If the number is negative
            negative = true;
            number = Math.abs(number);
        }
        //(number % numberBase) > 0
        while(number >= numberBase){//Divide by base number and add quotients converted to your symbols to a list
            quotients.add(base.correspondingValueInThisBase((int) (number % numberBase)));
            number /= numberBase;
        }
        
        //When I can no longer divide, I add the result converted to your symbol to the list
        quotients.add(base.correspondingValueInThisBase((int) number));
        
        Collections.reverse(quotients);//invert the list
        
        String numberInBaseX = "";
        for (int i = 0; i < quotients.size(); i++) {//I put the symbols in a String
            numberInBaseX += quotients.get(i)+"";
        }
        
        if(negative)//If the value is negative, multiply by -1
            numberInBaseX = base.getMinusSign()+numberInBaseX;
        
        return numberInBaseX;
    }
    
    /**
     * Converts the given numberin the form of String (can be any base),
     * for the base given in the base parameter.<br>
     * <b>Warning:</b> if any of the digits in the number are not recognized,
     * it will throw a <code>SymbolNotFoundException</code>.
     * 
     * @param number The number of the <code>Base</code>
     * received by the Constructor
     * @param sourceBase the base of origin of the number informed
     * @param targetBase the base conversion target
     * @return the number already converted to the decimal base
     */
    public static String convertToCustomBase(String number, Base sourceBase, Base targetBase){
        return convertToCustomBase(convertToDecimal(number, sourceBase), targetBase);
    }
    
    /**
     * Inverts the digits.
     * This is very useful for converting numeric bases.
     * 
     * @param digits the array that will be inverted
     * @return a new array already inverted
     */
    private static char[] reverseDigits(char[] digits){
        char[] reversed = new char[digits.length];
        
        for (int i = 0; i < digits.length; i++) {
            reversed[digits.length-i-1] = digits[i];
        }
        
        return reversed;
    }
    
    /**
     * Removes the last element from the array.
     * 
     * @param number the array to be removed the last element
     * @return  the array without the last element
     */
    private static char[] removeLastElement(char[] number){
        char[] array = new char[number.length-1];
        
        for (int i = 0; i < array.length; i++) {
            array[i] = number[i];
        }
        
        return array;
    }
    
}

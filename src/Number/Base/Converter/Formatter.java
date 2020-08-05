package Number.Base.Converter;

/**
 * This class is used to format numbers, 
 * separating them into groups delimited by a different character.
 * 
 * @author Lucas Barbosa
 */
public class Formatter {
    
    private char separator;
    private int groupedDigits;

    public Formatter() {
        separator = ' ';
        groupedDigits = 3;
    }

    public Formatter(char separator, int groupedDigits) {
        this.separator = separator;
        this.groupedDigits = groupedDigits;
    }
    
    /**
     * Formats the number entered, separating its digits with the 
     * <code> separator </code> character in groups of size equal to 
     * <code> groupedDigits </code>.
     * Examples:
     * <tr><th>separator</th><th>number of digits grouped</th><th>original number</th><th>formatted number</th></tr>
     * <tr><td>'&nbsp' (space)</td><td>3</td><td>1000000</td><td>1 000 000</td></tr>
     * <tr><td>'.'</td><td>3</td><td>1000000</td><td>1.000.000</td></tr>
     * <tr><td>'&nbsp' (space)</td><td>4</td><td>987654321</td><td>9 8765 4321</td></tr>
     * 
     * @param number the number to be separated
     * @param base the base to which the given number belongs.
     * @return the formatted number
     */
    public String format(String number, Base base){
        String formattedNumber = "";
        int digitsPlaced = 0;
        
        int i = number.length()-1;
        while(i >= 0) {
            if(digitsPlaced == groupedDigits){//If it's time to put a separator, I put it in the formatted number
                formattedNumber += separator;
                digitsPlaced = 0;//reset the digits of the group, because now is a new group
            }else{//If the time has not come to place a separator, I place the digit
                formattedNumber += number.charAt(i);
                digitsPlaced++;//I put that another digit was placed in the group
                i--;//decrease the i to be able to move to the next number
            }
            
        }
        
        return new StringBuffer(formattedNumber).reverse().toString();
    }
    
    //gets and sets
    public char getSeparator() {
        return separator;
    }

    public void setSeparator(char separator) {
        this.separator = separator;
    }

    public int getGroupedDigits() {
        return groupedDigits;
    }

    public void setGroupedDigits(int groupedDigits) {
        this.groupedDigits = groupedDigits;
    }
    
}

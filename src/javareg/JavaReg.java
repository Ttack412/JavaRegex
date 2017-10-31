/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareg;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ttackett
 */
public class JavaReg {
        
    public static void main(String[] args) {
                
        //sets string equal to the return of this method
        String input = getNumber();
        //creates a pattern that the input has to match
        Pattern myPattern = Pattern.compile("[(]?([0-9]{3})[),.,-][' ']?([0-9]{3})[.,-]([0-9]{4})");
        //makes a matcher object and sets the matchers pattern to the pattern^
        Matcher match = myPattern.matcher(input);
        
        //checks to see if the input matches the correct pattern
        if(validNumbers(match))
        {
            System.out.println("Thank you for your number: " + outputNumber(match));
        }
        else
        {
            System.out.println("Please enter your number in a different format");
        }
    }
    //creates the output using groups from the input
    public static String outputNumber(Matcher match){
        
        String groupOne = match.group(1);
        String groupTwo = match.group(2);
        String groupThree = match.group(3);
        
        String out = "(" + groupOne + ")" + " " + groupTwo + "-" + groupThree;
        
        return out;
    }
    
    //uses the matcher to see if it matches the pattern
    public static boolean validNumbers(Matcher match){
        boolean matches;
        
        if(match.matches())
        {
            matches = true;
        }
        else
        {
            matches = false;
        }
        
        return matches;
    }
    
    //gets an inputted number
    public static String getNumber(){
        
        String input;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your phone number");
        input = scan.nextLine();
        scan.close();
        return input;
    }
    
}

/* COSC326 Etude 11 - Arithmetic
   Author - Finn Luxton
            6362897            */

import java.util.Scanner;
import java.lang.Character;
import java.lang.StringBuilder;

public class Arithmetic{

    public static String operandBuilder = "";
    public static boolean isPossible = false;

    public static void main(String[] args){

        String inputNumbers;
        char operation;
        int target, i;
        int length = 0;
        Scanner scanner = new Scanner(System.in);

        // Takes in user input and makes it useable
        System.out.println("Please enter the numbers to be used");
        inputNumbers = scanner.nextLine();
        System.out.println("Please enter the target number followed by N or L");
        target = scanner.nextInt();
        operation = scanner.next().charAt(0);
        operation = Character.toUpperCase(operation);

        // Turns the input numbers into a string, and removes all occurances of spaces
        String[] stringSplitter = inputNumbers.split(" ");  
        length = stringSplitter.length;

        // Initializes a new int array with a size that can hold the inputted numbers
        int[] numbers = new int[length];

        // Fill the int array with contents from the string array
        for(i = 0; i < length; i++){
            numbers[i] = Integer.parseInt(stringSplitter[i]);
        }

        // If the user specified L operation, run that method. Otherwise, print error
        if(operation == 'L'){
            lrOperation(numbers, target, 0, 0);
        }else if(operation == 'N'){ 
            System.out.println("You printed N!");
        }else{
            System.err.println("ERROR: Please enter L or N for operation only");
        }
        
        // If the method adds anything to operand, it found a correct answer. The program prints that answer
        // Otherwise, it prints impossible.
        if(operandBuilder.length() > 0){
            System.out.println(operation + " " + (new StringBuilder(operandBuilder).reverse().toString()));
        }else{
            System.out.println(operation + " " + target + " impossible");
        }
        
        // Close the scanner, effectively ending the program
        scanner.close();

    }

    /* Recursively finds any possible solution for LHS solving 
       @param numbers - An int array which stores the numbers to be used
              target  - The int that the program is trying to find a calculation to hit
              sum     - Recursively stores the current sum of previous recursions
              depth   - Keeps track of what depth level the recursion is currently at
       @return boolean - Returns true if a possible calculation is found                  */
    public static boolean lrOperation(int[] numbers, int target, int sum, int depth){
       
        // If depth is higher than the length of numbers, return false
        if(depth >= numbers.length + 1){
            return false;
        }
        
        // Gets a digit length of current number to be used later
        int length = String.valueOf(numbers[depth]).length();

        // Checks to see if the current calculation is over the target
        if(!((sum * numbers[depth]) > target) || !((sum + numbers[depth]) > target)){
            // Checks to see if this if this current number is the last in inputs
            if(depth == numbers.length - 1){
                // If any current calculations are on target, return true and begin building the operandString
                if(sum + numbers[depth] == target){
                    isPossible = true;
                    if(length == 1){
                        operandBuilder += numbers[depth];
                    }else{
                        operandBuilder += new StringBuilder(Integer.toString(numbers[depth])).reverse().toString();
                    }
                    operandBuilder += " + ";
                    return true;
                }
                if(sum * numbers[depth] == target){
                    isPossible = true;
                    if(length == 1){
                        operandBuilder += numbers[depth];
                    }else{
                        operandBuilder += new StringBuilder(Integer.toString(numbers[depth])).reverse().toString();
                    }
                    operandBuilder += " * ";
                    return true;
                }
            }else{
                // Checks to see if the next calculation is over the target or not. If under, keep recurring.
                if(!(sum + numbers[depth] > target)){
                    if (lrOperation(numbers, target, sum + numbers[depth], depth + 1)){
                        // Flag will be thrown if calculation found in previous recursion. Begin building string recursively
                        if(isPossible){
                            if(length == 1){
                                operandBuilder += numbers[depth];
                            }else{
                                operandBuilder += new StringBuilder(Integer.toString(numbers[depth])).reverse().toString();
                            }
                            if(depth > 0){
                                operandBuilder += " + ";
                            }
                        }
                        return true;
                    }
                    
                }
                // Checks to see if the next calculation is over the target or not. If under, keep recurring.
                if(!(sum * numbers[depth] > target)){
                    if (lrOperation(numbers, target, sum * numbers[depth], depth + 1)){
                        // Flag will be thrown if calculation found in previous recursion. Begin building string recursively
                        if(isPossible){
                            if(length == 1){
                                operandBuilder += numbers[depth];
                            }else{
                                operandBuilder += new StringBuilder(Integer.toString(numbers[depth])).reverse().toString();
                            }
                            if(depth > 0){
                                operandBuilder += " * ";
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
    



}

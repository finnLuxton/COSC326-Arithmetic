/* COSC326 Etude 11 - Arithmetic
   Author - Finn Luxton
            6362897            */
import java.util.Scanner;

public class Arithmetic{

    public static void main(String[] args){

        String inputNumbers;
        int target, i;
        int length = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the numbers to be used");
        inputNumbers = scanner.nextLine();
        System.out.println("Please enter the target number");
        target = scanner.nextInt();

        // Turns the input numbers into a string, and removes all occurances of spaces
        String[] stringSplitter = inputNumbers.split(" ");
        
        length = stringSplitter.length;

        // Initializes a new int array with a size that can hold the inputted numbers
        int[] numbers = new int[length+1];

        // Fill the int array with contents from the string array
        for(i = 0; i < length; i++){
            numbers[i] = Integer.parseInt(stringSplitter[i]);
        }

        /* Errors
           Cannot accept double spaces
           Doesnt accept numbers over 10 characters long (eg, 12345678901, but does accept 10,000,000,000?)
         */
        
        for(i = 0; i < length; i++){
            System.out.println(numbers[i]);
        }
        
        
        scanner.close();

    }

}

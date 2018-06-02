/* COSC326 Etude 11 - Arithmetic
   Author - Finn Luxton
            6362897            */
import java.util.Scanner;

public class Arithmetic{

    /* Make a binary tree with * on the right, and + on the left */
    //public static String operandBuilder = "";

    public static void main(String[] args){

        String inputNumbers;
        char operation;
        int target, i;
        int length = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the numbers to be used");
        inputNumbers = scanner.nextLine();
        System.out.println("Please enter the target number followed by N or L");
        target = scanner.nextInt();
        operation = scanner.next().charAt(0);

        // Turns the input numbers into a string, and removes all occurances of spaces
        String[] stringSplitter = inputNumbers.split(" ");
        
        length = stringSplitter.length;

        // Initializes a new int array with a size that can hold the inputted numbers
        int[] numbers = new int[length];

        // Fill the int array with contents from the string array
        for(i = 0; i < length; i++){
            numbers[i] = Integer.parseInt(stringSplitter[i]);
        }

        if(operation == 'L'){
            System.out.println(lrOperation(numbers, target, 0, 0));
        }else if(operation == 'N'){ 
            System.out.println("You printed N!");
        }else{
            System.err.println("ERROR: Please enter L or N for operation only");
        }
        //if(operandBuilder.length() > 0){
        //    System.out.println("And the operators used are: " + operandBuilder);
        //}
        scanner.close();

    }

    /* Recursively find value for LHS operations - Done with products and sums! */
    public static boolean lrOperation(int[] numbers, int target, int sum, int depth){
        //System.out.println("Depth: " + depth + " length: " + numbers.length + " current num: " + numbers[depth] + " sum: " + sum);
        if(depth >= numbers.length + 1){
            return false;
        }

        if(!((sum * numbers[depth]) > target) || !((sum + numbers[depth]) > target)){
            if(depth == numbers.length - 1){
                
                if(sum + numbers[depth] == target){
                    System.out.println("Hey its possible using +!");
                    //operandBuilder += '+';
                    return true;
                }
                if(sum * numbers[depth] == target){
                    System.out.println("Hey its possible using *!");
                    //operandBuilder += '*';
                    return true;
                }
            }else{
                if(!(sum + numbers[depth] > target)){
                    //System.out.println("Going to the left");
                    if (lrOperation(numbers, target, sum + numbers[depth], depth + 1)){
                        return true;
                    }
                    
                }
                if(!(sum * numbers[depth] > target)){
                    //System.out.println("Going to the right");
                    lrOperation(numbers, target, sum * numbers[depth], depth + 1);
                }
            }
        }
        return false;
    }
    



}

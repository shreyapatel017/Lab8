import java.util.Scanner;

/**
 * Implements division method to convert positive decimal integer to its binary equivalent.
 *
 * @author Shreya Patel
 * @version 11/25/2026
 */
public class ConvertToBinary
{
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer in [0, 2147483647] or done to end: "); 
        String input = scan.next();
        
        while(!input.equalsIgnoreCase("done")){
            int value = Integer.parseInt(input);
            
            if(value == 0){
                stack.push(0);
            }
            
            while(value > 0){
                stack.push(value % 2);
                value = value / 2;
            }
            System.out.print("The equivalent binary number is: ");
            
            while(!stack.isEmpty()){
                System.out.print(stack.pop());
            }
            System.out.println();
            System.out.println();
            System.out.print("Enter an integer in [0, 2147483647] or done to end: ");
            input = scan.next();
        }
    }
}
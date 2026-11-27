import java.util.Scanner;

/**
 * Evaluates expressions in postfix notation.
 *
 * @author Shreya Patel
 * @version 11/25/2026
 */
public class PostFixCalculator
{
    public static void main(String[] args){
        Stack<Double> stack = new Stack<Double>();

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a postfix expression or DONE to end: "); 
        String input = scan.nextLine();
        String[] data = input.split(" ");
        
        while(!input.equalsIgnoreCase("done")){
            for(int i = 0; i < data.length; i++){
                if(data[i].equals("+") || data[i].equals("-") || data[i].equals("*") || data[i].equals("/")){
                    double num1 = stack.pop();
                    double num2 = stack.pop();
                    if(data[i].equals("+")){
                        stack.push(num1 + num2);
                    }else if(data[i].equals("-")){
                        stack.push(num2 - num1);
                    }else if(data[i].equals("*")){
                        stack.push(num1 * num2);
                    }else{
                        stack.push(num2 / num1);
                    }
                }else{
                    stack.push(Double.parseDouble(data[i]));
                }
            }
            System.out.println("The expression " + input + " evaluates to " + stack.pop());
            System.out.println();
            System.out.print("Enter a postfix expression or DONE to end: ");
            input = scan.nextLine();
            data = input.split(" ");
        }
        
        
    }
}
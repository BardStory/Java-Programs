//Author Joshua Bard
//V00865924

import java.util.Stack;
import java.util.Scanner;

public class Evaluator extends Object
{
    /** The addition operator : + */
    public static final char PLUS = '+';
    /** The subtraction operator : - */
    public static final char MINUS = '-';
    /** The multiplication operator : * */
    public static final char TIMES = '*';
    /** The division operator : / */
    public static final char DIVIDE = '/';
    /** The power operator : ^ */
    public static final char POWER = '^';

    public Stack<Double> stack;
    

    public Evaluator()
    {
        stack = new Stack<Double>();
    }

    public double evaluate(String expression)
    {
        double op1, op2; 
        double result = 0;
        String token;
        Scanner parser = new Scanner(expression);

        while (parser.hasNext())
        {
            token = parser.next();

            if (isOperator(token))
            {
                op2 = (stack.pop()).doubleValue();
                op1 = (stack.pop()).doubleValue();
                result = evaluateSingleOperator(token.charAt(0), op1, op2);
                stack.push(new Double(result));
            }
            else
                stack.push(new Double(Double.parseDouble(token)));
        }

        return result;
    }
    
    private boolean isOperator(String token)
    {
        return ( token.equals("+") || token.equals("-") ||
                 token.equals("*") || token.equals("/") ||
                 token.equals("^"));
    }

    private double evaluateSingleOperator(char operation, double op1, double op2)
    {
    switch(operation) 
        {
        case PLUS:
            return op1+op2;
        case MINUS:
            return op1-op2;
        case TIMES:
            return op1*op2;
        case DIVIDE:
            return op1/op2;
        case POWER:
            double exponent = (double)op2;
            if (op2-exponent > 0.00000001 || exponent < 0) {
                throw new IllegalExpressionException("exponent cannot be less than 0 or a non-integer");
            }
            double result = 1;
            for (double k=1; k<=exponent; k++) {
                result *= op1;
            }
            return result;
        default:
            throw new IllegalExpressionException("Unknown operator: "+operation);
        }   
    }

    public static void main(String[] args)
    {
        String expression;      // postfix expression entered by the user
        double result;             // value of the expression
        String again;           // user input 
 
    
        Scanner in = new Scanner(System.in);
      
        do
        {  
            // here: Declare a reference variable of type Evaluator and make it reference a newly created Evaluator object /
            
             Evaluator evaluator = new Evaluator();
        
            System.out.println("Enter a valid post-fix expression one token " +
                               "at a time with a space between each token (e.g. 5 4 + 3 2 1 - + *)");
            System.out.println("Each token must be an integer or an operator (+,-,*,/,^)");
            
            // here: Read in a line of input from the keyboard using the Scanner variable.
            //       Store the result in expression. /
            expression = in.nextLine();
            // here: Invoke the evaluate method from the Evaluator class.
            //       Store the returned value in result. / 
            
            result = evaluator.evaluate (expression);
            System.out.println();
            System.out.println("That expression equals " + result);

            System.out.print("Evaluate another expression [Y/N]? ");
            again = in.nextLine();
            System.out.println();
        }
        while (again.equalsIgnoreCase("y"));
   }
}
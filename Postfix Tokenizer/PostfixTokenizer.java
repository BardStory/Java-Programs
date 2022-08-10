//Author Joshua Bard
//V00865924

import java.util.Stack;

public class PostfixTokenizer extends Object implements Tokenizer
{
	private String[] tokens;
	private int currentTokenIndex;

	//originally was done for a string as I am having trouble with OperatirTokenizer
	public PostfixTokenizer(OperatorTokenizer infixTokens) throws IllegalExpressionException
    {
	 // initializing empty String for result
        String result= new String("");
        String exp = new String("");

        OperatorTokenizer postfixTokens = new OperatorTokenizer(result);

        // initializing empty stack
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i<numTokens(); ++i)
        {
            char c = exp.charAt(i);
            
            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;
            
            // If the scanned character is an '(', push it to the stack.
            else if (c == '(')
                stack.push(c);
            
            // If the scanned character is an ')', pop and output from the stack 
            // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();
                
                if (!stack.isEmpty() && stack.peek() != '(')
                    throw new IllegalExpressionException("Parenthesis are not balanced"); // invalid expression          
                else
                    stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
                    result += stack.pop();
                stack.push(c);
            }
        }

        // pop all the operators from the stack
        while (!stack.isEmpty())
        {
            result += stack.pop();
        }
    
        return result;
    }

    static int Prec(char ch)
    {
        switch (ch)
        {
        case '+':
        case '-':
            return 1;
    
        case '*':
        case '/':
            return 2;
    
        case '^':
            return 3;
        }
        return -1;
    }


	//Sets the iterator start position for the first item in the list.
	public void reset()
	{
		currentTokenIndex = 0;
	}
	
	//returns the number of tokens in the list.
	public int numTokens()
	{
		return tokens.length;
	}

	//Returns true if the iteration has more elements. 
	//(In other words, returns true if next() would return an element rather than throwing an exception.)
	public boolean hasNext()
	{
		return currentTokenIndex != tokens.length;
	}

	//if the iteration has no more elements
	public String next()
	{
		if (!hasNext()) {
			throw new UnsupportedOperationException("No more tokens");
		}
		return tokens[currentTokenIndex++];
	}
	
	public void remove()
	{
		throw new UnsupportedOperationException("Tokens may not be removed");
	}

	//The format is a list of tokens on a single line, delimited by a single space.
	public String toString()
	{
		StringBuilder sb = new StringBuilder(tokens.length*10);
		for (int i=0; i<tokens.length-1; i++) {
			sb.append(tokens[i]+' ');
		}
		if (tokens.length > 0) {
			sb.append(tokens[tokens.length-1]);
		}
		return sb.toString();
	}
	public static void main(String[] args) 
	{
		
	}
}
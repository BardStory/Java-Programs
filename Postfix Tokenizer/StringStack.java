//Author Joshua Bard
//V00865924


//pg 268 in java textbook for reminders

public class StringStack extends Node
{
	//private initialise variables
	private String stack[];
	private Node top;
	private String newItem;

	//Initializes a stack that has no elements.
	public StringStack()
	{
		top = null;
	}

	//True if the stack is empty, false if not.
	public boolean isEmpty()
	{
		return top == null;
	}

	//Inserts an element onto the top of the stack.
	public void push()
	{
		top = new Node(newItem, top);
	}


	//Removes the top element from the stack.
	public Object pop() throws StackException
	{
		if(!isEmpty())
		{
			Node temp = top;
			top = top.next;
			return temp.item;
		}
		else
		{
			throw new StackException("StackException on " + "pop: stack empty");
		}
	}

	//Accesses the top element of the stack, without removing it.
	public String peek() throws StackException
	{
		if(!isEmpty())
		{
			return top.item;
		}
		else
		{
			throw new StackException("StackException on " + "peek: stack is empty");
		}
	}

	//Empties all the elements from the stack.
	public void popAll()
	{
		top = null;
	}

	public static void main(String[] args) {
		
	}


}
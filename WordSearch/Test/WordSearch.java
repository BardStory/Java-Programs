// Stephen Fulwider
// 6 July 2008
// Word Search Program - finds location of the first instance of word, if found

import java.io.*;
import java.util.*;

public class WordSearch 
{
	// hold the board and its size
	int rows,cols;
	private char[][] board;
	
	// DR = delta row, DC = delta col, for easily iterating through moving through board
	private final static int[] DR = {-1,-1,-1,0,0,1,1,1}, 
							   DC = {-1,0,1,-1,1,-1,0,1};
	
	// load in new puzzle
	public WordSearch(String fileName) throws IOException
	{
		Scanner fin = new Scanner(new File(fileName));
		
		rows = fin.nextInt();
		cols = fin.nextInt();
		
		board = new char[rows][cols];
		fin.nextLine();
		for (int i=0; i<rows; i++)
		{
			String line = fin.nextLine();
			for (int j=0; j<cols; j++)
				board[i][j] = line.charAt(j);
		}
	}
	
	// attempt to find word in puzzle
	public int[] findWord(String word)
	{
		for (int i=0; i<rows; i++)
			for (int j=0; j<cols; j++)
				if (word.charAt(0) == board[i][j])
				{
					for (int k=0; k<DR.length; k++)
						if (search(i,j,0,word,DR[k],DC[k]))
							return new int[] {i,j};
					
				}
		return null;
	}
	
	// recursively search for word by checking this letter, then moving to next if match found
	private boolean search(int r, int c, int pos, String word, int dr, int dc)
	{
		if (pos == word.length()) return true;
		if (!isInBounds(r,c)) return false;
		
		if (board[r][c] == word.charAt(pos))
			return search(r+dr,c+dc,pos+1,word,dr,dc);
		return false;
	}
	
	// verify spot is in bounds
	private boolean isInBounds(int r, int c)
	{
		return r>=0 && c>=0 && r<rows && c<cols;
	}
	
	// print the board
	public void printBoard()
	{
		for (int i=0; i<rows; i++,System.out.println())
			for (int j=0; j<cols; j++)
				System.out.print(board[i][j]);
		System.out.println();
	}
	
	// main program execution
	public static void main(String[] args) throws IOException
	{
		Scanner sin = new Scanner(System.in);
		
		System.out.print("Filename of word search> ");
		String fileName = sin.next();
		
		WordSearch ws = new WordSearch(fileName);
		ws.printBoard();
		
		System.out.print("Word to search for (. to quit)> ");
		String word = sin.next();
		
		while (!word.equals("."))
		{
			int[] loc = ws.findWord(word);
			
			if (loc == null)
				System.out.println("Word not found in puzzle!");
			else
				System.out.printf("Word found beginning at location (%d,%d)!%n",loc[0],loc[1]);
			
			System.out.print("Word to search for (. to quit)> ");
			word = sin.next();
		}
		
		System.out.println("Thanks for playing, bye!");
	}
}

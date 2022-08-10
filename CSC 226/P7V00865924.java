//Author Joshua Bard
//V00865924
import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        //Using a scanner as input
        Scanner input = new Scanner(System.in);

        //int for the size of the array
        //Because each array is N x N only need 1 size variable as opposed
        //to Rows and collumns
        int size;
        size = input.nextInt();
        input.nextLine();
        //the char array to store the characters
        char[][] array = new char[size][size];
        
        //sets the source location to null
        Cell source = null;
        
        //reads the input into the array
        for (int i = 0; i < size; i++) {
            //We will store it row by row
            String row = input.nextLine();
            //for loop for the columns
            for (int j = 0; j < size; j++) {
                //Looking for the start point
                char square = row.charAt(j);
                // checks if source
                if (square == 'A') {
                    source = new Cell(i, j, 0);
                }
                array[i][j] = square;
            }
        }
   //Calls the breadth-first search
    search(array, source);
        
    }

    public static int search(char[][] array, Cell source) {
        //declares the brand new queue
        Queue<Cell> Q = new LinkedList<Cell>();
        //adds the source to q
        Q.offer(source);
        //marks the source as visited
        array[source.xPos][source.yPos] = '#';
        //checks the queue
        while (Q.peek() != null) {
            //grabs the next element
            Cell current = Q.poll();   
            //grabs the neighboors of the current
            ArrayList<Cell> neighbors = getNeighbors(array, current);
            
            //iterates through all of the neighboors
            for (Cell neighbor : neighbors) {
                //checks the exit
                if (array[neighbor.xPos][neighbor.yPos] == 'B') {
                    System.out.print(neighbor.dist);
                    return neighbor.dist;
                }
                // we know every neighbor in neighbors is unvisited - why?
                Q.offer(neighbor);
                // marks neighbor as visited in array
                array[neighbor.xPos][neighbor.yPos] = '#';
            }
        }
        //prints IMPOSSIBLE if it is impossible to solve
        System.out.print("IMPOSSIBLE");
        return 0;
    }

    //method for checking the neighboor
    public static ArrayList<Cell> getNeighbors(char[][] array, Cell current) {
        ArrayList<Cell> neighbors = new ArrayList<Cell>();
        //checks Up
        if (current.yPos > 0 && array[current.xPos][current.yPos-1] != '#') {
            neighbors.add(new Cell(current.xPos, current.yPos-1, current.dist+1));
        }
        //checks Right
        if (current.xPos < array.length-1 && array[current.xPos+1][current.yPos] != '#') {
            neighbors.add(new Cell(current.xPos+1, current.yPos, current.dist+1));
        }
        //checks Down
        if (current.yPos < array[0].length-1 && array[current.xPos][current.yPos+1] != '#') {
            neighbors.add(new Cell(current.xPos, current.yPos+1, current.dist+1));
        }
        //checks Left
        if (current.xPos > 0 && array[current.xPos-1][current.yPos] != '#') {
            neighbors.add(new Cell(current.xPos-1, current.yPos, current.dist+1));
        }
    return neighbors;
    }

    //small Changes to Cell that was provided in the hint
    private static class Cell {
        public int xPos, yPos, dist;

        public Cell(int xPos, int yPos, int dist) {
            this.xPos = xPos;
            this.yPos = yPos;
            this.dist = dist;
        }
    }
}
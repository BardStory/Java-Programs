//Solution for Assignment 1 CSC225

import java.io.*;
import java.util.*;

public class Solution {
   
    public static void main(String[] args) 
    {
        //variables
        int temp1 = 0;
        int temp2 = 0;
        int difference = 0;

        //scanner
        Scanner sc = new Scanner(System.in);
        //sets n as the first int
        int n= sc.nextInt();
        //puts the remaining numbers into the array
        int[] a = new int[n];
        //uses a for loop to restore remaining numbers
        for(int i=0; i< n; i++){
            //grabs the next int each time into the array
            a[i] = sc.nextInt();
        }
 
        //Sorts the Array
        Arrays.sort(a);
        int total = a[n-1];

       for(int i=n-1;i>0;i--)
       {
        //System.out.println(a[i]);
            {
                difference = a[i]-a[i-1];
                //System.out.println("difference = " +difference);
                if(difference<total)
                {
                    total = difference;
                    temp1 = a[i];
                    temp2 = a[i-1];
                }
            }          
       }
    System.out.print(temp2 + " " + temp1);        
    }
}

/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
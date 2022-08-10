import java.io.*;
import java.util.*;

public class Solution 
{

    public static boolean testing(int[] a, int[] b, int n)
    {
        if(n%2 == 0)
        {
            int mid = n/2;
            int[] a1 = Arrays.copyOfRange(a, 0, mid);
            int[] a2 = Arrays.copyOfRange(a, mid, n);
            int[] b1 = Arrays.copyOfRange(b, 0, mid);
            int[] b2 = Arrays.copyOfRange(b, mid, n);

            if((Arrays.equals(a1, b1)) == true && (Arrays.equals(a2,b2)) == true)
            {
                return false;
            }
            else if((Arrays.equals(a1, b1)) == true && (Arrays.equals(a1,b2)) == true)
            {
                return true;
            }
            else if((Arrays.equals(a2, b2)) == true && (Arrays.equals(a2,b1)) == true)
            {
                return true;
            }
            else
            {
                return(testing(a1, b1, n/2) || testing(a2,b2,n/2));
            }
        }
    return false;    
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        //scanner
        Scanner sc = new Scanner(System.in);
        //sets n as the first int
        int n= sc.nextInt();
        //initialises the two arrays
        int[] a = new int[n];
        int[] b = new int[n];
        //fills the arrays
        for(int i=0; i< n; i++){
            a[i] = sc.nextInt();
        }
        for(int i=0; i<n;i++)
        {
            b[i] = sc.nextInt();
        }
        //below is a test to see contents of the array
        //System.out.print(Arrays.toString(a));
        //System.out.print(Arrays.toString(b));

        if(Arrays.equals(a,b) == true)
        {
            System.out.print("YES");
        }
        else 
        {
            if(testing(a, b, n) == true)
            {
                System.out.print("YES");
            
            }       
            else
            {
                System.out.print("NO");
            }
        } 
    }
}


import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {



    public static void main(String[] args) 
    {

        
    	Scanner scanner = new Scanner(System.in).useDelimiter("[^0-9]+");

        int power = scanner.nextInt();
        BigInteger result = scanner.nextBigInteger();


        BigInteger two = new BigInteger("2");
        BigInteger one = new BigInteger("1");
        BigInteger zero = new BigInteger("0");
        BigInteger negativeOne = new BigInteger("-1");

        BigInteger start = new BigInteger("1");

        BigInteger mid = ((start.add(result)).divide(two));



        while(start.pow(power).compareTo(result.pow(power)) != 0)
        {
            mid = (start.add(result).divide(two));

            if(mid.pow(power).compareTo(result) == 0)
            {
                break;
            }
            else if (mid.pow(power).compareTo(result) == -1)
            {
                start = mid.add(one);
            }
            else
            {
                result = mid.add(negativeOne);
            }

            //System.out.println("First if statement = " + mid.pow(power).compareTo(result));
            //System.out.println("Second if statement = " + mid.pow(power).compareTo(result));
        }         

        mid = (start.add(result).divide(two));
        //System.out.print(mid);
    }
}
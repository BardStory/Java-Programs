import java.io.*;
import java.util.*;

public class Solution 
{

	public static void main(String[] args) 
	{
		

		FastReader input = new FastReader();
		TreeSet<Integer> a = new TreeSet<>();
		TreeSet<Integer> b = new TreeSet<>();

		int size = input.nextInt();
		long result = 1;

		int[] array = new int[size];

		for(int i=0; i< size; i++){
            //grabs the next int each time into the array
            array[i] = input.nextInt();
        }

        for(int i=0; i < size;i++)
        {
        	if(a.isEmpty()){
        		a.add(array[i]);
        	
        	}
       	
        	else{
        		a.add(array[i]);
        		
        	}
        	
        	if(a.size() > b.size() + 1)
        	{
        		
        		b.add(a.last());
        		a.remove(a.last());
        	
        	}
        	else if (a.size() + 1 < b.size())
        	{
        		
        		a.add(b.first());
        		b.remove(b.first());
        	
        	}

            if(b.size() != 0)
            {
                if(a.last() > b.first()){
                    a.add(b.first());
                    b.add(a.last());

                    a.remove(a.last());
                    b.remove(b.first());
                }
            }
			
			//System.out.println("median = " + a.last());
        	result = ((result * a.last()) % 1000000007);  	
        }

        System.out.println(result);
	}

static class FastReader {
        
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
            return Double.parseDouble(next());
        }
        
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
	}

}

	


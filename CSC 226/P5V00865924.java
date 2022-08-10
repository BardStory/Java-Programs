import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Solution {

	public static void main(String[] args) {
		//Fast Reader for reading the table
		FastReader input = new FastReader();
		//size to grab the total size of the input
		int size = input.nextInt();
		//the hash map will contain string then integer
		// .put ("java", 6) 
		HashMap<String,	Integer> table = new HashMap<>(size*2);

		//iterate through the arr storing the string next
		for(int i=0; i < size;i++){
			String next = input.next();

			if(!table.containsKey(next)){
				//store them all in the same spot 
				table.put(next, 1);		
			}
			else
				table.put(next, table.get(next)+1);
		}
		int big = 0;
		String blank = "";
		
		for (Entry<String, Integer> pair : table.entrySet()) {
            if((pair.getValue()) > big){
            	blank = pair.getKey();
            	big = pair.getValue();
            }
            else if((pair.getValue()) == big) {
            	if(pair.getKey().compareTo(blank) < 0){
            		blank = pair.getKey();
            		big = pair.getValue();
            	}
        	}
		}
	System.out.print(blank + " " + big);
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
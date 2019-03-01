package zip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class DeQ {
    public static void main(String[] args) throws IOException  {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        Deque subQ = new ArrayDeque<>();
        HashSet set ;
        int max=0;
        
        String nm[] = in.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        /*
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
           
        }
        */
        String nos[] = in.readLine().split(" ");
        for(int i=0;i<nos.length;i++) {
        	deque.add(nos[i]);
        	
        	if(deque.size()==m) {
        		set = new HashSet<Integer>(deque);
        		if(max<set.size())
            		max=set.size();
        		deque.pop();
        	}
        }
        
        //System.out.println(deque.removeLast());
        /*
        while(deque.size()>=m) {
        	for(int i=0;i<m;i++) {
        		subQ.add(deque.pop());
        	}
        	set = new HashSet<Integer>(subQ);
        	//System.out.println(set.size());
        	
        	
        	for(int i=0;i<m-1;i++) {
        		deque.addFirst(subQ.removeLast());
        	}
        	subQ.clear();
        }*/
        System.out.println(max);
        
        
        
    }
}





package dailyCodeProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LowestPositiveInteger {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String list[] = in.readLine().split(" ");
		int numList[] = new int[list.length];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n,min=1;
		
		for(int i =0;i<list.length;i++) {
			n = Integer.parseInt(list[i]);
			map.put(n, 0);
			if(min>n && n>0) {
				min = n;
			}
		}
		
		try {
			while(map.get(++min)==0) {
				
			}
			
		} catch (NullPointerException e) {
			System.out.println(min);
		}
		
		
		

	}

}

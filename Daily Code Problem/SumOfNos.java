package dailyCodeProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class SumOfNos {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> op;
		
		
		System.out.println("Enter the list of numbers: ");
		String[] nos = in.readLine().split(" ");
		int list[] = new int[nos.length];
		for(int i=0;i<nos.length;i++) {
			list[i]= Integer.parseInt(nos[i]);
		}
		
		System.out.println("Enter k: ");
		int k = Integer.parseInt(in.readLine());
		
		op = checkForSum(list,k,map);
		for(Integer n : op.keySet()) {
			
			System.out.println(n + "->" + op.get(n));
			
		}
		

	}
	
	static Map<Integer,Integer> checkForSum(int[] list, int k,Map<Integer, Integer> map){
		Map<Integer, Integer> op = new HashMap<Integer, Integer>();
		for(int i = 0;i<list.length;i++) {
			
			if(map.containsKey(Math.abs(list[i]-k))) {
				op.put(list[i], Math.abs(list[i]-k));
			}
			else {
				map.put(list[i], Math.abs(list[i]-k));
			}
			
			
			
			
		}
		
		return op;
		
		
	}

}

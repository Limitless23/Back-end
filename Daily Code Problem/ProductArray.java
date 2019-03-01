package dailyCodeProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductArray {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the list of numbers: ");
		String nos[] = in.readLine().split(" ");
		int list[] = new int[nos.length];
		for(int i=0;i<nos.length;i++) {
			list[i] = Integer.parseInt(nos[i]);
		}
		
		ProductArray prod = new ProductArray();
		prod.findProd(list);
	}
		
		public void findProd(int[] list) {
			
			int left[] = new int[list.length];
			left[0] = 1;
			int right[] = new int[list.length];
			right[list.length - 1] =1;
			
			
			for(int i=1;i<list.length;i++) {
				left[i] = list[i-1] * left[i-1];
				
			}
			
			for(int i = list.length-2;i>=0;i--) {
				right[i] = list[i+1] * right[i+1];
			}
			
			for(int i =0;i<list.length;i++) {
				System.out.print(left[i]*right[i] + " ");
			}
		}
		
		

	}



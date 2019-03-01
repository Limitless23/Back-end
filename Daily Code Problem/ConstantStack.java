package dailyCodeProblem;

import java.util.ArrayList;
import java.util.Scanner;

public class ConstantStack {

	static ArrayList<Integer> stack = new ArrayList<Integer>();
	static ArrayList<Integer> aux = new ArrayList<Integer>();
	private int max = Integer.MIN_VALUE;
	public void push(int element) {
		
		stack.add(element);
		if(element>max) {
			max = element;
			aux.add(max);
		}
		else {
			aux.add(aux.get(aux.size()-1));
		}
		
	}
	
	public int pop() {
		
		if(stack.isEmpty()) {
			System.out.println("Stack empty");
			return 0;
		}
		else {
			aux.remove(aux.size()-1);
			return stack.remove(stack.size()-1);
		}
	}
	
	public int max() {
		if(stack.isEmpty()) {
			System.out.println("Empty stack");
			return 0;
		}
		return aux.get(aux.size()-1);
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ConstantStack st = new ConstantStack();
		while(true) {
			System.out.println("1. Push  2. Pop  3. Max");
			switch(scan.nextInt()) {
			
			case 1: System.out.println("Enter the number to be pushed");
					st.push(scan.nextInt());
					break;
			case 2: System.out.println(st.pop());
					break;
			case 3: System.out.println(st.max());
					break;
			
			}
		}

	}

}

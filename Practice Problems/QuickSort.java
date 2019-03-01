package zip;

import java.util.Scanner;

public class QuickSort {

	static int[] arr;
	
	public int partition(int l,int r) {
		
		
			int i = l-1;
			int pivot = arr[r];
			
			for(int j=l;j<r;j++) {
				if(arr[j]<=pivot) {
					int temp = arr[j];
					arr[j] = arr[++i];
					arr[i] = temp;
				}
			}
			int temp = arr[i+1];
			arr[i+1]=arr[r];
			arr[r]= temp;
			
			return i+1;
		
		
	}
	
	public void quicksort(int l,int r) {
		
		if(l<r) {
			
			int q = partition(l,r);
			quicksort(l, q-1);
			quicksort(q+1, r);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the nos: ");
		String[] list = scan.nextLine().split(" ");
		arr = new int[list.length];
		for(int i =0;i<list.length;i++) {
			arr[i] = Integer.parseInt(list[i]);
		}
		
		QuickSort quick = new QuickSort();
		quick.quicksort(0, arr.length-1);
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i]+ " ");
		}

	}

}

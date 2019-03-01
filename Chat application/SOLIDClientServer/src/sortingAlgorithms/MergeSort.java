package sortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	private static int[] array;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the list of numbers: ");

		String[] list = in.nextLine().split(" ");
		in.close();


		MergeSort merge = new MergeSort();
		merge.handler(list);
		for(int i = 0;i<array.length;i++)
			System.out.print(array[i]+ " ");

	}

	public void handler(String[] list) {

		array = new int[list.length];
		for(int i = 0;i < list.length; i ++) {
			array[i] = Integer.parseInt(list[i]);
		}

		mergeSort(0,array.length-1);

	}

	private void mergeSort(int low, int high) {

		if(low<high) {
			int mid = low + (high-low)/2;
			mergeSort(0, mid);
			mergeSort(mid+1, high);
			merge(low,mid,high);
		}




	}

	private void merge(int low, int mid, int high) {

		int helper[] = Arrays.copyOf(array, array.length);
		int i = low;
		int j = mid+1;
		int k = low;

		while(i<= mid && j<=high) {

			if(helper[i]<=helper[j]) {
				array[k++]=helper[i++];

			}
			else {
				array[k++] = helper[j++];
			}			
		}

		while(i<=mid) {
			array[k++] = helper[i++];
		}

	}

}

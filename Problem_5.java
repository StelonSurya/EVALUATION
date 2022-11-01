package zoho;

import java.util.Arrays;

public class Problem_5 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(10);
		list.addLast(list.tail , 10);
		list.addLast(list.tail , 6);
		list.addLast(list.tail , 3);
		list.addLast(list.tail , 5);
		
		System.out.print("INPUT LINKED LIST: ");
		list.print(list.head);		
		System.out.println();
		
		//int length = list.findLength(list.head);
		
		int convertedArray [] = list.convert(list.head);
		System.out.println("Converted Array  : " + Arrays.toString(convertedArray));
		
		int ans[]  = findMax(convertedArray);
		System.out.println("answer Array  : " + Arrays.toString(ans));
		
	}

	private static int[] findMax(int[] arr) {
		int nums[] = new int[arr.length];
		int max=arr[arr.length-1];
		nums[arr.length-1]=0;
		 for(int i=arr.length-1 ;i>=0 ;i--) {
			 max = Math.max(arr[i], max);
			 if(arr[i] < max) {
				 nums[i] = max;           
			 }
		 }
		return nums;
	}

}

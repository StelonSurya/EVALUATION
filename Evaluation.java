import java.util.*;

public class Evaluation {

	public static void main(String[] args) {
		// problem 1
		int [] nums = {5,3,7,1};
		int [] ans = productExceptSelf(nums);
		System.out.println(Arrays.toString(ans));
		
		//problem 2 
		int nums1[] = {-1,0,1,2,-1,4};
		ArrayList<ArrayList<Integer>> ans1 = findTriplets(nums1);
		System.out.println(ans1);
		
		//problem 3
		String input = "XBXAXB";
		HashSet <String> list = new HashSet<>();
		findCombination("",input , list);
		System.out.println(list);
		System.out.println(list.size());
		int count =0 ;
		for(String  str : list) {
			if(findPattern(str)) {
				count++;
				System.out.println(str);
			}
		}
		System.out.println(count);
	}
	// problem 3
	private static boolean findPattern(String str) {
		int n = str.length();
	    if(n %2 == 0) {
	    	return str.substring(0,n/2).equals(str.substring(n/2,n));
	    }
		return str.substring(0,(n/2)+1).equals(str.substring(n/2,n));
	}
	// problem 1 --
	private static int [] productExceptSelf(int [] nums) {
		int [] ans = new int[nums.length];
		int [] left = new int [nums.length];
		int [] right = new int [nums.length];
		int product = 1;
		left[0] = product;
		for(int i=1;i<nums.length ; i++) {
			product*=nums[i-1];
			left[i] = product;
		}
		product =1 ;
		right[nums.length-1] = product;
		for(int i=nums.length-2;i>=0 ; i--) {
			product*=nums[i+1];
			right[i] = product;
		}
		
		for(int i=0;i<nums.length;i++) {
			ans[i] = left[i]*right[i];
		}
		return ans;
	}
	
	// problem 2 --
	private static ArrayList<ArrayList<Integer>> findTriplets(int [] nums){
		Arrays.sort(nums);
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0 ;i<nums.length-2;i++) {
			if(i==0 || (i>0 && nums[i] != nums[i-1])) {
			    int start =i+1;
			    int end = nums.length-1;
			    int sum = -nums[i];
			     while(start < end) {
			    	 if(nums[start] + nums [end] == sum) {
			    		 list.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[start], nums[end])));
			    		 while(start < end && nums[start] == nums[start+1])start++;
			    		 while(start < end && nums[end] == nums[end - 1])end--;
			    	 }
			    	if(nums[start] + nums [end] < sum)start ++;
			    	else  end --;
			    	
			     }
			}
		}
		return list;
	}
	// problem 3
   static  private void findCombination(String p , String up , HashSet<String> list){
    	if(p.length() >= 3 )list.add(p);
    	if(up.isEmpty())return;
    	for( int i =0 ;i< up.length(); i++) {
    		findCombination(p+up.charAt(0) , up.substring(i+1) , list);
    		findCombination(p , up.substring(i+1) , list);
    	}
    }
   
}

package 两数之和;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums= {2,7,11,15};
		int target=9;
		
		int []res=twoSum(nums, target);
		
		System.out.println(res[0]+"----"+res[1]);

	}
	 public static int[] twoSum(int[] nums, int target) {
	     int [] result=new int [2]; 
	     result[0]=0;
	     result[1]=0;
		 for(int i=0;i<nums.length;i++) {
			 for (int j = 0; j < result.length-i; j++) {
				 if((nums[i]+nums[i+1])==target) {
		        		result[0]=i;
		        		result[1]=i+1;
		        	}
			}
	        	
	        	
	        }
	 return result;   
	 }
}

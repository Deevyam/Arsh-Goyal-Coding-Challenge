/*
75. Sort Colors
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.
Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
*/

Soln: 

class Solution {
    public void sortColors(int[] nums) {
        int c1=0,c2=0,c3=0;
        for(int i:nums){
            if(i==0)c1++;
            else if(i==1) c2++;
            else c3++;
        }
        int idx=0;
        while(c1+c2+c3!=0){
            if(c1!=0){
                nums[idx++]=0;
                c1--;
            }
            else if(c1==0&&c2!=0  ){
                nums[idx++]=1;
                c2--;
            }
            else{
                nums[idx++]=2;
                c3--;
            }
        }
    }
}

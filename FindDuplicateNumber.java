/*
287. Find the Duplicate Number
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.
Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3
Constraints:
1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 
*/
Soln 1:(HashSet approach)
  class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            if(set.contains(i)){
                return i;
            }
            else{
                set.add(i);
            }
        }
        return 0;
    }
}

Soln 2: (Frequency check)

public int findDuplicate(int[] nums) {
       int[] freq=new int[nums.length+1];
       for(int i: nums){
        freq[i]++;
       }
     for(int i = 0;i<freq.length; i++){
            if(freq[i]>=2)return i;
        }
       return -1;
    }
}

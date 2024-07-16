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
All the integers in nums appear only once except for precisely one integer which appears two or more times
*/
soln 1:
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
soln 2 :
  public int findDuplicate(int[] nums) {
       for (int i = 0; i < nums.length; i++) {
        int index = Math.abs(nums[i]) - 1; // Adjusting index for zero-based array
        if (nums[index] < 0) {
            return Math.abs(nums[i]); // Duplicate found
        } else {
            nums[index] = -nums[index]; // Marking the element as visited
        }
    }
    return -1; // No duplicates found
}
}

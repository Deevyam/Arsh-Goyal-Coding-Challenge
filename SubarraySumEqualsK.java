/*
560. Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.
Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
Constraints
1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/

soln : (Brute force)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum==k){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
soln 2 : (optimized)
  class Solution {
    public int subarraySum(int[] nums, int k) {
       int count = 0;
        int cumulativeSum = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1); // Initialize with one occurrence of cumulative sum 0
        for (int num : nums) {
            cumulativeSum += num;
            int complement = cumulativeSum - k;
            if (sumMap.containsKey(complement)) {  // Check if the complement exists in the hashmap
                count += sumMap.get(complement);
            }
            sumMap.put(cumulativeSum, sumMap.getOrDefault(cumulativeSum, 0) + 1);  // Update the count of the current cumulative sum in the hashmap
        }
        return count;
    }
}

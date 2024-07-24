/*
42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
Constraints:
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/

Soln 1:Space O(n)
class Solution {
    public int trap(int[] bars) {
      int n = bars.length;
        
        // base case
        if (n <= 2) {
            return 0;
        }
        int water = 0;
        int[] left = new int[n-1];
        left[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n - 1; i++) {
            left[i] = Integer.max(left[i - 1], bars[i - 1]);
        }
        int right = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 1; i--)
        {
            right = Integer.max(right, bars[i + 1]);
            if (Integer.min(left[i], right) > bars[i]) {
                water += Integer.min(left[i], right) - bars[i];
            }
        }
        return water;
    }

Soln 2:(Constant Space O(1))
class Solution {
    public int trap(int[] height) {
        int ans=0;
        int left=0;int right=height.length-1;
        int maxl=0,maxr=0;
        while(left<right){
            maxl=Math.max(height[left],maxl);
            maxr=Math.max(height[right],maxr);
            if(maxl<maxr){
                ans+=maxl-height[left];
                left++;
            }
            else{
                ans+=maxr-height[right];
                right--;
            }
        }
        return ans;
    }
}

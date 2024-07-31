/*
Minimum Swaps to Sort
Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.
Example 1:
Input:
nums = {2, 8, 5, 4}
Output:
1
Explanation:
swap 8 with 4.
Example 2:
Input:
nums = {10, 19, 6, 3, 5}
Output:
2
Explanation:
swap 10 with 3 and swap 19 with 5.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minSwaps() which takes the nums as input parameter and returns an integer denoting the minimum number of swaps required to sort the array.
If the array is already sorted, return 0. 
Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(n)


Constraints:
1 ≤ n ≤ 105
1 ≤ numsi ≤ 106
*/

Soln :
class Solution
{
    public void swap(int[] arr, int x, int y)
    {
        int t= arr[x];
        arr[x]=arr[y];
        arr[y]=t;
    }
    
    public int minSwaps(int nums[])
    {
        // Code here
        int count=0;
        int n=nums.length;
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int x=0;x<n;x++)
            map.put(nums[x],x);
        Arrays.sort(nums);
        
        for(int x=0; x<n; x++)
        {
            if(x == map.get(nums[x]))
                continue;
            else
            {
                count++;
                swap(nums,x,map.get(nums[x]));
                x--;
            }
        }
        return count;
    }
}

/*
347. Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
*/
Soln :

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     HashMap<Integer,Integer> map=new HashMap<>();
     int[] arr=new int[k];
     int x=0;
     for(int i:nums){
         map.put(i,map.getOrDefault(i,0)+1);
     }
     PriorityQueue<Integer> p=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
     p.addAll(map.keySet());
     for(int i=0;i<k;i++){
         arr[i]=p.poll();
     }
     return arr;
    }
}

/*
973. K Closest Points to Origin
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
Example 1:
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
*/
Soln 1:
class Solution {
    class Pair{
        double a;
        int[]arr;
        Pair(double a,int[] arr){
            this.a=a;
            this.arr=arr;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int n=points.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b) -> Double.compare(b.a, a.a));
        int a[][]=new int[k][2];
        for(int i=0;i<n;i++){
           int x=points[i][0]*points[i][0];
           int y=points[i][1]*points[i][1];
            pq.offer(new Pair(Math.sqrt(x + y), new int[]{points[i][0], points[i][1]}));
           if(pq.size()>k) pq.poll();
        }
        for(int i=0;i<k;i++){
            Pair p=pq.poll();
            a[i][0]=p.arr[0];
            a[i][1]=p.arr[1];
        }
        return a;
    }
}
Soln 2:
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]>pq=new PriorityQueue<>((o1, o2) -> {
            return (o2[0]*o2[0] + o2[1]*o2[1]) - (o1[0]*o1[0] + o1[1]*o1[1]);
        });
        for(int[] p: points){
            pq.add(p);
            if(pq.size()>k)pq.poll();
        }
        return pq.toArray(new int[k][]); 
    }
}

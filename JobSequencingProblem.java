/*
Job Sequencing Problem
Given a set of N jobs where each jobi has a deadline and profit associated with it.
Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only if the job is completed by its deadline.
Find the number of jobs done and the maximum profit.
Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. Deadline of the job is the time before which job needs to be completed to earn the profit.
Example 1:
Input:
N = 4
Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
Output:
2 60
Explanation:
Job1 and Job3 can be done with
maximum profit of 60 (20+40).

Example 2:
Input:
N = 5
Jobs = {(1,2,100),(2,1,19),(3,2,27),
        (4,1,25),(5,1,15)}
Output:
2 127
Explanation:
2 jobs can be done with
maximum profit of 127 (100+27).
Your Task :
You don't need to read input or print anything. Your task is to complete the function JobScheduling() which takes an integer N and an array of Jobs(Job id, Deadline, Profit) as input and returns the count of jobs and maximum profit as a list or vector of 2 elements.


Expected Time Complexity: O(NlogN)
Expected Auxilliary Space: O(N)


Constraints:
1 <= N <= 105
1 <= Deadline <= N
1 <= Profit <= 500


*/
Ideal approch :
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class JobDeadline {
    static class Jobinfo {
        String jobName;
        double jobProfit;
        int jobDeadline;
        Jobinfo(String n, double p, int d) {
            jobName = n;
            jobProfit = p;
            jobDeadline = d;
        }
    }

    private final Scanner sc = new Scanner(System.in);
    private final ArrayList<Jobinfo> jobs = new ArrayList<>();
    private int numJobs;

    JobDeadline() {
        System.out.println("Enter number of jobs:");
        numJobs = sc.nextInt();
        for (int i = 0; i < numJobs; i++) {
           // System.out.println("Enter job name, profit, and deadline for job " + (i + 1) + ":");
            jobs.add(new Jobinfo(sc.next(), sc.nextDouble(), sc.nextInt()));
        }
    }

    void sortJob() {
        Collections.sort(jobs, (a, b) -> Double.compare(b.jobProfit, a.jobProfit));
    }

    void calMaxJob() {
        boolean[] vacantSpace = new boolean[numJobs];
        int maxProfit = 0;
        ArrayList<String> jobOrder=new ArrayList<>();
        for (int i = 0; i < numJobs; i++) {
            for (int j = Math.min(numJobs - 1, jobs.get(i).jobDeadline - 1); j >= 0; j--) {
                if (!vacantSpace[j]) {
                    vacantSpace[j] = true;
                    jobOrder.add(jobs.get(i).jobName);
                    maxProfit += jobs.get(i).jobProfit;
                    break;
                }
            }
        }
        System.out.println("Max Profit: " + maxProfit);
        System.out.println("Job order");
        for(int i=0;i<jobOrder.size();i++){
            System.out.println(jobOrder.get(i)+" ");
        }
    }
}

public class GreedyAlgo2 {
    public static void main(String[] args) {
        JobDeadline j = new JobDeadline();
        j.sortJob();
        j.calMaxJob();
    }
}
Soln based on Question :
/
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
      int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (a,b)-> b.profit-a.profit);
        boolean p[] = new boolean[n+1];
        int res[] = new int[2];
        for(Job job: arr) {
            for(int i=job.deadline; i>=1; i--) {
                if(!p[i]) {
                    p[i] = true;
                    res[0]++;
                    res[1] += job.profit;
                    break;
                }
            }
        }
        return res;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/

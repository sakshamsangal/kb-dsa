package com.app.advance.greedy;

import java.io.IOException;
import java.util.Arrays;


public class JobSch {
    public int[] JobScheduling(Job[] jobs, int n) {
        Arrays.sort(jobs, (o1, o2) -> o2.profit - o1.profit);


        int maxProfit = 0;
        int maxDeadline = 0;
        int jobCount = 0;

        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        boolean[] busySlot = new boolean[maxDeadline + 1];

        for (Job job : jobs) {
            for (int i = job.deadline - 1; i > -1; i--) {
                if (!busySlot[i]) {
                    maxProfit += job.profit;
                    jobCount++;
                    busySlot[i] = true;
                    break;
                }
            }
        }

        return new int[]{maxProfit, jobCount};
    }

    public static void main(String[] args) throws IOException {

        JobSch jobSch = new JobSch();

        //size of array
        Job[] arr = new Job[4];
        arr[0] = new Job(1, 4, 20);
        arr[1] = new Job(2, 1, 10);
        arr[2] = new Job(3, 2, 40);
        arr[3] = new Job(4, 2, 30);


        //function call
        int[] res = jobSch.JobScheduling(arr, 4);

    }
}
package com.app.advance.greedy;// Java program for activity selection problem.
// The following implementation assumes that the activities
// are already sorted according to their finish time

import java.util.*;

public class ActivitySelection {
    // Prints a maximum set of activities that can be done
    // by a single person, one at a time.
    public static void printMaxActivities(int[] s, int[] f, int n) {
        int i, j;
        System.out.println("Following activities are selected");
        // The first activity always gets selected
        i = 0;
        System.out.print(i + " ");
        // Consider rest of the activities
        for (j = 1; j < n; j++) {
            // If this activity has start time greater than
            // or equal to the finish time of previously
            // selected activity, then select it
            if (s[j] >= f[i]) {
                System.out.print(j + " ");
                i = j;
            }
        }
    }


    int[] JobScheduling(Job[] arr, int n) {

        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxi) {
                maxi = arr[i].deadline;
            }
        }

        int result[] = new int[maxi + 1];

        for (int i = 1; i <= maxi; i++) {
            result[i] = -1;
        }

        int countJobs = 0, jobProfit = 0;

        for (int i = 0; i < n; i++) {

            for (int j = arr[i].deadline; j > 0; j--) {

                // Free slot found
                if (result[j] == -1) {
                    result[j] = i;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }

        int ans[] = new int[2];
        ans[0] = countJobs;
        ans[1] = jobProfit;
        return ans;
    }

    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        List<Activity> activities = new ArrayList<>();
        ArrayList<Integer> meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            activities.add(new Activity(S[i], F[i], i + 1));
        }

        activities.sort(Comparator.comparingInt(o -> o.end));
        meetings.add(activities.get(0).index);
        int selectedEnd = activities.get(0).end;

        for (int i = 1; i < N; i++) {
            if (selectedEnd < activities.get(i).start) {
                meetings.add(activities.get(i).index);
                selectedEnd = activities.get(i).end;
            }
        }

        meetings.sort(Comparator.naturalOrder());

        return meetings;
    }










    // Driver code
    public static void main(String[] args) {
        int[] s = {1, 3, 0, 5, 8, 5};
        int[] f = {2, 4, 6, 7, 9, 9};
        // Function call
        ActivitySelection activitySelection = new ActivitySelection();
        Job job1 = new Job(1, 4, 20);
        Job job2 = new Job(2, 1, 10);
        Job job3 = new Job(3, 1, 40);
        Job job4 = new Job(4, 1, 30);
        Job job5 = new Job(1, 4, 20);

        Job[] arr = new Job[5];
        arr[0] = job1;
        arr[1] = job2;
        arr[2] = job3;
        arr[3] = job4;
        arr[4] = job5;
        activitySelection.JobScheduling(arr, 5);
    }
}


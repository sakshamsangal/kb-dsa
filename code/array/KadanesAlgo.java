package array;

public class KadanesAlgo {
    public static int maximumSubarraySum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int[] arr1 = new int[1];


        for (int i = 0; i <= n - 1; i++) {
            currSum += arr[i];

            if (currSum > maxSum) {
                maxSum = currSum;
            }

            if (currSum < 0) {
                currSum = 0;
            }
            arr1[i] = currSum;

        }

        return maxSum;
    }


    public static void main(String args[]) {
        // Your code goes here
        int a[] = {-10};
        System.out.println(maximumSubarraySum(a));
    }
}
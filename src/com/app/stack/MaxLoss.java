package com.app.stack;// Java implementation of the approach


public class MaxLoss {


    // Driver code
    public static void main(String[] args) {
        int[] price = {10,4,2,9};
        int n = price.length;
        solve(price, n);
//        System.out.print(solve(price, n));
    }

    private static void solve(int[] arr, int n) {

        int min = Integer.MAX_VALUE;
        int loss = 0;
        // curr=4  min=10
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i]< min){
                min = arr[i];
            }
            int currLoss = Math.max(arr[i]-min,0); // c=4,  min =2
            loss = Math.max(currLoss, loss);
        }
        System.out.println("loss = " + loss);


    }


}

// This code is contributed by PrinciRaj1992

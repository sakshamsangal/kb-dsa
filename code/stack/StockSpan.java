package stack;// Java implementation of the approach


import java.util.Arrays;
import java.util.Stack;

public class StockSpan {


    // Driver code
    public static void main(String[] args) {
        int[] price = {100, 80, 60, 70, 60, 75, 85};
        int n = price.length;
        solve(price, n);
//        System.out.print(solve(price, n));
    }

    private static void solve(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        ans[0] = 1;
        stack.add(0);
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[stack.peek()]) {
                ans[i] = 1;
            } else {
                while (arr[stack.peek()] < arr[i]){
                    stack.pop();
                }
                ans[i] = i - stack.peek();
            }
            stack.add(i);
        }
        System.out.println("ans = " + Arrays.toString(ans));
    }


}

// This code is contributed by PrinciRaj1992

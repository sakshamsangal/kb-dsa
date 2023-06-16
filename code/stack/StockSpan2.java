package stack;// Java implementation of the approach


import java.util.Stack;

public class StockSpan2 {


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
            while (stack.peek() < arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()){
                ans[i] = i+1;
            } else {
                ans[i]= i - stack.peek();
            }
            stack.add(i);
        }

    }


}


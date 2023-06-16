package stack;// Java implementation of the approach


public class StockBuySell2 {


    // Driver code
    public static void main(String[] args) {
        int[] price = {98,101,66,72};
        int n = price.length;
        int solve = solve(price, n);
        System.out.println("solve = " + solve);
//        System.out.print(solve(price, n));
    }

    private static int solve(int[] price, int n) {

        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            if (price[i] < minSoFar) {
                minSoFar = price[i];
            }
            int diff = price[i] - minSoFar;
            if (maxProfit<diff){
                maxProfit = diff;
            }
        }

        return maxProfit;
    }


}

// This code is contributed by PrinciRaj1992

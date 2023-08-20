public class CoinChange {
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,3,6};
        int ans = getWays(arr, arr.length-1, 10);
        System.out.println("ans = " + ans);
    }

    private static int getWays(int[] arr, int end, int sum) {
        if (sum == 0){
            return 1;
        }
        if (end == -1){
            return 0;
        }


        // not picked
        int ways =  getWays(arr, end - 1, sum);

        // picked
        if (arr[end]<= sum){
            ways += getWays(arr, end, sum - arr[end]);
        }

        return ways;
    }
}

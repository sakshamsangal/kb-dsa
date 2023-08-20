
public class LIS2 {


    public static void main(String[] args) {

        int[] arr = {3, 4, 2, 8, 10, 5, 1};

        int ans = lis(arr);
        System.out.println("ans = " + ans);

    }

    private static int lis(int[] arr) {
        int ans = 1;
        int[] li = new int[arr.length];

        li[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            li[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    li[i] = Math.max(li[j] + 1, li[i]);
                }
            }
        }


        for (int item : li) {
            ans = Math.max(ans, item);
        }
        return ans;
    }
}
public class LargestRect {

    public static int largestArea(int[] arr) {
        int ans = 0;

        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
            int selfArea = arr[i];
            int width = i + 1;
            for (int j = minIndex; j < i; j++) {

            }
            int areaWithPreviousItem = min * width;
            int maxAreaEndingWithItem = Math.max(selfArea, areaWithPreviousItem);
            System.out.println("maxAreaEndingWithItem = " + maxAreaEndingWithItem);
            ans = Math.max(ans, maxAreaEndingWithItem);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {6, 2, 5, 4, 1, 5, 6};
        int i = largestArea(arr);
        System.out.println("i = " + i);
    }

}
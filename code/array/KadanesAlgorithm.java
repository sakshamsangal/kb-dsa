package array;

public class KadanesAlgorithm {
    
    public static int solveMaxSubArrayProblem(int[] input) {
        int n = input.length;
        int globalMaxSum = Integer.MIN_VALUE;
        int localMaxSum = 0;
        int[] arr1 = new int[5];


        for (int i = 0; i < n ; i++) {
            localMaxSum = Math.max(input[i],input[i]+localMaxSum);
            arr1[i] = localMaxSum;
            if(localMaxSum>globalMaxSum){
                globalMaxSum = localMaxSum;
            }
        }

        return globalMaxSum;
    }
    public static void main(String args[]) {
        int input[] = {1, -2, 5, -3, 4};
        int result = solveMaxSubArrayProblem(input);
        System.out.println(result);
    }
}
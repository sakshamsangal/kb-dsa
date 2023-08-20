class Solution {
    public int climbStairs(int n) {
        if (n == 0) return 0;
        int i = 1+climbStairs(n - 1);
        int i1 = 0;
        if (n > 1) {
            i1 = 1+climbStairs(n - 2);
        }
        return i + i1;

    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        int i = solution.climbStairs(3);
        System.out.println("i = " + i);
    }
}
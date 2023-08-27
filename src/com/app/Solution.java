class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum1 = sum(nums, nums.length - 1, 0, 0, target);
        System.out.println("sum1 = " + sum1);
        return sum1;
    }


    public int sum(int[] nums, int end, int count, int p, int target) {
        if (end == -1) return 0;

        int picked = Integer.MAX_VALUE;
        int not_picked = Integer.MAX_VALUE;

        if (p < 3) {
            picked = nums[end] + sum(nums, end - 1, count, p + 1, target);
        }
        if (count < nums.length - 3) {
            not_picked = sum(nums, end - 1, count + 1, p, target);
        }
        if (picked==Integer.MAX_VALUE) return not_picked;
        if (not_picked==Integer.MAX_VALUE) return picked;
        if ((target - picked) < (target - not_picked)) {
            return picked;
        }
        return not_picked;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        solution.threeSumClosest(new int[]{0, 0, 0}, 1);
    }
}
package com.app.basic.array;

import com.app.util.LinkedListNode;

import java.util.*;

public class ArrayDsa {


    public int maxProfit(int[] prices) {

        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += Math.max(0, prices[i] - prices[i - 1]);
        }
        return sum;

    }

    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[(i + k) % nums.length];
        }

        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

    }

    Map<Integer, Integer> getFrequencyFromArray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            Integer freq = map.getOrDefault(item, 0);
            map.put(item, freq + 1);
        }
        return map;
    }

    public String simplifyPath(String path) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '.') {
                int countOfSlash = 0;
                while (!stack.isEmpty() && countOfSlash != 2) {
                    if (path.charAt(i) == '/') {
                        countOfSlash++;
                    }
                    stack.pop();
                }
                stack.push('/');
            } else if (path.charAt(i) == '/') {
                if (!stack.isEmpty() && stack.peek() != '/' && i != path.length() - 1) {
                    stack.push(path.charAt(i));
                }
            } else {
                stack.push(path.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Character character : stack) {
            ans.append(character);
        }
        return ans.toString();
    }


    public boolean isAnagram(String s1, String s2) {
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }


    static void powerSet(int[] arr, int size) {
        int totalSubset = (int) Math.pow(2, size); // total set

        for (int i = 1; i < totalSubset; i++) {
            for (int j = 0; j < size; j++) {

                // which items to pick from arr = set bits from i
                if ((i & (1 << j)) > 0) { // go inside if bit is set
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println();
        }
    }


    // max element
    int getMaxElementIndex(int[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    public String largestNumber(int[] nums) {
//        String[] str = new String[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            str[i] = String.valueOf(nums[i]);
//        }
//        List<String> collect = Arrays.stream(nums).mapToObj(String::valueOf).toList();
        String[] str = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        if (str[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (String s : str) {
            ans.append(s);
        }
        return ans.toString();
    }

    public LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {

        LinkedListNode<Integer> head = new LinkedListNode<>(-1);
        LinkedListNode<Integer> temp = head;
        while (first != null && second != null) {
            if (first.data < second.data) {

                temp.next = first;
                first = first.next;
            } else {
                temp.next = second;
                second = second.next;
            }
            temp = temp.next;
        }

        while (first != null) {
            temp.next = first;
            first = first.next;
        }

        while (second != null) {
            temp.next = second;
            second = second.next;
        }
        return head.next;
    }

    public ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {
        int len = permutation.size();
        if (1 < len) {

            // Write your code here.
            Integer a = permutation.remove(len - 1);
            Integer b = permutation.remove(len - 2);
            permutation.add(a);
            permutation.add(b);
        }

        return permutation;
    }

    public List<int[]> pairSum(int[] arr, int sum) {
        // Write your code here.
        ArrayList<int[]> list = new ArrayList<>();

        Arrays.sort(arr);
//        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    int[] temp = new int[arr.length];
                    temp[0] = arr[i];
                    temp[1] = arr[j];
                    list.add(temp);
//                    map.put(arr[i], arr[j]);
                }
            }
        }

//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            int[] temp = new int[arr.length];
//            temp[0] = entry.getKey();
//            temp[1] = entry.getValue();
//            list.add(temp);
//
//        }
        return list;

    }

    public int pivotIndex(int[] arr) {

        int n = arr.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];
        prefixSum[0] = 0;
        suffixSum[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];

        }

        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + arr[i + 1];
        }
        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == suffixSum[i]) {
                return i;
            }

        }
        return -1;

    }

    void productArray(int[] arr, int n) {

        // Base case
        if (n == 1) {
            System.out.print("0");
            return;
        }

        int i, temp = 1;

        /* Allocate memory for the product array */
        int[] prod = new int[n];

        /* Initialize the product array as 1 */
        Arrays.fill(prod, 1);

		/* In this loop, temp variable contains product of
		elements on left side excluding arr[i] */
        for (i = 0; i < n; i++) {
            prod[i] = temp;
            temp *= arr[i];
        }

        /* Initialize temp to 1 for product on right side */
        temp = 1;

		/* In this loop, temp variable contains product of
		elements on right side excluding arr[i] */
        for (i = n - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= arr[i];
        }

        /* print the constructed prod array */
        for (i = 0; i < n; i++)
            System.out.print(prod[i] + " ");

    }

    void reverseInteger(int n) {
        int[] a = new int[10];
        boolean isNegative = false;
        boolean isOverflow = false;
        if (n < 0) {
            isNegative = true;
            n = Math.abs(n);
        }
        int i = 0;
        int sum = 0;
        int prev = 0;
        while (n != 0) {
            a[i] = n % 10;
            n /= 10;
            sum = sum * 10 + a[i];
            if (sum < prev) {
                isOverflow = true;
                break;
            }
            prev = sum;
            i++;
        }
        if (isOverflow) {
            System.out.println(0);
        } else {
            if (isNegative) sum = -sum;
            System.out.println(sum);
        }
    }


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        for (int item : gas) {
            gasSum += item;
        }

        int costSum = 0;
        for (int item : cost) {
            costSum += item;
        }


        if (gasSum < costSum) {
            return -1;
        }


        int start = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            // choose starting point
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        return start;
    }


    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] ans = new int[nums.length];

        left[0] = 1;
        right[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        for (int i = nums.length - 2; i > -1; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }

    public int differenceOfSums(int n, int m) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                sum1 += i;
            } else {
                sum2 += i;
            }
        }

        return sum2 - sum1;
    }

    public int removeDuplicates(int[] nums) {
        int j = 2;
        for (int i = 2; i < nums.length; i++) {
            // prev different= add
            // prev 1 same = add
            // prev 2 same = ignore
            if (nums[i - 2] == nums[i]) {
                // ignore
            } else {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

//    public boolean canJumpRecur(int[] nums, int end) {
//        if (end == 0) {
//            return true;
//        }
//        for (int i = 0; i < end; i++) {
//            if (nums[i] + i >= end) {
//                return canJumpRecur(nums, i);
//            }
//        }
//        return false;
//    }

//    public boolean canJump(int[] nums) {
//        return canJumpRecur(nums, nums.length-1);
//    }

    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }


    public int foo(int sum) {
        if (sum == 1) {
            return 1;
        }
        if (sum == 2) {
            return 2;
        }
        return foo(sum - 1) + foo(sum - 2);
    }

    public int candy(int[] ratings) {
        int sum = 0;
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        left[0] = 1;
        right[right.length - 1] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        for (int i = ratings.length - 2; i > -1; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left[i], right[i]);
        }

        return sum;
    }

    public static void main(String[] args) {
        ArrayDsa arrayDsa = new ArrayDsa();
//        int[] arr = {0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 3};
//        int i = arrayDsa.removeDuplicates(arr);
//        System.out.println("arr = " + Arrays.toString(arr));
//        System.out.println("i = " + i);
//        boolean b = arrayDsa.canJump(arr);
//        System.out.println("b = " + b);

//        int[] arr = {-1, 1, 0, -3, 3};
//        int[] ints = arrayDsa.productExceptSelf(arr);
//        System.out.println("ints = " + Arrays.toString(ints));
//        System.out.println("i = " + i);
//        int i = arrayDsa.differenceOfSums(10, 3);

        int[] arr = {1, 0, 2};

        int candy = arrayDsa.candy(arr);
        System.out.println("candy = " + candy);
    }

}

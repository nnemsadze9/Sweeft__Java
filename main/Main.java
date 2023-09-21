package main;

import entity.MyDataStructure;
import entity.MyDataStructureException;

import java.util.*;

public class Main {
    public static void main(String[] args) throws MyDataStructureException {
        //1
        System.out.println("Test cases of first task:");
        System.out.println(singleNumber(new int[]{2,3,2,3,7,8,1,6,6,7,8}));//4
        System.out.println(singleNumber(new int[]{1,3,2,4,1,2,7,4,7}));//3
        System.out.println(singleNumber(new int[]{2,3,2,4,3,4,4,8}));//8
        System.out.println(singleNumber(new int[]{2,3,2,1,1,6,6,3}));//-1

        //2
        System.out.println("Test cases of second task:");
        System.out.println(minSplit(8));//4
        System.out.println(minSplit(11));//2
        System.out.println(minSplit(20));//1
        System.out.println(minSplit(152));//5

        //3
        System.out.println("Test cases of third task:");
        System.out.println(notContains(new int[]{3,4,1,6,7,8}));//2
        System.out.println(notContains(new int[]{1,3,2,4,1,2,7,7}));//5
        System.out.println(notContains(new int[]{2,3,2,4,3,4,4,8}));//1
        System.out.println(notContains(new int[]{2,3,2,1,1,3,6,6,3}));//4
        System.out.println(notContains(new int[]{2,3,2,1,4,3,5,6,7}));//8

        //4
        System.out.println("Test cases of fourth task:");
        System.out.println(addBinary("1010", "1011")); // 10101
        System.out.println(addBinary("111111", "1")); // 1000000
        System.out.println(addBinary("100101", "11010")); // 111111
        System.out.println(addBinary("101010101010", "1111111111")); // 110110110101

        //5
        System.out.println("Test cases of fifth task:");
        System.out.println(countVariants(5));//8
        System.out.println(countVariants(6));//13
        System.out.println(countVariants(7));//21

        //6
        System.out.println("Test cases of sixth task:");
        MyDataStructure<Integer> dataStructure = new MyDataStructure<>();
        dataStructure.add(50);
        dataStructure.add(60);
        dataStructure.add(100);
        System.out.println(dataStructure.get());
        System.out.println(dataStructure.delete());
        System.out.println(dataStructure.get());
        System.out.println(dataStructure.delete());
        System.out.println(dataStructure.get());

    }
    //1
    public static int singleNumber(int[] nums){
        HashMap<Integer,Integer> frequencyMap= new HashMap<>();// სიხშირეთა ჰეშმეპი
        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        for (Map.Entry<Integer,Integer> entry: frequencyMap.entrySet()) {
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return -1;//თუ მსგავსი რიცხვი ვერ იპოვა აბრუნებს -1
    }

    //2
    public static int minSplit(int amount) {
        int[] coins = {1, 5, 10, 20, 50};
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount];
    }

    //3
    public static int notContains(int[] arr) {
        int n = arr.length;
        boolean[] present = new boolean[n + 1];
        for (int j : arr)
            if (j >= 0 && j <= n)
                present[j] = true;
        for (int i = 1; i <= n; i++)
            if (!present[i])
                return i;
        return n + 1;
    }

    //4
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    //5
    public static int countVariants(int stairsCount){
        int[] dp = new int[stairsCount+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=stairsCount; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[stairsCount];
    }

    //6 It is in package called entity.
}

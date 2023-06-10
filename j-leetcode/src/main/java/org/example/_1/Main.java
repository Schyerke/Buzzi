package org.example._1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {
                3,2,4
        };
        int target = 6;
        int[] r = solve(nums, target);
        System.out.println(Arrays.toString(r));
    }

    private static int[] solve(int[] nums, int target) {
        for(int i = 0; i<nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                if(nums[i]+nums[j] == target && i!=j) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}

package org.example._2466;

import java.util.Arrays;

public class Solve {

    public static void main(String[] args) {
        countGoodString(3, 3, 1, 1);
    }

    public static void fib(int n){
        long[] dp = new long[5000];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(Arrays.toString(dp));
    }

    public static int countGoodString(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        dp[0] = 1;
        int ans = 0;
        int mod = 1000000007;
        for(int i = 1; i<high+1; i++) {
            dp[i] = ((i >= zero ? dp[i-zero] : 0) + (i >= one ? dp[i-one] : 0))%mod;
            System.out.println("dp[" + i + "]: " + dp[i]);
            if(i>=low){
                System.out.println("Entrato");
                ans += dp[i];
            }
        }
        System.out.println("Risposta: " + ans);
        return ans;
    }
}

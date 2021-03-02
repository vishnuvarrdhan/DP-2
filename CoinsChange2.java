// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : similar to coins change 1
// Your code here along with comments explaining your approach

class CoinsChange2 {
    public int change(int amount, int[] coins) {
        int n = coins.length + 1;
        int[][] dp =new int[n][amount+1];
        
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <n; i++){
            for(int j = 1; j < amount+1; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n-1][amount];
    }
}

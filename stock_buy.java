class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        
        if(n<=1||k<=0)
            return 0;
        int profit=0;
        
        if(k>=n/2){
            for(int i=0;i<n-1;i++){
                if(prices[i]<prices[i+1])
                    profit+=prices[i+1]-prices[i];
            }
            return profit;
            
        }
        
        
        int [][] dp= new int[k+1][n];
       
        
        for(int i=1;i<dp.length;i++){
            int maxdiff = -prices[0];
            for(int j=1;j<dp[0].length;j++){
                 maxdiff=Math.max(maxdiff,(dp[i-1][j-1]-prices[j-1]));
                 dp[i][j]=Math.max(dp[i][j-1],prices[j]+maxdiff);
            }
        }
        
        return dp[k][n-1];
        
    }
}

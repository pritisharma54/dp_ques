public class Solution {
     public static int helper(int[][] A,int i,int j,int [][] dp) {
         
        if(i >= A.length){
              return 0 ;
         }

           // To avoid solving overlapping subproblem
           if(dp[i][j] != -1){
             return dp[i][j] ;
           }


            // Add current to the minimum  of the next paths
            // and store it in dp matrix
          dp[i][j] = A[i][j] + Math.min(helper(A, i+1,j, dp), helper(A,i+1, j+1, dp)) ;

          return  dp[i][j];
     }
    public static int minimumPathSum(int[][] triangle, int n) {
        
        int[][] dp = new int[n+1][n+1];
        
         for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(triangle,0,0,dp);
       
    }
}

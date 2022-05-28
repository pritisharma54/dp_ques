public class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
       

        int m=grid.length;
        int n=grid[0].length;

       // Reference table to store subproblems.
		int[][] dp = new int[m][n];

         if(grid[0][0] == 0) 
            dp[0][0] = 1;

		// Paths to reach a cell in column 1.
		for (int i = 1; i < m; i++) {
            if(grid[i][0]==0)
			    dp[i][0] =  dp[i-1][0];
		}

		// Paths to reach a cell in row 1.
		for (int j = 1; j < n; j++) {
            if(grid[0][j]==0)
			    dp[0][j] =  dp[0][j-1];
		}

		// Bottom up approach.
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
                if(grid[i][j]==0)
				    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		// Returning answer.
		return dp[m - 1][n - 1];
    }
}

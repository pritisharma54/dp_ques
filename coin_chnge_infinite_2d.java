public class Solution {

	public static long countWaysToMakeChange(int A[], int c){
        //write your code here
        int n=A.length;
        long T[][]=new long[n+1][c+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=c;j++){
                if(i==0 && j==0){
                    T[i][j]=1;
                }
                else if(i==0){
                    T[i][j]=0;
                }
                 else if(j==0){
                    T[i][j]=1;
                }
                else if(j<A[i-1]){
                    T[i][j]=T[i-1][j];
                }else{
                    T[i][j]=T[i-1][j]+T[i][j-A[i-1]];
                }
            }
        }
        
        return T[n][c];

	}
	
}

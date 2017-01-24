package com.program.part2;

public class DPTest7 {
	public int findMinCost(String A,int n,String B,int m,int c0,int c1,int c2){
		if(A == null || B == null){
			return 0;
		}
		
		char[] str1 = A.toCharArray();
		char[] str2 = B.toCharArray();
		int[][] dp = new int[n+1][m+1];
		for(int i = 0;i < n+1;i++){
			dp[i][0] = i * c1;
		}
		for(int i = 0;i < m+1;i++){
			dp[0][i] = i * c0;
		}
		for(int i = 1;i < n+1;i++){
			for(int j = 1;j < m+1;j++){
				int temp1 = 0;
				if(str1[i-1] != str2[j-1]){
					temp1 = dp[i-1][j-1] + c2;
				}else{
					temp1 = dp[i-1][j-1];
				}
				dp[i][j] = Math.min(Math.min(dp[i][j-1]+c0, dp[i-1][j]+c1), temp1);
			}
		}
		return dp[n][m];
	}
}

package com.program.part2;

public class DPTest8 {
	public static void main(String[] args) {
		int[][] map = {{-2,-3,3},{-5,-10,1},{0,30,-5}};
		System.out.println(minBlood(map,3,3));
	}
	public static int minBlood(int[][] map,int n,int m){
		if(map == null){
			return 0;
		}
		int[][] dp = new int[n][m];
		dp[n-1][m-1] = map[n-1][m-1] > 0 ? 1 : 1 - map[n-1][m-1];
		for(int i = n-2;i > -1;i--){
			dp[i][m-1] = Math.max(dp[i+1][m-1] - map[i][m-1],1);
		}
		for(int i = m-2;i > -1;i--){
			dp[n-1][i] = Math.max(dp[n-1][i+1] - map[n-1][i], 1);
		}
		for(int i = n-2;i > -1;i--){
			for(int j = m-2;j > -1;j--){
				dp[i][j] = map[i][j] < Math.min(dp[i+1][j], dp[i][j+1]) ? Math.min(dp[i+1][j], dp[i][j+1]) - map[i][j] : 1;
			}
		}
		return dp[0][0];
	}
}

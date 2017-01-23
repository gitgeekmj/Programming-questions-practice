package com.program.part2;

public class DPTest6 {
	public static void main(String[] args) {
		int[] v = {261,247,419,133,391,456,374,591};
		int[] w = {42,25,30,35,42,21,26,28};
		System.out.println(maxValue(w,v,8,297));
	}
	//w为重量数组，v为价值数组，n为物品数量，cap为书包承重
	public static int maxValue(int[] w,int[] v,int n,int cap){
		if(w == null || v == null || n <= 0 || cap <= 0){
			return 0;
		}
		int km = cap+1;
		int[][] dp = new int[n][km];
		for(int i = 0; i < km; i++){
			if(i == w[0]){
				while(i < km){
					dp[0][i] = v[0];
					i++;
				}
				break;
			}
		}
		for(int i = 1; i < n; i++){
			for(int j = 1; j < km; j++){
				if((j - w[i]) >= 0){
					dp[i][j] = dp[i-1][j] > dp[i-1][j-w[i]]+v[i] ? dp[i-1][j] : dp[i-1][j-w[i]]+v[i];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n-1][cap];
	}
}

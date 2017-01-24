package com.program.part2;

public class DPTest6 {
	public static void main(String[] args) {
		int[] v = {3,5,2,1,4};
		int[] w = {2,1,3,4,6};
		System.out.println(maxValue(w,v,5,20));
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
		for(int i = 0; i < n; i++){
			for(int j = 0; j < km; j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[n-1][cap];
	}
}

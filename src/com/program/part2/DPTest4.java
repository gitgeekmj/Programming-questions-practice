package com.program.part2;
/**
 * 
 * @author 杰
 * 经典的LIS(即最长上升子序列)问题
 */
public class DPTest4 {
	public static void main(String[] args) {
		int[] arr = {1,4,2,5,3};
		System.out.println(getLIS(arr,5));
	}
	public static int getLIS(int[] A,int n){
		if(A == null || n <= 0){
			return 0;
		}
		int length = 0;
		int max = 0;
		int[] dp = new int[n];
		dp[0] = 1;
		for(int i = 1; i < n; i++){
			length = 0;
			for(int j = 0; j < i; j++){
				if(A[j] < A[i]){
					if(dp[j] > length){
						length = dp[j];
					}
				}
			}
			dp[i] = length +1;
			if(dp[i] > max){
				max = dp[i];
			}
		}
		return max;
	}
}

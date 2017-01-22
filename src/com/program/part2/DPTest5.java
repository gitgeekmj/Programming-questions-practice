package com.program.part2;

public class DPTest5 {
	public static void main(String[] args) {
		String A = "joneoovzzmuispkgmnhqgdmbchdntanbofhcwftcdnbsyvcragunnopknzazjqoprujqfiesoreslzvgzaed";
		String B = "oynwkodiovsvkliehbvvggpdydesncaentayeufhoaaildsdwkfpnvxwpsqcujtssriiudgyxstiefyvsp";
		System.out.println(findLCS(A,84,B,82));
	}
	public static int findLCS(String A,int n,String B,int m){
		if(A == null || B == null || n == 0 || m == 0){
			return 0;
		}
		char[] str1 = A.toCharArray();
		char[] str2 = B.toCharArray();
		int[][] dp = new int[n][m];
		for(int i = 0; i < m; i++){
			if(str1[0] == str2[i]){
				while(i < m){
					dp[0][i] = 1;
					i++;
				}
				break;
			}
			dp[0][i] = 0;
		}
		for(int i = 0; i < n; i++){
			if(str1[i] == str2[0]){
				while(i < n){
					dp[i][0] = 1;
					i++;
				}
				break;
			}
			dp[i][0] = 0;
		}
		for(int i = 1;i < n;i++){
			for(int j = 1;j < m;j++){
				if(str1[i] != str2[j]){
					dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
				}else if((dp[i-1][j-1]+1) >= dp[i-1][j] && (dp[i-1][j-1]+1) >= dp[i][j-1]){
					dp[i][j] = dp[i-1][j-1]+1;
				}else{
					dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
				}
			}
		}
		return dp[n-1][m-1];
	}
}

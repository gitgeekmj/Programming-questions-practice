package com.program.part8;

public class rank04 {
	public static void main(String[] args) {
		rank04 rank = new rank04();
		rank.getWays(10,3);
	}
    public int getWays(int n, int m) {
    	int res1 = 1;
    	int res2 = 1;
    	for(int i = n - 1; i >= n - m + 1 ; i--){
    		res1 = res1 * i;
    	}
    	for(int i = m - 1; i > 0; i--){
    		res2 = res2 * i;
    	}
    	return res1 / res2;
    }
}

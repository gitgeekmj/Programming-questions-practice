package com.program.part8;

public class rank03 {
	    public int getWays(int n, int A, int b, int c) {
	        int res1 = 1;
	        int res2 = 1;
	        int res3 = 1;
	        for(int i = n; i > 0; i--){
	        	res1 = res1 * i;
	        	if(i == 1){
	        		res2 = res1 / n;
	        		res3 = res1 / n / (n - 1);
	        	}
	        }
	        return res1 - res2 * 2 * 2 + res3 * 2;
	    }
}

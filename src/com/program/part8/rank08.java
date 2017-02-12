package com.program.part8;

public class rank08 {
    public int countWays(int n) {
    	if(n == 0 || n == 1){
    		return 1;
    	}
        int res1 = 1;
        int res2 = 1;
        for(int i = 2*n; i > n; i--){
        	res1 *= i;
        }
        for(int i = n; i > 1; i--){
        	res2 *= i;
        }
        return (res1/res2)/(n+1);
    }
}
